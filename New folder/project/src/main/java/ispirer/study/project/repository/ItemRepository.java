package ispirer.study.project.repository;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.Item;
import ispirer.study.project.model.Stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    public Item getItem(Integer orderNum, String manuCode){
        StockRepository stockRepository = new StockRepository();
        Stock stock = stockRepository.selectStock(orderNum, manuCode);
        Item item = new Item(stock) ;



        return item;
    }


}
