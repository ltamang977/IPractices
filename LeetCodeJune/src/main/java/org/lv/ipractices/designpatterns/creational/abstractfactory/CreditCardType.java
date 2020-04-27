package org.lv.ipractices.designpatterns.creational.abstractfactory;

public enum CreditCardType {

    VISA("Visa"), AMEX("AMEX");

    String value;

    private CreditCardType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
