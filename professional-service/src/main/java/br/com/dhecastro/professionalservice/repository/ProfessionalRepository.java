package br.com.dhecastro.professionalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dhecastro.professionalservice.model.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long>{

}
