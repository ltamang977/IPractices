package org.lv.ipractices.geekforgeeks.easy;

import java.util.Scanner;

/**
 * Created by root on 12/29/17.
 */
public class AddTwoNumbersRepresentedByArrays {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while(testCases>0) {

            int firstSize = scanner.nextInt();
            int[] a = new int[firstSize];
            for(int i=0; i<a.length ; i++){
                a[i]= scanner.nextInt();
            }

            int secondSize = scanner.nextInt();
            int[] b = new int[secondSize];
            for(int i=0; i<b.length ; i++){
                b[i]= scanner.nextInt();
            }

            int maxLength = Math.max(firstSize, secondSize);
           // resultSize++;

            int[] result = new int[maxLength+1];
            int i = a.length-1;//for a
            int j =b.length-1;// for b
            int k=0;

            int carry = 0;
            int first=0;
            int second = 0;
            while(k<maxLength){
                if(i>=0)
                    first = a[i];
                if(j>=0)
                    second = b[j];

                int sum = first+second+carry;
                String sumStr = String.valueOf(sum);
                if(sumStr.length()==1){
                    result[k]=sum;
                    carry = 0;
                    first = 0;
                    second = 0;
                    i--;
                    j--;
                    k++;

                }else {
                    result[k]=Integer.parseInt(String.valueOf(sumStr.charAt(1)));
                    carry = Integer.parseInt(String.valueOf(sumStr.charAt(0)));;
                    i--;
                    j--;
                    k++;
                    first =0;
                    second=0;
                }

            }

            if(carry>0)
                result[k]=carry;

            //how to array reverse
            //int[] orderedArr = new int[result.length];
            //for(int l=0; l<result.length; l++){
             //   orderedArr[result.length-l-1] = result[l];
           // }
            int startIndex = 0;
            for(int p=maxLength;p>=0; p--){
                if(result[p]!=0) {
                    break;
                }
            }

            for(int m = startIndex; m>=0; m--){
                System.out.printf("%d", result[m]);
            }

            testCases--;
        }
    }
}
