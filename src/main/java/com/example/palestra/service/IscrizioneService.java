package com.example.palestra.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.palestra.dto.IscrizioneDTO;
import com.example.palestra.entity.Iscrizione;
import com.example.palestra.repository.IscrizioneRepository;

@Service
public class IscrizioneService {

	 @Autowired
	    private IscrizioneRepository iscrizioneRepository;

	    public Iscrizione registraIscrizione(Iscrizione iscrizione) {
	        return iscrizioneRepository.save(iscrizione);
	    }

	    public List<IscrizioneDTO> getIscrizioniPerUtente(Long utenteId) {
	        List<Iscrizione> iscrizioni = iscrizioneRepository.findByUtenteId(utenteId);
	        return iscrizioni.stream()
	                .map(iscrizione -> new IscrizioneDTO(iscrizione.getId(), iscrizione.getUtente().getId(), iscrizione.getCorso().getId(), iscrizione.getMese(), iscrizione.getPagato()))
	                .collect(Collectors.toList());
	    }

	    public List<IscrizioneDTO> getIscrizioniPerCorso(Long corsoId) {
	        List<Iscrizione> iscrizioni = iscrizioneRepository.findByCorsoId(corsoId);
	        return iscrizioni.stream()
	                .map(iscrizione -> new IscrizioneDTO(iscrizione.getId(), iscrizione.getUtente().getId(), iscrizione.getCorso().getId(), iscrizione.getMese(), iscrizione.getPagato()))
	                .collect(Collectors.toList());
	    }

	    public void pagaIscrizione(Long id) {
	        Optional<Iscrizione> iscrizione = iscrizioneRepository.findById(id);
	        iscrizione.ifPresent(i -> {
	            i.setPagato(true);
	            iscrizioneRepository.save(i);
	        });
	    }

}
