package com.jd.interviewprep.designpattern.singleton;

/**
 * Created by jd birla on 04-02-2023 at 08:14
 */
public class TestSingletonEnum {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;

        System.out.println( instance.getName());
        instance.setName("JD");
        System.out.println( instance.getName());
    }
}
