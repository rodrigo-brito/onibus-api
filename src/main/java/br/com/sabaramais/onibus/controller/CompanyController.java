package br.com.sabaramais.onibus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.entity.Company;
import br.com.sabaramais.onibus.service.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	/**
	 * Get all companies from database
	 * @return list of companies
	 */
	@RequestMapping("")
	public Iterable<Company> findAll(){
		return companyService.findAll();
	}
	
	/**
	 * Get a specific company from database
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public Company findById(@PathVariable("id") long id){
		return companyService.findById(id);
	}
	
	/**
	 * Get all bus lines from a specific company
	 * @param id the company id
	 * @return list of bus lines
	 */
	@RequestMapping("/{id}/bus")
	public Iterable<Bus> getAllBusFromCompanyId(@PathVariable("id") long id){
		return companyService.getAllBusFromCompanyId(id);
	}
	
	/**
	 * Get all companies and your bus lines
	 * @return list of companies
	 */
	@RequestMapping("/bus")
	public Iterable<Company> getCompanyAndBus(){
		return companyService.getCompanyAndBus();
	}
}
