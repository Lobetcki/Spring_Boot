package com.example.springboot_app_act.controller;

import org.springframework.web.bind.annotation.*;
import com.example.springboot_app_act.entity.Employee;
import com.example.springboot_app_act.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/springBoot")
public class RestControllerNew {

    private EmployeeService employeeService;

    public RestControllerNew(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployeesController() {
        return employeeService.getEmployeesService();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeByIdController(@PathVariable int id){
        return employeeService.getEmployeeByIdService(id);
    }

    @PostMapping("/employee")
    public Employee addEmployeeController(@RequestBody Employee employee) {
        employeeService.addEmployeeService(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployeeController(@RequestBody Employee employee) {
        employeeService.updateEmployeeService(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeController(@PathVariable int id) {
        employeeService.deleteEmployeeService(id);
        return "Person with id = " + id + " was deleted";
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> getEmployeesByNameController(@PathVariable String name) {
        return employeeService.getEmployeesByNameService(name);
    }

}
