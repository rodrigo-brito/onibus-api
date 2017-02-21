package br.com.sabaramais.onibus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="onibus")
public class Onibus {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String fotoUrl;
	private double tarifa;
	@OneToMany(mappedBy="onibus")
	private List<Linha> linhas;
	
	public Onibus(){}
	
	public Onibus(long id, String nome, String fotoUrl, double tarifa, List<Linha> linhas) {
		super();
		this.id = id;
		this.nome = nome;
		this.fotoUrl = fotoUrl;
		this.tarifa = tarifa;
		this.linhas = linhas;
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
	
	public String getFotoUrl() {
		return fotoUrl;
	}
	
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
	public double getTarifa() {
		return tarifa;
	}
	
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public List<Linha> getLinhas() {
		return linhas;
	}
	
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
	
	
}
