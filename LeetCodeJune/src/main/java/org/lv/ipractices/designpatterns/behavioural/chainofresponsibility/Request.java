package org.lv.ipractices.designpatterns.behavioural.chainofresponsibility;

public class Request {

    private RequestTypeEnum requestType;
    private double amount;

    public Request(RequestTypeEnum requestType, double amount){
        this.requestType = requestType;
        this.amount = amount;
    }

    public RequestTypeEnum getRequestType() {
        return requestType;
    }

    public double getAmount() {
        return amount;
    }
}
