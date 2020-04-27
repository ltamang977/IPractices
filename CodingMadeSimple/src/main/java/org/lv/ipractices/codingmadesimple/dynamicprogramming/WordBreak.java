package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {


    public static boolean wordBreak(String s1, Set<String> dictionary){

        boolean[][] temp = new boolean[s1.length()][s1.length()];

        for(int l=1; l<=s1.length(); l++){
            for(int i=0; i<s1.length()-l+1; i++){

                int j = i+l-1;

                String s = s1.substring(i, j+1);

                if(dictionary.contains(s)){
                    temp[i][j]=true;
                }else {

                    for(int p=i+1; p<=j; p++){
                        if(temp[i][p-1] && temp[p][j]){
                            temp[i][j]=true;
                            break;
                        }
                    }

                }

            }
        }


        return temp[0][s1.length()-1];

    }




    public static void main(String[] args){


        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");

        String s1 = "Ihadliketoplay";

        boolean wordBreak = wordBreak(s1, dictionary);
        System.out.println("WordBreak is :"+wordBreak);

    }
}
