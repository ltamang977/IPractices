package org.lv.ipractices.designpatterns.creational.abstractfactory;

public class AbstractFactoryDemo {


    public static void main(String[] args){

        CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactoy(700);
        CreditCard creditCard = creditCardFactory.getCard(LevelType.GOLD);
        System.out.println(creditCard);


    }
}
