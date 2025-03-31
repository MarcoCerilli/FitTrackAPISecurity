package com.example.palestra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Iscrizione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	
	
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;
	
	@ManyToOne 
	@JoinColumn(name = "corso_id")
	private Corso corso;
	
	private String mese;
	private Boolean pagato;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public Boolean getPagato() {
		return pagato;
	}
	public void setPagato(Boolean pagato) {
		this.pagato = pagato;
	}
	
	
	
       	

}
