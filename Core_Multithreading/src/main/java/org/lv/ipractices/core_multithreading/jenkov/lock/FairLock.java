package org.lv.ipractices.core_multithreading.jenkov.lock;

import java.util.Queue;

/**
 * Created by root on 1/14/18.
 */
import java.util.List;
import java.util.ArrayList;

class QueueObject{

    boolean isNotified=false;

    public synchronized void doWait() throws InterruptedException{
        while(!isNotified){
            wait();
        }
        isNotified = true;
    }

    public synchronized void doNotify(){
        isNotified = false;

    }

}

public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> list = new ArrayList<QueueObject>();


    public void lock(){
        QueueObject queueObject = new QueueObject();
        synchronized (this){
            list.add(queueObject);
        }


        boolean isLockedForThisThread = true;

        while(isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || list.get(0) != queueObject;
                if(!isLockedForThisThread){
                    isLocked=true;
                    list.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }

            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                list.remove(queueObject);
                //e.printStackTrace();
            }
        }
    }

    public synchronized void unlock() throws Exception {
        if(lockingThread!=Thread.currentThread()){
            throw new Exception("This thread has not locked the monitor");
        }
        isLocked=false;
        lockingThread = null;
        if(list.size()>0){
            list.get(0).doNotify();
        }

    }

}
