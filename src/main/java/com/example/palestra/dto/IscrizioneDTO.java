package com.example.palestra.dto;

public class IscrizioneDTO {

	private Long id;
	private Long utenteId;
	private Long corsoId;
	private String mese;
	private boolean pagato;
	
	
	
	public IscrizioneDTO(Long id, Long utenteId, Long corsoId, String mese, boolean pagato) {
		super();
		this.id = id;
		this.utenteId = utenteId;
		this.corsoId = corsoId;
		this.mese = mese;
		this.pagato = pagato;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUtenteId() {
		return utenteId;
	}
	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}
	public Long getCorsoId() {
		return corsoId;
	}
	public void setCorsoId(Long corsoId) {
		this.corsoId = corsoId;
	}
	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public boolean isPagato() {
		return pagato;
	}
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	
	
	
	
}
