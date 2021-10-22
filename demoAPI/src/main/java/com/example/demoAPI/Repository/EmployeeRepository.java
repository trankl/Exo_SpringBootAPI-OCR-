package com.example.demoAPI.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demoAPI.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
