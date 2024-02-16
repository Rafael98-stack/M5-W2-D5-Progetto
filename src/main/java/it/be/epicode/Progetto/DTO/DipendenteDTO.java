package it.be.epicode.Progetto.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DipendenteDTO(
        @NotEmpty(message = "Lo username è obbligatorio")
        @Size(min = 3, max = 30, message = "Nome deve avere minimo 3 caratteri, massimo 30")
        String username,
        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(min = 3, max = 30, message = "Nome deve avere minimo 3 caratteri, massimo 30")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio")
        String surname,
        @NotEmpty(message = "L'email è obbligatoria!")
        @Email(message = "Non hai inserito un'email valida!")
         String email
) {
}
