package edu.bionic.domain;

import com.google.common.collect.ImmutableList;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
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

    public Order(Integer id, LocalDateTime dateTime, BigDecimal totalAmount, List<Product> products, String name, String email, String phone, String address) {
        this.id = id;
        this.dateTime = dateTime;
        this.totalAmount = totalAmount.setScale(2, RoundingMode.HALF_UP);
        this.products = products;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!dateTime.equals(order.dateTime)) return false;
        if (!totalAmount.equals(order.totalAmount)) return false;
        if (!products.equals(order.products)) return false;
        return email.equals(order.email);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + dateTime.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + products.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.totalAmount = totalAmount.setScale(2,RoundingMode.HALF_UP);
    }

    public List<Product> getProducts() {
        return ImmutableList.copyOf(products);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
