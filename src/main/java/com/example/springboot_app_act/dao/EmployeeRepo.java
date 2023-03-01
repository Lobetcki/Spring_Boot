package com.example.springboot_app_act.dao;

import com.example.springboot_app_act.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository {

    List<Employee> findAllByNameRepo(String name);

}
