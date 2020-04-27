package org.lv.ipractices.dynamicprogramming;

public class LongestCommonSequence {


    public static int longestCommonSequence(String str1, String str2){

        int[][] common = new int[str1.length()+1][str2.length()+1];

        for (int i=0; i<=str1.length(); i++) {
            for (int j=0; j<=str2.length(); j++) {
                if (i == 0 || j == 0)
                    common[i][j] = 0;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    common[i][j] = common[i-1][j-1] + 1;
                else
                    common[i][j] = Math.max(common[i-1][j], common[i][j-1]);
            }
        }


        return common[str1.length()][str2.length()];


    }

    public static void main(String[] args){
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println("The longest common sequence is : "+longestCommonSequence(str1, str2));

    }
}
