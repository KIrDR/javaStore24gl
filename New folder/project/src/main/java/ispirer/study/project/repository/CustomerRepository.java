package ispirer.study.project.repository;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try (
             PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerNum(resultSet.getInt("customer_num"));
                customer.setFname(resultSet.getString("fname"));
                customer.setLname(resultSet.getString("lname"));
                customer.setCompany(resultSet.getString("company"));
                customer.setAddress1(resultSet.getString("address1"));
                customer.setAddress2(resultSet.getString("address2"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setZipcode(resultSet.getString("zipcode"));
                customer.setPhone(resultSet.getString("phone"));

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
