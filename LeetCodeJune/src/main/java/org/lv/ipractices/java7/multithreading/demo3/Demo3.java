package org.lv.ipractices.java7.multithreading.demo3;

import java.util.Scanner;

public class Demo3 {


    static class Processor extends Thread{

        volatile boolean running = true;

        @Override
        public void run(){

            while(running){
                System.out.println("Hello");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public void shutDown(){
            running = false;
        }
    }


    public static void main(String[] args){

        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Pressing return to stop .. ");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutDown();

    }
}
