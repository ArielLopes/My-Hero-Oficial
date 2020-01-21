package com.ariellopes.myhero;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariellopes.myhero.domain.Alergia;
import com.ariellopes.myhero.domain.ContatoDeEmergencia;
import com.ariellopes.myhero.domain.Doenca;
import com.ariellopes.myhero.domain.Medicamento;
import com.ariellopes.myhero.domain.Paciente;
import com.ariellopes.myhero.enuns.Estados;
import com.ariellopes.myhero.enuns.TipoSanguinio;
import com.ariellopes.myhero.repositories.AlergiaRepository;
import com.ariellopes.myhero.repositories.ContatoDeEmergenciaRepository;
import com.ariellopes.myhero.repositories.DoencaRepository;
import com.ariellopes.myhero.repositories.MedicamentoRepository;
import com.ariellopes.myhero.repositories.PacienteRepository;

@SpringBootApplication
public class MyHeroOficialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyHeroOficialApplication.class, args);
	}

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private AlergiaRepository alergiaRepository;
	
	@Autowired
    private DoencaRepository doencaRepository;
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
    
	@Autowired
	private ContatoDeEmergenciaRepository contatoDeEmergenciaRepository;
	
	@Override
	public void run(String... args) throws Exception {

	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy"); //Conveter Data para Data do Brasil
	
	
	//Criar Teste de Paciente para salvar no BD H2
	Paciente p1 = new Paciente(1, "000.000.000-00", "Ariel Lopes", true, "(67) 99999-9999", 85.5, 1.79, sdf.parse("09/10/1994"), TipoSanguinio.O_NEGATIVO ,Estados.MATO_GROSSO_DO_SUL ,"ariel-edit@hotmail.com", "Teste Campo Observação");
	Paciente p2 = new Paciente(2, "111.111.111-11", "Simone Lima", false, "(67) 99999-9999", 72.0, 1.50, sdf.parse("10/10/1982"), TipoSanguinio.AB_NEGATIVO,Estados.RIO_GRANDE_DO_SUL, "simone.luiza@gmail.com", "");

	

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

	//Criando Doencas para salvar no BD H2
	Doenca doenca1 = new Doenca(null, "Depressão");
	Doenca doenca2 = new Doenca(null, "Obesidade");
	Doenca doenca3 = new Doenca(null, "Hipertensão arterial");
	Doenca doenca4 = new Doenca(null, "Diabetes");
	Doenca doenca5 = new Doenca(null, "Asma");
	Doenca doenca6 = new Doenca(null, "Acidente Vascular Cerebral.");
	Doenca doenca7 = new Doenca(null, "Câncer");
											
	//Criando Medicamentos  para salvar no BD H2
	Medicamento medicamento1 = new Medicamento(null, "Dorflex");
	Medicamento medicamento2 = new Medicamento(null, "Losartana");
	Medicamento medicamento3 = new Medicamento(null, "Sinvastatina");
	Medicamento medicamento4 = new Medicamento(null, "Neosaldina");
	Medicamento medicamento5 = new Medicamento(null, "Rivotril");
	Medicamento medicamento6 = new Medicamento(null, "Puran T4");
	

	//Criando Medicamentos  para salvar no BD H2
	ContatoDeEmergencia contato1 = new ContatoDeEmergencia(null, "Mae", "Fatima lopes", "9999999999");
	ContatoDeEmergencia contato2 = new ContatoDeEmergencia(null, "Irma", "Camila", "555555555555");
	ContatoDeEmergencia contato3 = new ContatoDeEmergencia(null, "vó", "Maria", "6733333333" );

	
	
	//Relacionando Alergias ao Paciente
	p1.getAlergia().add(aler1);
	p1.getAlergia().add(aler10);
	p1.getAlergia().add(aler6);
	p1.getAlergia().add(aler8);
	
	p2.getAlergia().add(aler4);
	
	//Relacionando Doenc ao Paciente
	 p1.getDoenca().add(doenca1);
	 p1.getDoenca().add(doenca2);
	 p1.getDoenca().add(doenca5);
	 
	 p2.getDoenca().add(doenca4);
	 p2.getDoenca().add(doenca2);
	 p2.getDoenca().add(doenca3);
	 p2.getDoenca().add(doenca1);
	 p2.getDoenca().add(doenca6);
	 
	
	//Relacionando Medicamento ao Paciente
	p1.getMedicamento().add(medicamento1);
	p1.getMedicamento().add(medicamento2);
	p1.getMedicamento().add(medicamento3);
	p1.getMedicamento().add(medicamento4);
	
	p2.getMedicamento().add(medicamento4);
	p2.getMedicamento().add(medicamento5);
	p2.getMedicamento().add(medicamento6);
	
	//Relacionando Contato de Emergencia ao Paciente
	
	p1.getContatoDeEmergencias().add(contato1);
	p1.getContatoDeEmergencias().add(contato2);
	p2.getContatoDeEmergencias().add(contato3);
	
	//Salvar no Repositories
	alergiaRepository.saveAll(Arrays.asList(aler1, aler2, aler3, aler4, aler5, aler6, aler7, aler8, aler9, aler10));
	doencaRepository.saveAll(Arrays.asList(doenca1, doenca2, doenca3, doenca4, doenca5, doenca6, doenca7));
	medicamentoRepository.saveAll(Arrays.asList(medicamento1, medicamento2 ,medicamento3 ,medicamento4 ,medicamento5, medicamento6));


		contatoDeEmergenciaRepository.saveAll(Arrays.asList(contato1, contato2 , contato3));
		pacienteRepository.saveAll(Arrays.asList(p1, p2));
	

	
	
	
	}

}
