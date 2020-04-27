package org.lv.ipractices.java7.multithreading.demo2;

import org.lv.ipractices.java7.multithreading.demo1.App;

public class Demo2 {

    static class Runner implements Runnable{

        @Override
        public void run(){

            for(int i = 0; i<10; i++){
                System.out.println("Hello "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args){

        Thread runner1 = new Thread(new Runner());
        runner1.start();

        Thread runner2 = new Thread(new Runner());
        runner2.start();


    }

}
