package org.lv.ipractices.leetcodejune;

import java.util.Collections;

public class _295_MedianFinder {

    static class MedianFinder{

        int[] arr = new int[2];
        int n=0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if(n==arr.length){
                resize(2*n);
            }

            int i = n;
            while(i>0 && num<arr[i-1]){
                arr[i]=arr[i-1];
                i--;
            }
            arr[i]=num;
            n++;

            Collections.reverseOrder();

        }

        public double findMedian() {

            if(n%2==0){
                //even
                int mid= (0+(n-1))/2;
                double evenResult = (arr[mid]+arr[mid+1])/2;
                return evenResult;

            }else{
                //odd
                int medianIndex = (0+(n-1))/2;
                int oddResult = arr[medianIndex];
                return oddResult;

            }
        }

        public void resize(int capacity){
            assert capacity>n;

            int[] temp = new int[capacity];
            for(int i=0; i<n; i++){
                temp[i]=arr[i];
            }
            arr = temp;
        }

    }


    public static void main(String[] args){

        MedianFinder sol = new MedianFinder();
        sol.addNum(1);
        sol.addNum(2);
        sol.addNum(3);

        System.out.println("Median is :"+ sol.findMedian());

    }
}


