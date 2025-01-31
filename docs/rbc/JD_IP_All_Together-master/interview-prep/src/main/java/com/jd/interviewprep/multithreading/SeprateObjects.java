package com.jd.interviewprep.multithreading;

/**
 * Created by jd birla on 02-02-2023 at 08:56
 */
public class SeprateObjects {

    public static void main(String[] args) {
        RaceConditionProblem raceConditionProblem1 = new RaceConditionProblem();
        RaceConditionProblem raceConditionProblem2 = new RaceConditionProblem();
        Thread thread1 =  new Thread(raceConditionProblem1 , "Thread 1");
        Thread thread2 =  new Thread(raceConditionProblem2 , "Thread 2");
        thread1.start();
        thread2.start();

    }
   /* Out put: Beacsue both thread executing diffrent objects
   Thread 2 : 1000000
    Thread 1 : 1000000*/
}
