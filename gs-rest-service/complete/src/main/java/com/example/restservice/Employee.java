package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("employeeId")
    private String employee_id;

    @JsonProperty("firstName")
    private String first_name;

    @JsonProperty("lastName")
    private String last_name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("title")
    private String title;

    public Employee() {
        // Default constructor for JSON mapping
    }

    public Employee(String employee_id, String first_name, String last_name, String email, String title) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
    }

    public String getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
