package com.pet.todo.repository;

import com.pet.todo.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gun on 9/20/18.
 */
public interface OfficeRepository extends JpaRepository<Office,String> {
}
