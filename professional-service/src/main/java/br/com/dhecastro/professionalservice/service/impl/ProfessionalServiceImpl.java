package br.com.dhecastro.professionalservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dhecastro.professionalservice.exception.ProfessionalNotFoundException;
import br.com.dhecastro.professionalservice.model.Professional;
import br.com.dhecastro.professionalservice.repository.ProfessionalRepository;
import br.com.dhecastro.professionalservice.service.ProfessionalService;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

	 	@Autowired
	    private ProfessionalRepository professionalRepository;

	 	@Override
	    public Professional findById(Long professionalId) {
	        return professionalRepository.findById(professionalId)
	                .orElseThrow(() -> new ProfessionalNotFoundException(professionalId));
	    }

		@Override
		public List<Professional> findAll() {
			return professionalRepository.findAll();
		}
}
