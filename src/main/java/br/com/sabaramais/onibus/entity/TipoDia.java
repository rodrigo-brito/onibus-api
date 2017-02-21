package br.com.sabaramais.onibus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TipoDia {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private boolean ativo;
	@JsonIgnore
	@OneToMany(mappedBy="tipoDia")
	private List<Horario> horarios;
	
	public TipoDia() {}
	
	public TipoDia(long id, String nome, boolean ativo, List<Horario> horarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.horarios = horarios;
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}	
}
