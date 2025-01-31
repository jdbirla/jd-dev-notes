package com.jd.inttest.core;

import java.util.function.Consumer;

/**
 * Created by jd birla on 11-06-2023 at 07:07
 */
public class Callback {
    public static void main(String[] args) {
        hello("John", "asdasd", value -> {
            System.out.println("no lastName provided for " + value);
        });

        hello2("John",
                null,
                () -> System.out.println("no lastName provided"));

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
    }
