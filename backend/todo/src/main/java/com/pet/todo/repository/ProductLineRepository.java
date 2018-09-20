package com.pet.todo.repository;

import com.pet.todo.domain.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gun on 9/20/18.
 */
public interface ProductLineRepository extends JpaRepository<ProductLine,String> {

}
