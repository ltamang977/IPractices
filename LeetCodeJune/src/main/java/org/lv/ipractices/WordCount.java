package org.lv.ipractices;


import java.io.*;
        import java.util.*;

import java.io.*;
import java.util.*;

class WordCount {

    static String[][] wordCountEngine(String document) {
        // your code goes here
        LinkedHashMap<String, Integer> StringFreq = new LinkedHashMap<String, Integer>();
        String[] arr = document.trim().split(" ");
        for(String str : arr){
            StringBuilder sb = new StringBuilder();
            for(char c : str.toCharArray()){
                if(Character.isLetter(c)){
                    sb.append(c);
                }
            }
            if(!sb.toString().equals("")){
                String toBeStored = sb.toString().toLowerCase();
                StringFreq.put(toBeStored, StringFreq.getOrDefault(toBeStored, 0) + 1);
            }

        }

        ArrayList<String> list = new ArrayList<>(StringFreq.keySet());
        list.sort((e1,e2)->StringFreq.get(e2)-StringFreq.get(e1));

        String[][] resArray = new String[list.size()][2];
        for(int i = 0; i < resArray.length; i++){
            resArray[i][0] = list.get(i);
            resArray[i][1] = String.valueOf(StringFreq.get(list.get(i)));
        }
        //convert LinkedHashMap to String[][]
    /*
    "" -> 6
    [[, 6]
    */
        return resArray;
    }

    public static void main(String[] args) {

    }

}
/*
document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

                    apple
                    you'll
                    letter and . and " "


        1. seperate into String[]
        iterate String[]
        //2. Map(word -> freq) freqLi
        LInkedMap   1. maintain insert seq

        3. TreeMap => String[][]






*/