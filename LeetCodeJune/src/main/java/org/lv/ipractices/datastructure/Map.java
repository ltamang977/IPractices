package org.lv.ipractices.datastructure;

import java.util.ArrayList;

public class Map<K,V> {

    class Entry<K,V>{

        K k;
        V v;

        public Entry(K k, V v){
            this.k = k;
            this.v = v;
        }

    }

    ArrayList<Entry<K,V>>[] bucket = null;

    public Map(int capacity){
        bucket =  (ArrayList<Entry<K,V>>[]) new ArrayList[capacity];

        for(int i=0; i<capacity; i++){
            bucket[i]=new ArrayList<>();
        }

    }

    public boolean isEmpty(){

        return false;
    }

    public boolean containsKey(K k){
        int index = k.hashCode()%bucket.length;
        int pos = getPos( index, k);

        return pos!=-1;

    }


    public void put(K k, V v){

        int index = k.hashCode()%bucket.length;
        int pos = getPos( index, k);

        if(containsKey(k)){
        //update
            bucket[index].get(pos).v=v;

        }else{
        //insert
            bucket[index].add( new Entry<>(k,v));
        }

    }

    public V get(K k){

        int index = k.hashCode()%bucket.length;
        int pos = getPos( index, k);

        return bucket[index].get(pos).v;

    }

    public int getPos(int index, K k){

        ArrayList<Entry<K,V>> list = bucket[index];

        for(int i = 0; i<list.size(); i++){
            Entry<K,V> entry = list.get(i);
            if(entry.k.equals(k)){
                return i;
            }

        }

        return -1;

    }



    public int size(){
        return 0;
    }


    public static void main(String[] args){

        Map<Integer,String> map = new Map<>(10);
        map.put(1, "Labin");
        map.put(2, "Dipen");
        map.put(3, "Palden");
        map.put(4, "Mummy");
        map.put(5, "Daddy");

        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.get(5));



    }
}
