package com.veeru.test.springboot3democlient.controller;

import com.veeru.test.springboot3democlient.model.Employee;
import com.veeru.test.springboot3democlient.service.EmployeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/emp")
public class EmployeeClientController {

    @Autowired
    private EmployeeClientService employeeClientService;
    @GetMapping
    public List<Employee> getAllEmployees(){
        System.out.println("---> Employee service is calling");
        return employeeClientService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        System.out.println("--> Employee id:"+ id);
        return employeeClientService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("--> Employee Details:"+employee.toString());
        return employeeClientService.addEmployee(employee);
    }

    @GetMapping("/test")
    public String getTextMessage(){
        return "Welcome to Employee client service";
    }
}
