package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getScheduleForEmployee(Long id) {
        return scheduleRepository.getScheduleForEmployee(id);
    }

    @Override
    public List<Schedule> getScheduleForPet(Long id) {
        return scheduleRepository.getScheduleForPet(id);
    }

    @Override
    public List<Schedule> getScheduleForCustomer(Long id) {
        return scheduleRepository.getScheduleForCustomer(id);
    }
}
