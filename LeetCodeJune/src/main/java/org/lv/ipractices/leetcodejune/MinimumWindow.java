package org.lv.ipractices.leetcodejune;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here

        /*
        "ADOBEC ODEBANC", target = "ABC"
        */

        if(source==null || target==null || source.isEmpty() || target.isEmpty()){
            return "";
        }

        Map<Character,Integer> targetMap = new HashMap<>();
        for(char c : target.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c,0)+1);
        }

        Map<Character,Integer> map = new HashMap<>();

        int mappedCount = 0;
        int start = 0;
        int min = source.length()+1;
        String minString= null;


        for(int i=0; i<source.length(); i++){

            char c = source.charAt(i);

            if(targetMap.containsKey(c)){
               // map.put(c, map.getOrDefault(c,0)+1);
                mappedCount++;

            }

            if(mappedCount==targetMap.keySet().size()){


                while(start<i){
                    char t = source.charAt(start);
                    if(!targetMap.containsKey(t)){
                        /*if(map.get(t)>1){
                            map.put(t, map.get(t)-1);
                        }else{
                            map.remove(t);
                        }*/
                        start++;

                    }else{
                        /*if(map.get(t)>1){
                            map.put(t, map.get(t)-1);
                        }else{
                            map.remove(t);
                        }*/
                        if(i-start+1<min){
                            minString = source.substring(start, i+1);
                        }
                        start++;
                        break;
                    }


                }



            }

        }

        return minString;
    }


    public static void main(String[] args){

        String source = "abc";
        String target = "a";

        MinimumWindow sol = new MinimumWindow();
        String s = sol.minWindow(source, target);

        System.out.println(s);

    }
}
