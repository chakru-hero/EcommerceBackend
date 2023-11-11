package com.portfolio.chakru.models;

import javax.persistence.*;

@Entity
public class ProductModel {

    @Id
    @Column(nullable = false, updatable = false, name="code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String name;
    private String description;
    private int price;
    private String imageUrl;

    private String Category;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
