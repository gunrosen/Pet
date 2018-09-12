package com.pet.todo.restful.dto;

import com.pet.todo.domain.Employee;

import java.io.Serializable;

/**
 * Created by Gun on 9/10/18.
 */
public class EmployeeDto implements Serializable{

    private int employeeNumber;
    private String name;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String jobTitle;

    EmployeeDto(){}

    public EmployeeDto(Employee em){
        this.employeeNumber = em.getEmployeeNumber();
        this.name = em.getFirstName() + " " + em.getLastName();
        this.email = em.getEmail();
        this.jobTitle = em.getJobTitle();
        this.firstName = em.getFirstName();
        this.lastName = em.getLastName();
    }

    public Employee toEntity(){
        Employee em = new Employee();
        em.setFirstName(this.firstName);
        em.setLastName(this.lastName);
        em.setEmail(this.email);
        em.setExtension(this.extension);
        em.setJobTitle(this.jobTitle);
        return em;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
