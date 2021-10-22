package com.example.demoAPI.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAPI.Model.Employee;
import com.example.demoAPI.Repository.EmployeeRepository;

import lombok.Data;

@Data
@Service
public class EmployeeService {

	  @Autowired
	    private EmployeeRepository employeeRepository;

	    public Optional<Employee> getEmployee(final Long id) {
	        return employeeRepository.findById(id);
	    }

	    public Iterable<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public void deleteEmployee(final Long id) {
	        employeeRepository.deleteById(id);
	    }

	    public Employee saveEmployee(Employee employee) {
	        Employee savedEmployee = employeeRepository.save(employee);
	        return savedEmployee;
	    }

}
