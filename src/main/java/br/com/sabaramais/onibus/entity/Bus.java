package br.com.sabaramais.onibus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "bus")
public class Bus {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String imageUrl;
	private double fare;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
	private Set<Line> lines;

	public Bus() {
	}
	
	/**
	 * @param id
	 * @param name the bus name
	 * @param imageUrl the bus photo url
	 * @param fare the bus fare
	 * @param lines list of bus lines
	 */
	public Bus(long id, String name, String imageUrl, double fare, Set<Line> lines) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.fare = fare;
		this.lines = lines;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Set<Line> getLines() {
		return lines;
	}

	public void setLines(Set<Line> lines) {
		this.lines = lines;
	}
}
