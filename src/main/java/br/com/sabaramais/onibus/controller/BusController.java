package br.com.sabaramais.onibus.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.entity.DayType;
import br.com.sabaramais.onibus.service.BusService;
import br.com.sabaramais.onibus.service.DayTypeService;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
	@Autowired
	private BusService busService;
	@Autowired
	private DayTypeService dayTypeService;
	
	/**
	 * Get all lines from database
	 * @return list of bus lines
	 */
	@RequestMapping("")
	public Iterable<Bus> findAll(){
		return busService.findAll();
	}
	
	/**
	 * Get a specific bus from database
	 * @return bus or null if not found
	 */
	@RequestMapping("/{id}")
	public Bus findOne(@PathVariable("id") long id){
		return busService.findOne(id);
	}
	
	/**
	 * Get a specific bus from database
	 * @return bus or null if not found
	 */
	@RequestMapping("/schedule")
	public Iterable<Bus> getBusWithSchedule(){
		return busService.getBusWithSchedule();
	}
	
	/**
	 * Get a specific bus from database
	 * @return bus or null if not found
	 */
	@RequestMapping("/{id}/schedule")
	public Bus getBusWithSchedule(@PathVariable("id") long id, @RequestParam(name = "day_type", required = false) Long idDayType){
		if(idDayType != null){
			return busService.getBusWithScheduleByDayType(id, idDayType.intValue());
		}
		return busService.getBusWithSchedule(id);
	}
	
	/**
	 * Schedules separated by day type
	 * @param busId the bus identifier
	 * @return a list of day type
	 */
	@RequestMapping("/{id}/schedule/daytype")
	public Set<DayType> findSchedulesByDayType(@PathVariable("id") long busId){
		return dayTypeService.findSchedulesByDayType(busId);
	}

}
