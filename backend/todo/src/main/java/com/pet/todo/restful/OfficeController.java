package com.pet.todo.restful;

import com.pet.todo.restful.dto.OfficeDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gun on 9/21/18.
 */
@RestController(value = "apiOffice")
@RequestMapping(value = "/api/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll(){
        ListDto<OfficeDto> lstDto = officeService.getList();
        return new Envelop(lstDto).toResponseEntity();
    }
}
