package org.lv.ipractices.leetcodejune;

public class _14_LongestCommonPrefix_E {


    /*
    Longest common prefix using horizontal method
     */
    public static String longestCommonPrefixHorizontal(String[] strs){

        if(strs==null || strs.length==0){
            return "";
        }

        String lcp = strs[0];


        for(int i=1; i<strs.length; i++){
            lcp = findLcp(lcp, strs[i]);
        }

        return lcp;

    }

    public static String findLcp(String lcp, String str){
        int i=0;
        for(;i<Math.min(lcp.length(), str.length()); i++){
            if(lcp.charAt(i)!=str.charAt(i)){
                break;
            }
        }
        return lcp.substring(0, i);

    }


    public static void main(String[] args){

        String[] strs= {"flower", "flow", "flight"};
        String lcp = longestCommonPrefixHorizontal(strs);
        System.out.println("Longes common prefix is :"+lcp);

    }
}
