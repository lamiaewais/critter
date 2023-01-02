package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.data.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s WHERE :id MEMBER OF s.petIds")
    List<Schedule> getScheduleForPet(Long id);
    @Query("SELECT s FROM Schedule s WHERE :id MEMBER OF s.employeeIds")
    List<Schedule> getScheduleForEmployee(Long id);
    @Query("SELECT s FROM Schedule s JOIN Pet p ON p.id MEMBER OF s.petIds WHERE p.customer.id=:id")
    List<Schedule> getScheduleForCustomer(Long id);
}
