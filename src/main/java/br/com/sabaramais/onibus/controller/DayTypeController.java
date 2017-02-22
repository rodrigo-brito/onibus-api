package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.DayType;
import br.com.sabaramais.onibus.service.DayTypeService;

@RestController
@RequestMapping("/api/v1/daytype")
public class DayTypeController {
	@Autowired
	private DayTypeService dayTypeService;
	
	/**
	 * Get all day types from database
	 * @return list of day types
	 */
	@RequestMapping("")
	public Iterable<DayType> findAll(){
		return dayTypeService.findAll();
	}
	
	/**
	 * Get a specific day type
	 * @param id the day type identifier
	 * @return day type or null if not found
	 */
	@RequestMapping("/{id}")
	public DayType findOne(@PathVariable("id") long id){
		return dayTypeService.findOne(id);
	}

}
