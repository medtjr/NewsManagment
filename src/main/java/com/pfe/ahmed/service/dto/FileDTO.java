package com.pfe.ahmed.service.dto;

public class FileDTO {

	private String base64;
	private String filename;
	private String filetype;
	private String filepath="404";
	
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public FileDTO(String filepath) {
		super();
		this.filepath = filepath;
	}
	
	
	
	
	
}
