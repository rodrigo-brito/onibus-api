package br.com.sabaramais.onibus.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.entity.DayType;

public interface DayTypeRepository extends CrudRepository<DayType, Long>{
	@Query("select d from day_type as d join fetch d.schedules as s where s.bus.id = ?1 ORDER BY s.dayType.id, s.time ASC")
	public Set<DayType> findSchedulesByDayType(long id);
}
