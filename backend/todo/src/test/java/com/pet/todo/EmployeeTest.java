package com.pet.todo;

import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.OfficeDto;
import com.pet.todo.service.EmployeeService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Gun on 9/21/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeService employeeService;

    List<Integer> lstIds = null;

    @Before
    public void setUp() {
        lstIds = new ArrayList<>();

        OfficeDto office = new OfficeDto();
        office.setOfficeCode("2");

        EmployeeDto dto1 = new EmployeeDto();
        dto1.setName("Pham Hung");
        dto1.setEmail("gunrosen@mail.com");
        dto1.setExtension("Mr.");
        dto1.setJobTitle("Dr.");
        dto1.setFirstName("Hung");
        dto1.setLastName("Pham");
        dto1.setOfficeCode(office);

        EmployeeDto dto2 = new EmployeeDto();
        dto2.setName("Pham Hung");
        dto2.setEmail("gunrosen@mail.com");
        dto2.setExtension("Mr.");
        dto2.setJobTitle("Dr.");
        dto1.setFirstName("Hung");
        dto1.setLastName("Pham");
        dto2.setOfficeCode(office);

        int id1 = employeeService.create(dto1);
        int id2 = employeeService.create(dto2);
        lstIds.add(id1);
        lstIds.add(id2);

    }

    @After
    public void deleteData() {
        for (int id : lstIds) {
            employeeService.delete(id);
        }
    }

    @Test
    public void count() {

    }

    @Test
    public void test1() {
        List<EmployeeDto> lstDto = employeeService.getList().getList();
        lstDto.forEach(Assert::assertNotNull);
    }
}
