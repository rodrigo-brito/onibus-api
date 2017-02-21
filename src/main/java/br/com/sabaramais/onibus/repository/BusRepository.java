package br.com.sabaramais.onibus.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabaramais.onibus.entity.Bus;

public interface BusRepository extends CrudRepository<Bus, Long> {
	/**
	 * Get all bus and lines if they have
	 * @return list of bus with lines
	 */
	@Query("select o from bus as o left join fetch o.lines as l")
	public Set<Bus> getBusAndLines();
}