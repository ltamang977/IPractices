package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum {



    public static boolean subsetSum(int sum, int[] input){

        boolean[][] matrix = new boolean[input.length+1][sum+1];

        for(int i=0; i<input.length; i++){
            matrix[i][0]=true;
        }

        for(int i=1; i<=input.length; i++){
            for(int j=1; j<=sum; j++){
                if(j>=input[i-1]){
                    matrix[i][j]=matrix[i-1][j] || matrix[i-1][j-input[i-1]];
                }else {
                    matrix[i][j]=matrix[i-1][j];
                }
            }
        }

        printElements(matrix, input);

        return matrix[input.length][sum];


    }

    public static void printElements(boolean[][] matrix, int[] input){

        int i = matrix.length-1;
        int j = matrix[0].length-1;

        while(j>0 && i>0){

            if(matrix[i][j]==matrix[i-1][j]){
                i=i-1;
            }else {
                System.out.print(input[i-1]);
                i=i-1;
                j=j-input[i];
            }

        }

    }


    public static void main(String[] args){

        int sum = 11;
        int[] input = {2,3,7,8,10};

        Map<Integer,Integer> memo = new HashMap<>();
        //int minTopDown = minimumCoinChangeTopDown( total,  coins, memo);
        //System.out.println("Minimimum using top down approach is :"+minTopDown);


        boolean subsetSum = subsetSum(sum, input);
        System.out.println("SubsetSum using bottom up  approach is : " +subsetSum);

    }
}
