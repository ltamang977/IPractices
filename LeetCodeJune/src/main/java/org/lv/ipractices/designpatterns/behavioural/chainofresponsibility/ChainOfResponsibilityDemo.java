package org.lv.ipractices.designpatterns.behavioural.chainofresponsibility;


public class ChainOfResponsibilityDemo {

    public static void main(String[] args){

        Director director = new Director();
        VP vp = new VP();
        CEO ceo = new CEO();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request request1 = new Request(RequestTypeEnum.CONFERENCE, 500);
        director.handleRequest(request1);

        Request request2 = new Request(RequestTypeEnum.PURCHASE, 500);
        director.handleRequest(request2);

        Request request3 = new Request(RequestTypeEnum.PURCHASE, 2000);
        director.handleRequest(request3);

    }
}
