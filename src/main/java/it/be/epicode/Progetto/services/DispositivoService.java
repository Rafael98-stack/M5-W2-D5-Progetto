package it.be.epicode.Progetto.services;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.DTO.DispositivoDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.entities.Dispositivo;
import it.be.epicode.Progetto.entities.Stato_Dispositivo;
import it.be.epicode.Progetto.entities.Tipologia_Dispositivo;
import it.be.epicode.Progetto.repositories.DipendenteDAO;
import it.be.epicode.Progetto.repositories.DispositivoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class DispositivoService {
    @Autowired
    private DispositivoDAO dispositivoDAO;
Random random = new Random();
    public Dispositivo save(DispositivoDTO body) {
        int rndm1 = new Random().nextInt(Stato_Dispositivo.values().length);
        int rndm2 = new Random().nextInt(Tipologia_Dispositivo.values().length);
        Dispositivo dispositivo = new Dispositivo(Stato_Dispositivo.values()[rndm1].toString(), Tipologia_Dispositivo.values()[rndm2].toString());
        return this.dispositivoDAO.save(dispositivo);
    }
    public Page<Dispositivo> getDevices(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return this.dispositivoDAO.findAll(pageable);
    }
}
