package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Employee;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(Long id);
    void setEmployeeAvailability(Long id, Set<DayOfWeek> daysAvailable);
    List<Employee> findEmployeesForService(LocalDate date);
}
