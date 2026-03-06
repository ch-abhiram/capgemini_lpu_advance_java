package com.prac.cache.Controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prac.cache.Entity.FileData;
import com.prac.cache.repo.Filerepo;

@RestController
@RequestMapping("/files")
public class FileController {
	
	private Filerepo repo;
	
	
	
	public FileController(Filerepo repo) {
		this.repo = repo;
	}



	@PostMapping("/upload")
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFiletype(file.getContentType());
		data.setData(file.getBytes());
		FileData saved = repo.save(data);
		return saved;
	}
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable int id) {
		FileData data = repo.findById(id).orElseThrow(()-> new RuntimeException("FileNotFound"));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=/"+data.getFilename()).
				header(HttpHeaders.CONTENT_TYPE, data.getFiletype())
				.body(data.getData());
	}
}
