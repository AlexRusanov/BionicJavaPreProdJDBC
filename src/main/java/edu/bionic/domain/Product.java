package edu.bionic.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Color color;
    private Integer capacity;
    private String display;
    private String description;

    public Product() { }

    public Product(Integer id, String name, BigDecimal price, Color color, Integer capacity, String display, String description) {
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.color = color;
        this.capacity = capacity;
        this.display = display;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (color != product.color) return false;
        if (!capacity.equals(product.capacity)) return false;
        return display.equals(product.display);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + capacity.hashCode();
        result = 31 * result + display.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", capacity=" + capacity +
                ", display='" + display + '\'' +
                ", description='" + description + '\'' +
                '}';
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
        this.price = price.setScale(2, RoundingMode.HALF_UP);
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
