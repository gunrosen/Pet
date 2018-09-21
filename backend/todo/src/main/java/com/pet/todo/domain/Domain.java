package com.pet.todo.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gun on 9/20/18.
 */
@MappedSuperclass
public abstract class Domain implements Serializable {

    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;

    @Column(name = "lastModifiedEmployee")
    private String lastModifiedEmployee;


    public Domain(){}

    public Domain(Date lastModifiedDate, String lastModifiedEmployee) {
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedEmployee = lastModifiedEmployee;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedEmployee() {
        return lastModifiedEmployee;
    }

    public void setLastModifiedEmployee(String lastModifiedEmployee) {
        this.lastModifiedEmployee = lastModifiedEmployee;
    }

    public String getClassName(){
        return this.getClass().getName();
    }
}
