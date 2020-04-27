package org.lv.ipractices.dsa;

import java.util.Map;
import java.util.LinkedList;

public class HashMap<K,V> {

    class Node<K,V>{
        K key;
        V value;
        Node next;

        Node(K key, V value){
           this.key = key;
           this.value = value;
           this.next = null;
        }

    }

    LinkedList<Node<K,V>>[] table;
    int size = 0;

    public static int INITIAL_HASHTABLE_CAPACITY = 16;

    public HashMap(){
        this.size = INITIAL_HASHTABLE_CAPACITY;
        table = (LinkedList<Node<K,V>>[]) new LinkedList[size];
        for(int i = 0; i<size ; i++){
            table[i] = new LinkedList<>();
        }
    }


    public void put(K key, V value){

        int index = findIndex(key);
        LinkedList<Node<K,V>> list = table[index];

        int i= 0;
        for(; i<list.size(); i++){
            Node<K,V> node = list.get(i);
            if(node.key.equals(key)){
                node.value = value;
                break;
            }
        }
        if(i==list.size()){
            list.addLast(new Node<>(key, value));
        }

    }

    public V get(K key){
        int index = findIndex(key);
        LinkedList<Node<K,V>> list = table[index];

        int i= 0;
        for(; i<list.size(); i++){
            Node<K,V> node = list.get(i);
            if(node.key.equals(key)){
                return node.value;
            }
        }

        return null;
    }

    /**
     * need to improve this
     * Methods for writing hash functions
     * 1. Modular hashing
     *  h(k)= k(hash code of key) mod m(largest prime number without overflow)
     *  //A precomputed table of various primes and their fixed-point reciprocals is therefore useful with this approach,
     *  because the implementation can then use multiplication instead of division to implement the mod operation.
     *
     * 2. Multiplication
     *
     * 3. Universal Hashing
     * @param key
     * @return
     */
    public int findIndex(K key){
        int hashValue = key.hashCode();
        hashValue = hashValue & 0x7fffffff;
        hashValue = hashValue%size;
        return hashValue;
    }

    public static void main(String[] args){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(5,6);
        System.out.println("Searching key"+map.get(5));
        map.put(5,11);
        System.out.println("Searching key"+map.get(5));

        //implementing load factor and growing map is pending

    }
}
