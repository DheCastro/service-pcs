package br.com.dhecastro.professionalservice.service;

import java.util.List;

import br.com.dhecastro.professionalservice.model.Professional;

public interface ProfessionalService {

	public Professional findById(Long professionalId);
	public List<Professional> findAll();
}
