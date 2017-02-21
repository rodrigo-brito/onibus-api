package br.com.sabaramais.onibus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "line")
public class Line {
	@Id
	@GeneratedValue
	private long id;
	private String number;
	private String name;

	@OneToMany(mappedBy = "line", fetch = FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Schedule> schedules;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	public Line() {
	}
	
	/**
	 * @param id
	 * @param number the line number
	 * @param name the name of the line
	 * @param schedules the list of schedules of the line
	 * @param bus the bus of the line
	 */
	public Line(long id, String number, String name, List<Schedule> schedules, Bus bus) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.schedules = schedules;
		this.bus = bus;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
