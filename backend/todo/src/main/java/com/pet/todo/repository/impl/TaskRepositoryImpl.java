package com.pet.todo.repository.impl;

import com.pet.todo.model.Task;
import com.pet.todo.repository.BaseRepository;
import com.pet.todo.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by Gun on 8/24/18.
 */
@Repository
public class TaskRepositoryImpl extends BaseRepository<Task,Long> implements TaskRepository {

    public TaskRepositoryImpl(Class<Task> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public Task findByTitle(String title) {
        return null;
    }
}
