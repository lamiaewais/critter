package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE :day MEMBER OF e.daysAvailable")
    List<Employee> findEmployeesForService(DayOfWeek day);
}
