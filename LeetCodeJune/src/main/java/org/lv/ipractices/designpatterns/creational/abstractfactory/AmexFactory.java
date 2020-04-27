package org.lv.ipractices.designpatterns.creational.abstractfactory;

import java.util.logging.Level;

public class AmexFactory extends CreditCardFactory{

    public CreditCard getCard(LevelType level){

        switch(level){
            case GOLD:
                return new GoldAmex();

            case PLATINUM:
                return new PlatinumAmex();

            default:
                return null;
        }
    }


}
