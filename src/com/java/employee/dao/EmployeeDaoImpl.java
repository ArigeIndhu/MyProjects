package com.java.employee.dao;

import com.java.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    static List<Employee> employeeList;

    static {
        employeeList = new ArrayList<Employee>();
    }

    @Override
    public List<Employee> showEmployeeDao() {

        return employeeList;
    }

    @Override
    public String addEmployeeDao(Employee employee) {
        employeeList.add(employee);
        return "Employ Record Inserted...";
    }

    @Override
    public Employee searchEmployeeDao(int empno) {
        Employee employeeFound = employeeList.stream().filter(employee -> employee.getEmpno() == empno).findFirst().orElse(null);
        return employeeFound;
    }

    @Override
    public String deleteEmployeeDao(int empno) {
        Employee employeeFound = searchEmployeeDao(empno);
        if (employeeFound != null) {
            employeeList.remove(employeeFound);
            return "Employ Record Deleted...";
        }
        return "Employ Record Not Found...";
    }

    @Override
    public String updateEmployeeDao(Employee employeeUpdate) {
        Employee employeeFound = searchEmployeeDao(employeeUpdate.getEmpno());
        if (employeeFound != null) {
            employeeFound.setName(employeeUpdate.getName());
            employeeFound.setGender(employeeUpdate.getGender());
            employeeFound.setDept(employeeUpdate.getDept());
            employeeFound.setDesig(employeeUpdate.getDesig());
            employeeFound.setBasic(employeeUpdate.getBasic());
            return "Employ Record Updated...";
        }
        return "Employ Record Not Found...";
    }
}