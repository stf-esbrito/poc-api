package br.com.stefanini.poc.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.stefanini.poc.dto.FileDTO;
import br.com.stefanini.poc.service.UploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping
	public void UploadFile(@RequestBody MultipartFile degree_attachment) throws IOException {
		FileDTO file = new FileDTO(degree_attachment.getBytes(), degree_attachment.getOriginalFilename());
		uploadService.salvar(file);
	}
	
	@GetMapping
	public ResponseEntity<InputStreamResource> Buscar() throws IOException {
		return uploadService.downloadArquivo(); 
	}

}
