package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.*;
import java.util.LinkedList;

public class _9_KthMostFrequentString {


    //kthMostFrequentString

    public static List<Integer> kthMostFrequentComparator(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        //Collections.sort(entryList, (a,b)->b.getValue().compareTo(a.getValue()));
        //Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));

        /*Collections.sort(entryList, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
                return b.getValue().compareTo(a.getValue());
            }
        });*/

        Collections.sort(entryList, new Comparator(){
            public int compare( Object a, Object b){

                Map.Entry<Integer,Integer> entryA = (Map.Entry<Integer,Integer>) a;
                Map.Entry<Integer,Integer> entryB = (Map.Entry<Integer,Integer>) b;

                return entryB.getValue().compareTo(entryA.getValue());
            }
        });

        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : entryList){
            if(resultList.size()>=k){
                break;
            }
            resultList.add(entry.getKey());
        }

        return resultList;


    }

    public static List<Integer> kthMostFrequentBucket(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }


        List<Integer>[] bucketList = new List[arr.length+1];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(bucketList[freq]==null){
                bucketList[freq] = new ArrayList<>();
            }
            bucketList[freq].add(entry.getKey());
        }

        List<Integer> resultList = new ArrayList<>();

        for(int i=bucketList.length-1; i>0 && resultList.size()<k; i--) {
            List<Integer> list = bucketList[i];
            if(list!=null) {
                for(Integer item : list){
                    if(resultList.size()>=k)
                        break;
                    resultList.add(item);

                }
            }

        }
        return resultList;

    }

    /*
    solution using max heap : O(nlogn)
     */
    public static List<Integer> kthMostFrequentMaxHeap(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxHeap.add(entry);

        }

        List<Integer> resultList = new ArrayList<>();
        while(resultList.size()<k){
            Map.Entry<Integer, Integer> currMax = maxHeap.poll();
            resultList.add(currMax.getKey());
            /*for(Integer i : entry.getValue()){
                if(resultList.size()>=k){
                    break;
                }

            }*/
        }

        return resultList;

    }


    /*
        solution using treemap : O(nlog(n))
     */
    public static List<Integer> kthMostFrequentTreeMap(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }

            freqMap.get(freq).add(key);

        }

        List<Integer> resultList = new ArrayList<>();
        while(resultList.size()<k){
            Map.Entry<Integer,List<Integer>> entry = freqMap.pollLastEntry();
            for(Integer i : entry.getValue()){
                if(resultList.size()>=k){
                    break;
                }
                resultList.add(i);
            }
        }

        return resultList;

    }



    public static void main(String[] args){

        //[1,1,1,2,2,2,3, 3, 3, 4] and k = 2, return [1,2].
        int[] input = {1,1,1,2,2,2,3, 3,3,4};
        int k = 2;
        //System.out.println(compressStringCheckingDiff(s1));
        //List<Integer> list = kthMostFrequentTreeMap(input, 2);
        //List<Integer> list = kthMostFrequentMaxHeap(input, 2);//1,1
        //List<Integer> list = kthMostFrequentBucket(input, 2);//1,1
        List<Integer> list = kthMostFrequentComparator(input, 2);//1,1
        //kthMostFrequentComparator
        System.out.println(list.toString());


    }
}
