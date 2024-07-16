package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.service.UserService;
import co.edu.uptc.gerencia.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model) {
        model.addAttribute("webUser", new WebUser());
        return "register/registration-form";
    }

    @PostMapping("/processRegisterForm")
    public String processRegisterForm(
            @Valid @ModelAttribute("webUser") WebUser webUser,
            BindingResult bindingResult,
            HttpSession session, Model model){
        String userName = webUser.getUserName();
        String documentNumber = webUser.getDocumentNumber();
        logger.info("Procesando formulario de registro para: " + userName);

        // Validacion de formulario
        if(bindingResult.hasErrors()){
            return "register/registration-form";
        }

        // Revisa en la base de datos si el usuario existe
        User existing = userService.findByUserName(userName);
        User existingDocumentNumber = userService.findByDocumentNumber(documentNumber);
        if(existing != null || existingDocumentNumber != null){
            model.addAttribute("webUser", new WebUser());
            model.addAttribute("registrationUsernameError", "Ya existe un usuario con ese nombre");
            model.addAttribute("registrationDocNumberError", "Ya existe un usuario con ese numero de documento");

            logger.warning("Ya existe un usuario con ese nombre");
            logger.warning("Ya existe un usuario con ese numero de documento");
            return "register/registration-form";
        }

        // Crea cuenta de usuario y la almacena en la base de datos
        userService.save(webUser);
        logger.info("Usuario creado exitosamente: " + userName);

        session.setAttribute("user", webUser);

        return "register/registration-confirmation";
    }

    /*@GetMapping("")
    public String login() {

        return "registro";
    }*/
}
