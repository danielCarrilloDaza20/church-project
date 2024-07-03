package co.edu.uptc.gerencia.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WebUser {

    @NotNull
    @Size(min = 1, message = "es requerido")
    private String userName;

    @NotNull
    @Size(min = 1, message = "es requerido")
    private String password;
}
