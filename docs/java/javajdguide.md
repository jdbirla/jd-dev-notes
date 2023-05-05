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
---
## Optional Use
#### ofNullable(): 
 - This method returns an empty Optional instance if the value passed is null, otherwise, it returns an Optional instance containing the passed value.
```java
  String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    System.out.println(optionalStr.isEmpty());//true
    String str1 = "Jitendra";
    Optional<String> optionalStr1 = Optional.ofNullable(str1);
    System.out.println(optionalStr1.get());//Jitendra
```
#### isPresent():
- This method returns true if the Optional instance contains a value, otherwise, it returns false.
```java
String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    System.out.println(optionalStr.isPresent());//false
    String str1 = "Jitendra";
    Optional<String> optionalStr1 = Optional.ofNullable(str1);
    System.out.println(optionalStr1.isPresent());//true
```
#### orElse(): 
- This method returns the value contained in the Optional instance if it is present, otherwise, it returns the value passed as a parameter.
```java
 String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    System.out.println(optionalStr.orElse("Hello, world!"));//Hello, world!
    String str1 = "Jitendra";
    Optional<String> optionalStr1 = Optional.ofNullable(str1);
    System.out.println(optionalStr1.orElse("Hello, world!"));//Jitendra

```
#### orElseGet(): 
- This method is similar to orElse(), but instead of returning a value, it returns a Supplier that produces a value when the Optional instance is empty.
```java
String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    String result = optionalStr.orElseGet(() -> "Hello, world!");
    System.out.println(result);//Hello, world!
```

#### orElseThrow(): 
- This method returns the value contained in the Optional instance if it is present, otherwise, it throws the exception passed as a parameter.
```java
 String str = null;
    Optional<String> optionalStr = Optional.ofNullable(str);
    String result = optionalStr.orElseThrow(() -> new IllegalArgumentException("Value cannot be null"));
//output

//Exception in thread "main" java.lang.IllegalArgumentException: Value cannot be null
//	at com.jd.test.Test.PracticeTest.lambda$main$0(PracticeTest.java:18)
//	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
//	at com.jd.test.Test.PracticeTest.main(PracticeTest.java:18)
```
#### filter(): 
- This method applies a predicate to the value contained in the Optional instance and returns an Optional instance containing the value if the predicate is true, otherwise, it returns an empty Optional instance.
```java
   String str = "Hello, world!";
    Optional<String> optionalStr = Optional.ofNullable(str);
    Optional<String> filtered = optionalStr.filter(s -> s.contains("world"));
    System.out.println(filtered.get());//Hello, world!
    String str1 = null;
    Optional<String> optionalStr1 = Optional.ofNullable(str1);
    Optional<String> filtered1 = optionalStr1.filter(s -> s.contains("world"));
    System.out.println(filtered1.isEmpty()?"Empty optional":filtered1.get());//Empty optional
```

#### map(): 
- This method applies a function to the value contained in the Optional instance and returns an Optional instance containing the result of the function, or an empty Optional instance if the original Optional instance was empty.
```java
   String str = "Hello, world!";
    Optional<String> optionalStr = Optional.ofNullable(str);
    Optional<Integer> filtered = optionalStr.map(s -> s.length());
    System.out.println(filtered.get());//13

    String str1 = null;
    Optional<String> optionalStr1 = Optional.ofNullable(str1);
    Optional<Integer> filtered1 = optionalStr1.map(s -> s.length());
    System.out.println(filtered1.isEmpty()?"Empty optional":filtered1.get());//Empty optional


```

#### flatMap(): 
- This method applies a function that returns an Optional instance to the value contained in the original Optional instance, and returns the result of the function or an empty Optional instance if the original Optional instance was empty.
```java
String str = "Hello, world!";
    Optional<String> optionalStr = Optional.ofNullable(str);
    Optional<Character> firstChar = optionalStr.flatMap(s -> s.isEmpty() ? Optional.empty() : Optional.of(s.charAt(0)));
    System.out.println(firstChar.get()); //H


```

---
## Disable H2 in Spring Boot Test
- Disable H2 DB `@AutoConfigurationTestDataBase(replace = AutoConfigurationTestDatabase.Replace.NONE)
![image](https://user-images.githubusercontent.com/69948118/236414915-80f23a38-90fa-481e-bdf7-ed4d696c1149.png)

---
## Common Java Mistakes
#### Remove Object from Collection
- Use Iterator for removing object from collection in loop 
#### Don't use wrapper classes in loop instead use primitive Long -> long

---
### Spring Boot Mistakes 
#### Leaking iternals 
