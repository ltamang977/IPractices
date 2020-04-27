package org.lv.ipractices.geekforgeeks.string;


public class MinimumWindowStringContainingAllCharsOfOtherString {

    public static String minWindow(String s, String t) {

        char[] textHash = new char[256];

        int patternCount = t.length();
        char[] patternHash = new char[256];
        for(int i=0; i<t.length(); i++){
            patternHash[t.charAt(i)]++;
        }

        int i=0;
        int j=0;

        String minWindow = "";
        int minWindowLeft = 0;
        int minWindowRight = Integer.MAX_VALUE-1;

        //int minWindowLeft = 0;
        //int minWindowRight = 0;


        int textCount = 0;
        while(i<s.length()){

            textHash[s.charAt(i)]++;

            if(patternHash[s.charAt(i)]!=0 && textHash[s.charAt(i)]<=patternHash[s.charAt(i)]){
                textCount++;
            }

            if(textCount == patternCount){ //window found

                while(patternHash[s.charAt(j)]==0 || textHash[s.charAt(j)]>patternHash[s.charAt(j)]){
                    if(textHash[s.charAt(j)]>patternHash[s.charAt(j)]){
                        textHash[s.charAt(j)]--;
                        //textCount--;
                    }
                    j++;
                }

                if(i+1-j<minWindowRight+1-minWindowLeft){
                    minWindow = s.substring(j,i+1);
                    minWindowLeft = j;
                    minWindowRight = i;
                }

                i++;

            }else {
                i++;
            }

        }

        return minWindow;

    }

    public static void main(String[] args){

        minWindow("abb", "a");

    }
}
