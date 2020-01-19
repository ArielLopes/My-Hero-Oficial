package com.testspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.testspring.domain.Cliente;
import com.testspring.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public void salvarCliente(Cliente cliente) {
		repo.save(cliente);
	}
	
	public Cliente buscarPorId(Integer id) {
		
		Optional<Cliente> obj  = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Cliente> buscarTodos() {
		List<Cliente> obj = repo.findAll();
		return obj;
	}
	
	
	public void deletarUsuuario(Integer id) {
		repo.deleteById(id);
		
	}
	
	public void atualizarCliente(Integer id , Cliente cliente) {
		Optional<Cliente> obj = repo.findById(id);
		  repo.save(obj);
	
	}
	
}
