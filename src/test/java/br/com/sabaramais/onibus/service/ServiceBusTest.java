package br.com.sabaramais.onibus.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sabaramais.onibus.entity.Bus;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
})
public class ServiceBusTest {

	@Autowired
	private BusService busService;


	@Test
	public void testFindAll() {
		Iterable<Bus> bus = busService.findAll();
		assertThat(bus).isNotEmpty().hasSize(2);
	}

	@Test
	public void testFindOne() {
		Bus bus = busService.findOne(2);
		assertThat(bus).isNotNull();
		assertEquals(bus.getName(), "Executivo");
	}

	@Test
	public void testGetBusWithSchedule() {
		Iterable<Bus> bus = busService.getBusWithSchedule();
		assertThat(bus).isNotEmpty().hasSize(2);
		for(Bus b : bus){
			assertThat(b.getSchedules()).isNotNull();
		}
	}

}
