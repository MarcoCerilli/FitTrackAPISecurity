package com.example.palestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palestra.dto.CorsoDTO;
import com.example.palestra.entity.Corso;
import com.example.palestra.service.CorsoService;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

	@Autowired
	private CorsoService corsoService;

	@PostMapping
	public ResponseEntity<Corso> aggiungiCorso(@RequestBody Corso corso) {
		return ResponseEntity.ok(corsoService.aggiungiCorso(corso));

	}

	@GetMapping
	public List<CorsoDTO> getTuttiICorsi() {

		return corsoService.getTuttiCorsi();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CorsoDTO> getCorsoPerId(@PathVariable Long id) {
		return corsoService.getCorsoPerId(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
