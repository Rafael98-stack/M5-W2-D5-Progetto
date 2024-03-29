package it.be.epicode.Progetto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "devices")
@NoArgsConstructor
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private String type;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(String status, String type) {
        this.status = status;
        this.type = type;
    }

    public Dispositivo(String status, String type, Dipendente dipendente) {
        this.status = status;
        this.type = type;
        this.dipendente = dipendente;
    }
}
