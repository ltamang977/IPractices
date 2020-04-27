package org.lv.ipractices.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {

    public static void coinChangeRecursion(int n, List<Integer> list, Set<List<Integer>> set){

        int sum = list.stream().mapToInt(i->i).sum();
        if(sum>n){
            return;
        }

        if(sum==n){
            set.add(new ArrayList(list));
            return;
        }

        for(int i=1; i<=3; i++){
            list.add(i);
            coinChangeRecursion(n, list, set);
            list.remove(list.size()-1);
        }

    }



    public static void main(String[] args){

        //int result = minimumStepsToOneMemoization(4);
        //minimumStepsToOneDynamicProgramming
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        coinChangeRecursion(4, list, set);

        System.out.println("possible outcomes is :"+set.size());

    }
}
