package br.com.sabaramais.onibus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabaramais.onibus.entity.Bus;

public interface BusRepository extends CrudRepository<Bus, Long>{

	@Query("select b from bus as b left join fetch b.schedules where b.id = ?1")
	public Bus getBusWithSchedule(long id);

	@Query("select distinct b from bus as b left join fetch b.schedules")
	public Iterable<Bus> getBusWithSchedule();
}
