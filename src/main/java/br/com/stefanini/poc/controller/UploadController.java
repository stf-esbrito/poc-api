package br.com.stefanini.poc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import br.com.stefanini.poc.dto.ColaboradorDTO;
import br.com.stefanini.poc.dto.ArquivoDTO;
import br.com.stefanini.poc.service.UploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping
	public void UploadFile(@RequestParam MultipartFile file, @RequestParam String colaboradorJson) throws IOException {
		ColaboradorDTO colaborador= new Gson().fromJson(colaboradorJson, ColaboradorDTO.class);
		colaborador.setFile(new ArquivoDTO(file.getBytes(), file.getOriginalFilename(), file.getContentType()));
		uploadService.salvar(colaborador);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InputStreamResource> Buscar(@PathVariable Long id) throws IOException {
		return uploadService.downloadArquivo(id); 
	}

}
