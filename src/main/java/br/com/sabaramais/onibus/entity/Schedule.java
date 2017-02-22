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

@Entity(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue
	private long id;
	private String origin;
	private String destiny;
	private String observation;

	@Temporal(TemporalType.TIME)
	private Date time;

	@ManyToOne
	@JoinColumn(name = "daytype_id")
	private DayType dayType;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	public Schedule() {
	}

	/**
	 * @param id
	 * @param origin the starting point of the bus
	 * @param destiny the final point of the bus
	 * @param observation some observation of the schedule
	 * @param time the time of departure
	 * @param dayType the day type
	 * @param bus the bus bus of schedule
	 */
	public Schedule(long id, String origin, String destiny, String observation, Date time, DayType dayType, Bus bus) {
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
		this.observation = observation;
		this.time = time;
		this.dayType = dayType;
		this.bus = bus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public DayType getDayType() {
		return dayType;
	}

	public void setDayType(DayType dayType) {
		this.dayType = dayType;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
