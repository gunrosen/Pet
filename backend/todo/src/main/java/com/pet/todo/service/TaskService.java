package com.pet.todo.service;

import com.pet.todo.domain.Task;
import com.pet.todo.restful.dto.ListDto;

/**
 * Created by Gun on 8/24/18.
 */
public interface TaskService {

    ListDto<Task> getAllTask();

    void addTask(Task task);

    Task editTask(Task task);

    void deleteTask(long id);

    ListDto<Task> getTask(int page, int size);
}
