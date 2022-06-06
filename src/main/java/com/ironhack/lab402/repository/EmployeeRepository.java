package com.ironhack.lab402.repository;

import com.ironhack.lab402.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByStatus(String status);
    public List<Employee> findByDepartment(String department);


}
