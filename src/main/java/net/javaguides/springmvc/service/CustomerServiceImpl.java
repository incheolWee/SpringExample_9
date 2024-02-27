package net.javaguides.springmvc.service;

import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 해당 클래스를 스프링의 Bean으로 등록하는 역할
public class CustomerServiceImpl implements CustomerService {

    @Autowired //자동 매칭
    private CustomerRepository customerRepository;

    @Override
    @Transactional //트렌젝션 적용하여 외부의 개입아니 복합적이 아닌 독립적으로 함수가 작동될 수 있도록 설정
    public List < Customer > getCustomers() {
        return customerRepository.findAll();
    }
    //모든 요소들을 List 형식으로 반환한다 -> List 형식으로 반환해준다

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }
    //해당 정보를 저장한다.
    @Override
    @Transactional
    public Customer getCustomer(int id) throws ResourceNotFoundException {//id가 null이 아니면 실행 아니면 null
        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }
//값이 없으면 예외를 던져 준다
    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }
    //id로 삭제한다
}