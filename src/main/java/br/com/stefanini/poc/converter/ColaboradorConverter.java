package br.com.stefanini.poc.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.poc.dto.ColaboradorDTO;
import br.com.stefanini.poc.model.Colaborador;

public class ColaboradorConverter {

	public static ColaboradorDTO getColaboradorAsDTO(Colaborador colaborador) {
		ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
		colaboradorDTO.setId(colaborador.getId());
		colaboradorDTO.setName(colaborador.getName());
		colaboradorDTO.setFile(ArquivoConverter.getArquivoAsDTO(colaborador.getFile()));
		return colaboradorDTO;
	}
	
	public static Colaborador getColaboradorAsModel(ColaboradorDTO colaboradorDTO) {
		Colaborador colaborador = new Colaborador();
		colaborador.setId(colaboradorDTO.getId());
		colaborador.setName(colaboradorDTO.getName());
		colaborador.setFile(ArquivoConverter.getArquivoAsModel(colaboradorDTO.getFile()));
		return colaborador;
	}
	
	public static List<Colaborador> toModel(List<ColaboradorDTO> colaboradoresDTO) {
		List<Colaborador> colaboradores = new ArrayList<>();
		if(!colaboradoresDTO.isEmpty()) {
			colaboradoresDTO.forEach(colaboradorDTO -> {
				colaboradores.add(getColaboradorAsModel(colaboradorDTO));
			});
		}
		return colaboradores;
	}
	public static List<ColaboradorDTO> toDTO(List<Colaborador> colaboradores){
		List<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();
		if(!colaboradores.isEmpty()) {
			colaboradores.forEach(colaborador -> {
				colaboradoresDTO.add(getColaboradorAsDTO(colaborador));
			});
		}
		return colaboradoresDTO;
	}
}
