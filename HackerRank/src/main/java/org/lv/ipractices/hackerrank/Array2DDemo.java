package org.lv.ipractices.hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array2DDemo {


    public static int hourGlassSum(int[][] arr, int lowRow, int highRow, int lowCol, int highCol){

        int mid = (lowRow+highRow)/2;
        int sum = 0;
        for(int i = lowRow; i<highRow; i++){
            for(int j=lowCol; j<highCol; j++){
                if(i==mid && j!=i){
                    continue;
                }
                sum = sum + arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];

        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int maxsum = 0;
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                if(i+2<6 &&  j+2<6 ){
                    int hourglassSum  = hourGlassSum(arr, i, i+2, j, j+2);
                    if(hourglassSum>maxsum){
                        maxsum = hourglassSum;
                    }
                }
            }
        }
    }
}
