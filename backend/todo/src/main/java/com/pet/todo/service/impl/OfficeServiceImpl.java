package com.pet.todo.service.impl;

import com.pet.todo.domain.Office;
import com.pet.todo.repository.OfficeRepository;
import com.pet.todo.restful.dto.OfficeDto;
import com.pet.todo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Gun on 9/20/18.
 */
@Service
public class OfficeServiceImpl extends AbstractService<OfficeDto, Office, String> implements OfficeService{

    @Autowired
    OfficeRepository officeRepository;

    @Override
    protected JpaRepository<Office, String> getRepository() {
        return officeRepository;
    }

    @Override
    protected OfficeDto convertToDto(Office domain) {
        OfficeDto dto = new OfficeDto();
        dto.setOfficeCode(domain.getOfficeCode());
        dto.setCity(domain.getCity());
        dto.setCountry(domain.getCountry());
        dto.setPhone(domain.getPhone());
        dto.setAddressLine1(domain.getAddressLine1());
        dto.setAddressLine2(domain.getAddressLine2());
        dto.setPostalCode(domain.getPostalCode());
        dto.setState(domain.getState());
        dto.setTerritory(domain.getTerritory());

        return dto;
    }

    @Override
    protected Office convertToDomain(OfficeDto dto) {
        return dto.toDomain();
    }

    @Override
    protected String getObjectId(OfficeDto officeDTO) {
        return officeDTO.getOfficeCode();
    }

    @Override
    protected String getDomainId(Office domain) {
        return domain.getOfficeCode();
    }

    @Override
    protected OfficeDto emptyDTO() {
        return new OfficeDto();
    }
}
