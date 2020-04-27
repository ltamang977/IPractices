package org.lv.ipractices.designpatterns.behavioural.chainofresponsibility;

public class Director extends  Handler{


    @Override
    public void handleRequest(Request request) {

        if(RequestTypeEnum.CONFERENCE == request.getRequestType()){
            System.out.println("Director can approve conference");
        }else{
            successor.handleRequest(request);
        }

    }
}
