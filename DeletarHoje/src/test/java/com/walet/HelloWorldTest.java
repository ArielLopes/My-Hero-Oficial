package com.walet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.walet.repositories.UsuarioRepository;


@SpringBootTest
public class HelloWorldTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void salvarUsuario() {
		
		Usuario user = new Usuario();
		
		user.setLogin("Ariel");
		user.setEmail("ariel-edit@hotmail.com");
		user.setSenha("ariel1234");
		Usuario response = usuarioRepository.save(user);
		assert
		assertNotNull(response);
	}

}
