package ispirer.study.project.repository;

import ispirer.study.project.controller.MenuController;
import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Item;
import ispirer.study.project.model.Order;
import ispirer.study.project.model.Stock;
import ispirer.study.project.model.forms.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    public Item showStock(Integer orderNum, String manuCode){
        StockRepository stockRepository = new StockRepository();
        Stock stock = stockRepository.selectStock(orderNum, manuCode);
        Item item = new Item(stock) ;



        return item;
    }

    public List<Item> getAllItem() {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items";
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Item item = new Item();
                item.setItemNum(resultSet.getInt("item_num"));
                item.setOrderNum(resultSet.getInt("order_num"));
                item.setStockNum(resultSet.getShort("stock_num"));
                item.setManuCode(resultSet.getString("manu_code"));
                item.setDescription(MenuController.stockService.selectStock(Integer.valueOf(item.getStockNum()),item.getManuCode()).getDescription());
                item.setQuantity(resultSet.getShort("quantity"));
                item.setTotalPrice(resultSet.getDouble("total_price"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }


    public Item getItem(Integer orderNum,Integer stockNum, String manuCode){
        String query = "SELECT * FROM items where order_num = " + orderNum + "and stock_num = " + stockNum + " and manu_code = '" + manuCode + "'";
        Item item = new Item();
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {

                item.setItemNum(resultSet.getInt("item_num"));
                item.setOrderNum(resultSet.getInt("order_num"));
                item.setStockNum(resultSet.getShort("stock_num"));
                item.setManuCode(resultSet.getString("manu_code"));
                item.setDescription(MenuController.stockService.selectStock(Integer.valueOf(item.getStockNum()),item.getManuCode()).getDescription());
                item.setQuantity(resultSet.getShort("quantity"));
                item.setTotalPrice(resultSet.getDouble("total_price"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
