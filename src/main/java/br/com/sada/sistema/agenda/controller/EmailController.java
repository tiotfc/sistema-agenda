package br.com.sada.sistema.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.agenda.model.dto.EmailInput;
import br.com.sada.sistema.agenda.services.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/email")
	public ResponseEntity<?> email(@RequestBody EmailInput email) {
		emailService.enviaEmail(email);
		return ResponseEntity.ok().build();
	}
}