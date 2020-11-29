package com.serverprogramming.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    //TRANS_TEST
    @Column(unique = true)
    private String title;
    private long isbn;
    private String author;
    private int year;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonManagedReference
    private Category category;

    public Book() {
    }

    public Book(String title, long isbn, String author, int year, double price, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.year = year;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null){
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", isbn=" + isbn +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", category=" + this.getCategory() +
                    '}';
        }else {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", isbn=" + isbn +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    '}';
        }
    }
}
