package org.lv.ipractices.hackerrank.statistics;


import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MeanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] arr = {64630 ,11735, 14216 ,99233 ,14470, 4978, 73429 ,38120 ,51135, 67060};

        List<Integer> list = new ArrayList<>();
        list.add(64630);
        list.add(11735);
        list.add(14216);
        list.add(99233);
        list.add(14470);
        list.add(4978);
        list.add(73429);
        list.add(38120);
        list.add(51135);
        list.add(67060);

        /*Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i<times; i++){
            list.add(scanner.nextInt());
        }*/

        //mean
        int sum = list.stream().reduce(0, (x,y)->x+y);
        float mean = (float) sum/list.size();
        System.out.println(mean);

        Collections.sort(list);//sorts in ascending order
        //need to find two mid elements
        float median = 0;
        if(list.size()%2==1){
            //odd length
            int mid = list.size()/2;
            median = (float)list.get(mid);
        }else {
            //even
            int mid = list.size()/2;
            median = (float)(list.get(mid-1)+list.get(mid))/2;
        }
        System.out.println(median);

      //  Iterable

        //mediam
        Map<Integer, Integer> freqMap = list.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        Map<Integer, Integer> result = freqMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (maxEntry == null
                    || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry.getKey());

    }
}
