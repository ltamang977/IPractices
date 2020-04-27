package org.lv.ipractices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPoints {

    public static long maxPoints(List<Integer> elements) {
        // Write your code here

        if(elements==null || elements.isEmpty()){
            return 0;
        }

        Collections.sort(elements);
        // elements.sort();//sorting in ascending order

        int i = elements.size()-1;

        long totalPoints = 0L;
        while(i>=0){

            int chosen = elements.get(i);
            totalPoints=totalPoints+chosen;

            int j = i-1;
            while(j>=0 && elements.get(j)==chosen){
                totalPoints=totalPoints+chosen;
                j--;
            }

            if(j>=0 && elements.get(j)==chosen-1){
                j--;
            }
            i=j;

        }

        return totalPoints;

    }

    public static void main(String[] args){

        /*
        6
1
2
1
3
2
3
         */

        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(1);
        elements.add(1);
        elements.add(1);
        elements.add(2);
        elements.add(3);
        /*
        elements.add(6);
        elements.add(1);
        elements.add(2);
        elements.add(1);
        elements.add(3);
        elements.add(2);
        elements.add(3);*/

        long max = maxPoints(elements);
        System.out.println(max);
    }
}
