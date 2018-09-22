package com.pet.todo.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gun on 8/31/18.
 */
@Entity
@Table(name = "employees")
public class Employee extends Domain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode",referencedColumnName = "officeCode")
    private Office officeCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo",referencedColumnName = "employeeNumber")
    private Employee reportsTo;

    @Column(name = "jobTitle")
    private String jobTitle;

    public Employee(){}

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Office getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
