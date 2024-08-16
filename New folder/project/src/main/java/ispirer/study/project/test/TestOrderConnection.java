package ispirer.study.project.test;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestOrderConnection {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders")) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNum(resultSet.getInt("order_num"));
                order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
                order.setCustomerNum(resultSet.getInt("customer_num"));
                order.setShipInstruct(resultSet.getString("ship_instruct"));
                order.setBacklog(resultSet.getString("backlog").charAt(0));
                order.setPoNum(resultSet.getString("po_num"));
                order.setShipDate(resultSet.getDate("ship_date") != null ? resultSet.getDate("ship_date").toLocalDate() : null);
                order.setShipWeight(resultSet.getDouble("ship_weight"));
                order.setShipCharge(resultSet.getDouble("ship_charge"));
                order.setPaidDate(resultSet.getDate("paid_date") != null ? resultSet.getDate("paid_date").toLocalDate() : null);

                orders.add(order);
            }

            for (Order order : orders) {
                System.out.println(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.closeConnection(Connector.getConnection());
        }
    }
}
