package br.com.sabaramais.onibus.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabaramais.onibus.entity.Onibus;

public interface OnibusRepository extends CrudRepository<Onibus, Long> {
	@Query("select o from onibus as o join fetch o.linhas as l")
	public Set<Onibus> allOnibusData();
}