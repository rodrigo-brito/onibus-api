package br.com.sabaramais.onibus.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Horario {
	@Id
	@GeneratedValue
	private long id;
	private String origem;
	private String destino;
	private String observacao;

	@Temporal(TemporalType.TIME)
	private Date horario;

	@ManyToOne
	@JoinColumn(name = "diatipo_id")
	private TipoDia tipoDia;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "linha_id")
	private Linha linha;

	public Horario() {
	}

	public Horario(long id, String origem, String destino, String observacao, Date horario, TipoDia tipoDia,
			Linha linha) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.observacao = observacao;
		this.horario = horario;
		this.tipoDia = tipoDia;
		this.linha = linha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public TipoDia getTipoDia() {
		return tipoDia;
	}

	public void setTipoDia(TipoDia tipoDia) {
		this.tipoDia = tipoDia;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}
}
