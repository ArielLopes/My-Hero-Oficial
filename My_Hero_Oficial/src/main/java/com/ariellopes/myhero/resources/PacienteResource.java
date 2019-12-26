package com.ariellopes.myhero.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariellopes.myhero.domain.Paciente;

@RestController
@RequestMapping(value = "pacientes")
public class PacienteResource {
	
	Paciente p1 = new Paciente("Ariel Lopes", 25);
	
	@GetMapping
	public Paciente buscarProId() {
		return p1;
		
	}

}
