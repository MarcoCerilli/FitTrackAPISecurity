package com.example.palestra.dto;

public class CorsoDTO {

	private Long id;
	private String nome;
	private String descrizione;
	private Integer postiDisponibili;

	public CorsoDTO(Long id, String nome, String descrizione, Integer postiDisponibili) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.postiDisponibili = postiDisponibili;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

}
