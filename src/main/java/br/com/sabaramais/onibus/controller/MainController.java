package br.com.sabaramais.onibus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Contato;
import br.com.sabaramais.onibus.entity.Onibus;
import br.com.sabaramais.onibus.repository.OnibusRepository;
import br.com.sabaramais.onibus.repository.UsuarioDao;

@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	UsuarioDao usuarioDao;
	@Autowired
	OnibusRepository onibusRepository;
	@RequestMapping("/")
	public String index(){
		return "API Openshift - Spring Boot WildFly 10";
	}
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World";
	}
	
	@RequestMapping("/users")
	public Iterable<Contato> users(){
		return usuarioDao.findAll();
	}
	
	@RequestMapping("/contatos")
	public Iterable<Contato> contatos(){
		return usuarioDao.findContatoWithTelefone();
	}
	
	@RequestMapping("/onibus")
	public Iterable<Onibus> onibus(){
		return onibusRepository.findAll();
	}
}
