package ispirer.study.project.controller;

import ispirer.study.project.model.Basket;
import ispirer.study.project.model.Item;
import ispirer.study.project.model.forms.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BasketController {

    @PutMapping("/addToBasket")
    public ResponseEntity<String> addToBasket() {
        if (Menu.getStockId()  != null && Menu.getStockManu() != null ) {

            Item item = new Item(MenuController.stockService.selectStock(Menu.getStockId(),Menu.getStockManu() ));
            Basket.addToBasket(item);
        }
        return ResponseEntity.ok("updated successfully");
    }


}
