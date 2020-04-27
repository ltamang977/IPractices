package org.lv.ipractices.designpatterns.creational.abstractfactory;

public abstract class CreditCardFactory {


    public static CreditCardFactory getCreditCardFactoy(int score){
        if(score>650){
            return new AmexFactory();
        }else{
            return new  VisaFactory();
        }
    }


    public abstract CreditCard getCard(LevelType levelType);
}
