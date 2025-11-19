package com.java.employee.dao;


import com.java.employee.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> showEmployeeDao();
    String addEmployeeDao(Employee employee);
    Employee searchEmployeeDao(int empno);
    String deleteEmployeeDao(int empno);
    String updateEmployeeDao(Employee employeeUpdate);
}