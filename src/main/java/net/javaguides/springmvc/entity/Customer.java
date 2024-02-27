package net.javaguides.springmvc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data // lombok 사용해서  setter, getter toString 생성자 자동 등록
@Table(name = "customer")  // customer 이라는 table에 매핑해준다
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //기본키를 자동으로 생성해주는 어노테이션
    //IDENTITY는 기본 키생성을 데이터베이스에 위임하는 전략이다. id값을 따로 할당하지 않아도 db가 자동으로 auto_increment를 해서 기본키 생성 주로 MySQL, PostgreSQL, SQL Server에서 사용한다.

    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


}