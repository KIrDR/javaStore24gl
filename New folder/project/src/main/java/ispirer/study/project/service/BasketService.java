package ispirer.study.project.service;

import ispirer.study.project.controller.MenuController;
import ispirer.study.project.model.Basket;
import ispirer.study.project.model.Item;
import ispirer.study.project.model.Stock;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.repository.BasketRepository;

import java.util.List;

public class BasketService {

    BasketRepository basketRepository = new BasketRepository();

    public double displayTotal() {
        return basketRepository.displayTotal();
    }

    public static Item getItemByIndex(Integer index) {
        List<Item> basket = Basket.getBasket();

        if (index < 0 || index >= basket.size()) {
            throw new IndexOutOfBoundsException("Item not found at index: " + index);
        }

        return basket.get(index);
    }

    public static void updateTotalPrice(Integer index) {
        var list = Basket.getBasket();
        list.get(index).setTotalPrice(countTotalPrice());
        Basket.setBasket(list);
    }

    public static double getUnitPrice(){
        Item item = BasketService.getItemByIndex(Menu.getItemId());
        Stock stock = MenuController.stockService.selectStock((int) item.getStockNum(),item.getManuCode());
        double unitPrice = stock.getUnitPrice();

        return unitPrice;
    }

    public static double countTotalPrice() {
        return getUnitPrice() * getItemByIndex(Menu.getItemId()).getQuantity();
    }

    public void deleteItem(int index) {
        var list = Basket.getBasket();

        if (index >= 0 && index < list.size()) {
            list.remove(index);
            Basket.setBasket(list);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }


}
