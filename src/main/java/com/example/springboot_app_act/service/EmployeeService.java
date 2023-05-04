package com.example.springboot_app_act.service;


import com.example.springboot_app_act.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployeesService();

    Employee getEmployeeByIdService(int id);

    void addEmployeeService(Employee employee);

    void updateEmployeeService(Employee employee);

    void deleteEmployeeService(int id);

    List<Employee> getEmployeesByNameService(String name);
}
