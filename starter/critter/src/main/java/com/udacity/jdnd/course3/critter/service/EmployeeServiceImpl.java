package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Employee;
import com.udacity.jdnd.course3.critter.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void setEmployeeAvailability(Long id, Set<DayOfWeek> daysAvailable) {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new).setDaysAvailable(daysAvailable);
    }

    @Override
    public List<Employee> findEmployeesForService(DayOfWeek day) {
        return employeeRepository.findEmployeesForService(day);
    }
}
