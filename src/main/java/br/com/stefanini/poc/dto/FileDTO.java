package br.com.stefanini.poc.dto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FileDTO {
	private byte[] file;
	private String name;
	
	public FileDTO() {
		
	}
	public FileDTO(byte[] file, String name) {
		this.file = file;
		this.name = name;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InputStream getInputStream() {
		return new ByteArrayInputStream(this.getFile());
	}
	
	
}
