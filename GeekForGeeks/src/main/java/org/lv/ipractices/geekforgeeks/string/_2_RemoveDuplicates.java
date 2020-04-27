package org.lv.ipractices.geekforgeeks.string;

import java.util.Arrays;
import java.util.Scanner;


import java.util.Set;
import java.util.HashSet;

/**
 * Created by root on 1/16/18.
 */
public class _2_RemoveDuplicates {


    public static void removeDuplicates(char[] chArr){

        Arrays.sort(chArr);

        //
        int i=0;
        int j=1,k=1;

        while(i<chArr.length && chArr[i]!=' '){

            while(j<chArr.length && chArr[i]==chArr[j]){
                chArr[j]=' ';
                j++;
            }

            //duplicates found
            if(j!=k){
                //shift
                while(j<chArr.length){
                    //chArr[k]=chArr[j];
                    swap(chArr, j, k);
                    j++;
                    k++;
                }
            }

            i++;
            k=j=i+1;
        }

    }

    public static void swap(char[] chArr, int i, int j){
        char c = chArr[i];
        chArr[i]= chArr[j];
        chArr[j]= c;
    }


    public static void removeDuplicatesHash(char[] chArr){
        Set<Character> set = new HashSet<Character>();

        for(char ch : chArr){
            set.add(ch);
        }


        for(Character c : set){
            System.out.print(c);
        }

    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chArr = input.toCharArray();

        //recurse(chArr, 0, chArr.length-1);
        //removeDuplicates(chArr);
        removeDuplicatesHash(chArr);

        System.out.println("Reversed string is "+new String(chArr));

    }
}
