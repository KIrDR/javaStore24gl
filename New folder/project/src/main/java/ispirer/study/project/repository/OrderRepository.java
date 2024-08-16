package ispirer.study.project.repository;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNum(resultSet.getInt("order_num"));
                order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
                order.setCustomerNum(resultSet.getInt("customer_num"));
                order.setShipInstruct(resultSet.getString("ship_instruct"));
                order.setBacklog(resultSet.getString("backlog").charAt(0));
                order.setPoNum(resultSet.getString("po_num"));
                order.setShipDate(resultSet.getDate("ship_date")!= null ? resultSet.getDate("ship_date").toLocalDate() : null);
                order.setShipWeight(resultSet.getDouble("ship_weight"));
                order.setShipCharge(resultSet.getDouble("ship_charge"));
                order.setPaidDate(resultSet.getDate("paid_date") != null ? resultSet.getDate("paid_date").toLocalDate() : null);

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
