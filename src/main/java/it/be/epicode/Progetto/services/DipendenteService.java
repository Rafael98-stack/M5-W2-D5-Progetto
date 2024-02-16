package it.be.epicode.Progetto.services;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.exceptions.NotFoundException;
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
        Dipendente dipendente = new Dipendente(body.username(), body.name(), body.surname(), body.email());
        return this.dipendenteDAO.save(dipendente);
    }

    public Page<Dipendente> getEmployees(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return this.dipendenteDAO.findAll(pageable);
    }

    public Dipendente findById(long id) {
        return dipendenteDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Dipendente findByIdAndUpdate(long id, Dipendente body) {
        Dipendente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        return dipendenteDAO.save(found);
    }
}
