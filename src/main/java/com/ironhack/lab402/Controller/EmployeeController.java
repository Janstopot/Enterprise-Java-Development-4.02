package com.ironhack.lab402.Controller;

import com.ironhack.lab402.models.Employee;
import com.ironhack.lab402.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    //1. Create a route to get all doctors.

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){ return employeeRepository.findAll();}


    //2. Create a route to get a doctor by employee_id.

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        if(employeeRepository.findById(id).isPresent()) return employeeRepository.findById(id).get();
        else return null;

    }

    //3. Create a route to get doctors by status.


    @GetMapping("/employee-status/")
    public List<Employee> findAllByStatus(@RequestParam String status){
        return employeeRepository.findByStatus(status);
    }

    //4. Create a route to get doctors by department.

    @GetMapping("/employee-department/")
    public List<Employee> findAllByDepartment(@RequestParam String department){
        return employeeRepository.findByDepartment(department);
    }

}
