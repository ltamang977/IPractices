package org.lv.ipractices.ctci._16_threadsandlocks;

/**
 * Created by root on 1/15/18.
 */
public class DiningPhilosopherDemo {


    public static void main(String[] args){

        DiningPhilosopher[] philosophers = new DiningPhilosopher[5];
        Chopstick[] chopsticks = new Chopstick[5];

        for(int i=0; i<5; i++){
            chopsticks[i] = new Chopstick(i);
        }

        for(int i= 0; i<=4; i++){

            int right = i+1;
            if(right>4){
                right = 0;
            }
            philosophers[i] = new DiningPhilosopher(Integer.valueOf(i).toString(),
                    chopsticks[i], chopsticks[right]);
        }


        for(int i=0; i<5; i++){
           // System.out.println();
            philosophers[i].start();
        }
    }
}
