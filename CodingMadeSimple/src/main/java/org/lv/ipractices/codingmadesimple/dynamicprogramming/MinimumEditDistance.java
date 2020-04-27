package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumEditDistance {


    public static int minimumEditDistance(String s1, String s2){

        int[][] temp = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i==0){
                    temp[i][j]=j;
                    continue;
                }
                if(j==0){
                    temp[i][j]=i;
                    continue;
                }

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    //same
                    temp[i][j]=temp[i-1][j-1];
                }else {
                    int min = Math.min(temp[i-1][j-1],temp[i-1][j]);
                    min = Math.min(min,temp[i][j-1]);
                    temp[i][j]=min+1;
                }

            }
        }


        return temp[temp.length-1][temp[0].length-1];

    }




    public static void main(String[] args){

        String s1 = "azced";
        String s2 = "abcdef";

        int minimumEditDistance = minimumEditDistance(s1, s2);
        System.out.println("minimumEditDistance is :"+minimumEditDistance);


     /*


        int minBottomUp = minimumCoinChangeBottomUp( total, coins);
        System.out.println("Minimimum using bottom up  approach is :"+minBottomUp);
*/
    }
}
