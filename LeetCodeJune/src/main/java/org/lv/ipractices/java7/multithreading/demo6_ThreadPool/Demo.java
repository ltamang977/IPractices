package org.lv.ipractices.java7.multithreading.demo6_ThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private int id;

    public Processor(int id){
        this.id = id;
    }


    public void run(){
        System.out.println("Started "+id);

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ie){

        }

        System.out.println("Completed "+id);
    }


}
public class Demo {


    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i<5; i++){

            Processor processor = new Processor(i);
            executor.submit(processor);


        }

        executor.shutdown();
        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");

    }

}
