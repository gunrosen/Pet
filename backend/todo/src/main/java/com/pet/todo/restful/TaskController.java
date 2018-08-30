package com.pet.todo.restful;

import com.pet.todo.model.Task;
import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Gun on 8/24/18.
 */

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> getAll() {
//        ListDto<Task> lstDto = taskService.getAllTask();
//        return new Envelop(lstDto).toResponseEntity();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new Envelop(null).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> editTask(@RequestBody Task task) {
        Task editedTask = taskService.editTask(task);
        return new Envelop(editedTask).toResponseEntity();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        taskService.deleteTask(Long.valueOf(id));
        return new Envelop(null).toResponseEntity();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getTaskPaging(@RequestParam Integer page, @RequestParam Integer size){
        ListDto<Task> lstDto = taskService.getTask(page,size);
        return new Envelop(lstDto).toResponseEntity();
    }

}
