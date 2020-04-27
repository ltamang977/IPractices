package org.lv.ipractices.geekforgeeks.school;

import java.util.Scanner;

import java.util.Stack;

/**
 * Created by root on 12/26/17.
 */
public class _26_DecimalToBinary {

    public static void convertDecimalToBinary(int dec){

        Stack<Integer> stack = new Stack();
        do {
            int modulo = dec%2;
            dec = dec/2;
            stack.push(modulo);

        }while(dec>=2);

        stack.push(dec);

        while(!stack.isEmpty()){
          System.out.printf("%d", stack.pop());
        }
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while(testCases>0) {
            int str = scanner.nextInt();
            System.out.println("String input is :" + str);

            convertDecimalToBinary(str);

            testCases--;
        }

    }
}
