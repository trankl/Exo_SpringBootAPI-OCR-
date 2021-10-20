package com.example.API.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.API.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
 //~DAO
}
