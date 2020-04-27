package org.lv.ipractices.corejava;

public class RunTimeClassDemo {




    public static void main(String[] args){

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Available processors : "+runtime.availableProcessors());

        System.out.println("Free memory is : "+runtime.freeMemory());

        System.out.println("Max memory is : "+runtime.maxMemory());

        System.out.println("Total memory is : "+runtime.totalMemory());

    }
}
