package br.com.sabaramais.onibus.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabaramais.onibus.entity.DayType;
import br.com.sabaramais.onibus.repository.DayTypeRepository;

@Service
public class DayTypeService {
	@Autowired
	DayTypeRepository dayTypeRepository;

	/**
	 * Get all day types from database
	 * @return list of day types
	 */
	public Iterable<DayType> findAll() {
		return dayTypeRepository.findAll();
	}

	/**
	 * Get a specific day type
	 * @param id the day type id
	 * @return day type or null if not found
	 */
	public DayType findOne(long id) {
		return dayTypeRepository.findOne(id);
	}

	/**
	 * Get a DayType list with all schedules from a specific bus
	 * @param busId the bus id identifier
	 * @return list of DayType
	 */
	public Set<DayType> findSchedulesByDayType(long busId) {
		return dayTypeRepository.findSchedulesByDayType(busId);
	}

}
