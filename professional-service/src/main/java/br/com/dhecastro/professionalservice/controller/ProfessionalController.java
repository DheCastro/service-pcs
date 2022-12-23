package br.com.dhecastro.professionalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dhecastro.professionalservice.model.Professional;
import br.com.dhecastro.professionalservice.service.ProfessionalService;

@RestController
@RequestMapping("/v1/professionals")
public class ProfessionalController {

	@Autowired
	private ProfessionalService professionalService;

	@GetMapping("/{professionalId}")
	public Professional getProfessionalById(@PathVariable("professionalId") Long professionalId) {
		return professionalService.findById(professionalId);
	}

	@GetMapping
	public List<Professional> getAllProfessionals() {
		return professionalService.findAll();
	}
}
