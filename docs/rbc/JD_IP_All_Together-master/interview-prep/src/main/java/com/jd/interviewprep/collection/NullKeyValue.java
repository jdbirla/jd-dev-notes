package com.jd.interviewprep.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NullKeyValue {

    public static void main(String[] args) {

        Map<String, String> map=new ConcurrentHashMap<>();
        map.put(null,null);
        System.out.println(map);
    }
}
