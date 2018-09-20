package com.pet.todo.service.impl;

import com.pet.todo.domain.Office;
import com.pet.todo.repository.OfficeRepository;
import com.pet.todo.restful.dto.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Gun on 9/20/18.
 */
@Service
public class OfficeServiceImpl extends BaseService<OfficeDTO,Office> {
    @Autowired
    OfficeRepository officeRepository;

    @Override
    protected JpaRepository<Office, Object> getRepository() {
        return officeRepository;
    }

    @Override
    protected OfficeDTO convertToDto(Office domain) {
        return null;
    }

    @Override
    protected Office convertToDomain(OfficeDTO officeDTO) {
        return null;
    }

    @Override
    protected Object getObjectId(OfficeDTO officeDTO) {
        return null;
    }

    @Override
    protected OfficeDTO emptyDTO() {
        return null;
    }
}
