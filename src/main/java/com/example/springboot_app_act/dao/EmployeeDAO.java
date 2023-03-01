package com.example.springboot_app_act.dao;

import com.example.springboot_app_act.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployeesDAO();

    Employee getEmployeeByIdDAO(int id);

    void addEemployeeDAO(Employee employee);

    void updateEmployeeDAO(Employee employee);

    void deleteEmployeeDAO(int id);
}
