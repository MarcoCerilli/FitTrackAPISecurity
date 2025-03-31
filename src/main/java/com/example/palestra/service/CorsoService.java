package com.example.palestra.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.palestra.dto.CorsoDTO;
import com.example.palestra.entity.Corso;
import com.example.palestra.repository.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	private CorsoRepository corsoRepository;

	public Corso aggiungiCorso(Corso corso) {
		return corsoRepository.save(corso);

	}

	public List<CorsoDTO> getTuttiCorsi() {
		List<Corso> corsi = corsoRepository.findAll();
		return corsi.stream().map(corso -> new CorsoDTO(corso.getId(), corso.getNome(), corso.getDescrizione(),
				corso.getPostiDisponibili())).collect(Collectors.toList());

	}

	public Optional<CorsoDTO> getCorsoPerId(Long Id) {
		Optional<Corso> corso = corsoRepository.findById(Id);
		return corso.map(c -> new CorsoDTO(c.getId(), c.getNome(), c.getDescrizione(), c.getPostiDisponibili()));

	}

}
