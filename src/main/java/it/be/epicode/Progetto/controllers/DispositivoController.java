package it.be.epicode.Progetto.controllers;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.DTO.DispositivoDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.entities.Dispositivo;
import it.be.epicode.Progetto.entities.Stato_Dispositivo;
import it.be.epicode.Progetto.entities.Tipologia_Dispositivo;
import it.be.epicode.Progetto.repositories.DispositivoDAO;
import it.be.epicode.Progetto.services.DipendenteService;
import it.be.epicode.Progetto.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/devices")
public class DispositivoController {
    @Autowired
    DispositivoService dispositivoService;
Random random = new Random();
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DispositivoDTO saveDevices(@RequestBody @Validated DispositivoDTO body) {
        int rndm1 = new Random().nextInt(Stato_Dispositivo.values().length);
        int rndm2 = new Random().nextInt(Tipologia_Dispositivo.values().length);
        Dispositivo dispositivo = dispositivoService.save(body);
//        return new DispositivoDTO(Stato_Dispositivo.values()[rndm1].toString(),Tipologia_Dispositivo.values()[rndm2].toString(),body.dipendenteId());
        return new DispositivoDTO(Stato_Dispositivo.values()[rndm1].toString(),Tipologia_Dispositivo.values()[rndm2].toString());
    }

    @GetMapping
    public Page<Dispositivo> getDevices(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getDevices(page, size, sortBy);
    }
    @PutMapping("/{deviceId}")
    public Dispositivo findAndUpdate(@PathVariable long deviceId, @RequestBody DispositivoDTO body) {
        return dispositivoService.findByIdAndUpdate(deviceId, body);
    }
}
