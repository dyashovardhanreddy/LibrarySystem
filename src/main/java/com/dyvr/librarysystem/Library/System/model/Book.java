package com.dyvr.librarysystem.Library.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="author", nullable = false)
    private String author;


    @Column(name="published_year", nullable = false)
    private int publishedYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }



}
