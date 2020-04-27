package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 */
public class _4_ReplaceSpace {

    public static String replaceSpace(char[] chArr, int  txtLength){
        //replace ' ' with '%20'
        int arrIndex = chArr.length-1;
         for(int i = txtLength-1; i>=0; i--){
            if(' '==chArr[i]){
                chArr[arrIndex--]='0';
                chArr[arrIndex--]='2';
                chArr[arrIndex--]='%';
            }else {
                chArr[arrIndex--]=chArr[i];
            }
        }
        return new String(chArr);

    }

    public static void main(String[] args){

        char[] chArr = {'M','r', ' ',
                        'J','o','h','n', ' ',
                        'S', 'm', 'i', 't', 'h', ' ',' ',' ',' '};

        System.out.println("Replaced string is :"+replaceSpace(chArr, 13));

    }
}
