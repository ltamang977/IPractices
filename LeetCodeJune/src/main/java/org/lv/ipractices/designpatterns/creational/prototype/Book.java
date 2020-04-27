package org.lv.ipractices.designpatterns.creational.prototype;

public class Book extends Item {

    int numberOfPages;


    public Book(String title, double price, String url, int numberOfPages){
        this.title = title;
        this.price = price;
        this.url = url;
        this.numberOfPages = numberOfPages;

    }
}
