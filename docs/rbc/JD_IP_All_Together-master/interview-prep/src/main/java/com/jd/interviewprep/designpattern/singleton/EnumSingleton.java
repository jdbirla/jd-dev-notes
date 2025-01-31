package com.jd.interviewprep.designpattern.singleton;

/**
 * Created by jd birla on 04-02-2023 at 08:13
 */
public enum EnumSingleton {
    INSTANCE;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
