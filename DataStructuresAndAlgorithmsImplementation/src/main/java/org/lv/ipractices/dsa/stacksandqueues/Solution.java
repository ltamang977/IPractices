package org.lv.ipractices.dsa.stacksandqueues;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        // WRITE YOUR CODE HERE
        List<String> resultList = new ArrayList<String>();

        if(literatureText==null || (literatureText.trim()).equals("")){
            return resultList;
        }

        Map<String, Integer> freqMap = new HashMap<>();

        String[] arr = literatureText.split("\\s+");
        for(String s: arr){
            if(!wordsToExclude.contains(s)){
                freqMap.put(s, freqMap.getOrDefault(s, 0)+1);
            }
        }

        Set<Map.Entry<String,Integer>> entrySet = freqMap.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);


        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){

            public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){
                return e2.getValue().compareTo(e1.getValue());
            }

        });

        int maxFreq = list.get(0).getValue();

        for(Map.Entry<String,Integer> entry : list){
            if(entry.getValue()==maxFreq){
                resultList.add(entry.getKey());
            }

        }

        return resultList;
    }
    // METHOD SIGNATURE ENDS


    public static void main(String[] args){

        String literatureText = "hello hello how how ";
        List<String> wordsToExclude = new ArrayList<>();
        wordsToExclude.add("how");

        List<String> list = retrieveMostFrequentlyUsedWords( literatureText,
                 wordsToExclude);

        System.out.println(list.toString());

    }
}