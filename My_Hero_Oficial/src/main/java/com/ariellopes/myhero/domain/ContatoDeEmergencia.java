package com.ariellopes.myhero.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContatoDeEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String grauDeParentesco;
	private String nome;
	private String telefone;

	//Relacionando com o Paciente


    //@ManyToOne
    //@JoinColumn(name = "paciente_id")
	//private Paciente paciente;

	public ContatoDeEmergencia() {
	}

	public ContatoDeEmergencia(Integer id, String grauDeParentesco, String nome, String telefone) {
		super();
		this.id = id;
		this.grauDeParentesco = grauDeParentesco;
		this.nome = nome;
		this.telefone = telefone;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}

	public String getNome() {

	    return nome;
	}

	public void setNome(String nome) {

	    this.nome = nome;
	}

	public String getTelefone() {

	    return telefone;
	}

	public void setTelefone(String telefone) {

	    this.telefone = telefone;
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
		ContatoDeEmergencia other = (ContatoDeEmergencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
