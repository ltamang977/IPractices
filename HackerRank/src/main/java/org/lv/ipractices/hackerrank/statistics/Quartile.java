package org.lv.ipractices.hackerrank.statistics;


import java.io.*;
        import java.util.*;

        import java.math.*;

public class Quartile {


    public static int findMedian(int[] arr, int lowIndex, int highIndex){
        int cnt = highIndex-lowIndex+1;
        int mid = lowIndex + (highIndex-lowIndex)/2;
        if(cnt%2==1){//odd
            return arr[mid];
        }else {//even
            return (arr[mid]+arr[mid+1])/2;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int items = scanner.nextInt();

        int[] arr = new int[items];
        for(int i=0; i<items;i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int q1LastIndex;
        int q3FirstIndex;

        int q2 = findMedian(arr, 0, arr.length-1);

        int q1=0;
        int q3=0;
        if(items%2==1){//odd
            q1 = findMedian(arr, 0, (arr.length/2)-1);
            q3 = findMedian(arr, (arr.length/2)+1, arr.length-1);
        }else{
            int mid = arr.length/2;
            q1 = findMedian(arr, 0, mid-1);
            q3 = findMedian(arr, mid, arr.length-1);
        }

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }


}