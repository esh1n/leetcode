package com.esh1n.concurrency;

import static sun.jvm.hotspot.HelloWorld.fib;

public class VolatileTest {

    public static void main(String[] args) throws InterruptedException{
        System.out.println("Начало вычислений");
        CalcThread thread = new CalcThread();
        thread.start();
        Thread.sleep(5_000);
        System.out.println("Сигнал остановки");
        thread.shutDown();
        Thread.sleep(5_000);
        System.out.println("Программа завершена");
    }

    public static class CalcThread extends Thread{
        private volatile boolean shutdownRequested;
        public void shutDown() {
            shutdownRequested = true;
        }
        @Override
        public void run(){
            while(!shutdownRequested){
                fib(40);
            }
            System.out.println("Вычисления завершены");
        }
    }
}
