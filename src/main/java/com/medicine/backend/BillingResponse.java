package com.medicine.backend;

public class BillingResponse {

    private String medicineName;
    private String category;
    private int quantity;
    private double pricePerTablet;
    private double totalAmount;
    private int remainingStock;

    public BillingResponse() {
    }

    public BillingResponse(String medicineName, String category,
                           int quantity, double pricePerTablet,
                           double totalAmount, int remainingStock) {

        this.medicineName = medicineName;
        this.category = category;
        this.quantity = quantity;
        this.pricePerTablet = pricePerTablet;
        this.totalAmount = totalAmount;
        this.remainingStock = remainingStock;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerTablet() {
        return pricePerTablet;
    }

    public void setPricePerTablet(double pricePerTablet) {
        this.pricePerTablet = pricePerTablet;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }
}