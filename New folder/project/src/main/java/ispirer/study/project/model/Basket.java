package ispirer.study.project.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private static List<Item> basket = new ArrayList<>();

    public static void addToBasket(Item item) {
        basket.add(item);
    }

    public static List<Item> getBasket() {
        return basket;
    }

    public static void setBasket(List<Item> basket) {
        Basket.basket = basket;
    }
}
