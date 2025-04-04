package com.example.palestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.palestra.entity.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

}
