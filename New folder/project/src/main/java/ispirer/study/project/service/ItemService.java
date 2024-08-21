package ispirer.study.project.service;

import ispirer.study.project.model.Item;
import ispirer.study.project.model.Stock;
import ispirer.study.project.repository.ItemRepository;
import ispirer.study.project.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository = new ItemRepository();

    public Item getItem(Integer orderNum, String manuCode){
        return itemRepository.getItem(orderNum,manuCode);
    }
}
