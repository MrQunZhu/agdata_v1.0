package org.clesun.entity;

public class IndustryEntity {
    private String name;
    private double count;
    private String productParentId;
    private String productParentValue;
    private double totalArea;
    private double plantArea;
    private IndustryEntity industryEntity;

    public String getProductParentId() {
        return productParentId;
    }

    public void setProductParentId(String productParentId) {
        this.productParentId = productParentId;
    }

    public String getProductParentValue() {
        return productParentValue;
    }

    public void setProductParentValue(String productParentValue) {
        this.productParentValue = productParentValue;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(double plantArea) {
        this.plantArea = plantArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public IndustryEntity getIndustryEntity() {
        return industryEntity;
    }

    public void setIndustryEntity(IndustryEntity industryEntity) {
        this.industryEntity = industryEntity;
    }
}
