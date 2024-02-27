package net.javaguides.springmvc.service;

import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

import java.util.List;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId) throws ResourceNotFoundException;

    public void deleteCustomer(int theId) throws ResourceNotFoundException;

}