package com.example.palestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palestra.dto.IscrizioneDTO;
import com.example.palestra.entity.Iscrizione;
import com.example.palestra.service.IscrizioneService;

@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioneController {

    @Autowired
    private IscrizioneService iscrizioneService;

    @PostMapping
    public ResponseEntity<Iscrizione> registraIscrizione(@RequestBody Iscrizione iscrizione) {
        return ResponseEntity.ok(iscrizioneService.registraIscrizione(iscrizione));
    }

    @GetMapping("/utente/{id}")
    public List<IscrizioneDTO> getIscrizioniPerUtente(@PathVariable Long id) {
        return iscrizioneService.getIscrizioniPerUtente(id);
    }

    @GetMapping("/corso/{id}")
    public List<IscrizioneDTO> getIscrizioniPerCorso(@PathVariable Long id) {
        return iscrizioneService.getIscrizioniPerUtente(id);
    }

    @PutMapping("/{id}/paga")
    public ResponseEntity <Void> pagaIscrizione(@PathVariable Long id) {
        iscrizioneService.pagaIscrizione(id);
        return ResponseEntity.noContent().build();
    }
}
