package it.be.epicode.Progetto.repositories;

import it.be.epicode.Progetto.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteDAO extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
}
