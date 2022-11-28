package com.dmitriev.DAO;

import com.dmitriev.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public List<Employee> findByProgrammerPosition();

}
