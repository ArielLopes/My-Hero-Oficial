package com.testspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testspring.domain.Cliente;
import com.testspring.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvarUmCliente(@RequestBody Cliente cliente) {
		clienteService.salvarCliente(cliente);

	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Integer id) {
		return clienteService.buscarPorId(id);
	}

	@GetMapping
	public List<Cliente> buscarTodos() {
		return clienteService.buscarTodos();
	}

	@PutMapping("{id}")
	public Cliente editar(@PathVariable Integer id ,@RequestBody Cliente cliente) {
		Cliente obj = clienteService.atualizarCliente(cliente);
		return obj;
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Integer id) {
		clienteService.deletarUsuuario(id);
	}
}
