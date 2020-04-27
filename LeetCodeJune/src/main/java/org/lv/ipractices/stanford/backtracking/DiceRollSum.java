package org.lv.ipractices.stanford.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceRollSum {

    static int calls =0;


    public static void diceRoll(int dices, int target, List<Integer> tempList, List<List<Integer>> resultList){

        calls++;

        if(dices==0){

            if(target==0){
                resultList.add(new ArrayList<>(tempList));
            }
            return;
        }


        for(int i=1; i<=6; i++){

           /* if(target-i<0){
                continue;
            }*/
            tempList.add(i);
            diceRoll(dices-1,target-i, tempList, resultList );
            tempList.remove(tempList.size()-1);
        }

    }


    public static void main(String[] args){

        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        diceRoll(2, 7, tempList, resultList);
        System.out.println("calls aret"+calls);
        System.out.println(resultList);

    }
}
