package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/27/18.
 */
public class BestTimeToBuyAndSellSocket {


    public static int bestTimeToBuyAndSellSocket(int[] arr){

        int minSoFar = Integer.MAX_VALUE;
        int maxProfitSoFar = 0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]<minSoFar){
                minSoFar = arr[i];
            }else if (arr[i]-minSoFar>maxProfitSoFar){
                maxProfitSoFar = arr[i]-minSoFar;
            }
        }

        return maxProfitSoFar;

    }


    public static int stockProfitMultipleTransactions(int[] arr){
        int minYet = Integer.MAX_VALUE;
        int maxYet = 0;
        int totalProfit = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<minYet){
                minYet=arr[i];
            }else if(arr[i]>minYet){
                totalProfit = totalProfit+(arr[i]-minYet);
                minYet=0;

            }
        }
        return totalProfit;
    }


    public static void main(String[] args){
        int[] arr = {7,1,5,3,6,4};
        //int maxProfit = bestTimeToBuyAndSellSocket(arr);
        int maxProfit= stockProfitMultipleTransactions(arr);
        System.out.println("Maximum profit is "+maxProfit);

    }
}
