package net.javaguides.springmvc.controller;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    //로그를 콘솔창에 찍어서 어디에서 에러가 났는지 알수있는 코드
    //static인 이유 -> 객체를 싱글턴과 같이 한 번만 생성해서 사용하게 된다.
    //final인 이유 -> 로그를 찍는 경우 초기에 생성된 이후 변경될 필요 없음 -> 유지보수, 가독성 up

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    //필드 자동주입을 하고 있다.
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) { //Model은 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 하는 존재
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers); // customers라는 변수명으로 생성한 list의 값을 넣어서 전달해준다
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method"); //디버그 용도로 메세지를 출력
        Customer theCustomer = new Customer(); // 객체 생성후
        theModel.addAttribute("customer", theCustomer); //customer 로 입력된 값을 넣어서 보내준다.
        return "customer-form";
    }

    @PostMapping("/saveCustomer") //form에서 입력한 값을 Post형식으로  받는다
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer); // 서비스에서 받아온 Customer 값을 저장한다.
        return "redirect:/customer/list"; // 다리 customer/list로 url을 이동한다.
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) throws ResourceNotFoundException { // 스프링은 HTTTP 요청을 파라미터를 @RequestParam으로 받을 수 있다.
        Customer theCustomer = customerService.getCustomer(theId); //id값으로 가져온다.
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException { //id값으로 삭제시킨다.
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}