package ispirer.study.project.service;

import ispirer.study.project.model.Stock;
import ispirer.study.project.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository = new StockRepository();


    public Stock selectStock(Integer stockId, String manuCode) {
        return stockRepository.selectStock(stockId, manuCode);
    }

    public double getUnitPrice(Integer stockNum,String manuCode){
        return  selectStock(stockNum, manuCode).getUnitPrice();
    }
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
