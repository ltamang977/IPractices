package org.lv.ipractices.geekforgeeks.basic;

/**
 * Created by root on 12/28/17.
 */
public class MaxOfTriplets {

    public static int max(int a, int b, int c) {

        if (a >= b && a >= c) {
            return a;
        }

        if (b >= c && b >= a) {
            return b;
        }

        if (c >= a && c >= b) {
            return c;
        }

        return -1;
    }

    public static int maxTriplets(int[] arr) {

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        int ab;
        int ac;
        int bc;


        int maxOne = Math.max(a, b);
        int minOne = Math.min(a, b);
        int maxTwo = a + b;
        int minTwo = a + b;

        int maxThree = 0;
        for (int i = 2; i < arr.length; i++) {

            int x = arr[i];
            if (x > 0) {//+ve
                maxThree = maxTwo + x;
                maxTwo = maxOne + x;
                maxOne = Math.max(maxOne, x);

            } else { // -ve

            }
            maxThree = maxTwo + maxOne;

        }

        return 0;

    }
}
