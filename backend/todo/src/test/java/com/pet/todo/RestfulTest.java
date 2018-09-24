package com.pet.todo;

import com.pet.todo.domain.Employee;
import com.pet.todo.restful.EmployeeController;
import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.OfficeDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gun on 9/24/18.
 */
@WebMvcTest(value = EmployeeController.class,secure = false)
@RunWith(SpringRunner.class)
public class RestfulTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void findAllEmployee() throws Exception{
        String expected = "{\"count\":1,\"list\":[{\"employeeNumber\":1,\"name\":\"Pham Hung\",\"firstName\":\"Hung1\",\"lastName\":\"Pham1\",\"extension\":\"Mr.\",\"email\":\"gunrosen@mail.com\",\"jobTitle\":\"Dr.\",\"officeCode\":{\"officeCode\":\"2\",\"city\":null,\"phone\":null,\"addressLine1\":null,\"addressLine2\":null,\"state\":null,\"country\":null,\"postalCode\":null,\"territory\":null}}]}";

        OfficeDto office = new OfficeDto();
        office.setOfficeCode("2");

        EmployeeDto dto1 = new EmployeeDto();
        dto1.setEmployeeNumber(1);
        dto1.setName("Pham Hung");
        dto1.setEmail("gunrosen@mail.com");
        dto1.setExtension("Mr.");
        dto1.setJobTitle("Dr.");
        dto1.setFirstName("Hung1");
        dto1.setLastName("Pham1");
        dto1.setOfficeCode(office);

        List<EmployeeDto> lst = new ArrayList<>();
        lst.add(dto1);
        ListDto<EmployeeDto> lstDto = new ListDto<EmployeeDto>(lst);

        Mockito.when(employeeService.getList(Mockito.any(PageRequest.class))).thenReturn(lstDto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employee?page=0&size=10")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true);
    }

}
