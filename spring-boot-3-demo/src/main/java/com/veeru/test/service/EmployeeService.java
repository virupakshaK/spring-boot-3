package com.veeru.test.service;

import com.veeru.test.model.Employee;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    @Autowired
    ObservationRegistry observationRegistry;

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        //return employee;
        return Observation.createNotStarted("AddEmployee", observationRegistry).observe(() -> employee);
    }

    public List<Employee> getAllEmployees() {
        //return employeeList;

        return Observation.createNotStarted("GetAllEmployees", observationRegistry).observe(() -> employeeList);
    }

    public Employee getEmployeeById(int id) {
        //return employeeList.stream().filter(emp -> emp.id() == id).findFirst().get();

        return Observation.createNotStarted("GetEmployeeById", observationRegistry).observe(() -> employeeList.stream().filter(emp -> emp.id() == id).findFirst().get());
    }


}
