package ispirer.study.project.test;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customer")) {

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

            for (Customer customer : customers) {
                System.out.println(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             Connector.closeConnection(Connector.getConnection());
        }
    }
}
