package com.ariellopes.myhero;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariellopes.myhero.domain.Alergia;
import com.ariellopes.myhero.domain.Paciente;
import com.ariellopes.myhero.enuns.TipoSanguinio;
import com.ariellopes.myhero.repositories.AlergiaRepository;
import com.ariellopes.myhero.repositories.PacienteRepository;

@SpringBootApplication
public class MyHeroOficialApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyHeroOficialApplication.class, args);
	}

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	AlergiaRepository alergiaRepository;
	
	@Override
	public void run(String... args) throws Exception {

	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy"); //Conveter Data para Data do Brasil
	
	
	//Criar Teste de Paciente para salvar no BD H2
	Paciente p1 = new Paciente(null, "000.000.000-00", "Ariel Lopes", "(67) 99999-9999", 85.5, 1.79, sdf.parse("09/10/1994"), TipoSanguinio.O_NEGATIVO , "ariel-edit@hotmail.com", "Teste Campo Observação");	
	Paciente p2 = new Paciente(null, "111.111.111-11", "Simone Lima", "(67) 99999-9999", 72.0, 1.50, sdf.parse("10/10/1982"), TipoSanguinio.AB_NEGATIVO, "simone.luiza@gmail.com", "");

	

	//Criando Alergias para salvar no BD H2
	Alergia aler1 = new Alergia(null, "Amendoim e nozes");
	Alergia aler2 = new Alergia(null, "Pólen");
	Alergia aler3 = new Alergia(null, "Mariscos");
	Alergia aler4 = new Alergia(null, "Animais de estimação");
	Alergia aler5 = new Alergia(null, "Ovo");
	Alergia aler6 = new Alergia(null, "Poeira");
	Alergia aler7 = new Alergia(null, "Soja");
	Alergia aler8 = new Alergia(null, "Picadas de insetos");
	Alergia aler9 = new Alergia(null, "Leite");
	Alergia aler10 = new Alergia(null, " Trigo (glúten)");

	
	
	
	//Relacionando Alergias ao Paciente
	p1.getAlergias().add(aler1);
	p1.getAlergias().add(aler10);
	p1.getAlergias().add(aler6);
	p1.getAlergias().add(aler8);
	
	p2.getAlergias().add(aler4);
	
	//Salvar no Repositories
	alergiaRepository.saveAll(Arrays.asList(aler1, aler2, aler3, aler4, aler5, aler6, aler7, aler8, aler9, aler10));
	pacienteRepository.saveAll(Arrays.asList(p1, p2));
	
	
	
	}

}
