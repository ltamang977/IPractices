package org.lv.ipractices.leetcode.problems;

public class _14_LongestCommonPrefix {

    /**
     * LongestCommonPrefixHorizontal O(n*m)
     * @param strs
     * @return
     */
    public static String longestCommonPrefixHorizontal(String[] strs) {
        if (strs==null || strs.length == 0)
            return "";

        String prefix = strs[0];
        //for(int i=1; i<strs.length; i++){
           // String st = strs[i];
            //find common s1 and s2
        while(prefix.length()!=0){
            if(longestCommonPrefixHelper(prefix, strs)) {
                return  prefix;
            }else{
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return null;

    }

    public static boolean longestCommonPrefixHelper(String str, String[] strs){
        for(int i=0; i<strs.length; i++){
            if(!strs[i].startsWith(str)){
                return false;
            }
        }
        return true;
    }


    /**
     * LongestCommonPrefixVertical O(n*m)
     * @param strs
     * @return
     */
    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs==null || strs.length == 0)
            return "";

        String str = strs[0];
        String prefix = "";
        int i=0;
        for(; i<strs[0].length(); i++){
            for(int j=1; j< strs.length; j++){
                if(i>=strs[i].length() ||  strs[0].charAt(i)!=strs[i].charAt(i)){
                    return strs[0].substring(0, i);
                }

            }
        }

        return strs[0].substring(0, i);

    }

    /**
     * LongestCommonPrefixVertical O(n*m)
     * @param strs
     * @return
     */
    public static String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs==null || strs.length == 0)
            return "";

        return longestCommonPrefixRecursive(strs, 0, strs.length-1);

    }

    public static String longestCommonPrefixRecursive(String[] arr, int left, int right){

        if(left==right)
            return arr[left];

        int mid = left + (right-left)/2;

        String leftStr = longestCommonPrefixRecursive(arr, left, mid);
        String rightStr = longestCommonPrefixRecursive(arr, mid+1, right);

        return common(leftStr, rightStr);

    }

    public static String common(String s1, String s2){

        int min = Math.min(s1.length(), s2.length());
        int i=0;
        for(; i<min; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return s1.substring(0, i);
            }
        }
        return  s1.substring(0, i);

    }

   // public static boolean isPrefix(String s1, String s2){

  //  }

    public static void main(String[] args){
        String[] strArr = {"leet", "leets", "leetcode", "lee"};
        System.out.println(longestCommonPrefixDivideAndConquer(strArr));
    }
}
