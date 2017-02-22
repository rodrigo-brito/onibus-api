package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Schedule;
import br.com.sabaramais.onibus.service.ScheduleService;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	
	/**
	 * Get all schedules from database
	 * @return list of schedules
	 */
	@RequestMapping("")
	public Iterable<Schedule> findAll(){
		return scheduleService.findAll();
	}
	
	/**
	 * Get all schedules from database
	 * @return list of schedules
	 */
	@RequestMapping("/{id}")
	public Schedule findOne(@PathVariable("id") long id){
		return scheduleService.findOne(id);
	}
}
