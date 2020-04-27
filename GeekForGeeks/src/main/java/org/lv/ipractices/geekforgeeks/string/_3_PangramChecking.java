package org.lv.ipractices.geekforgeeks.string;

/**
 * Created by root on 1/16/18.
 */
public class _3_PangramChecking {


    public static boolean isPangram(char[] chArr){
        //create boolean array of alphabets
        //loop throught character and set alphabet status
        //loop throught alphabet status to check for pangram

        boolean[]  alphabetStatus = new boolean[26];
        int upperOffset = 65;
        int lowerPffset = 97;

        for(char c : chArr){
            if(c>='A' && c<='Z'){
               alphabetStatus[c-'A']=true;
            }else if (c>=97 && c<=122){
                alphabetStatus[c-lowerPffset]=true;
            }
        }

        for(boolean bool : alphabetStatus){
            if(!bool){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        String pangram = "The quick brown fox jumps over the lazy dog";

        String notPangram = "The quick brown fox jumps over the dog";

        System.out.println("Pangram chec is"+isPangram(notPangram.toCharArray()));

    }
}
