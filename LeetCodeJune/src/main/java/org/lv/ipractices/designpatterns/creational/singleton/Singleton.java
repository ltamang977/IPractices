package org.lv.ipractices.designpatterns.creational.singleton;

/**
 * Createional : Singleton pattern
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton(){

        if(instance!=null)
            throw new RuntimeException("Instance already created");

    }

    public static Singleton getInstance(){

        if(instance==null){
            synchronized (Singleton.class) {
                if(instance==null){
                    instance = new Singleton();
                }

            }
        }

        return  instance;
    }


    public static void main(String[] args){

        Singleton first = Singleton.getInstance();
        System.out.println(first);

        Singleton second = Singleton.getInstance();
        System.out.println(second);

        Singleton third= Singleton.getInstance();
        System.out.println(third);
    }
}
