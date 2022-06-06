package com.ironhack.lab402.repository;

import com.ironhack.lab402.models.Employee;
import com.ironhack.lab402.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findByDateOfBirthBetween(Date start, Date end);

    //public List<Patient> findByEmployeeIdContainingDepartment(Employee employeeId, String deparment);



    @Query(
            value = "SELECT Patient.name, Patient.id, Patient.date_of_birth, Patient.admitted_by from Patient " +
                    "INNER JOIN Employee ON Employee.employee_id = Patient.admitted_by WHERE Employee.department = :department ",
            nativeQuery = true)
    List<Patient> findPatientsByDepartmentNative(@Param("department") String department);

    @Query(
            value=  "SELECT Patient.name, Patient.id, Patient.date_of_birth, Patient.admitted_by from Patient" +
                    "INNER JOIN Employee ON Employee.employee_id = Patient.admitted_by WHERE Employee.status = :status ",
            nativeQuery = true)
    List<Patient>findPatientsByStatusNative(@Param("status") String status);
}
