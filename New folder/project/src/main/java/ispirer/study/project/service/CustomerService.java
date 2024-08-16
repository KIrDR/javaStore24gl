package ispirer.study.project.service;

import ispirer.study.project.controller.MenuController;
import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Customer;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.repository.CustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public List<Customer> filterCustomers(String condition){
        List<Customer> customers = new ArrayList<>();

        String query = "SELECT * FROM customer" + condition;

        try (
             PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setFname(resultSet.getString("fname"));
                    customer.setLname(resultSet.getString("lname"));
                    customer.setCompany(resultSet.getString("company"));
                    customer.setAddress1(resultSet.getString("address1"));
                    customer.setAddress2(resultSet.getString("address2"));
                    customer.setCity(resultSet.getString("city"));
                    customer.setZipcode(resultSet.getString("zipcode"));
                    customer.setPhone(resultSet.getString("phone"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer showCustomer(Integer customerNum) {
        return customerRepository.showCustomer(customerNum);
    }

    public Integer countOrders(Integer num){
        return customerRepository.countOrders(num);
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerRepository.addCustomer(customer);
    }

    public void editCustomer(String fname, String lname, String company, String address1, String address2, String city, String state, String zipcode) throws SQLException {
        String query = """
        UPDATE customer
        SET
            fname = ?,
            lname = ?,
            company = ?,
            address1 = ?,
            address2 = ?,
            city = ?,
            state = ?,
            zipcode = ?
        WHERE customer_num = ?;
        """;

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, company);
            preparedStatement.setString(4, address1);
            preparedStatement.setString(5, address2);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, state);
            preparedStatement.setString(8, zipcode);
            preparedStatement.setString(9, Menu.getCustomer().toString());

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }


    public void deleteCustomer(Integer num) throws SQLException {

        customerRepository.deleteCustomer(num);

    }


}
