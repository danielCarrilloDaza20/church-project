package co.edu.uptc.gerencia.user;

import co.edu.uptc.gerencia.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class WebUser {

    @NotNull(message = "es requerido.")
    @Size(min = 1, message = "es requerido.")
    private String userName;

    @NotNull(message = "es requerido.")
    @Size(min = 1, message = "es requerido.")
    private String password;

    @NotNull(message = "es requerido.")
    @Size(min = 1, message = "es requerido.")
    private String firstName;

    @NotNull(message = "es requerido.")
    @Size(min = 1, message = "es requerido.")
    private String lastName;

    @NotNull(message = "es requerido")
    @Size(min = 1, message = "es requerido")
    private String cellPhone;

    @NotNull(message = "es requerido.")
    @Size(min = 1, message = "es requerido.")
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message = "Campo requerido")
    @PastOrPresent(message = "La fecha de nacimiento debe ser en el pasado o presente")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotNull(message = "Campo requerido")
    @Size(min = 1, message = "Campo requerido")
    private String gender;

    @NotNull(message = "Campo requerido")
    @Size(min = 1, message = "Campo requerido")
    private String documentType;

    @NotNull(message = "Campo requerido")
    @Size(min = 1, message = "Campo requerido")
    private String documentNumber;

    @NotNull(message = "Campo requerido")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registryDate = new Date();
}
