package com.pet.todo.restful.dto.common;

import com.pet.todo.domain.Domain;

import java.io.Serializable;

/**
 * Created by Gun on 9/21/18.
 */
public interface  AbstractDto<DOMAIN extends Domain> extends Serializable {
    DOMAIN toDomain();
}
