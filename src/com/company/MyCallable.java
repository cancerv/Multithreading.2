package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    int timeToSleep;
    int numOfTask;

    public MyCallable(int timeToSleep, int numOfTask) {
        this.timeToSleep = timeToSleep;
        this.numOfTask = numOfTask;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < numOfTask; i++) {
            count++;
            System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
            Thread.sleep(timeToSleep);
        }
        return count;
    }
}
