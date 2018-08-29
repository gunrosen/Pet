package com.pet.todo.repository;

import com.pet.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Gun on 8/24/18.
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
     Task findByTitle(String title);
}
