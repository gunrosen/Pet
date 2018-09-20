package com.pet.todo.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pet.todo.domain.Domain;
import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.restful.dto.common.ListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gun on 9/20/18.
 */
public abstract class BaseService<DTO extends Serializable, DOMAIN extends Domain> {

    protected abstract JpaRepository<DOMAIN, Object> getRepository();

    protected abstract DTO convertToDto(DOMAIN domain);

    protected abstract DOMAIN convertToDomain(DTO dto);

    protected abstract Object getObjectId(DTO dto);

    protected abstract DTO emptyDTO();

    ListDto<DTO> getList(PageRequest page) {
        Page<DOMAIN> pageDomain = getRepository().findAll(page);
        List<DTO> lstDto = pageDomain.stream().map(this::convertToDto).collect(Collectors.toList());
        long count = getRepository().count();
        return new ListDto<>(count, lstDto);
    }

    ListDto<DTO> getList() {
        List<DOMAIN> lstDomain = getRepository().findAll();
        List<DTO> lstDto = lstDomain.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ListDto<DTO>(lstDto);
    }

    DTO create(DTO dto) {
        DOMAIN domain = convertToDomain(dto);
        DOMAIN newDomain = getRepository().save(domain);
        return convertToDto(newDomain);
    }

    DTO update(DTO dto) {
        Object objectId = getObjectId(dto);
        Optional<DOMAIN> domain = getRepository().findById(objectId);
        domain.orElseThrow(() -> new ResourceNotFoundException());
        DOMAIN updateDomain = getRepository().save(domain.get());
        return convertToDto(updateDomain);
    }

    DTO findById(Object id) {
        Optional<DOMAIN> domain = getRepository().findById(id);
        if (domain.isPresent()) {
            return convertToDto(domain.get());
        } else {
            return emptyDTO();
        }
    }

}
