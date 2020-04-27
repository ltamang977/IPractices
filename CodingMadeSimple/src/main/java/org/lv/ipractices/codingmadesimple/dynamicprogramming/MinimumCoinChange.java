package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoinChange {

    public static int minimumCoinChangeTopDown(int total, int[] coins, Map<Integer,Integer> map){

        if(total==0){
            return 0;
        }

        if(map.containsKey(total)){
            return map.get(total);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){

            if(total<coins[i]){
                continue;
            }
            int val = minimumCoinChangeTopDown(total-coins[i], coins, map);
            if(val+1<min){
                min = val+1;
            }
        }

        map.put(total, min);

        return min;
    }


    public static int minimumCoinChangeBottomUp(int total, int[] coins) {
        int[] T = new int[total+1];
        int[] R = new int[total+1];

        for(int i=1; i<=total; i++){
            T[i]= Integer.MAX_VALUE;
        }

        for(int i=0; i<=total; i++){
            R[i]= -1;
        }

        for(int i=0; i<coins.length; i++){
            for(int j=1; j<=total;j++){
                if(j>=coins[i]) {
                    if (T[j - coins[i]] + 1 < T[j]) {
                        T[j] = T[j - coins[i]] + 1;
                        R[j]=i;
                    }
                }
            }
        }

        printMinimumCoinChangeBottomUp(total, coins, T, R);

        return T[total];

    }

    public static void printMinimumCoinChangeBottomUp(int total, int[] coins, int[] T, int[] R){

        while(total!=0){
            int start = R[total];//denom value
            System.out.println(coins[start]);//denom value
            total = total - coins[start];
            start = R[total];
        }

    }

    public static void main(String[] args){

        int total = 32;
        int[] coins = {1,5,10,25};

        Map<Integer,Integer> memo = new HashMap<>();
        //int minTopDown = minimumCoinChangeTopDown( total,  coins, memo);
        //System.out.println("Minimimum using top down approach is :"+minTopDown);


        int minBottomUp = minimumCoinChangeBottomUp( total, coins);
        System.out.println("Minimimum using bottom up  approach is :"+minBottomUp);

    }
}

