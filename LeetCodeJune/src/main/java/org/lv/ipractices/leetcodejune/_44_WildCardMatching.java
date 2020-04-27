package org.lv.ipractices.leetcodejune;

public class _44_WildCardMatching {

    public static boolean isMatch(String s, String p) {


        boolean[][] matrix = new boolean[s.length()+1][p.length()+1];

        for(int i=0; i<=p.length(); i++){
            if(i==0 || p.charAt(i-1)=='*'){
                matrix[0][i]=true;
            }
        }

        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    matrix[i][j] = matrix[i-1][j-1];

                }else if (p.charAt(j-1)=='*'){
                    matrix[i][j] = true;

                }else {
                    matrix[i][j] = false;
                }

            }
        }

        return matrix[s.length()][p.length()];

    }

    public static void main(String[] args){

        String text = "acdcb";
        String prefix = "a*c?b";

        System.out.println(isMatch(text, prefix));

    }


}
