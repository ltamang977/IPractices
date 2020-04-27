package org.lv.ipractices.geekforgeeks.basic;

/**
 * Created by root on 12/28/17.
 */
public class SquaresDifference {

    public static int sumOfSquares(int n){
        //formaula is
        int  sum = (n * (n+1) *(2*n+1))/6;

        return sum;
    }

    public static int sumOfNaturalNumbers(int n){
        int sum = (n*(n+1))/2;
        return sum;
    }

    public static void main(String[] args){

        int n = 10;

        int sumOfNaturalNbr = sumOfNaturalNumbers(n);

        int absoluteDiff = sumOfSquares(n) - (sumOfNaturalNbr * sumOfNaturalNbr);

        System.out.println("Absolute diff is :"+Math.abs(absoluteDiff));

    }
}
