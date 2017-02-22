package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.service.BusService;

@RestController
@RequestMapping("/api/v1/line")
public class BusController {
	@Autowired
	private BusService busService;
	
	/**
	 * Get all lines from database
	 * @return list of bus lines
	 */
	@RequestMapping("")
	public Iterable<Bus> findAll(){
		return busService.findAll();
	}

}
