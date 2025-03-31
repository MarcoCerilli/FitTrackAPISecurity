package com.example.palestra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.palestra.entity.Iscrizione;



@Repository
public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long>{

	List<Iscrizione> findByUtenteId(Long utendeId);
	List<Iscrizione> findByCorsoId(Long corsoId);
	
	
}
