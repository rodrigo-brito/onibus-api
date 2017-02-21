package br.com.sabaramais.onibus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.repository.BusRepository;

@Service
public class BusService {
	@Autowired
	BusRepository busRepository;

	/**
	 * Get all bus saved in database, without lines
	 * @return list of bus
	 */
	public Iterable<Bus> findAll() {
		return busRepository.findAll();
	}
	
	/**
	 * Get all bus with your lines
	 * @return list of bus
	 */
	public Iterable<Bus> getBusAndLines() {
		return busRepository.getBusAndLines();
	}

	/**
	 * Get bus by id
	 * @param id the bus id
	 * @return bus or null if not found
	 */
	public Bus findById(long id) {
		return busRepository.findOne(id);
	}
}
