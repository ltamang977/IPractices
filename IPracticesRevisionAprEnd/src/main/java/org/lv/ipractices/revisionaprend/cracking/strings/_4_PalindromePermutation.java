package org.lv.ipractices.revisionaprend.cracking.strings;

public class _4_PalindromePermutation {


    public static boolean isPalindromePermutation(String input){

        int[] count = new int[256];

        boolean oddFound= false;
        for(int i=0; i<input.length(); i++){
            count[input.charAt(i)]++;

        }

        for(int i=0; i<256; i++){
            if(count[i]%2==1 && oddFound){
                return false;
            }else if(count[i]%2==1){
                oddFound = true;
            }

        }

        return true;
    }


    public static void main(String[] args){

        String str = "taco cat";
        System.out.println("Urilified string is :"+isPalindromePermutation(str));

    }
}
