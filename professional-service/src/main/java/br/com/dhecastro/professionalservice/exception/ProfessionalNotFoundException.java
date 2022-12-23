package br.com.dhecastro.professionalservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfessionalNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessionalNotFoundException(Long professionalId) {
		super(String.format("Professional id %d not found", professionalId));
	}
}
