package com.jd.interviewprep.multithreading;

/**
 * Created by jd birla on 02-02-2023 at 08:11
 */
public class RaceConditionProblem implements  Runnable{
private int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
        }
        System.out.println(Thread.currentThread().getName()+" : "+this.count);
    }
}
