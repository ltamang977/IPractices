package org.lv.ipractices.codingmadesimple.dynamicprogramming;

public class WildCardMatching {


    public static boolean wildCardMatching(String str, String pattern){

        boolean[][] temp = new boolean[str.length()+1][pattern.length()+1];

        temp[0][0]=true;

        for(int i=1; i<=str.length(); i++){
            for(int j=1; j<=pattern.length(); j++){

                if(str.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                    temp[i][j] = temp[i-1][j-1];

                }else if (pattern.charAt(j-1)=='*'){
                    temp[i][j] = temp[i-1][j] || temp[i][j-1];
                }else {
                    temp[i][j] = false;
                }

            }

        }

        return temp[str.length()][pattern.length()];

    }


    public static void main(String[] args){

        String str = "xaylmz";
        String pattern = "x?y*z";

        boolean wildCard = wildCardMatching(str, pattern);
        System.out.println("WildCard using bottom up  approach is : " +wildCard);

    }
}
