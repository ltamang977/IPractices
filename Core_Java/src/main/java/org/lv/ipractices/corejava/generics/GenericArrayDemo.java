package org.lv.ipractices.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayDemo {

    public static void demo(){

        List<String>[] arrOfStringList = new ArrayList[5];

        for(int i=0; i<5; i++){
            arrOfStringList[i]= new ArrayList<>();
        }


        //not allowed List<E>[],, new List<String>[],, new E[]


    }


    public static void main(String[] args){

        demo();

    }
}
