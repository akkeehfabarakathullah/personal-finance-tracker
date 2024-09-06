package com.example.Final.Entities;

import com.example.Final.Types.TransactionType;
import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
       this.Category = category;
    }

    private String Category;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(String name,long id,TransactionType type) {
        this.name = name;
        this.id = id;
        this.type = type;


    }

}
