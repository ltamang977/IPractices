package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/20/18.
 */

import java.util.*;

public class ThreeSum {


    /**
     * three sum 0 using hashing
     * //gets some duplicates elements
     * @param arr
     * @return
     */
    public static List<List<Integer>> threeSumZeroHashingGFG(int[] arr){

        List<Integer> triplets = new ArrayList<>();

        List<List<Integer>> tripletsList = new ArrayList<>();


        for(int i=0; i<arr.length-1; i++){//go till second last

            Set<Integer> set = new HashSet<>();

            for(int j=i+1; j<arr.length;j++) {
                int searchKey = -(arr[i]+arr[j]);

                //if(set.contains(searchKey))

                if (set.contains(searchKey)) {
                    triplets = new ArrayList<>();
                    triplets.add(arr[i]);
                    triplets.add(arr[j]);
                    triplets.add(searchKey);

                    tripletsList.add(triplets);

                    set.add(arr[j]);
                    //triplets.addAll(Arrays.asList(new int[]{4,5,6}));
                } else {
                    //map.put(x, i);
                    set.add(arr[j]);
                }
            }
        }

        return tripletsList;


    }

    /**
     * three sum using soring from gff
     * returns duplicate triplets
     * //fixning duplicates after solution
     * @param arr
     * @return
     */
    public static List<List<Integer>> threeSumZeroSortingGFG(int[] arr){


        Arrays.sort(arr);
        System.out.println("Sorted array :"+Arrays.toString(arr));

        List<Integer> triplet = new ArrayList<>();
        List<List<Integer>> tripletList = new ArrayList<>();

        if(arr==null || arr.length<3)
            return tripletList;

        for(int i=0; i<arr.length-2; i++){

            if(i>0 && arr[i]==arr[i-1])
                continue;

            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum==0){
                    triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    tripletList.add(triplet);
                    left++;
                    while(left<right && arr[left]==arr[left-1]){
                        left++;
                    }
                    right--;
                    while(left<right && arr[right]==arr[right+1]){
                        right--;
                    }
                }else if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }
            }
        }

        //int index = Arrays.binarySearch(arr, 0);

        //System.out.println("index of 0 is : "+index);


        return tripletList;

    }


    public static List<List<Integer>> threeSumSortingLC(int[] arr){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 0);
        int maxNeg=index;
        int minPos=index;
        int zeroCount;

        if(index<0){//zero not found
            int insertionPoint = -(index+1);
            maxNeg = insertionPoint-1;
            minPos = insertionPoint;
            zeroCount=0;

        }else {
            //sero found
            while(maxNeg>-1 && arr[maxNeg]==0){
                maxNeg--;
            }

            while(minPos<arr.length && arr[minPos]==0){
                minPos++;
            }

            zeroCount=minPos-maxNeg-1;
        }

        int min= arr[0];
        int max = arr[arr.length-1];
        int[] hash = new int[max-min+1];

        for(int v :arr){
            hash[v-min]++;
        }

        if(zeroCount>3){
            addTriplets(result, 0,0,0);
        }

        if (zeroCount > 0) {
            for(int i=minPos; i<arr.length; i++){
                if(i>minPos && arr[i]==arr[i-1]){
                    continue;
                }
                if(-arr[i]-min>-1 && hash[-arr[i]-min]>0)
                    addTriplets(result, 0, arr[i], -arr[i]);
            }
        }

        //lets ignore zero for now

        //consider positive side
        for(int i=minPos; i<arr.length;i++){
            if(i>minPos && arr[i]==arr[i-1])
                continue;

            int half;

            if(arr[i]%2!=0)
                half = -(arr[i]/2+1);
            else{
                half= -(arr[i]/2);
                if(half-min>-1 && hash[half-min]>1)
                    addTriplets(result, arr[i],half, half);
            }

            for(int j=maxNeg;j>-1 && arr[j]>half;j--){
                if(j<maxNeg && arr[j]==arr[j+1])
                    continue;
                if((-arr[i]-arr[j])-min>-1 && hash[(-arr[i]-arr[j])-min]>0)
                    addTriplets(result, arr[i], arr[j], -arr[i]-arr[j]);
            }
        }


        //consider negative side
        for(int i=maxNeg; i>-1;i--){
            if(i>maxNeg && arr[i]==arr[i+1])
                continue;

            int half;

            if(arr[i]%2!=0)
                half = -(arr[i]/2-1);
            else{
                half= -(arr[i]/2);
                if(half-min<hash.length && hash[half-min]>1)
                    addTriplets(result, arr[i],half, half);
            }

            for(int j=minPos;j<arr.length && arr[j]<half;j++){
                if(j>minPos && arr[j]==arr[j-1])
                    continue;
                if((-arr[i]-arr[j])-min<hash.length && hash[(-arr[i]-arr[j])-min]>0)
                    addTriplets(result, arr[i], arr[j], -arr[i]-arr[j]);
            }
        }

        return result;

    }

    public static void addTriplets(List<List<Integer>> result, int i, int j, int k){
        List<Integer> triplet = new ArrayList<>();
        triplet.add(i);
        triplet.add(j);
        triplet.add(k);
        result.add(triplet);

    }



    public static void main(String[] args){

        int[] arr = {-1,0,  1,2, -1,-4};

        /*
        List<List<Integer>> tripletsList = threeSumZeroHashing(arr);
        System.out.println("triplets count"+tripletsList.size());
        */

        List<List<Integer>> tripletsList = threeSumZeroSortingGFG(arr);

        //List<List<Integer>> tripletsList = threeSumSortingLC(arr);

       for(List<Integer> triplet : tripletsList){
           System.out.println("triplet :"+triplet.toString());
        }
    }
}
