package org.lv.ipractices.java7.multithreading.demo7_CountDownLatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

    private CountDownLatch latch;

    public Processor(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started");

        try {
            Thread.sleep(3000);

        }catch(InterruptedException ex){

        }

        latch.countDown();
    }
}
public class Demo {





    public static void main(String[] args){

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i<10; i++){
            executorService.submit(new Processor(latch));
        }

        try{
            latch.await();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }


        System.out.println("Completed!! ");


    }
}
