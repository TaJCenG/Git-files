package com.example.restservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    private EmployeeController employeeController;
    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = Mockito.mock(EmployeeManager.class);
        employeeController = new EmployeeController(employeeManager);
    }

    @Test
    public void testGetEmployees() {
        // Arrange
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        employeeList.add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Project Manager"));
        Employees employees = new Employees();
        employees.setEmployeeList(employeeList);
        
        when(employeeManager.getEmployees()).thenReturn(employees);

        // Act
        Employees result = employeeController.getEmployees();

        // Assert
        assertEquals(2, result.getEmployeeList().size());
        assertEquals("John", result.getEmployeeList().get(0).getFirstName());
    }

    @Test
    public void testAddEmployee() {
        // Arrange
        Employee newEmployee = new Employee("3", "Alice", "Brown", "alice.brown@example.com", "HR Manager");
        
        // Create a mutable list to hold employees
        List<Employee> employeeList = new ArrayList<>();
        Employees employees = new Employees();
        employees.setEmployeeList(employeeList);
        
        // Mock the behavior of employeeManager
        when(employeeManager.getEmployees()).thenReturn(employees);

        // Act
        ResponseEntity<Employee> response = employeeController.addEmployee(newEmployee);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newEmployee.getFirstName(), response.getBody().getFirstName());
        assertEquals(1, employees.getEmployeeList().size()); // Check that the employee was added
        assertEquals("Alice", employees.getEmployeeList().get(0).getFirstName()); // Verify the added employee
    }
}
