package org.lv.ipractices.geekforgeeks.school;

import java.util.Scanner;

/**
 * Created by root on 12/25/17.
 */
public class _25_CheckString {

    public static boolean checkString(String input, int lo, int hi){

        if(hi<=lo){
            return true;
        }

        if(input.charAt(lo)!=input.charAt(hi)){
            return false;
        }
        int mid = lo+(hi-lo)/2;

        boolean left = checkString(input, lo, mid);
        boolean right = checkString(input, mid+1, hi);

        boolean result = left && right;

        return  result;
    }

    public static void checkString(String input){
        boolean result = checkString(input, 0, input.length()-1);
        if(result){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while(testCases>0) {
            String str = scanner.next();
            System.out.println("String input is :" + str);

            checkString(str);

            testCases--;
        }

    }
}
