package org.lv.ipractices.geekforgeeks.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _Anagram_2_PrintAnagramsTogether {


    static class Word{
        String data;
        int index;

        public Word(String data, int index){
            this.data = data;
            this.index = index;
        }
    }


    public static void printAnagramsTogether(String[] inputs){

        Word[] wordArr = new Word[inputs.length];
        for(int i=0; i<inputs.length; i++){
            Word word = new Word(inputs[i], i);
            wordArr[i]= word;

            char[] chArr = word.data.toCharArray();
            Arrays.sort(chArr);
            word.data = new String(chArr);

        }

        Arrays.sort(wordArr, (Word x, Word y)->x.data.compareTo(y.data));

        for(Word word : wordArr){
            System.out.print(inputs[word.index]);
        }

    }


    public static void main(String[] args){

        String words[] = {"cat", "dog", "tac", "god", "act"};

        printAnagramsTogether(words);



    }
}
