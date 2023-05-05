# Java JD's Guide

## combinator pattern
- The Combinator pattern in Java is a functional programming technique that allows you to combine multiple small functions to create more complex functions. It involves creating a set of small, pure functions that perform specific tasks, and then combining them together using higher-order functions to create more complex functions.
- We can use the combinator patterrn for validatoin service and function.
#### Ex1
```java
import java.util.function.Function;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "example@domain.com";
        Function<String, Boolean> validateInput = createInputValidator();
        boolean result = validateInput.apply(input);
        System.out.println(result); // Output: true
    }

    public static Function<String, Boolean> createInputValidator() {
        Function<String, Boolean> notEmpty = s -> !s.isEmpty();
        Function<String, Boolean> validEmail = s -> Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", s);
        Function<String, Boolean> minLength = s -> s.length() >= 6;

        return notEmpty.and(validEmail).and(minLength);
    }
}

```

- Create validation service 
#### Ex2
#### Customer.java
```java
package combinatorpatttern;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }
}
```
#### CustomerRegistrationValidator.java
```java
package combinatorpatttern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatttern.CustomerRegistrationValidator.*;
import static combinatorpatttern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> {
            System.out.println("running email validation");
            return customer.getEmail().contains("@") ?
                    SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
```
#### Main.java
```java
package combinatorpatttern;

import java.time.LocalDate;

import static combinatorpatttern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2015, 1,1)
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
```
---
## Readme file / Wiki page for project Doc
---
## Callback Functions in java
#### Callback.java
```java
package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        hello("John", null, value -> {
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

//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }
//    }
}
```
