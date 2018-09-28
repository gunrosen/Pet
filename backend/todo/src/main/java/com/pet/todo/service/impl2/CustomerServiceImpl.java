package com.pet.todo.service.impl2;

import com.pet.todo.domain.Customer;
import com.pet.todo.restful.dto.CustomerDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.CustomerService;
import com.pet.todo.service.impl.AbstractService;
import com.pet.todo.support.annotation.VersionApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Gun on 9/28/18.
 */
@Service(value = "customerService2" )
@VersionApi(value = VersionApi.V.VER_2)
public class CustomerServiceImpl extends AbstractService<CustomerDto,Customer,Integer> implements CustomerService {
    @Override
    public ListDto<CustomerDto> getCustomerManagedBy(int employeeId) {
        return null;
    }

    @Override
    public ListDto<CustomerDto> getCustomerNotManaged() {
        return null;
    }

    @Override
    public void updateEmployee(int customerId, int employeeId) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    protected JpaRepository<Customer, Integer> getRepository() {
        return null;
    }

    @Override
    protected CustomerDto convertToDto(Customer domain) {
        return null;
    }

    @Override
    protected Customer convertToDomain(CustomerDto customerDto) {
        return null;
    }

    @Override
    protected Integer getObjectId(CustomerDto customerDto) {
        return null;
    }

    @Override
    protected Integer getDomainId(Customer domain) {
        return null;
    }

    @Override
    protected CustomerDto emptyDTO() {
        return null;
    }
}
