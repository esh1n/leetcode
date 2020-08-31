package com.esh1n.concurrency;

public class JoinSleepTest {
    public static void main(String[] args){
        Thread thread = new Thread(() -> {
            System.out.println("Дополнительный поток :стартовал");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Доп поток завершился");
        });
        System.out.println("Стартуем доп-й поток");
        thread.start();
        try{
            thread.join();
            System.out.println("Программа завершилась");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
