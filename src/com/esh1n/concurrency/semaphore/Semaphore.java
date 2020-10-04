package com.esh1n.concurrency.semaphore;

public class Semaphore {
    private final int maxSize;
    private int curSize = 0;

    private final Object lock = new Object();
    private final Object waitLock = new Object();

    public Semaphore(int maxSize){
        this.maxSize = maxSize;
    }

    public void acquire() throws InterruptedException{
        boolean needToWait = false;
        synchronized (lock){
            //пытаемся получить разрешение
            if(curSize<maxSize){
                curSize++;
                System.out.println("Семафор++ "+curSize);
            }else {
                needToWait = true;
            }
        }
        if (needToWait){
            synchronized (waitLock){
                waitLock.wait();
            }
            //рекурсия - снова пытаемся получить разрешение
            acquire();
        }
    }

    public void release(){
        synchronized (lock){
            if(curSize>0){
                curSize--;
                System.out.println("Семафор-- "+curSize);
            }
            synchronized (waitLock){
                waitLock.notify();
            }
        }
    }

}
