package com.ariellopes.myhero.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariellopes.myhero.domain.Paciente;
import com.ariellopes.myhero.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository repo;
	
	public Paciente findById(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	public Paciente findByCpf(String cpf) {
		 Optional<Paciente> obj = repo.findByCpf(cpf);
		return obj.orElse(null);
	}
	public Paciente insert (Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
			repo.deleteById(id);
		}	
	
	public Paciente update (Paciente obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
		
	

}
