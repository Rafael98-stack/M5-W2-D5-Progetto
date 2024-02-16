package it.be.epicode.Progetto.services;

import it.be.epicode.Progetto.DTO.DipendenteDTO;
import it.be.epicode.Progetto.DTO.DispositivoDTO;
import it.be.epicode.Progetto.entities.Dipendente;
import it.be.epicode.Progetto.entities.Dispositivo;
import it.be.epicode.Progetto.entities.Stato_Dispositivo;
import it.be.epicode.Progetto.entities.Tipologia_Dispositivo;
import it.be.epicode.Progetto.exceptions.NotFoundException;
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
    @Autowired
            private DipendenteService dipendenteService;
Random random = new Random();
    public Dispositivo save(DispositivoDTO body) {
//        Dipendente dipendente = dipendenteService.findById(body.dipendenteId());
        int rndm1 = new Random().nextInt(Stato_Dispositivo.values().length);
        int rndm2 = new Random().nextInt(Tipologia_Dispositivo.values().length);
//        Dispositivo dispositivo = new Dispositivo(
//                Stato_Dispositivo.values()[rndm1].toString(),
//                Tipologia_Dispositivo.values()[rndm2].toString(),dipendente
//        );
        Dispositivo dispositivo = new Dispositivo(
                Stato_Dispositivo.values()[rndm1].toString(),
                Tipologia_Dispositivo.values()[rndm2].toString()
        );
        return this.dispositivoDAO.save(dispositivo);
    }
    public Page<Dispositivo> getDevices(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return this.dispositivoDAO.findAll(pageable);
    }

    public Dispositivo findById(long id) {
        return dispositivoDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Dispositivo findByIdAndUpdate(long id, Dispositivo body) {
        Dispositivo found = this.findById(id);

        found.setStatus(body.getStatus());
        found.setType(body.getType());
        return dispositivoDAO.save(found);
    }
}
