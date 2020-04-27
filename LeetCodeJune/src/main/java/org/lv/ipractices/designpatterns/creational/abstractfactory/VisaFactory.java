package org.lv.ipractices.designpatterns.creational.abstractfactory;

public class VisaFactory extends CreditCardFactory{

    public CreditCard getCard(LevelType level){

        switch(level){
            case GOLD:
                return new GoldVisa();

            case PLATINUM:
                return new PlatinumVisa();

            default:
                return null;
        }
    }

}
