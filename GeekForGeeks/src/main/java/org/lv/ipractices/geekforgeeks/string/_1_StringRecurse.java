package org.lv.ipractices.geekforgeeks.string;

/**
 * Created by root on 1/16/18.
 */

import java.util.Scanner;
public class _1_StringRecurse {

    public static void swap(char[] chArr, int i, int j){
        char temp = chArr[i];
        chArr[i] = chArr[j];
        chArr[j]=temp;
    }

    public static void recurse(char[] chArr, int i, int j){

        if(j<=i)
            return;

        swap(chArr, i, j);
        recurse(chArr, i+1, j-1);

    }

    public static boolean isValidChar(char c){
        if(c>=65 && c<=90){
            return true;
        }

        if (c>=97 && c<=122){
            return true;
        }

        return false;
    }


    public static void reverseWithSpecialChars(char[] chArr){
        int i =0;
        int j= chArr.length-1;


        while(i<=j){

            while(!isValidChar(chArr[i])){
                i++;
            }

            while(!isValidChar(chArr[j])){
                j--;
            }

            if(j<=i)
                break;

            swap(chArr, i, j);
            i++;
            j--;

        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chArr = input.toCharArray();

        //recurse(chArr, 0, chArr.length-1);

        reverseWithSpecialChars(chArr);

        System.out.println("Reversed string is "+new String(chArr));

    }

}
