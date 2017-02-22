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

@Entity(name = "bus")
public class Bus {
	@Id
	@GeneratedValue
	private long id;
	private String number;
	private String name;
	private double fare;

	@OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Schedule> schedules;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Bus() {
	}
	
	/**
	 * @param id
	 * @param number the line number
	 * @param name the name of the line
	 * @param fare the fare of the line
	 * @param schedules the list of schedules of the line
	 * @param company the company of the line
	 */
	public Bus(long id, String number, String name, double fare, List<Schedule> schedules, Company company) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.fare = fare;
		this.schedules = schedules;
		this.company = company;
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
	
	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
