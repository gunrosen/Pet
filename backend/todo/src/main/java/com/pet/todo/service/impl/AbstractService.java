package com.pet.todo.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pet.todo.domain.Domain;
import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

/**
 * Created by Gun on 9/20/18.
 */
public abstract class AbstractService<DTO extends Serializable, DOMAIN extends Domain, ID extends Object> implements BaseService<DTO,ID>{

    protected abstract JpaRepository<DOMAIN, ID> getRepository();

    protected abstract DTO convertToDto(DOMAIN domain);

    protected abstract DOMAIN convertToDomain(DTO dto);

    protected abstract ID getObjectId(DTO dto);

    protected abstract ID getDomainId(DOMAIN domain);

    protected abstract DTO emptyDTO();

    @Override
    public ListDto<DTO> getList(PageRequest page) {
        Page<DOMAIN> pageDomain = getRepository().findAll(page);
        List<DTO> lstDto = pageDomain.stream().map(this::convertToDto).collect(Collectors.toList());
        long count = getRepository().count();
        return new ListDto<>(count, lstDto);
    }

    @Override
    public ListDto<DTO> getList() {
        List<DOMAIN> lstDomain = getRepository().findAll();
        List<DTO> lstDto = lstDomain.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ListDto<DTO>(lstDto);
    }

    @Override
    public ID create(DTO dto) {
        DOMAIN domain = convertToDomain(dto);
        domain.setLastModifiedDate(new Date());
        DOMAIN newDomain = getRepository().save(domain);
        return getDomainId(newDomain);
    }

    @Override
    public ID update(DTO dto) {
        ID objectId = getObjectId(dto);
        Assert.notNull(objectId,"Id could not be null");
        Optional<DOMAIN> domain = getRepository().findById(objectId);
        domain.orElseThrow(() -> new ResourceNotFoundException());

        DOMAIN _domain = domain.get();
        _domain.setLastModifiedDate(new Date());
        DOMAIN updateDomain = getRepository().save(_domain);
        return getDomainId(updateDomain);
    }

    @Override
    public DTO findById(ID id) {
        Optional<DOMAIN> domain = getRepository().findById(id);
        if (domain.isPresent()) {
            return convertToDto(domain.get());
        } else {
            return emptyDTO();
        }
    }

    @Override
    public boolean delete(ID id){
        Assert.notNull(id,"Id could not be null");
        Optional<DOMAIN> domain = getRepository().findById(id);
        domain.orElseThrow(() -> new ResourceNotFoundException());
        getRepository().deleteById(id);
        return true;
    }

}
