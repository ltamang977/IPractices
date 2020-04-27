package org.lv.ipractices.stanforduniversity.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    public static int count;

    public static void diceSum(int dices, int sum, List<Integer> list){
        count++;

        if(dices==0){
            if(sum==0){
                System.out.println(list.toString());
            }
            return;
        }else if(sum>=dices*1 && sum<=dices*6) {

            for (int i = 1; i <= 6; i++) {
                list.add(i);
                diceSum(dices - 1, sum - i, list);
                list.remove(list.size() - 1);
            }
        }


    }


    public static void permutation(List<Integer> list, List<Integer> choice){

        if(list.isEmpty()){
            System.out.println(choice.toString());
            return;
        }

        int s = list.size();
        for(int i=0; i<s; i++){

            Integer n = list.get(i);
            choice.add(n);
            list.remove(i);
            permutation(list, choice);
            list.add(i, n);
            choice.remove(choice.size()-1);


        }

    }


    public static void sublists(List<String> list, List<String> choice){

        if(list.isEmpty()){
            System.out.println(choice.toString());
            return;
        }

        //without
        String name = list.remove(0);
        sublists(list, choice);


        choice.add(0, name);
        sublists(list, choice);
        choice.remove(0);
        list.add(0, name);


    }


    public static void main(String[] args){

        /*List<Integer> list = new ArrayList<>();
        diceSum(3, 5, list);*/
       /* List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> choice = new ArrayList<>();
        permutation(list, choice);
        System.out.println("Total Count :"+count);*/


        List<String> nameList = new ArrayList<>(Arrays.asList("Labin", "Dipen", "Palden"));
        List<String> nameChoiceList = new ArrayList<>();
        sublists(nameList, nameChoiceList);


    }
}
