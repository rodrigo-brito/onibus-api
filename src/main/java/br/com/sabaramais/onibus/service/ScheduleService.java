package br.com.sabaramais.onibus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabaramais.onibus.entity.Schedule;
import br.com.sabaramais.onibus.repository.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepository;

	/**
	 * Get all schedules from database
	 * @return list of schedules
	 */
	public Iterable<Schedule> findAll() {
		return scheduleRepository.getAllSchedulesByTime();
	}

	/**
	 * Get a specific schedule
	 * @param id the schedule id
	 * @return schedule or null if not found
	 */
	public Schedule findOne(long id) {
		return scheduleRepository.findOne(id);
	}

}
