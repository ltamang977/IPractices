package org.lv.ipractices.stanford.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {



    public static void permute(char[] arr, int start, List<char[]> resultList){

        if(start==arr.length){
            resultList.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        for(int i=start; i<arr.length; i++){

            swap(arr, start, i);
            permute(arr, start+1, resultList);
            swap(arr, start, i);

        }

    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;

    }

    public static void main(String[] args){

        char[] arr = {'a','b','c','d'};
        List<char[]> resultList= new ArrayList<char[]>();
        permute(arr, 0, resultList);

        for(char[] chars : resultList){
            System.out.println(Arrays.toString(chars));
        }

    }
}
