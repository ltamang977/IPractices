package org.lv.ipractices.designpatterns.behavioural.chainofresponsibility;

public class CEO extends Handler {

    @Override
    public void handleRequest(Request request) {

         System.out.println("CEO can approve anything");

    }
}
