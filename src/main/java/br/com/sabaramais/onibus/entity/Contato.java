package br.com.sabaramais.onibus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="contato")
public class Contato {	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="contato")
	private Set<Telefone> telefones;
	private String email;
	
	public Contato() { }
	
	public Contato(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" +  "]";
	}
}
