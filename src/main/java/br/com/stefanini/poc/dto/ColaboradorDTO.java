package br.com.stefanini.poc.dto;

public class ColaboradorDTO {
	private Long id;
	private String name;
	private ArquivoDTO file;
	
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
	public ArquivoDTO getFile() {
		return file;
	}
	public void setFile(ArquivoDTO file) {
		this.file = file;
	}
	
}
