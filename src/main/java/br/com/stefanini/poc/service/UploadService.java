package br.com.stefanini.poc.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.stefanini.poc.dto.FileDTO;

@Service
public class UploadService {

	private final  ArrayList<FileDTO> ARQUIVOS = new ArrayList<>();

	public void salvar(FileDTO file) throws IOException {
		ARQUIVOS.add(file);
	}

	public HttpHeaders getHeaders(String fileName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Content-disposition", "attachment;filename=" + fileName);
		return headers;
	}

	public ResponseEntity<InputStreamResource> downloadArquivo() {
		FileDTO file = ARQUIVOS.get(0);
		return ResponseEntity.ok().headers(getHeaders(file.getName()))
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.contentLength(file.getFile().length)
				.body(new InputStreamResource(file.getInputStream()));
	}

}
