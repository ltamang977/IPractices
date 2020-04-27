package org.lv.ipractices;


/*
Your previous Plain Text content is preserved below:

// index of anagram;
// s = "actormpo";//m

        -----

// t = "rot";//space//n

// return 2;
// tor - rot - otr - ort : anagrams

r- 1
o-1
t-1

size -3


 */


import java.util.HashMap;
import java.util.Map;

class YahooQuestion {

    private static int getIndex(String s, String t) {

        if(s==null || t==null){
            return -1;
        }

        //counting target chrs
        Map<Character,Integer> charCount = new HashMap<>();
        for(char c : t.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0)+1);//rot {t:1, o:1, r: 1}
        }

        int start = 0;
        int i=0;
        for(; i<s.length(); i++){//actor  start = 1, i=0, 1, 2, 3, 4

            char c = s.charAt(i);
            if(charCount.containsKey(c)){

                if(charCount.get(c)>1){
                    charCount.put(c, charCount.get(c)-1);

                }else{
                    charCount.put(c, 0);
                }
                //
            }else{

                //map is empty and length
                if(i-start==t.length()){
                    return start;

                }else{
                    //mismatch
          /*
          actor
           s
           i
          rot

          1. regular moving
          2. terminng search and reseting
          */




                    start++;
                    while(start<i){
                        char temp = s.charAt(start);

                        if(charCount.containsKey(temp)){
                            charCount.put(temp, charCount.getOrDefault(temp, 0)+1);
                        }

                        start++;

                    }
                }
            }
        }

        if(i-start==t.length()){
            return start;

        }else{

            return -1;

        }



    }
    public static void main(String[] args) {

        System.out.println(getIndex("actor", "rot"));

    }
}


