package br.com.stefanini.poc.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_COLABORADOR")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_COLABORADOR")
	private Long id;
	
	@Column(name="NOME")
	private String name;

	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="ID_ARQUIVO")
	private Arquivo file;
	
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
	public Arquivo getFile() {
		return file;
	}

	public void setFile(Arquivo file) {
		this.file = file;
	}

}
