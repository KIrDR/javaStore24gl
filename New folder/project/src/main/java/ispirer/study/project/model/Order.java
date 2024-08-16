package ispirer.study.project.model;

import java.time.LocalDate;

public class Order {

    private int orderNum;
    private LocalDate orderDate;
    private int customerNum;
    private String shipInstruct;
    private char backlog;
    private String poNum;
    private LocalDate shipDate;
    private double shipWeight;
    private double shipCharge;
    private LocalDate paidDate;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public String getShipInstruct() {
        return shipInstruct;
    }

    public void setShipInstruct(String shipInstruct) {
        this.shipInstruct = shipInstruct;
    }

    public char getBacklog() {
        return backlog;
    }

    public void setBacklog(char backlog) {
        this.backlog = backlog;
    }

    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public double getShipWeight() {
        return shipWeight;
    }

    public void setShipWeight(double shipWeight) {
        this.shipWeight = shipWeight;
    }

    public double getShipCharge() {
        return shipCharge;
    }

    public void setShipCharge(double shipCharge) {
        this.shipCharge = shipCharge;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", customerNum=" + customerNum +
                ", shipInstruct='" + shipInstruct + '\'' +
                ", backlog=" + backlog +
                ", poNum='" + poNum + '\'' +
                ", shipDate=" + shipDate +
                ", shipWeight=" + shipWeight +
                ", shipCharge=" + shipCharge +
                ", paidDate=" + paidDate +
                '}';
    }
}
