package br.com.sabaramais.onibus.service;

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
	 * Get a specifica day type
	 * @param id the day type id
	 * @return day type or null if not found
	 */
	public DayType findOne(long id) {
		return dayTypeRepository.findOne(id);
	}

}
