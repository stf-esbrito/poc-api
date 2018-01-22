package br.com.stefanini.poc.converter;

import br.com.stefanini.poc.dto.ArquivoDTO;
import br.com.stefanini.poc.model.Arquivo;

public class ArquivoConverter {

	
	public static ArquivoDTO getArquivoAsDTO(Arquivo arquivo) {
		ArquivoDTO arquivoDTO = new ArquivoDTO();
		arquivoDTO.setId(arquivo.getId());
		arquivoDTO.setName(arquivo.getName());
		arquivoDTO.setType(arquivo.getType());
		arquivoDTO.setFile(arquivo.getFile());
		return arquivoDTO;
	}
	
	public static Arquivo getArquivoAsModel(ArquivoDTO arquivoDTO) {
		Arquivo arquivo = new Arquivo();
		arquivo.setId(arquivoDTO.getId());
		arquivo.setName(arquivoDTO.getName());
		arquivo.setType(arquivoDTO.getType());
		arquivo.setFile(arquivoDTO.getFile());
		return arquivo;
	}
}
