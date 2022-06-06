package com.ironhack.lab402.Controller;

import com.ironhack.lab402.models.Employee;
import com.ironhack.lab402.models.Patient;
import com.ironhack.lab402.repository.EmployeeRepository;
import com.ironhack.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    //5. Create a route to get all patients.

    @GetMapping("/patients")
    public List<Patient> getALlPatients(){ return patientRepository.findAll(); }

    //6. Create a route to get a patient by patient_id.

    @GetMapping("/patients/{id}")
    public Patient findById(@PathVariable int id){
        if(patientRepository.findById(id).isPresent()) return patientRepository.findById(id).get();
        else return null;

    }

    //7. Create a route to get patients date of birth within a specified range.

    @GetMapping("patient-date/")
    public List<Patient> findByDateRange(@RequestParam Date start, @RequestParam Date end){
        return patientRepository.findByDateOfBirthBetween(start,end);
    }

    //8. Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).

    @GetMapping("patient-department")
    public List<Patient>findByEmployeeDepartment(@RequestParam String department){
        return patientRepository.findPatientsByDepartmentNative(department);
    }

    //9. Create a route to get all patients with a doctor whose status is OFF.

    @GetMapping("patient-status")
    public List<Patient>findByEmployeeStatus(@RequestParam String status){
        return patientRepository.findPatientsByStatusNative(status);
    }


}
