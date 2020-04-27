package org.lv.ipractices.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    Map<String, Item> items = new HashMap<>();

    public Registry(){
        loadItems();
    }


    public void loadItems(){
        Movie movie = new Movie("Toilet", 12.00, "sth", 2);

        Book book = new Book("Harry Porter", 12.00, "porter", 350);

        items.put("Movie", movie);
        items.put("Book", book);

    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item) items.get(type).clone();

        }catch(CloneNotSupportedException ex){

        }

        return item;
    }
}
