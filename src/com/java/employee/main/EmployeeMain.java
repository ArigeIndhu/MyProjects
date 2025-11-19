package com.java.employee.main;


import com.java.employee.bal.EmployeeBal;
import com.java.employee.exception.EmployeeException;
import com.java.employee.model.Employee;
import com.java.employee.model.Gender;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

    static EmployeeBal employeeBal;
    static {
        employeeBal = new EmployeeBal();
    }

    public static void searchEmployeeMain() {
        int empno;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employ no:  ");
        empno = sc.nextInt();
        Employee employee = employeeBal.searchEmployeeBal(empno);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employe Not Found");
        }
    }

    public  static void deleteEmployeeMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employ no:  ");
        int empno = sc.nextInt();
        System.out.println(employeeBal.deleteEmployeeBal(empno));
    }

    public static void showEmployeeMain() {
        List<Employee> employeeList = employeeBal.showEmployeeBal();
        employeeList.forEach(x -> {
            System.out.println(x);
        });
    }
    public static void addEmployeeMain() throws EmployeeException {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter Employ Number   ");
        employee.setEmpno(sc.nextInt());
        System.out.println("Enter Employ Name   ");
        employee.setName(sc.next());
        System.out.println("Enter Gender (MALE/FEMALE)    ");
        employee.setGender(Gender.valueOf(sc.next()));
        System.out.println("Enter Department   ");
        employee.setDept(sc.next());
        System.out.println("Enter Designation      ");
        employee.setDesig(sc.next());
        System.out.println("Enter Salary            ");
        employee.setBasic(sc.nextDouble());
        System.out.println(employeeBal.addEmployeeBal(employee));
    }

    public static void updateEmployeeMain() throws EmployeeException {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter Employ Number   ");
        employee.setEmpno(sc.nextInt());
        System.out.println("Enter Employ Name   ");
        employee.setName(sc.next());
        System.out.println("Enter Gender (MALE/FEMALE)    ");
        employee.setGender(Gender.valueOf(sc.next()));
        System.out.println("Enter Department   ");
        employee.setDept(sc.next());
        System.out.println("Enter Designation      ");
        employee.setDesig(sc.next());
        System.out.println("Enter Salary            ");
        employee.setBasic(sc.nextDouble());
        System.out.println(employeeBal.updateEmployeeBal(employee));
    }
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("O P T I O N S");
            System.out.println("1. Add Employ");
            System.out.println("2. Show Employ");
            System.out.println("3. Search Employ");
            System.out.println("4. Delete Employ");
            System.out.println("5. Update Employ");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice) {
                case 1 :
                    try {
                        addEmployeeMain();
                    } catch (EmployeeException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2 :
                    showEmployeeMain();
                    break;
                case 3 :
                    searchEmployeeMain();
                    break;
                case 4 :
                    deleteEmployeeMain();
                    break;
                case 5 :
                    try {
                        updateEmployeeMain();
                    } catch (EmployeeException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6 :
                    System.exit(0);
            }
        } while(choice !=6);
    }
}
