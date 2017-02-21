package br.com.sabaramais.onibus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="telefone")
public class Telefone {
	@Id
	@GeneratedValue
	private long id;
	private String ddd;
	private String telefone;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	public Telefone() {}
	
	public Telefone(long id, String ddd, String telefone) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "("+this.ddd+") "+this.telefone;
	}
}
