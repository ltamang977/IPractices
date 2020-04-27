package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _13_Permutations {

    //permutation of strings

    //permutation of array

    public static List<List<Integer>> permutationOfArray(int[] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        permutationOfArray(resultList, nums, 0);
        return resultList;
    }

    public static void permutationOfArray(List<List<Integer>> resultList, int[] nums, int count ){

        if(count==nums.length){
            List<Integer> list = Arrays.stream(nums)
                                .boxed()
                                .collect(Collectors.toList());
            resultList.add(list);
        }

        for(int i=count; i<nums.length; i++){
            swap(nums, i,count);
            permutationOfArray(resultList, nums, count+1);
            swap(nums, i,count);
        }

    }



    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }





    public static void permutationOfString(String prefix, String suffix, List<String> resultList ){

        if(suffix.length()==0){
            resultList.add(prefix);
        }

        for(int i=0; i<suffix.length(); i++){
            permutationOfString( prefix+suffix.charAt(i),
                    suffix.substring(0,i)+suffix.substring(i+1,suffix.length()),
                    resultList );
        }

    }



    public static void main(String[] args){

        //int[] nums = {1,2,3};
        //List<List<Integer>> permutationList = permutationOfArray(nums);
        //permutationList.forEach(item->System.out.println(item));


        List<String> resultList = new ArrayList<>();
        permutationOfString("", "abc", resultList);
        resultList.forEach(item-> System.out.println(item));


    }
}
