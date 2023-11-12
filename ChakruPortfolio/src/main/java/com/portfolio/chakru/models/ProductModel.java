package com.portfolio.chakru.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
