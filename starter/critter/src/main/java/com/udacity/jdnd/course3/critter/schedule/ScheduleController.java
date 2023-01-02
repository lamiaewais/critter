package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.data.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import com.udacity.jdnd.course3.critter.uti.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.saveSchedule(Converter.convertScheduleDtoToSchedule(scheduleDTO));
        scheduleDTO.setId(schedule.getId());
        return scheduleDTO;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService
                .getAllSchedule()
                .stream()
                .map(Converter::convertScheduleToScheduleDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return scheduleService
                .getScheduleForPet(petId)
                .stream()
                .map(Converter::convertScheduleToScheduleDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleService
                .getScheduleForEmployee(employeeId)
                .stream()
                .map(Converter::convertScheduleToScheduleDto)
                .collect(Collectors.toList());

    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return scheduleService
                .getScheduleForCustomer(customerId)
                .stream()
                .map(Converter::convertScheduleToScheduleDto)
                .collect(Collectors.toList());
    }
}
