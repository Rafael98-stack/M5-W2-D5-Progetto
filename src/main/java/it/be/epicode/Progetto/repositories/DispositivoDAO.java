package it.be.epicode.Progetto.repositories;


import it.be.epicode.Progetto.entities.Dispositivo;
import it.be.epicode.Progetto.entities.Tipologia_Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DispositivoDAO extends JpaRepository<Dispositivo,Long> {
//    Optional<Dispositivo> findByDevice(String device);
}
