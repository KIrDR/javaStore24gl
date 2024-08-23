package ispirer.study.project.model;

public class Item {

    private int itemNum;
    private int orderNum;
    private short stockNum;
    private String manuCode;
    private String description;
    private short quantity;
    private double totalPrice;

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public short getStockNum() {
        return stockNum;
    }

    public void setStockNum(short stockNum) {
        this.stockNum = stockNum;
    }

    public String getManuCode() {
        return manuCode;
    }

    public void setManuCode(String manuCode) {
        this.manuCode = manuCode;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNum=" + itemNum +
                ", orderNum=" + orderNum +
                ", stockNum=" + stockNum +
                ", manuCode='" + manuCode + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Item(){

    }

    public Item(Stock stock) {
        this.stockNum = stock.getStockNum();
        this.manuCode = stock.getManuCode();
        this.quantity = 1 ;
        this.totalPrice = stock.getUnitPrice() ;
        this.description = stock.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
