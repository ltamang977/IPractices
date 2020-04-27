package org.lv.ipractices.geekforgeeks.basic;

import java.util.Scanner;
/**
 * Created by root on 12/28/17.
 */
public class DigitalRoot {

    public int digitalRoot(int nbr){

        String nbrStr = String.valueOf(nbr);
        if(nbrStr.length()==1)
            return nbr;

        char[] chArr = nbrStr.toCharArray();
        int sum = 0;
        for(int i=0; i<chArr.length;i++){
            char c = chArr[i];
            Integer digit = Integer.parseInt(String.valueOf(c));
            sum = sum +digit;
        }

        if(String.valueOf(sum).length()==1){
            return sum;
        }else {
            return digitalRoot(sum);
        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Integer testCases = scanner.nextInt();

        while(testCases>0){

            int n = scanner.nextInt();
            int xDigit = scanner.nextInt();

            // n numbers from 1 to n
            //whose digital root is equal to the x digit

            testCases--;
        }

    }
}
