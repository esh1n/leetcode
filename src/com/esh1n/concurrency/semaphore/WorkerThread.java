package com.esh1n.concurrency.semaphore;

public class WorkerThread extends Thread {
    private final int id;
    private final long sleepBeforeReleaseMs;
    private final Semaphore semaphore;


    public WorkerThread(int id, long sleepBeforeReleaseMs, Semaphore semaphore) {
        this.id = id;
        this.sleepBeforeReleaseMs = sleepBeforeReleaseMs;
        this.semaphore = semaphore;
    }

    private void log(String message) {
        System.out.println("Поток " + id + ": " + message);
    }

    @Override
    public void run() {
        try {
            log("пытаюсь захватить семафор");
            semaphore.acquire();
            log("семафор успешно захвачен мной");
            log("собираюсь спать в течение " + sleepBeforeReleaseMs + "ms");
            Thread.sleep(sleepBeforeReleaseMs);
            log("собираюсь отпустить семафор");
            semaphore.release();
            log("отпустил семафор.Конец работы");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
