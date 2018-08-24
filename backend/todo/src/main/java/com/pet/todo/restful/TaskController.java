package com.pet.todo.restful;

import com.pet.todo.model.Task;
import com.pet.todo.repository.TaskRepository;
import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Gun on 8/24/18.
 */

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        ListDto<Task> lstDto = taskService.getAllTask();
        return new Envelop(lstDto).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task){
        taskService.addTask(task);
        return new Envelop(null).toResponseEntity();
    }
}
