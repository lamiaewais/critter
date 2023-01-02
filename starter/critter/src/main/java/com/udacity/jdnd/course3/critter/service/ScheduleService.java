package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Schedule;
import java.util.List;

public interface ScheduleService {
    Schedule saveSchedule(Schedule schedule);
    List<Schedule> getAllSchedule();
    List<Schedule> getScheduleForPet(Long id);
    List<Schedule> getScheduleForEmployee(Long id);
    List<Schedule> getScheduleForCustomer(Long id);
}
