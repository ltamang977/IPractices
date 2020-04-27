package org.lv.ipractices.java7.multithreading.demo4;

public class Demo {

    private int count = 0;


    public synchronized void increment(){
        count++;
    }

    public void doWork(){

        Thread t1 = new Thread(
                ()->{
                    for(int i = 0; i<10000; i++){
                        increment();
                    }
                }
        );

        Thread t2 = new Thread(
                ()->{
                    for(int i = 0; i<10000; i++){
                        increment();
                    }
                }
        );

        t1.start();
        t2.start();

        System.out.println("Count is :"+count);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){

        Demo demo = new Demo();
        demo.doWork();

    }
}
