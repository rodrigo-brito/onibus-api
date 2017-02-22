package br.com.sabaramais.onibus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.repository.BusRepository;

@Service
public class BusService {
	
	@Autowired
	private BusRepository busRepository;

	/**
	 * Get all bus lines from database
	 * @return list of bus lines
	 */
	public Iterable<Bus> findAll() {
		return busRepository.findAll();
	}
	
}
