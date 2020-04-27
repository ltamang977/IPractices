package org.lv.ipractices.designpatterns.creational.factory;

public class FactoryDemo {


    public static void main(String[] args){


        WebSite blog = WebsiteFactory.createWebSite(WebSiteType.BLOG);
        System.out.println(blog);

        WebSite shop = WebsiteFactory.createWebSite(WebSiteType.SHOP);
        System.out.println(shop);
    }
}
