package org.lv.ipractices.revisionaprend.cracking.strings;

public class _1_AllUniqueChars {


    public static boolean isUnique(String input){
        boolean[] checkUnique = new boolean[256];


        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(checkUnique[c]){
                return false;//already present
            }
            checkUnique[c]=true;
        }
        return true;
    }

    public static boolean isUniqueBitWise(String input){


        int checker = 0;

        boolean[] checkUnique = new boolean[256];


        for(int i=0; i<input.length(); i++){

            int c = input.charAt(i)-'a';//considering only 26 chars
            if((checker & (1<<c))>0){
                return false;//characters already set
            }

            checker |= (1<<c);

        }
        return true;
    }


    public static void main(String[] args){

        //String input = "labin";
        String input = "laabin";
        System.out.println("Checking unique :"+isUnique(input));
        System.out.println("Checking unique bitwise:"+isUniqueBitWise(input));

    }
}
