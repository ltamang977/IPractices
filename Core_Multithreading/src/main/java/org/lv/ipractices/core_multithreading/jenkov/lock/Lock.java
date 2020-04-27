package org.lv.ipractices.core_multithreading.jenkov.lock;

/**
 * Created by root on 1/14/18.
 */
public class Lock {

    boolean isLocked = false;
    Thread lockingThread = null;

    public void lock(){
        synchronized(this){
            while(!isLocked){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked=true;
            lockingThread = Thread.currentThread();
        }

    }

    public void unlock() throws Exception {
        synchronized (this){
            if(lockingThread!=Thread.currentThread())
                throw new Exception("Calling thread has not locked this object");
            isLocked=false;
            notify();
            lockingThread = null;
        }
    }
}
