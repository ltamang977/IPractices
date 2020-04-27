package org.lv.ipractices.algorithms1;

import java.util.Random;


/**
 * Created by root on 12/15/17.
 */
public class RandomNumberClient {


    public static void randomUsingMath(){

        System.out.println("Random number generated using Math");
        //returns +ve number between 0.0 inclusive and 1.0 exclusive
        // i.e 0.0 to 0.9
        for(int i=0; i<5;i++){
            System.out.println(Math.random());
        }



        //in range 1 to 50
        System.out.println("In range 1 to 50: "+(int) (Math.random()*50+1));

        System.out.println("In range 5 to 15: "+(int) (Math.random()*10+5));


    }

    public static void randomUsingUtilRandom(){

        System.out.println("Random number generated using util Random");

        Random rand = new Random();

        for(int i=0; i<5;i++) {
            //between int min and max value
            System.out.printf("%12d", rand.nextInt());
            //between long min and max value
            System.out.printf("%25d", rand.nextLong());

            //between 0(inclusive) and bound(exclusive)
            System.out.printf("%15d", rand.nextInt(10));

            //between 5 to 25
            //25-5+1
            System.out.printf("%15d", rand.nextInt(21)+5);

            System.out.println();
        }


    }

    public static void main(String[] args){
        System.out.println("");
        randomUsingMath();
        //randomUsingUtilRandom();

    }
}
