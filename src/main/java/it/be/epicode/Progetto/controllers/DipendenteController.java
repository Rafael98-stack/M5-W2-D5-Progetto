package it.be.epicode.Progetto.controllers;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class DipendenteController {
    @Autowired
    DipendenteService dipendenteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDTO saveEmployees(@RequestBody @Validated DipendenteDTO body) {
        Dipendente dipendente = dipendenteService.save(body);
        return new DipendenteDTO(dipendente.getUsername(),dipendente.getName(), dipendente.getSurname(), dipendente.getEmail());
    }
    @GetMapping
    public Page<Dipendente> getEmployees(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getEmployees(page, size, sortBy);
    }
}
