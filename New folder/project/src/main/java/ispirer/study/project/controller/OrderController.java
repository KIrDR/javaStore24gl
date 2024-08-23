package ispirer.study.project.controller;

import ispirer.study.project.model.Order;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {


    @PutMapping("/updateOrderNumber")
    public ResponseEntity<String> updateOrderNumber(@RequestBody Integer orderNumber) {
        if (orderNumber != null) {
            System.out.println("Received order number: " + orderNumber);
            Menu.setOrderId(orderNumber);

        }
        return ResponseEntity.ok("Order number updated successfully");
    }

//    @PutMapping("/itemSelect")
//    public ResponseEntity<String> itemSelect(
//            @RequestParam("order_num") Integer orderNum,
//            @RequestParam("stock_num") Integer stockNum,
//            @RequestParam("manu_code") Integer manuCode) {
//
//            MenuController
//
//    }
}
