package org.lv.ipractices.leetcode.strings;

/**
 * Created by root on 1/21/18.
 */
import org.lv.ipractices.leetcode.strings.trie.*;
public class LongestCommonPrefix {


    /**
     * longest common prefix word by word
     */
    public static String longestCommonPrefixWordByWord(String[] arr){

        String longestPrefix = "";
        String prev = arr[0];
        for(int i=1; i<arr.length; i++){
            String prefix = commonPrefix(prev, arr[i]);
            prev = prefix;
            longestPrefix = (prefix.length()>longestPrefix.length())
                                ?prefix:longestPrefix;
        }
        return prev;

    }

    public static String commonPrefix(String s1, String s2){

        int i=0, j=0;

        int common = 0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                break;
            }
            common++;
            i++;
            j++;
        }

        return s1.substring(0, common);

    }

    /**
     * second solution to find common prefix
     * @param arr
     * @return
     */
    public static String longestCommonPrefixByEachChar(String[] arr){

        int n = arr[0].length();

        for(int i = 0; i<n; i++){
            char c = arr[0].charAt(i);
            for(int j=1; j<arr.length;j++){
                if(i>=arr[j].length() || c!=arr[j].charAt(i)){
                    return arr[0].substring(0,i);
                }

            }
        }

        return arr[0];

    }


    /**
     * sollution 3 : Divide and conquer
     * solution 4 : Binary Search
     * Solution 5 : Trie
     */
    public static void longestCommonPrefixTrie(String[] inputs){
        Trie trie = new Trie();

        for(int i=0; i<inputs.length; i++) {
            trie.insert("geek");
            trie.insert("geekfor");
            trie.insert("gee");
            trie.insert("geeks");
        }


        System.out.println("Searching for gee:"+trie.startsWith("gee"));

    }

    public static void main(String[] args){

        String arr[] = {"GEEK", "GEEKSFOR","GEE", "GEEKS"};

        String test = "test";

        String testSubstr = test.substring(0,0);
        System.out.println(testSubstr);

       // System.out.println("Common prefx is "+longestCommonPrefixWordByWord(arr));

        //System.out.println("Common prefx is "+longestCommonPrefixByEachChar(arr));

        //longestCommonPrefixTrie();

       // System.out.println("Common prefx is "+longestCommonPrefixTrie();

    }
}
