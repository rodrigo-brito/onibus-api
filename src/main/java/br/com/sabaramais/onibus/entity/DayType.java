package br.com.sabaramais.onibus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "day_type")
public class DayType {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private boolean active;

	@OneToMany(mappedBy = "dayType", fetch=FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Schedule> schedules;

	public DayType() {
	}

	/**
	 * @param id 
	 * @param name the name of day type
	 * @param active the active state
	 * @param schedules the list of schedules when
	 */
	public DayType(long id, String name, boolean active, List<Schedule> schedules) {
		this.id = id;
		this.name = name;
		this.active = active;
		this.schedules = schedules;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
