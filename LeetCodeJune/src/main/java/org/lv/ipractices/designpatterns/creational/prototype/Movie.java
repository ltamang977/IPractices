package org.lv.ipractices.designpatterns.creational.prototype;

public class Movie extends Item {

    int runtime;

    /*
        protected String title;
    protected double price;
    protected String url;
     */

    public Movie(String title, double price, String url, int runtime){
        this.title = title;
        this.price = price;
        this.url = url;
        this.runtime = runtime;

    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + "Movie{" +
                "runtime=" + runtime +
                '}';
    }
}
