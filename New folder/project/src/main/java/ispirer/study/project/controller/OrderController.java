package ispirer.study.project.controller;

import ispirer.study.project.model.Order;
import ispirer.study.project.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {
//    private final OrderService orderService = new OrderService();
//
//    @GetMapping("/orders")
//    public String getOrders(Model model) {
//        List<Order> orders = orderService.getAll();
//        System.out.println("Number of orders: " + orders.size());
//        model.addAttribute("orders", orders);
//        return "orders";
//    }
}
