package com.example.palestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.palestra.entity.Corso;


@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {

	
	
}
