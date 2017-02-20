package net.rodrigobrito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.rodrigobrito.api.Entity.Contato;
import net.rodrigobrito.api.dao.UsuarioDao;

@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	UsuarioDao usuarioDao;
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
}
