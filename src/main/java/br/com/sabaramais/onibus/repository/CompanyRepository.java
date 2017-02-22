package br.com.sabaramais.onibus.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabaramais.onibus.entity.Bus;
import br.com.sabaramais.onibus.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	/**
	 * Get all bus and lines if they have
	 * @return list of bus with lines
	 */
	@Query("select c from company as c left join fetch c.bus")
	public Set<Company> getCompanyAndBus();
	
	/**
	 * Get all bus from a specific company
	 * @param id the company id
	 * @return list of bus lines
	 */
	@Query("select b from bus as b join fetch b.company as c where c.id = ?1")
	public Set<Bus> getAllBusFromCompanyId(long id);
}