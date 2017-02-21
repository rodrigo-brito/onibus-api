package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Onibus;
import br.com.sabaramais.onibus.repository.OnibusRepository;

@RestController
@RequestMapping("/api/v1/")
public class MainController {
	@Autowired
	OnibusRepository onibusRepository;
	@RequestMapping("/")
	public String index(){
		return "API Ônibus - www.sabaramais.com.br";
	}
	
	@RequestMapping("/onibus/full")
	public Iterable<Onibus> onibusComplete(){
		return onibusRepository.allOnibusData();
	}
	
	@RequestMapping("/onibus")
	public Iterable<Onibus> onibus(){
		return onibusRepository.findAll();
	}
}
