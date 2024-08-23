package ispirer.study.project.service;

import ispirer.study.project.model.Item;
import ispirer.study.project.model.Stock;
import ispirer.study.project.repository.ItemRepository;
import ispirer.study.project.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository = new ItemRepository();

    public Item showStock(Integer orderNum, String manuCode){
        return itemRepository.showStock(orderNum,manuCode);
    }

    public Item getItem(Integer orderNum,Integer stockNum, String manuCode){
        return  itemRepository.getItem( orderNum, stockNum,  manuCode);

    }

    public List<Item> getAllItem( ){
        return itemRepository.getAllItem();
    }

    public List<Item> getOrderItems( Integer orderNum){
        return getAllItem().stream()
            .filter(x -> x.getOrderNum() == orderNum).toList();
    }
}
