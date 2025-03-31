package com.example.palestra.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.palestra.dto.UtenteDTO;
import com.example.palestra.entity.Utente;
import com.example.palestra.repository.UtenteRepository;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Inizializzazione diretta

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Utente registraUtente(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente);
    }

    public List<UtenteDTO> getTuttiGliUtenti() {
        List<Utente> utenti = utenteRepository.findAll();
        return utenti.stream()
                .map(utente -> new UtenteDTO(utente.getId(), utente.getEmail(), utente.getActive()))
                .collect(Collectors.toList());
    }

    public Optional<UtenteDTO> getUtentePerId(Long id) {
        Optional<Utente> utente = utenteRepository.findById(id);
        return utente.map(u -> new UtenteDTO(u.getId(), u.getEmail(), u.getActive()));
    }

    public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
