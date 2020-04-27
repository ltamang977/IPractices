package org.lv.ipractices.algorithms1.searching;

/**
 * Created by root on 12/23/17.
 */
public class OrderedBinarySearch<Key extends Comparable<Key>, Value> {

    Node[] arr = null;
    int N = 0;

    public OrderedBinarySearch(){
        //
    }

    //insert
    public void put(Key key, Value val){

    }

    //select
    public Value get(Key key){
        if(isEmpty()){
            return null;
        }

        int i = rank(key);
        Node node = arr[i];
        return (Value)node.value;
    }

    //delete
    public void delete(Key key){

    }

    //number of keys less than key
    public int rank(Key key){
        int lo = 0;
        int hi = N-1;

        //ordered so can do binary search
        int rank = 0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            Node midNode = arr[mid];
            if(key.compareTo((Key)midNode.key)<0){
                hi = mid -1;
            }else if (key.compareTo((Key)midNode.key)<0){
                lo = mid + 1;
            }else {
                //found it
                return mid;
            }
        }
       return lo;
    }

    public boolean contains(){
      return true;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean size(){
        return true;
    }
}
