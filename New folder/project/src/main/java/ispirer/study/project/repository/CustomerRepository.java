package ispirer.study.project.repository;

import ispirer.study.project.controller.MenuController;
import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Customer;
import ispirer.study.project.model.forms.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

            while (resultSet.next())             {
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

    public Customer showCustomer(Integer customerNum){

        Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE customer_num == " + customerNum;
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
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
            }


        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return customer;
    }

    public Integer countOrders(Integer customerNumber) {
        String query = "SELECT COUNT(*) AS count FROM orders WHERE customer_num = ?";
        Integer count = 0;
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, customerNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return count;
    }

    public void deleteCustomer(Integer num) throws SQLException {
        String query = "DELETE FROM customer WHERE customer_num = " + num;

        try
                (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
                 ) {
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }

    }

    public void addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customer (fname, lname, company, address1, address2, city, zipcode, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, customer.getFname());
            preparedStatement.setString(2, customer.getLname());
            preparedStatement.setString(3, customer.getCompany());
            preparedStatement.setString(4, customer.getAddress1());
            preparedStatement.setString(5, customer.getAddress2());
            preparedStatement.setString(6, customer.getCity());
            preparedStatement.setString(7, customer.getZipcode());
            preparedStatement.setString(8, customer.getPhone());

            int rowsAdded = preparedStatement.executeUpdate();
            System.out.println("Rows added: " + rowsAdded);
        }
    }



}
