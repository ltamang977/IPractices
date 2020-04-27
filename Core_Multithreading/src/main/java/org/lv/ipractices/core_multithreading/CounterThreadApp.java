package org.lv.ipractices.core_multithreading;

/**
 * Created by root on 1/13/18.
 */

class CounterThread extends Thread{


        @Override
        public void run(){

            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(100);
                    System.out.println(i);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }

        }



}

public class CounterThreadApp {

    public static void main(String[] args) {

        CounterThread t1 = new CounterThread();

        CounterThread t2 = new CounterThread();

        t1.start();
        t2.start();

    }

}
