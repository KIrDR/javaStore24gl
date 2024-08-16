package ispirer.study.project.model;

public class Stock {

    private short stockNum;
    private String manuCode;
    private String description;
    private double unitPrice;
    private String unit;
    private String unitDescr;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitDescr() {
        return unitDescr;
    }

    public void setUnitDescr(String unitDescr) {
        this.unitDescr = unitDescr;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockNum=" + stockNum +
                ", manuCode='" + manuCode + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", unitDescr='" + unitDescr + '\'' +
                '}';
    }
}
