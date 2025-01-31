package com.jd.test.Test;

/**
 * Created by jd birla on 08-02-2023 at 19:58
 */
public class SingletonExample {
    private static volatile SingletonExample singletonExample = new SingletonExample();
    private SingletonExample()
    {

    }

    public static SingletonExample getSingleTonObj()
    {
          synchronized(SingletonExample.class)
          {
             return singletonExample;
          }
    }


}
