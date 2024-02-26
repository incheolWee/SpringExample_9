package net.javaguides.springmvc.repository;


import net.javaguides.springmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
