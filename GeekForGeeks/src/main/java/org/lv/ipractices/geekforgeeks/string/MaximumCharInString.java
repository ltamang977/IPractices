package org.lv.ipractices.geekforgeeks.string;

/**
 * Created by root on 1/16/18.
 */
public class MaximumCharInString {

    public static char findMaxChar(char[] chArr){


        int[] occurences = new int[128];

        //count occurences
        for(char c : chArr){
            occurences[c]++;
        }

        //find max
        int maxIndex = 0;
        for(int i= 0; i<128; i++){
            if(occurences[i]>occurences[maxIndex]){
                maxIndex=i;
            }
        }

        return (char)maxIndex;

    }

    public static char findSecondMaxChar(char[] chArr){


        int[] occurences = new int[128];

        //count occurences
        for(char c : chArr){
            occurences[c]++;
        }

        //find max
        int maxIndex = 0;
        int secondMaxIndex =0;
        for(int i= 0; i<128; i++){
            if(occurences[i]>occurences[maxIndex]){
                secondMaxIndex=maxIndex;
                maxIndex=i;
            }else if(occurences[i]>occurences[secondMaxIndex]){
                secondMaxIndex=i;
            }
        }

        return (char)secondMaxIndex;

    }

    public static void main(String[] args){
        String input = "Hello there";

        System.out.println("Max char is "+findMaxChar(input.toCharArray()));


        System.out.println("Second Max char is "+findSecondMaxChar(input.toCharArray()));
    }
}
