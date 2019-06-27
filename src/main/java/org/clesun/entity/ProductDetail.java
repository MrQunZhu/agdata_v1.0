package org.clesun.entity;

public class ProductDetail {
    private String productName;
    private int productType;
    private String yieldUnit;
    private String priceUnit;
    private double totalYield;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getYieldUnit() {
        return yieldUnit;
    }

    public void setYieldUnit(String yieldUnit) {
        this.yieldUnit = yieldUnit;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public double getTotalYield() {
        return totalYield;
    }

    public void setTotalYield(double totalYield) {
        this.totalYield = totalYield;
    }
}
