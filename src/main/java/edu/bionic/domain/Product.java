package edu.bionic.domain;

import java.math.BigDecimal;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Color color;
    private Integer capacity;
    private String display;
    private String description;

    public Product() { }

    public Product(Integer id, String name, BigDecimal price, Color color, Integer capacity, String display) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.capacity = capacity;
        this.display = display;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String printInfo() {
        return String.format("%d. %s %s %d - %.2f", id, name, color, capacity, price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
