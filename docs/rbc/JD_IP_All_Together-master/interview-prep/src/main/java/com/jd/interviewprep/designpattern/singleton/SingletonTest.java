package com.jd.interviewprep.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jd birla on 04-02-2023 at 07:34
 */
public class SingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        //DateUtil dateUtil = new DateUtil(); // Cant' create instance as constructor is private
        DateUtil dateUtil1 = DateUtil.getDateUtil();
        DateUtil dateUtil2 = DateUtil.getDateUtil();
        System.out.println("Normal ");

        System.out.println(dateUtil1 == dateUtil2);
        System.out.println(dateUtil1 + " : " + dateUtil2);

        //Problem 1 : Singleton breaking by serialization and de-serialization
        DateUtil dateUtil3 = DateUtil.getDateUtil();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\D_Drive\\DXC\\Learning\\Projects\\JD_IP_All_Together\\interview-prep\\src\\main\\java\\com\\jd\\interviewprep\\designpattern\\singleton\\dateUtil.ser"));
        oos.writeObject(dateUtil3);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\\\D_Drive\\\\DXC\\\\Learning\\\\Projects\\\\JD_IP_All_Together\\\\interview-prep\\\\src\\\\main\\\\java\\\\com\\\\jd\\\\interviewprep\\\\designpattern\\\\singleton\\\\dateUtil.ser"));
        DateUtil readObj = (DateUtil) ois.readObject();
        oos.close();
        ois.close();
        System.out.println("//Problem 1 : Singleton breaking by serialization and de-serialization\n ");

        System.out.println(dateUtil3 == readObj);
        System.out.println(dateUtil3 + " : " + readObj);

        //Problem 2:  Cloning problem
        DateUtil instance1 = DateUtil.getDateUtil();
        //  DateUtil instance2 = (DateUtil)instance1.clone();
        System.out.println(" //Problem 2:  Cloning problem\n ");

        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
//        System.out.println("instance2 hashCode:- "
//                + instance2.hashCode());


        //Problem 3 : Reflection
        DateUtil instance3 = DateUtil.getDateUtil();
        DateUtil instance4 = null;
        Constructor<?>[] declaredConstructors = DateUtil.class.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors
        ) {
            cons.setAccessible(true);
            try {
                instance4 = (DateUtil) cons.newInstance();
                break;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(" //Problem 3 : Reflection \n");

        System.out.println("instance3 hashCode:- "
                + instance3.hashCode());
        System.out.println("instance4 hashCode:- "
                + instance4.hashCode());
    }
}
