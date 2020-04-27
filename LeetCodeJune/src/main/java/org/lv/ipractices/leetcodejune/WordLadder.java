package org.lv.ipractices.leetcodejune;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */

    class Ladder{
        String word;
        int step;
        public Ladder(String word, int step){
            this.word = word;
            this.step = step;
        }
    }



    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if(start==null || end==null || start.equals(end)){
            return 0;
        }

        Queue<Ladder> queue = new LinkedList<>();
        queue.add(new Ladder(start, 1));

        dict.add(end);

        while(!queue.isEmpty()){
            Ladder ladder = queue.poll();
            String word = ladder.word;


            if(word.equals(end)){
                return ladder.step;
            }

            char[] arr = word.toCharArray();
            for(int i = 0; i<arr.length; i++){
                for(char c = 'a'; c<='z'; c++){
                    char temp = arr[i];

                    if(arr[i]==c){
                        continue;
                        //arr[i]=c;
                    }
                    arr[i]=c;

                    String s = new String(arr);//updated Character

                    if(dict.contains(s)){
                        dict.remove(s);
                        queue.offer(new Ladder(s, ladder.step+1));
                    }

                    arr[i]=temp;

                }
            }


        }


        return 0;



    }


    public static void main(String[] args){

        String start = "a";
        String end = "c";

        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");


        WordLadder sol = new WordLadder();

        int len = sol.ladderLength(start, end, dict);

        System.out.println("Length is :"+len);

    }
}
