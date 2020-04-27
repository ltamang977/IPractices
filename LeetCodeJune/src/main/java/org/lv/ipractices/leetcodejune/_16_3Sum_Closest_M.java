package org.lv.ipractices.leetcodejune;

import java.util.*;

public class _16_3Sum_Closest_M {

    public static int threeSumClosestDemo(int[] arr, int target) {


        Arrays.sort(arr);

       List<Integer> list = new ArrayList<>();
       int diff = Integer.MAX_VALUE;


        for (int i = 0; i < arr.length - 2; i++) {

            int lo = i + 1;
            int hi = arr.length - 1;

            while (lo < hi) {

                if(Math.abs(arr[i]+arr[lo]+arr[hi]-target)<diff){
                    diff = Math.abs(arr[i]+arr[lo]+arr[hi]-target);
                    list = Arrays.asList(new Integer[]{arr[i],arr[lo],arr[hi]});
                }

                if (diff == 0) {
                    //System.out.println(Arrays.toString(new int[]{arr[i],arr[lo],arr[hi]}));
                    return  list.stream().reduce(0,
                            (element1, element2) -> element1 + element2);

                } else if (arr[i]+arr[lo]+arr[hi] < target) {
                    lo++;

                } else {
                    hi--;
                }
            }

        }

        //System.out.println("List with closest target is :"+list.toString());


        return  list.stream().reduce(0,
                (element1, element2) -> element1 + element2);
    }


    public static void main(String[] args){

        int[] arr = {-1, 2, 1, -4};

        int closestToTarget = threeSumClosestDemo( arr, 1);

        System.out.println("Closest sums is :"+ closestToTarget);



    }




}
