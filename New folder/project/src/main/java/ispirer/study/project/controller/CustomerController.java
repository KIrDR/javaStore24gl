package ispirer.study.project.controller;

import ispirer.study.project.model.Customer;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @PutMapping("/updateCustomerNumber")
    public ResponseEntity<String> updateCustomerNumber(@RequestBody Integer customerNumber) {
        if (customerNumber != null) {
            System.out.println("Received customer number: " + customerNumber);
            Menu.setCustomer(customerNumber);

        }
        return ResponseEntity.ok("Customer number updated successfully");
    }

    @PostMapping("/editCustomer")
    public ResponseEntity<String> editCustomer(@RequestBody Map<String, String> customerData) {
        try {
            System.out.println("Received data: " + customerData); // Отладочный вывод

            String fname = customerData.get("fname");
            String lname = customerData.get("lname");
            String company = customerData.get("company");
            String address1 = customerData.get("address1");
            String address2 = customerData.get("address2");
            String city = customerData.get("city");
            String state = customerData.get("state");
            String zipcode = customerData.get("zipcode");

            MenuController.customerService.editCustomer(fname, lname, company, address1, address2, city, state, zipcode);

            return ResponseEntity.ok("Customer updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating customer");
        }
    }



    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Integer customerNumber) {
        try {
            if (MenuController.customerService.countOrders(customerNumber) == 0) {
                MenuController.customerService.deleteCustomer(customerNumber);
                return ResponseEntity.ok("Customer deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer has existing orders and cannot be deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting customer");
        }
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Map<String, String> customerData) {
        try {
            Customer customer = new Customer();
            customer.setFname(customerData.get("fname"));
            customer.setLname(customerData.get("lname"));
            customer.setCompany(customerData.get("company"));
            customer.setAddress1(customerData.get("address1"));
            customer.setAddress2(customerData.get("address2"));
            customer.setCity(customerData.get("city"));
            customer.setState(customerData.get("state"));
            customer.setZipcode(customerData.get("zipcode"));
            customer.setPhone(customerData.get("phone"));

            MenuController.customerService.addCustomer(customer);

            return ResponseEntity.ok("Customer added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding customer");
        }
    }
}