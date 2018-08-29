package com.pet.todo.service.impl;

import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.model.Task;
import com.pet.todo.repository.TaskRepository;
import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        task.setModifiedTime(ZonedDateTime.now(ZoneId.systemDefault()));
        task.setCreatedTime(ZonedDateTime.now(ZoneId.systemDefault()));
        taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task editTask(Task task) {
        Optional<Task> _task = taskRepository.findById(task.getId());
        _task.orElseThrow(() -> new ResourceNotFoundException("Task", "id", task.getId()));
        _task.ifPresent(t -> {
            t.setModifiedTime(ZonedDateTime.now(ZoneId.systemDefault()));
            taskRepository.save(t);
        });

        return _task.orElse(null);
    }

    @Override
    public void deleleTask(long id) {
        Optional<Task> task = taskRepository.findById(id);
        task.orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        taskRepository.deleteById(id);
    }

    @Override
    public ListDto<Task> getTask(int page, int size) {
        long total = taskRepository.count();
        Page<Task> pageTask = taskRepository.findAll(PageRequest.of(page, size));
        ListDto<Task> lstTask = new ListDto<Task>(total, pageTask.getContent());
        return lstTask;
    }
}
