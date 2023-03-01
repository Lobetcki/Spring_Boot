package com.example.springboot_app_act.service;

import org.springframework.stereotype.Service;
import com.example.springboot_app_act.dao.EmployeeRepo;
import com.example.springboot_app_act.entity.Employee;
import com.example.springboot_app_act.exceptions.EmployeeException;

import javax.transaction.Transactional;
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
        Employee employee = (Employee) employeeRepo.findById(id).get();
//        if (employee == null) {
//        throw new EmployeeException("Person with id = " + id + " doesn't exist");
//            }
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
//        Employee employee = employeeRepo.deleteById(id);
//        if (employee == null) {
//            throw new EmployeeException("Person with id = " + id + " doesn't exist");
//        }

        employeeRepo.deleteById(id);
    }
}
