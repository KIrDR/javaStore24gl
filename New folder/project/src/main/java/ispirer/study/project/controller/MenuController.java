package ispirer.study.project.controller;

import com.google.common.base.Strings;
import ispirer.study.project.model.*;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.service.CustomerService;
import ispirer.study.project.service.OrderService;
import ispirer.study.project.service.StateService;
import ispirer.study.project.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class MenuController {


    public static final OrderService orderService = new OrderService();
    public static final CustomerService customerService = new CustomerService();
    public static final StockService stockService = new StockService();
    public static final StateService stateService = new StateService();

    @GetMapping("/wMain")
    public String getMain(Model model) {
        try {
            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "wMain";
    }
    @GetMapping("/customers")
    public String getCustomers(
            @RequestParam(value = "condition", defaultValue = " ") String condition,
            Model model) {
        try {
            if (!Menu.isCustomers()) {
                Menu.setCustomers(true);
            }

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());

            // Filter customers based on the provided parameters
            List<Customer> customers = customerService.filterCustomers(condition);
            System.out.println("Number of customers: " + customers.size());
            model.addAttribute("customersList", customers);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "customers";
    }


    @GetMapping("/orders")
    public String getOrders(@RequestParam(value = "condition", defaultValue = " ") String condition,
                            Model model) {
        try {
            if (!Menu.isOrders()) {
                Menu.setOrders(true);
            }

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());
            if( condition.equals(" ")) {
                List<Order> orders = orderService.orders();
                System.out.println("Number of orders: " + orders.size());
                model.addAttribute("ordersList", orders);
            }
            else {
                Integer customerNum = Integer.valueOf(condition);
                List<Order> orders = orderService.ordersByCustomer(customerNum);
                System.out.println("Number of orders: " + orders.size());
                model.addAttribute("ordersList", orders);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "orders";
    }


    @GetMapping("/stocks")
    public String getStock(Model model) {

        try {
            if (!Menu.isStock()) {
                Menu.setStock(true);
            }

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());
            List<Stock> stocks = stockService.findAll();

            System.out.println("Number of stock: " + stocks.size());
            model.addAttribute("stockList", stocks);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "stocks";
    }

    @GetMapping("/stock")
    public String getStockId(Model model) {

        try {
            if (!Menu.isStock()) {
                Menu.setStock(true);
            }

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());
            Stock stock = stockService.selectStock(Menu.getStockId(),Menu.getStockManu());

            model.addAttribute("stockId", stock);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "stock";
    }

    @GetMapping("/basket")
    public String getBasket(Model model) {
        try {
            if (!Menu.isBasket()) {
                Menu.setBasket(true);
            }

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());


            model.addAttribute("basket", Basket.getBasket());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "basket";
    }

    @GetMapping("/customer")
    public String getCustomer(Model model) {

        Customer customer = new Customer();
        try {

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("stockId", Menu.getStockId());
            model.addAttribute("stockManu", Menu.getStockManu());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());


            customer = MenuController.customerService.showCustomer(Menu.getCustomer());
            Integer count = MenuController.customerService.countOrders(Menu.getCustomer());
            //SelectCustomer

            model.addAttribute("customer_num", customer.getCustomerNum());
            model.addAttribute("fname", customer.getFname());
            model.addAttribute("lname", customer.getLname());
            model.addAttribute("company", customer.getCompany());
            model.addAttribute("address1", customer.getAddress1());
            model.addAttribute("address2", customer.getAddress2());
            model.addAttribute("city", customer.getCity());
            model.addAttribute("state", customer.getState());
            model.addAttribute("zipcode", customer.getZipcode());
            model.addAttribute("phone", customer.getPhone());
            model.addAttribute("count", count);
            model.addAttribute("norders", null);


            List<State> states = stateService.initStates();
            model.addAttribute("states",states);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "customer";
    }

    @GetMapping("/order")
    public String getOrder(Model model) {

        Order order = new Order();
        try {

            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());


            order = MenuController.orderService.showOrder(Menu.getOrderId());
            Integer count_item = MenuController.orderService.countItems(Menu.getOrderId());

            //SelectOrder
            model.addAttribute("order_num", order.getOrderNum());
            model.addAttribute("order_date", order.getOrderDate());
            model.addAttribute("customer_num", order.getCustomerNum());
            model.addAttribute("ship_instruct", order.getShipInstruct());
            model.addAttribute("backlog", order.getBacklog());
            model.addAttribute("po_num", order.getPoNum());
            model.addAttribute("ship_date", order.getShipDate());
            model.addAttribute("ship_weight", order.getShipWeight());
            model.addAttribute("ship_charge", order.getShipCharge());
            model.addAttribute("paid_date", order.getPaidDate());
            model.addAttribute("count_item", count_item);

            List<State> states = stateService.initStates();
            model.addAttribute("states",states);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "order";
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        try {
            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "items";
    }

    @GetMapping("/item")
    public String getItem(Model model) {
        try {
            model.addAttribute("wMain", Menu.isWMain());
            model.addAttribute("customers", Menu.isCustomers());
            model.addAttribute("customer", Menu.getCustomer());
            model.addAttribute("orders", Menu.isOrders());
            model.addAttribute("stock", Menu.isStock());
            model.addAttribute("items", Menu.isItems());
            model.addAttribute("basket", Menu.isBasket());
            model.addAttribute("orderId", Menu.getOrderId());
            model.addAttribute("itemId", Menu.getItemId());

            //selectedItem


        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "items";
    }
}
