package org.lv.ipractices.designpatterns.behavioural.chainofresponsibility;

public class VP extends  Handler{

    @Override
    public void handleRequest(Request request) {

        if(RequestTypeEnum.PURCHASE == request.getRequestType() && request.getAmount()<1500){
            System.out.println("VP can approve purchase less than 1500");

        }else {
            successor.handleRequest(request);
        }

    }
}
