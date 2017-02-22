package br.com.sabaramais.onibus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.entity.Company;
import br.com.sabaramais.onibus.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	/**
	 * Get all companies saved in database, without bus lines
	 * @return list of companies
	 */
	public Iterable<Company> findAll() {
		return companyRepository.findAll();
	}
	
	/**
	 * Get all company with your bus lines
	 * @return list of bus
	 */
	public Iterable<Company> getCompanyAndBus() {
		return companyRepository.getCompanyAndBus();
	}

	/**
	 * Get company by id
	 * @param id the company id
	 * @return company or null if not found
	 */
	public Company findById(long id) {
		return companyRepository.findOne(id);
	}

	/**
	 * Get all bus from a specific company
	 * @param id the company id
	 * @return list of bus lines
	 */
	public Iterable<Bus> getAllBusFromCompanyId(long id) {
		return companyRepository.getAllBusFromCompanyId(id);
	}
}
