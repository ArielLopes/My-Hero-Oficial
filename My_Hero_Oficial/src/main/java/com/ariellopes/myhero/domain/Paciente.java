package com.ariellopes.myhero.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.ariellopes.myhero.enuns.Estados;
import com.ariellopes.myhero.enuns.TipoSanguinio;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
    
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String cpf;
	private String nome;
	private boolean doadorDeOrgao;
	private String telefone;
	private double peso;
	private double altura;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataDeNascimento;
	private Integer tipoSanguinio;
	private Integer estado;
	private String email;
	private String observacao;
	
	//Relacionamento de tabelas tipo agregação
	
	
	
	@ManyToMany
	private List<Alergia> alergia = new ArrayList<>();
	
	@ManyToMany
	private List<Doenca> doenca = new ArrayList<>();
	
	@ManyToMany
	private List<Medicamento> medicamento = new ArrayList<>();
	
	//Constructor Vazio
	public Paciente() {
	}


	//Constructor
	public Paciente(Integer id, String cpf, String nome,boolean doadorDeOrgao,  String telefone, double peso, double altura,
			Date dataDeNascimento, TipoSanguinio tipoSanguinio, Estados estado, String email, String observacao) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.doadorDeOrgao = doadorDeOrgao;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.dataDeNascimento = dataDeNascimento;
		this.tipoSanguinio = tipoSanguinio.getCod();
		this.estado = estado.getCod();
		this.email = email;
		this.observacao = observacao;
	}

  //Metodos Especiais Get e Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDoadorDeOrgao() {
		return doadorDeOrgao;
	}


	public void setDoadorDeOrgao(boolean doadorDeOrgao) {
		this.doadorDeOrgao = doadorDeOrgao;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public TipoSanguinio getTipoSanguinio() {
		return TipoSanguinio.toEnum(tipoSanguinio);
	}

	public void setTipoSanguinio(TipoSanguinio tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio.getCod();
	}
	
	public Estados getEstado() {
		return Estados.toEnum(estado);
	}
	
	public void setEstado(Estados estado) {
	   this.estado = estado.getCod();	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Alergia> getAlergia() {
		return alergia;
	}


	public void setAlergia(List<Alergia> alergia) {
		this.alergia = alergia;
	}


	public List<Doenca> getDoenca() {
		return doenca;
	}


	public void setDoenca(List<Doenca> doenca) {
		this.doenca = doenca;
	}


	public List<Medicamento> getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
