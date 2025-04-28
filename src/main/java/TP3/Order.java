package TP3;

public class Order {
    private String product;
    private int quantity;

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters et Setters
    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

