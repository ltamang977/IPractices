package org.lv.ipractices.codingmadesimple.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {

    //value //60,100,120
    //weight  //10,20,30
    // max weight 50

    public static int knapSackTopDown(int total, int index, int[] weights, int[] values, Map<Integer,Integer> map){

        if(total<=0 || index>=weights.length){
            return 0;
        }

        if(total<weights[index])
            return knapSackTopDown(total, index+1, weights, values,  map);

        int previousValue = knapSackTopDown(total, index+1, weights, values,  map); //arr[row-1][j];//not taking the item
        int updatedValue  = knapSackTopDown(total-weights[index], index+1, weights, values,  map) + values[index]; // arr[row-1][j-weights[row-1]] + values[row-1];
        int val = Math.max(previousValue, updatedValue);

        return val;
    }



    public static int knapSackBottomUp(int maxWeight, int[] weights, int[] values) {

        //since weight is 0 baed
        //maxWeight is 1 based
        //
        int[][] arr = new int[weights.length+1][maxWeight+1];

        for(int i=0; i<weights.length; i++){
            for(int j=1; j<=maxWeight; j++){
                int row = i+1;
                if(j<weights[i]){
                    arr[row][j] =  arr[row-1][j];

                }else{
                    int previousValue = arr[row-1][j];//not taking the item
                    int updatedValue  = arr[row-1][j-weights[row-1]] + values[row-1];
                    int val = Math.max(previousValue, updatedValue);

                    arr[row][j] = val;
                }
            }
        }

        return arr[weights.length][maxWeight];

    }


    public static void main(String[] args){

        int maxWeight = 7;
        int[] weights = {1,3,4,5};
        int[] values = {1,4,5,7};

        Map<Integer,Integer> memo = new HashMap<>();
        // public static int knapSackTopDown(int total, int index, int[] weights, int[] values, Map<Integer,Integer> map){
        int knapSackTopDown = knapSackTopDown( maxWeight, 0, weights, values, memo);
        System.out.println("Maximum using top down approach is :"+knapSackTopDown);


        //int knapSackBottomUp = knapSackBottomUp( 7, weights, values );
        //System.out.println("Maximum value using bottom up  approach is :"+knapSackBottomUp);

    }
}


