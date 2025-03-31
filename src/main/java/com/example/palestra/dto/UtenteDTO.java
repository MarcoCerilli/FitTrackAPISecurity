package com.example.palestra.dto;

public class UtenteDTO {

	
	private Long id;
	private String email;
	private boolean active;
	
	
	
	public UtenteDTO(Long id, String email, boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
	
	
}
