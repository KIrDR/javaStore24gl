package ispirer.study.project.service;

import ispirer.study.project.model.Customer;
import ispirer.study.project.model.Order;
import ispirer.study.project.repository.CustomerRepository;
import ispirer.study.project.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
