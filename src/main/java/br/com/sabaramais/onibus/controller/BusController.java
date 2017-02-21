package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.service.BusService;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
	
	@Autowired
	BusService busService;
	
	@RequestMapping("")
	public Iterable<Bus> findAll(){
		return busService.findAll();
	}
	
	@RequestMapping("/{id}")
	public Bus findById(@PathVariable("id") long id){
		return busService.findById(id);
	}
	
	@RequestMapping("/lines")
	public Iterable<Bus> busAndLines(){
		return busService.getBusAndLines();
	}
}
