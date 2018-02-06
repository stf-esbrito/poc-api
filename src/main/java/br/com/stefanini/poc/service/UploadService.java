package br.com.stefanini.poc.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.stefanini.poc.dto.ColaboradorDTO;
import br.com.stefanini.poc.converter.ArquivoConverter;
import br.com.stefanini.poc.converter.ColaboradorConverter;
import br.com.stefanini.poc.dto.ArquivoDTO;
import br.com.stefanini.poc.repository.ColaboradorRepository;

@Service
public class UploadService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public void salvar(ColaboradorDTO colaborador) throws IOException {
		colaboradorRepository.save(ColaboradorConverter.getColaboradorAsModel(colaborador));
	}

	public HttpHeaders getHeaders(String fileName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Content-Disposition", "attachment;filename=" + fileName);
		headers.add("access-control-expose-headers", "content-disposition");
		return headers;
	}

	public ResponseEntity<InputStreamResource> downloadArquivo(Long id) throws IOException {
		ArquivoDTO file = ArquivoConverter.getArquivoAsDTO(colaboradorRepository.findOne(id).getFile());
		return ResponseEntity.ok().headers(getHeaders(file.getName()))
				.contentType(MediaType.parseMediaType(file.getType()))
				.contentLength(file.getFile().length)
				.body(new InputStreamResource(file.getInputStream()));
	}

}
