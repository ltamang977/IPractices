package org.lv.ipractices.leetcode.strings.trie;

/**
 * Created by root on 1/22/18.
 */
public class Trie {

    public TrieNode root = null;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String str){

        TrieNode node = root;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String str){
        TrieNode node = root;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            }else {
                return null;
            }
        }
        return node;
    }

    //prefix
    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;

    }

    public boolean search(String str){
        TrieNode node = searchPrefix(str);
        return node!=null && node.isEnd;
    }

    /*
    public String longestCommonPrefix(String[] arr){
        TrieNode node = root;
        int indexes = 0;
        StringBuilder prefix = new StringBuilder();
        while(node!=null){
            if(node.size==1 && !node.isEnd){
                index++;
                prefix.append();
            }

        }

    }*/
}
