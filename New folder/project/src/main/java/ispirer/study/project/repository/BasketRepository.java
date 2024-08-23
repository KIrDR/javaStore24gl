package ispirer.study.project.repository;

import ispirer.study.project.controller.MenuController;
import ispirer.study.project.model.Basket;
import ispirer.study.project.model.Item;

public class BasketRepository {

    public double displayTotal() {

        double total = Basket.getBasket().stream().mapToDouble(Item::getTotalPrice).sum();
        return total;
    }

}
