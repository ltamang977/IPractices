package org.lv.ipractices.leetcodejune;

import java.util.*;

public class _15_3Sum_M {

    public static List<List<Integer>> threeSumDemo(int[] arr) {


        Arrays.sort(arr);

        Set<List<Integer>> resultSet = new HashSet<>();


        for (int i = 0; i < arr.length - 2; i++) {

            int val = arr[i];
            int other = -val;

            int lo = i + 1;
            int hi = arr.length - 1;

            while (lo < hi) {

                if (arr[lo] + arr[hi] == other) {
                    resultSet.add(Arrays.asList(new Integer[]{arr[i], arr[lo], arr[hi]}));
                    lo++;
                } else if (arr[lo] + arr[hi] < other) {
                    lo++;

                } else {
                    hi--;
                }
            }

        }

        return new ArrayList<>(resultSet);
    }


    public static void main(String[] args){

        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> resultList = threeSumDemo( arr);

        resultList.stream().forEach(System.out :: println);



    }




}
