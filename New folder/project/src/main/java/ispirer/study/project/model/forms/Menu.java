package ispirer.study.project.model.forms;
public class Menu {
    private static final boolean w_main = true;
    private static boolean customers = false;
    private static Integer customer = null;
    private static boolean orders = false;
    private static boolean stock = false;
    private static boolean items = false;
    private static boolean basket = false;
    private static Integer orderId = null;
    private static Integer itemId = null;

    public Menu() {
    }

    public static boolean isWMain() {
        return w_main;
    }

    public static boolean isStock() {
        return stock;
    }

    public static void setStock(boolean stock) {
        Menu.stock = stock;
    }
    public static boolean isCustomers() {
        return customers;
    }

    public static void setCustomers(boolean customers) {
        Menu.customers = customers;
    }

    public static Integer getCustomer() {
        return customer;
    }

    public static void setCustomer(Integer customer) {
        Menu.customer = customer;
    }

    public static boolean isOrders() {
        return orders;
    }

    public static void setOrders(boolean orders) {
        Menu.orders = orders;
    }

    public static boolean isItems() {
        return items;
    }

    public static void setItems(boolean items) {
        Menu.items = items;
    }

    public static boolean isBasket() {
        return basket;
    }

    public static void setBasket(boolean basket) {
        Menu.basket = basket;
    }

    public static Integer getOrderId() {
        return orderId;
    }

    public static void setOrderId(Integer orderId) {
        Menu.orderId = orderId;
    }

    public static Integer getItemId() {
        return itemId;
    }

    public static void setItemId(Integer itemId) {
        Menu.itemId = itemId;
    }
}

