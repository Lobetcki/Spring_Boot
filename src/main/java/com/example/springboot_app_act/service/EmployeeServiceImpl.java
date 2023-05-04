package com.example.springboot_app_act.service;

import org.springframework.stereotype.Service;
import com.example.springboot_app_act.dao.EmployeeDAO;
import com.example.springboot_app_act.entity.Employee;
import com.example.springboot_app_act.exceptions.EmployeeException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesService() {
        return employeeDAO.getEmployeesDAO();
    }

    @Override
    @Transactional
    public Employee getEmployeeByIdService(int id) {
        Employee employee = employeeDAO.getEmployeeByIdDAO(id);
        if (employee == null) {
        throw new EmployeeException("Person with id = " + id + " doesn't exist");
            }
        return employee;
    }

    @Override
    @Transactional
    public void addEmployeeService(Employee employee) {
        employee.setId(null);
        employeeDAO.addEemployeeDAO(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeService(Employee employee) {
        employeeDAO.updateEmployeeDAO(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeService(int id) {
        Employee employee = employeeDAO.getEmployeeByIdDAO(id);
        if (employee == null) {
            throw new EmployeeException("Person with id = " + id + " doesn't exist");
        }

        employeeDAO.deleteEmployeeDAO(id);
    }
}
