package org.lv.ipractices.stanforduniversity.recursion;

public class PrintAllBinary {

    public static void printBinary(int digits, String soFar){
        if(digits==0) {
            System.out.println(soFar);
            return;
        }

        printBinary(digits-1, soFar+"0");
        printBinary(digits-1, soFar+"1");

    }

    public static void printDecimal(int digits, String soFar){//decision

        if(digits==0) {
            System.out.println(soFar);
            return;
        }

        for(int i=0; i<10; i++){//choices
            printDecimal(digits-1, soFar+String.valueOf(i));
        }

    }

    public static void main(String[] args){

        //printBinary(3,"");
        printDecimal(3,"");

    }
}
