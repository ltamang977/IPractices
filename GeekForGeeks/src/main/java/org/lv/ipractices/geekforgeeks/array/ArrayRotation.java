package org.lv.ipractices.geekforgeeks.array;

import java.util.Arrays;

public class ArrayRotation {


    public static void rotationWithTempArray(int[] arr, int d){

        //arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7

        // if arr is small than d throw exception
        int[] temp = new int[d];
        System.arraycopy(arr, 0, temp, 0, 2);

        for(int i=0; i<arr.length-d; i++){
            arr[i]= arr[i+d];
        }

        System.arraycopy(temp, 0, arr, arr.length-d, 2);

        System.out.println(Arrays.toString(arr));

    }

    public static void rotationOneAtATime(int[] arr, int d){


        for(int i=0; i<d; i++){
            int temp = arr[0];
            for(int j = 1; j<arr.length; j++){
                arr[j-1]=arr[j];
            }
            arr[arr.length-1]= temp;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void rotationUsingGcd(int[] arr, int d){

        int gcd = gcd(arr.length, d);

        for(int i=0; i<gcd; i++){
            int temp = arr[i];

            int index = i;
            while(index+d<arr.length){
                arr[index]=arr[index+d];
                index = index+d;

            }
            arr[index]=temp;

        }

        System.out.println(Arrays.toString(arr));

    }


    public static int gcd(int a, int b){
        if(b==0)
            return a;

        return gcd(b, a%b);
    }


    public static void rotationRight(int[] arr, int d){


        for(int i=0; i<d; i++){
            int temp = arr[arr.length-1];
            for(int j = arr.length-1; j>0; j--){
                arr[j]=arr[j-1];
            }
            arr[0]= temp;
        }

        System.out.println(Arrays.toString(arr));

    }


    public static void main(String[] args){

        int[] arr  = {1, 2, 3, 4, 5, 6, 7, 8};
        int d = 1;
        //rotationWithTempArray(arr, 2);
        //rotationOneAtATime(arr, 2);
        //rotationUsingGcd(arr, d);
        rotationRight(arr, d);
    }
}
