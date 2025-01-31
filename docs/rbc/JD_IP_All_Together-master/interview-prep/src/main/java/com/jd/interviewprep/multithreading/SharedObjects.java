package com.jd.interviewprep.multithreading;

/**
 * Created by jd birla on 02-02-2023 at 08:58
 */
public class SharedObjects {
    public static void main(String[] args) {
        RaceConditionProblem raceConditionProblem = new RaceConditionProblem();
        Thread thread1 =  new Thread(raceConditionProblem , "Thread 1");
        Thread thread2 =  new Thread(raceConditionProblem , "Thread 2");
        thread1.start();
        thread2.start();
    }
// Expection is first thread increased 1,000,000 then second hread will increase to 2,000,000 however end
// result below 2 M becasue of race condition value is not updating in sync in Heap
//    Thread 2 : 1002739
//    Thread 1 : 1995155

}
