package org.lv.ipractices.dsa;

public class Trie {

    class TrieNode{
        TrieNode[] links;
        int R=26;
        boolean isEnd;

        public  TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        public void put(char ch, TrieNode node){
            links[ch-'a']=node;
        }

        public TrieNode get(char ch){
            return links[ch-'a'];
        }

        public void setIsEnd(){
            isEnd=true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }

    TrieNode root = null;

    public Trie(){
        this.root = new TrieNode();
    }

    //
    public void insert(String key){
        TrieNode node = root;
        for(int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);

        }
        node.setIsEnd();
    }

    public TrieNode searchKey(String key){

        TrieNode node = root;
        for(int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            if(!node.containsKey(ch)){
                return null;
            }
            node = node.get(ch);
        }

        return node;

    }

    public boolean search(String key) {
        TrieNode node = searchKey(key);
        return node!=null && node.isEnd();
    }

    public boolean startsWith(String key){
        TrieNode node = searchKey(key);
        return node!=null;
    }


    public static void main(String[] args){

        Trie trie = new Trie();
        trie.insert("leet");
        trie.insert("leets");
        trie.insert("leetd");
        trie.insert("leetcode");
        System.out.println(trie.startsWith("lee"));
        System.out.println(trie.search("lee"));
    }


}
