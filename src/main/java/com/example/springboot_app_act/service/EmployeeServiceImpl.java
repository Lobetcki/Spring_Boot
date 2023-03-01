package com.example.springboot_app_act.service;

import org.springframework.stereotype.Service;
import com.example.springboot_app_act.dao.EmployeeRepo;
import com.example.springboot_app_act.entity.Employee;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesService() {
        return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeByIdService(int id) {
        return (Employee) employeeRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void addEmployeeService(Employee employee) {
        employee.setId(null);
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeService(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeService(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByNameService(String name) {
        return employeeRepo.findAllByNameRepo(name);
    }
}
