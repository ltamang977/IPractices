package org.lv.ipractices.leetcode.strings.trie;

/**
 * Created by root on 1/22/18.
 */
public class TrieNode {

    public static int R=26;
    public TrieNode[] links;
    public boolean isEnd;
    int size = 0;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return links[c-'a']!=null;
    }

    public TrieNode get(char c){
        return links[c-'a'];
    }

    public void put(char c, TrieNode val){
        links[c-'a']=val;
        size++;
    }

    public void setEnd(){
        isEnd = true;
    }

}
