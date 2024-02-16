package it.be.epicode.Progetto.services;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.repositories.DipendenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteDAO dipendenteDAO;

    Random random = new Random();
    public Dipendente save(DipendenteDTO body) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(body.username());
        dipendente.setName(body.name());
        dipendente.setSurname(body.surname());
        dipendente.setEmail(body.email());
        return dipendenteDAO.save(dipendente);
    }

    public Page<Dipendente> getEmployees(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteDAO.findAll(pageable);
    }

}
