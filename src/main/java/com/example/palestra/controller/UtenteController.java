package com.example.palestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palestra.dto.UtenteDTO;
import com.example.palestra.entity.Utente;
import com.example.palestra.service.UtenteService;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@PostMapping
	public ResponseEntity<Utente> registraUtente(@RequestBody Utente utente) {
		return ResponseEntity.ok(utenteService.registraUtente(utente));

	}

	@GetMapping
	public List<UtenteDTO> getTuttiGliUtenti() {
		return utenteService.getTuttiGliUtenti();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UtenteDTO> getUtentePerId(@PathVariable Long id) {

		return utenteService.getUtentePerId(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminaUtente(@PathVariable Long id) {
		utenteService.eliminaUtente(id);
		return ResponseEntity.noContent().build();

	}

}
