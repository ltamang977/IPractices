package org.lv.ipractices.core_multithreading;

import java.lang.Runnable;
import java.lang.Thread;

/**
 * Created by root on 1/13/18.
 */


class CounterRunnable implements Runnable{

    @Override
    public void run(){

        for(int i=0; i<10; i++){
            try {
                Thread.sleep(200);
                System.out.println(i);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }

}
public class CounterRunnableApp {

    public static void main(String[] args) {

        CounterRunnable c1 = new CounterRunnable();
        Thread t1 = new Thread(c1);


        CounterRunnable c2 = new CounterRunnable();
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();
    }

}
