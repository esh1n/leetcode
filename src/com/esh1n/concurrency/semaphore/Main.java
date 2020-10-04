package com.esh1n.concurrency.semaphore;

public class Main {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 4; i++) {
            int sleepMs = (i / 2 + 1) * 1000;
            WorkerThread workerThread = new WorkerThread(i, sleepMs, semaphore);
            workerThread.start();
        }
    }
}
