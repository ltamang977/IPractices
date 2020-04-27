package org.lv.ipractices.designpatterns.creational.prototype;

public abstract class Item implements Cloneable{

    protected String title;
    protected double price;
    protected String url;


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
