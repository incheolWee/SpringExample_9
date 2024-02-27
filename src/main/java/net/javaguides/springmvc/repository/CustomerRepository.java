package net.javaguides.springmvc.repository;

import net.javaguides.springmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository") //안붙여도 상관없다? jpa가 연결해주기 때문
//외부 I/O 를 해결해주는 역할을 한다.
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//Repository는 인터페이스로 생성하며, 확장자를 JpaRepository< Entity 클래스, Prime Key 타입> 을 작성한다.
}