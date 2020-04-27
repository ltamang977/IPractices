package org.lv.ipractices.ctci._16_threadsandlocks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by root on 1/15/18.
 */
public class Chopstick {

    private Lock lock;
    private int index;

    public Chopstick(int index){
        this.index = index;
        lock = new ReentrantLock();
    }


    public boolean pickUp(){
        return lock.tryLock();
    }

    public void putDown(){
        lock.unlock();
    }

    public int getIndex(){
        return index;
    }
}
