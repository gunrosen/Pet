package com.pet.todo;

import com.pet.todo.domain.Task;
import com.pet.todo.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
/**
 * Created by Gun on 8/24/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception{
        Task task1 = new Task("Alice","Prepare something") ;
        Task task2 = new Task("Bob","Coding something") ;

        taskRepository.save(task1);
        taskRepository.save(task2);

    }

    @Test
    public void testInsertData(){
        Task bob = taskRepository.findByTitle("Bob");
        assertNotNull(bob);
    }

    @Test
    public void testUpdateData(){
        Task bob = taskRepository.findByTitle("Bob");
        bob.setContent("Update Successful");
        taskRepository.save(bob);

        Task bobUpdate = taskRepository.findByTitle("Bob");
        assertTrue(bobUpdate.getContent().contains("Update"));
    }

    @Test
    public void testGetData(){
       Iterable<Task> lstTask = taskRepository.findAll();
       lstTask.forEach( task -> {
                   System.out.print(task.getContent());
                   assertNotNull(task);
               }
       );
    }
}
