package com.example.springboot_app_act.dao;

import com.example.springboot_app_act.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override                                                       // 1. Получение всех;
    public List<Employee> getEmployeesDAO() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }

    @Override                                                       //  2. Получение одного по id;
    public Employee getEmployeeByIdDAO(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override                                                       //  3. Добавление;
    public void addEemployeeDAO(Employee employee) {
        Employee newEmoloyee = entityManager.merge(employee);
        employee.setId(newEmoloyee.getId());
    }

    @Override                                                       //  4. Изменение;
    public void updateEmployeeDAO(Employee employee) {
        entityManager.merge(employee);
    }

    @Override                                                       //  5. Удаление
    public void deleteEmployeeDAO(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
