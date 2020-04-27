package org.lv.ipractices.algorithms1.searching;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 12/21/17.
 */
public class UnOrderedSequentialSearch<Key extends Comparable<Key>, Value> {

    private  Node first;

    private static class Node<Key, Value>{
        public Key key;
        public Value value;
        public Node<Key,Value> next;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            next = null;
        }

    }

    public UnOrderedSequentialSearch(){

    }


    public UnOrderedSequentialSearch(Key key, Value value){

        first = new Node(key, value);

    }

    public void put(Key key, Value value){

        if(first == null) {
            first = new Node(key, value);
            return;
        }

        Node current = first;
        Node previous = null;

        while(current!=null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            previous = current;
            current=current.next;

        }

        if(current==null) {
            current = new Node(key, value);
            previous.next = current;
        }



    }

    public Value get(Key key){
        Node current = first;

        while(current!=null){
            if(current.key.equals(key)){
                return (Value)current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void delete(Key key){

        if(first !=null && first.key.equals(key)) {
            first = null;
            return;
        }

        Node current = first;

        while(current.next!=null){
            if(current.next.key.equals(key)){
                current.next = current.next.next;
            }
            current = current.next;
        }

        return;
    }


    public boolean contains(Key key){
        return get(key)!=null;
    }

    public boolean isEmpty(){
        return first!=null;
    }

    public int size(){
        return 0;

    }

    public Iterable<Node> keys(){

        List<Node> nodes = new ArrayList<>();

        Node current = first;
        while(current!=null){
            nodes.add(current);
            current = current.next;
        }
        return nodes;
    }



    /*
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        UnOrderedSequentialSearch st = new UnOrderedSequentialSearch();

        boolean isContinue = true;
        while(isContinue) {
            System.out.println("Enter key :");
            String key = scanner.next();

            System.out.println("Enter value : ");
            Integer value = scanner.nextInt();

            st.put(key, value);

            System.out.println("Do you want to continue?Tyes Y or N.");
            String decision = scanner.next();

            isContinue = "Y".equalsIgnoreCase(decision);

        }


        Iterator iterator = st.keys().iterator();
        while(iterator.hasNext()){
            Node node = (Node)iterator.next();
            System.out.printf("Key is %S and Value is %d", node.key, node.value);
        }


        System.out.println("Scanning finished");

    }*/


    public static void main(String[] args){
        UnOrderedSequentialSearch<String, Integer> unSt = new UnOrderedSequentialSearch<>();
        unSt.put("S", 0);
        unSt.put("Y", 1);
        unSt.put("M", 2);
        unSt.put("B", 3);
        unSt.put("O", 4);
        unSt.put("L", 5);
        unSt.put("T", 6);
        unSt.put("A", 7);
        unSt.put("B", 8);
        unSt.put("L", 9);
        unSt.put("E", 10);

        Iterator iterator = unSt.keys().iterator();
        while(iterator.hasNext()){
            Node node = (Node)iterator.next();
            System.out.printf("Key is %S and Value is %d \n", node.key, node.value);
        }

        System.out.println("\n Deleting B O L T ");
        unSt.delete("B");
        unSt.delete("O");
        unSt.delete("L");
        unSt.delete("T");

        Iterator iterator1 = unSt.keys().iterator();
        while(iterator1.hasNext()){
            Node node = (Node)iterator1.next();
            System.out.printf("Key is %S and Value is %d \n", node.key, node.value);
        }


        System.out.println("Value for S is :"+unSt.get("S"));
        System.out.println("Value for Y is :"+unSt.get("Y"));

    }
}
