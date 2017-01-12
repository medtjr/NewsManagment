package com.pfe.ahmed.service.dto;

import java.io.Serializable;

public class NewsDTO implements Serializable {

	private Integer id;
	private String titre;
	private FileDTO image;
	private boolean urgent;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public FileDTO getImage() {
		return image;
	}
	public void setImage(FileDTO image) {
		this.image = image;
	}
	public boolean isUrgent() {
		return urgent;
	}
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
	
	
	
	
}
