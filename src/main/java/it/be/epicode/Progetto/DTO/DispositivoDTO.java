package it.be.epicode.Progetto.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DispositivoDTO(
        @NotEmpty(message = "Lo stato del dispositivo è obbligatorio")
        String status,
        @NotEmpty(message = "La tipologia del dispositivo è obbligatorio")
        String type
) {
}
