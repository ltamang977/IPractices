package org.lv.ipractices.ctci._16_threadsandlocks;

/**
 * Created by root on 1/15/18.
 */

import java.util.Random;
public class DiningPhilosopher extends Thread{

    private Chopstick left;
    private Chopstick right;

    public DiningPhilosopher(String name, Chopstick left, Chopstick right){
        super(name);
        this.left=left;
        this.right=right;
    }


    @Override
    public void run(){

        Random rand = new Random();

        for(int i=0; i<10; i++){
            eat();
            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void eat(){
        if(!pickUp()){
            return;
        }
        System.out.println(super.getName()+ " eating");
        putDown();
    }

    public boolean pickUp(){
        if(!left.pickUp()){
           return false;
        }

        if(!right.pickUp()){
            left.putDown();
            return false;
        }

        System.out.println("Using left "+left.getIndex()+" and right "+right.getIndex());

        return true;
    }

    public void putDown(){
        left.putDown();
        right.putDown();
    }

}
