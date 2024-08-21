package ispirer.study.project.repository;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockRepository {

    public StockRepository(){};

    public Stock selectStock(Integer stockId, String manuCode){
        Stock stock = new Stock();
        String query = "SELECT * FROM stock where stock_num = " + stockId  + " and manu_code = '" + manuCode + "'";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                stock.setStockNum(resultSet.getShort("stock_num"));
                stock.setManuCode(resultSet.getString("manu_code"));
                stock.setDescription(resultSet.getString("description"));
                stock.setUnitPrice(resultSet.getDouble("unit_price"));
                stock.setUnit(resultSet.getString("unit"));
                stock.setUnitDescr(resultSet.getString("unit_descr"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public List<Stock> findAll() {
        List<Stock> stocks = new ArrayList<>();
        String query = "SELECT * FROM stock";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setStockNum(resultSet.getShort("stock_num"));
                stock.setManuCode(resultSet.getString("manu_code"));
                stock.setDescription(resultSet.getString("description"));
                stock.setUnitPrice(resultSet.getDouble("unit_price"));
                stock.setUnit(resultSet.getString("unit"));
                stock.setUnitDescr(resultSet.getString("unit_descr"));

                stocks.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }

}
