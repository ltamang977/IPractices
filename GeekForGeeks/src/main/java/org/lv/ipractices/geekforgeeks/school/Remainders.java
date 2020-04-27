package org.lv.ipractices.geekforgeeks.school;


import java.util.Scanner;

/**
 * Created by root on 12/25/17.
 */
public class Remainders {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();

        while(numberOfTestCases>0){
            float first = scanner.nextFloat();
            float second = scanner.nextFloat();

            float remainder = first%second;
            System.out.println("Remainder is :"+remainder);

            numberOfTestCases--;
        }

    }
}

