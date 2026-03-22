package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

	private Employees employees;
    public EmployeeManager() {
        // Initialize the Employees object
        employees = new Employees();
        
        // Create a mutable list of employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        employeeList.add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Project Manager"));
        employeeList.add(new Employee("3", "Emily", "Johnson", "emily.johnson@example.com", "Data Analyst"));
        
        // Set the employee list
        employees.setEmployeeList(employeeList);
    }
    public Employees getEmployees() {
        return employees;
    }
}
