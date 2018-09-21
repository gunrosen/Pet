package com.pet.todo.service;

import com.pet.todo.restful.dto.common.ListDto;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;

/**
 * Created by Gun on 9/21/18.
 */
public interface BaseService <DTO extends Serializable, ID extends Object> {

    ListDto<DTO> getList(PageRequest page) ;

    ListDto<DTO> getList() ;

    ID create(DTO dto);

    ID update(DTO dto) ;

    DTO findById(ID id) ;

    boolean delete(ID id);
}
