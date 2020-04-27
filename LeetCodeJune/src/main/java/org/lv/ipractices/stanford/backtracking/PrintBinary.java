package org.lv.ipractices.stanford.backtracking;

public class PrintBinary {





    private static void printBinary(String s, int n){

        if(n==0){
            System.out.println(s);
            return;
        }

        printBinary(s+"0", n-1);
        printBinary(s+"1", n-1);

    }


    private static void printDecimal(String s, int n){

        if(n==0){
            System.out.println(s);
            return;
        }

        for(int i =0; i<=9; i++){
            printDecimal(s+i, n-1);
        }

    }


    public static void main(String[] args){

       // printBinary("", 5);
        printDecimal("", 2);

    }
}
