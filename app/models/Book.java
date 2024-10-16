package models;

import java.util.Set;
import java.util.Optional;

public class Book {
    Integer id;
    String title;
    String author;
    Double price;

    public Book(Integer id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /*public Boolean isValid(){
        return !(this.id == null || this.author == null || this.price == null || this.title == null);
    }*/

}
