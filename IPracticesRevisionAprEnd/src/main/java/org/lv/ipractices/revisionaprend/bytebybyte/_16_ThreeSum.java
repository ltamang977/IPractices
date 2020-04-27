package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.ArrayList;
import java.util.Arrays;

public class _16_ThreeSum {


    public static ArrayList<int[]> threeSumToZero(int[] arr){

        ArrayList<int[]> resultList = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0; i<arr.length-2; i++){

            //no duplicates
            if(i==0 || arr[i]>arr[i-1]){

                int start = i+1;
                int end = arr.length-1;

                while(start<end){

                    if(arr[i]+arr[start]+arr[end]<=0){
                        if(arr[i]+arr[start]+arr[end]==0){
                            resultList.add(new int[]{arr[i], arr[start], arr[end]});
                        }
                        int currentStart = start;
                        while(start<end && arr[currentStart]==arr[start]){
                            start++;
                        }
                    }

                    if(arr[i]+arr[start]+arr[end]>0){
                        int currentEnd = end;
                        while(start<end && arr[currentEnd]==arr[end]){
                            end--;
                        }
                    }


                }

            }

        }

        return resultList;

    }


    public static void main(String[] args){

        int[] arr = {-4, -1, -1, 0, 1, 2};
        ArrayList<int[]> resusltList = threeSumToZero(arr);
        resusltList.forEach(e-> System.out.println(Arrays.toString(e)));

    }
}
