package org.lv.ipractices.geekforgeeks.basic;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by root on 12/28/17.
 */
public class CheckNumberWithBitDifference {


    public static int[] convertDecimalToBinary(int dec){

        Stack<Integer> stack = new Stack();
        do {
            int modulo = dec%2;
            dec = dec/2;
            stack.push(modulo);

            //stack.size()

        }while(dec>=2);

        stack.push(dec);

        int[] arr = new int[stack.size()];
        for(int i=0; i<arr.length; i++){
            arr[i]=stack.pop();
        }

        return arr;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while(testCases>0) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            int[] a = convertDecimalToBinary(first);
            int[] b = convertDecimalToBinary(second);

            int diffCount =0;
            for(int i=0; i<a.length; i++){
                if(a[i]!=b[i])
                    diffCount++;
            }

            if(diffCount==1)
                System.out.println("1");
            else
                System.out.println("0");


            testCases--;
        }

    }

}
