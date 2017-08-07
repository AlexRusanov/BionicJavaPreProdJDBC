package edu.bionic.domain;

import java.time.LocalDateTime;

public class Comment {

    private Integer id;
    private Integer productId;

    private String author;
    private LocalDateTime dateTime;
    private String text;
    private Integer rating;

    public Comment(Integer productId, String author, LocalDateTime dateTime, String text, Integer rating) {
        this.productId = productId;
        this.author = author;
        this.dateTime = dateTime;
        this.text = text;
        this.rating = rating;
    }

    public Comment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
