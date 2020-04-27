package org.lv.ipractices.designpatterns.creational.factory;

public class WebsiteFactory {


    public static WebSite createWebSite(WebSiteType type){

        switch(type){

            case BLOG:
                return new Blog();

            case SHOP:
                return new Shop();

            default:
                return null;

        }
    }
}
