package ispirer.study.project.controller;

import ispirer.study.project.model.Basket;
import ispirer.study.project.model.Item;
import ispirer.study.project.model.forms.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/basketItem")
    public  ResponseEntity<String> basketItem(@RequestBody Integer itemIndex) {
        Menu.setItemId(itemIndex);
        System.out.println("Item Index was chosen " + itemIndex);
        return ResponseEntity.ok("updated successfully");

    }


    @PostMapping("/updateQuantity")
    public ResponseEntity<String> updateQuantity(@RequestParam("index") Integer index,
                                                 @RequestParam("quantity") Integer quantity,
                                                 Model model) {
        MenuController.basketService.getItemByIndex(index).setQuantity(quantity.shortValue());

        MenuController.basketService.updateTotalPrice(index);

        return ResponseEntity.ok("Customer number updated successfully");
    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity<String> deleteItem(@RequestParam("item_num") Integer itemNum) {
        if (itemNum == null) {
            return ResponseEntity.badRequest().body("Item number is missing");
        }
        Menu.setItemId(null);
        MenuController.basketService.deleteItem(itemNum);

        System.out.printf(Basket.getBasket().toString());
        return ResponseEntity.ok("Item deleted successfully");
    }


}
