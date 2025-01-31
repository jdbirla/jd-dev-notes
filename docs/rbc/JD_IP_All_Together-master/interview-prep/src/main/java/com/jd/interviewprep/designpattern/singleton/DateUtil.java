package com.jd.interviewprep.designpattern.singleton;

import java.io.Serializable;

/**
 * Created by jd birla on 04-02-2023 at 07:22
 */
public class DateUtil implements Serializable , Cloneable {

    private static final long serialVersionId = 1L;
    private static volatile DateUtil dateUtil;

    private DateUtil() {

    }

    public static DateUtil getDateUtil() {
        if(dateUtil == null) {
            synchronized (DateUtil.class) {
                if (dateUtil == null) {
                    dateUtil = new DateUtil();
                }
            }
        }
        return dateUtil;

    }
    //Solving serialization problem
    private Object readResolve()
    {
        return dateUtil;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        //return super.clone();
        throw new CloneNotSupportedException();
    }
}
