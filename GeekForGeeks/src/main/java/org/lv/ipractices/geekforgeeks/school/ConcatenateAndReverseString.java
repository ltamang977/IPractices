package org.lv.ipractices.geekforgeeks.school;

import java.util.Scanner;

/**
 * Created by root on 12/27/17.
 */
public class ConcatenateAndReverseString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        while (numberOfTestCases > 0) {
            String str1 = scanner.next();
            String str2 = scanner.next();

            String result = str1.concat(str2);
            char[] chArr = result.toCharArray();

            System.out.println("Result if :" + result);

            int i = 0;
            int j = result.length() - 1;
            while (i <= j) {
                swap(chArr, i,j);
                i++;
                j--;
            }
            System.out.println("Reverse is :" + new String(chArr));

            numberOfTestCases--;
        }
    }

        public static void swap(char[] arr, int i, int j){
            char temp = arr[i];
            arr[i]= arr[j];
            arr[j]= temp;

        }

}
