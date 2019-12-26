package com.ariellopes.myhero;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariellopes.myhero.domain.Paciente;
import com.ariellopes.myhero.enuns.TipoSanguinio;
import com.ariellopes.myhero.repositories.PacienteRepository;

@SpringBootApplication
public class MyHeroOficialApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyHeroOficialApplication.class, args);
	}

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	Paciente p1 = new Paciente(null, "056877485", "Ariel", "3244565", 85.0, 1.79, sdf.parse("01/12/1982"), TipoSanguinio.O_NEGATIVO , "Ariel.lopes@gmail.com", "Apenas um teste");
	
	
	Paciente p2 = new Paciente(null, "056877485", "Ariel", "547855", 85.50, 1.50, sdf.parse("10/10/2012"), TipoSanguinio.A_NEGATIVO, "Arasdas@email.com", "Apenas um teste");
	
	pacienteRepository.saveAll(Arrays.asList(p1, p2));
	}

}
