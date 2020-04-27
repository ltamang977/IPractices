package org.lv.ipractices.stanford.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubLists {



    public static void sublists(List<String> org, List<String> chosen){

        if(org.isEmpty()){
            System.out.println(chosen);
            return;
        }

        String curr = org.get(0);
        org.remove(0);

        sublists(org, chosen);

        chosen.add(curr);
        sublists(org, chosen);

        org.add(0, curr);
        chosen.remove(chosen.size()-1);

    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;

    }

    public static void main(String[] args){

        List<String> org = new ArrayList<>(Arrays.asList("Jane", "Bob", "Matt", "Sara"));
        List<String> chosen = new ArrayList<>();
        sublists(org, chosen);

    }
}
