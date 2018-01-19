package br.com.stefanini.poc.dto;

import org.springframework.web.multipart.MultipartFile;

public class ColaboradorDTO {
	private Long id;
	private String name;
	private MultipartFile file;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
