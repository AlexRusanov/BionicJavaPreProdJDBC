package edu.bionic.domain;

import com.google.common.collect.ImmutableList;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime dateTime;
    private BigDecimal totalAmount;
    private List<Product> products;

    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @NotBlank(message = "Это поле должно быть заполнено")
    @Email(message = "Поле должно содержать правильный email")
    private String email;

    private String phone;

    @NotBlank(message = "Это поле должно быть заполнено")
    private String address;


    public Order() {
        this.products = new ArrayList<>();
    }

    public Order(LocalDateTime dateTime, BigDecimal totalAmount, List<Product> products) {
        this.dateTime = dateTime;
        this.totalAmount = totalAmount;
        this.products = new ArrayList<>(products);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return ImmutableList.copyOf(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
