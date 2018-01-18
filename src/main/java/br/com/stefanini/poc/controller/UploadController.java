package br.com.stefanini.poc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@PostMapping
	public String UploadFile(@RequestBody MultipartFile degree_attachment) {
		try {
			System.out.println(degree_attachment);
		} catch (Exception e) {

			e.printStackTrace();

			return "Failure";
		}

		return "Success";
	}

}
