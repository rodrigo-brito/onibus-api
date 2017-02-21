package br.com.sabaramais.onibus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Linha {
	@Id
	@GeneratedValue
	private long id;
	private String numero;
	private String nome;
	@OneToMany(mappedBy="linha")
	private List<Horario> horarios;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "onibus_id")
	private Onibus onibus;
	
	public Linha(){}
	
	public Linha(long id, String numero, String nome, List<Horario> horarios, Onibus onibus) {
		super();
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.horarios = horarios;
		this.onibus = onibus;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
}
