package br.com.stefanini.poc.dto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ArquivoDTO {
	private Long id;
	private byte[] file;
	private String name;
	private String type;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArquivoDTO() {
		
	}
	public ArquivoDTO(byte[] file, String name, String type) {
		this.file = file;
		this.name = name;
		this.type = type;
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
