package br.com.sabaramais.onibus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "company")
public class Company {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String imageUrl;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private Set<Bus> bus;

	public Company() {
	}
	
	/**
	 * @param id
	 * @param name the bus name
	 * @param imageUrl the bus photo url
	 * @param bus list of bus bus
	 */
	public Company(long id, String name, String imageUrl, Set<Bus> bus) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.bus = bus;
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

	public Set<Bus> getBus() {
		return bus;
	}

	public void setBus(Set<Bus> bus) {
		this.bus = bus;
	}
}
