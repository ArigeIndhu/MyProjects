package com.java.employee.bal;

import com.java.employee.dao.EmployeeDao;
import com.java.employee.dao.EmployeeDaoImpl;
import com.java.employee.exception.EmployeeException;
import com.java.employee.model.Employee;

import java.util.List;

public class EmployeeBal {

    static StringBuilder sb;
    static EmployeeDao employeeDao;

    static {
        sb = new StringBuilder();
        employeeDao = new EmployeeDaoImpl();
    }

    public List<Employee> showEmployeeBal() {
        return employeeDao.showEmployeeDao();
    }

    public String addEmployeeBal(Employee employee) throws EmployeeException {
        if (validateEmployee(employee) == true) {
            return employeeDao.addEmployeeDao(employee);
        }
        throw new EmployeeException(sb.toString());
    }

    public String updateEmployeeBal(Employee employee) throws EmployeeException {
        if (validateEmployee(employee) == true) {
            return employeeDao.updateEmployeeDao(employee);
        }
        throw new EmployeeException(sb.toString());
    }
        public Employee searchEmployeeBal ( int empno){
            return employeeDao.searchEmployeeDao(empno);
        }

        public String deleteEmployeeBal ( int empno){
            return employeeDao.deleteEmployeeDao(empno);
        }

        public boolean validateEmployee (Employee employee){
            boolean isValid = true;

            if (employee.getEmpno() <= 0) {
                sb.append("Employ No Cannot be Zero or Negative...\n");
                isValid = false;
            }
            if (employee.getName().length() < 5) {
                sb.append("Employ Name must be 5 char min...\n");
                isValid = false;
            }
            if (employee.getDept().length() < 3) {
                sb.append("Department Contains Min 3 Chars...\n");
                isValid = false;
            }

            if (employee.getBasic() < 10000 || employee.getBasic() > 80000) {
                sb.append("Basic Must be Between 10000 and 80000...\n");
                isValid = false;
            }
            return isValid;
        }
    }