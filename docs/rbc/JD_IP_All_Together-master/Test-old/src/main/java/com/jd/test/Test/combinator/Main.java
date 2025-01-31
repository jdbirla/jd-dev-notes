package com.jd.test.Test.combinator;

import java.time.LocalDate;

import static com.jd.test.Test.combinator.CustomerRegistrationValidator.*;

/**
 * Created by jd birla on 11-06-2023 at 06:56
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+0898787879878",
                LocalDate.of(1991, 1,1)
        );


        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}