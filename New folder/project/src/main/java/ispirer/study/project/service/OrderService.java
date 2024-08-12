package ispirer.study.project.service;

import ispirer.study.project.model.Customer;
import ispirer.study.project.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
