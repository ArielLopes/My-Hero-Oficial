package com.ariellopes.myhero.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ariellopes.myhero.domain.Paciente;
import com.ariellopes.myhero.repositories.ContatoDeEmergenciaRepository;
import com.ariellopes.myhero.services.PacienteService;

@RestController
@RequestMapping(value = "pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {
		Paciente obj = pacienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Paciente> foundByCpf(@RequestParam("codigo-paciente") String cpf){   
		Paciente obj = pacienteService.findByCpf(cpf);
	    return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Paciente obj){

		obj = pacienteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			      .path("/{id}").buildAndExpand(obj.getId()).toUri();
	   return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Paciente obj , @PathVariable Integer id){
		 obj.setId(id);
		 obj = pacienteService.update(obj);
		 
		 return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		pacienteService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
