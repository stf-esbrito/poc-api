package br.com.stefanini.poc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import br.com.stefanini.poc.dto.ColaboradorDTO;
import br.com.stefanini.poc.service.UploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping
	public void UploadFile(@RequestParam MultipartFile file, @RequestParam String colaborador) throws IOException {
		ColaboradorDTO colaboradorX = new Gson().fromJson(colaborador, ColaboradorDTO.class);
		colaboradorX.setFile(file);
		uploadService.salvar(colaboradorX);
	}
	
	@GetMapping
	public ResponseEntity<InputStreamResource> Buscar() throws IOException {
		return uploadService.downloadArquivo(); 
	}

}
