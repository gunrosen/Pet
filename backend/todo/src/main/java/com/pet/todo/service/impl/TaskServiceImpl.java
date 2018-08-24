package com.pet.todo.service.impl;

import com.pet.todo.model.Task;
import com.pet.todo.repository.TaskRepository;
import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Gun on 8/24/18.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public ListDto<Task> getAllTask() {
        List<Task> lst = (List<Task>) taskRepository.findAll();
        return new ListDto<Task>(lst);
    }

    @Override
    public void addTask(Task task) {
        task.setModifiedTime(new Date());
        task.setCreatedTime(new Date());
        taskRepository.save(task);
    }
}
