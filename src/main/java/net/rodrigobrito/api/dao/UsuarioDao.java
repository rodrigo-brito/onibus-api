package net.rodrigobrito.api.dao;

import net.rodrigobrito.api.Entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface UsuarioDao  extends CrudRepository<Contato, Long>  {
	@Query("select c from contato as c inner join c.telefones as t")
	public Iterable<Contato> findContatoWithTelefone();
}
