package org.lv.ipractices.core_multithreading.jenkov;

/**
 * Created by root on 1/13/18.
 */

class Counter{

    int count = 0;

    public void increment(){
        count++;
    }

}

class CounterThread extends  Thread{

    Counter counter;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){

        for(int i=0; i<10; i++) {
            System.out.println(counter.count);
            counter.increment();
        }
    }
}

public class RaceCondition {

    public static void main(String[] args){

        Counter counter = new Counter();
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

    }

}
