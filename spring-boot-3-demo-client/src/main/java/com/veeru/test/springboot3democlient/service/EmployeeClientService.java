package com.veeru.test.springboot3democlient.service;

import com.veeru.test.springboot3democlient.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/employee")
public interface EmployeeClientService {

    @GetExchange
    List<Employee> getAllEmployees();

    @GetExchange("/{id}")
    Employee getEmployeeById(@PathVariable int id);

    @PostExchange
    Employee addEmployee(@RequestBody Employee emp);

}
