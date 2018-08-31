package com.pet.todo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Task")

public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Boolean isCompleted;


    private ZonedDateTime createdTime;

    private ZonedDateTime modifiedTime;

    public Task(@NotBlank String title, @NotBlank String content) {
        this.title = title;
        this.content = content;
        this.isCompleted = false;
        this.createdTime =  ZonedDateTime.now(ZoneId.systemDefault());
        this.modifiedTime =  ZonedDateTime.now(ZoneId.systemDefault());
    }
    public Task(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
