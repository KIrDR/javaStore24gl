package ispirer.study.project.service;

import ispirer.study.project.model.Customer;
import ispirer.study.project.model.Order;
import ispirer.study.project.repository.CustomerRepository;
import ispirer.study.project.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

    public List<Order> orders() {
        return orderRepository.findAll();
    }

    public List<Order> ordersByCustomer(Integer customerNum){
        return orderRepository.ordersByCustomer(customerNum);
    }
    public Order showOrder(Integer orderNum) {
        return orderRepository.showOrder(orderNum);
    }

    public Integer countItems(Integer orderNum) {
        return orderRepository.countItems(orderNum);
    }

}
