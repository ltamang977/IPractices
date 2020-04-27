package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _66_Plus_One {

    public static int[] plusOne(int[] digits) {

        if(digits==null || digits.length==0)
            return digits;

        int sum = digits[digits.length-1]+1;

        digits[digits.length-1]=sum%10;
        int carry = sum/10;

        for(int i=digits.length-2; i>=0;i--){
            int sm = digits[i]+carry;
            digits[i]=sm%10;
            carry = sm/10;
        }

        if(carry==1){

            int[] arr = new int[digits.length+1];
            System.arraycopy(digits, 0, arr, 1, digits.length);
            arr[0]=carry;
            return arr;
        }else{
            return digits;
        }


    }


    public static void main(String[] args){

        int[] digits = {1, 2, 3};
        int[]  result = plusOne(digits);

        System.out.println(Arrays.toString(result));

    }
}
