package ispirer.study.project.controller;

import ispirer.study.project.model.Customer;
import ispirer.study.project.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService = new CustomerService();

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Number of customers: " + customers.size());
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("")
    public String getMainWindow(Model model) {

        return "wMain";
    }

}
