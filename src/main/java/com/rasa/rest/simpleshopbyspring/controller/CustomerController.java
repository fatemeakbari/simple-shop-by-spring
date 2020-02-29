package com.rasa.rest.simpleshopbyspring.controller;

import com.rasa.rest.simpleshopbyspring.EntityNotFoundException;
import com.rasa.rest.simpleshopbyspring.repository.entity.Address;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import com.rasa.rest.simpleshopbyspring.service.AddressService;
import com.rasa.rest.simpleshopbyspring.service.CustomerService;
import com.rasa.rest.simpleshopbyspring.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Customer Api")
@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/customers")
    public void save(@RequestBody @Valid Customer customer) throws Exception
    {
        customerService.save(customer);
    }

    @PostMapping("/customers/{id}/addresses")
    public void addAddress(@PathVariable Long id, @RequestBody Address address)
    {
        address.setCustomer(new Customer(id));
        addressService.save(address);
    }

    @PostMapping("/customers/{id}/orders")
    public void addOrder(@PathVariable Long id,@RequestBody Order order)
    {
        order.setCustomer(new Customer(id));
        orderService.save(order);
    }

    @PostMapping("/customers/{id}/orders/{orderId}/products/{productId}")
    public void addProduct(@PathVariable Long id, @PathVariable Long orderId, @PathVariable Long productId)
    {
        orderService.addProduct(orderId,productId);
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id) throws EntityNotFoundException
    {
        return customerService.findById(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),

            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping("/customers/name/{name}")
    public Page<Customer> findByName(Pageable pageable, @PathVariable String name)
    {
        return  customerService.findByName(pageable,name);
    }
    @GetMapping("/customers/email/{email}")
    public Customer findByEmail(@PathVariable String email)
    {
        return customerService.findByEmail(email);
    }

    @GetMapping("/customers")
    public List<Customer> findAll()
    {
        return customerService.findAll();
    }


    @GetMapping("/customers/{id}/addresses")
    public Customer findByIdAndFindAddresses(@PathVariable Long id)
    {
        Customer customer = customerService.findById(id);
        customer.setAddressList(addressService.findByCustomerId(id));
        return customer;
    }

    @GetMapping("/customers/{id}/orders")
    public Customer getOrdersByCustomerId(@PathVariable Long id)
    {
        Customer customer = customerService.findById(id);
        customer.setOrderList(orderService.findByCustomerId(id));
        return customer;
    }

    @PutMapping("/customers/{id}")
    public void update(@PathVariable Long id, @RequestBody Customer customer)
    {
        customer.setId(id);
        customerService.update(customer);
    }

    @PutMapping("/customers/{id}/addresses/{addressId}")
    public void updateAddress(@PathVariable Long id, @PathVariable Long addressId, @RequestBody Address address)
    {
        address.setId(addressId);
        address.setCustomer(new Customer(id));
        addressService.update(address);
    }

    @PutMapping("/customers/{id}/orders/{orderId}")
    public void updateOrder(@PathVariable Long id,@PathVariable Long orderId, @RequestBody Order order)
    {
        order.setId(orderId);
        order.setCustomer(new Customer(id));
        orderService.update(order);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Long id)
    {
        customerService.deleteById(id);
    }

    @DeleteMapping("/customers/{id}/addresses/{addressId}")
     public void deleteAddress(@PathVariable Long id,@PathVariable Long addressId)
    {
        addressService.deleteById(addressId);
    }

    @DeleteMapping("/customers/{id}/orders/{orderId}")
    public void deleteOrder(@PathVariable Long id,@PathVariable Long orderId)
    {
        orderService.deleteById(orderId);
    }

    @PostMapping("/customers/{id}/orders/{orderId}/products")
    public void deleteProductFromOrder(@PathVariable Long id, @PathVariable Long orderId, @RequestParam Long productId)
    {
        orderService.deleteProductFromOrder(orderId,productId);
    }
}
