# Java JD's Guide


## Java Clean Code
<https://github.com/jdbirla/JD_Clean_Code_with_Java/tree/master>

---
## Java Design 
### Combinatory pattern
- The Combinator pattern in Java is a functional programming technique that allows you to combine multiple small functions to create more complex functions. It involves creating a set of small, pure functions that perform specific tasks, and then combining them together using higher-order functions to create more complex functions.
- We can use the combinator patterrn for validatoin service and function.
#### Ex1
```java
import java.util.function.Function;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
         String input = "example@domain.com";
    Predicate<String> validateInput = createInputValidator();
    boolean result = validateInput.test(input);
    System.out.println(result); // Output: true
    }

public static Predicate<String> createInputValidator() {
    Predicate<String> notEmpty = s -> !s.isEmpty();
    Predicate<String> validEmail = s -> Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", s);
    Predicate<String> minLength = s -> s.length() >= 6;

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
### Design Patterns
<https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_Design_Patterns/Notes_Design_Pattern.md>
<https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_Design_Patterns/Bharath_Thippireddy/README.md>

### Java Coding Tips and Tricks
- Use efficient data structures: Use the appropriate data structure for your use case. For example, use a HashSet instead of a List when you need to check for the presence of an element.
- Avoid creating unnecessary objects: Creating objects can be expensive, especially if you’re creating a large number of them in a short period of time. Try to reuse existing objects instead of creating new ones.
- Use StringBuilder instead of String concatenation: String concatenation creates a new String object every time, which can be inefficient. Instead, use StringBuilder to concatenate Strings.
- Avoid excessive method calls: Method calls can be expensive, especially if they’re inside a loop. Try to minimize the number of method calls you make.
- Minimize object copying: Copying objects can be expensive, especially if the objects are large. Try to minimize the number of times you copy objects.
- Use the right algorithms: Use the appropriate algorithm for your use case. For example, if you need to sort a large array, use a quicksort algorithm instead of a bubble sort algorithm.
- Use primitive types instead of wrapper classes: Primitive types are faster and use less memory than wrapper classes.
- Avoid unnecessary calculations: Try to eliminate unnecessary calculations from your code. For example, if you’re calculating the same value multiple times, calculate it once and store the result in a variable.
- Use efficient I/O operations: I/O operations can be slow, especially if they involve disk access. Use efficient I/O operations, such as buffered I/O, to minimize the time spent on I/O.
- Profile your code: Use a profiler to identify the parts of your code that are taking the most time. This can help you focus your optimization efforts where they’ll have the biggest impact.
- Avoid unnecessary synchronization: Synchronization can be expensive, especially if it’s not needed. Only synchronize when necessary, and try to use more fine-grained locking when possible.
- Minimize exceptions: Exceptions are expensive, both in terms of performance and memory usage. Try to minimize the number of exceptions thrown, and avoid using exceptions for control flow.
- Use lazy initialization: If you have expensive objects that aren’t always needed, use lazy initialization to defer their creation until they’re actually needed.
- Use caching: If you have expensive operations that are performed frequently, consider caching the results to avoid unnecessary computations.
- Avoid excessive memory usage: Java applications can quickly consume large amounts of memory if you’re not careful. Be mindful of how much memory your application is using, and avoid unnecessary object creation.
- Use the right collection type: Choose the appropriate collection type for your use case. For example, if you’re frequently inserting and removing elements, use a LinkedList instead of an ArrayList.
- Use final variables: Using final variables can improve performance by allowing the compiler to optimize the code.
- Avoid unnecessary class loading: Class loading can be expensive, especially if it’s done frequently. Try to load classes only when they’re needed, and avoid unnecessary class loading.
- Optimize loops: Loops can be a major performance bottleneck in Java code. Make sure that your loops are as efficient as possible, and avoid unnecessary iterations.
- Use primitive arrays instead of collections: Primitive arrays are faster and use less memory than collections of objects. If you’re dealing with a large amount of data, consider using primitive arrays instead of collections.
- Minimize object initialization: Object initialization can be expensive, especially if it involves complex constructors. Try to minimize object initialization, and consider using object pooling to reuse existing objects.
- Use JIT optimization: The Java Virtual Machine (JVM) includes a Just-In-Time (JIT) compiler that can optimize your code at runtime. Make sure that JIT optimization is enabled, and consider using the -XX:+AggressiveOpts option to enable more aggressive optimization.
- Use parallelism: If your application can benefit from parallelism, consider using Java’s concurrency features to take advantage of multiple cores or processors.
- Use the right data structure for searching and sorting: The choice of data structure can have a big impact on the performance of searching and sorting operations. Use a data structure that’s optimized for the type of search or sort you’re performing.
- Minimize memory leaks: Memory leaks can be a major performance problem in Java applications. Make sure that your code doesn’t create unnecessary object references that prevent objects from being garbage collected.
- Use the right logging level: Logging can be expensive, especially if you’re logging at a high level. Use the appropriate logging level for your use case, and consider disabling logging in production environments.
- Avoid unnecessary string manipulation: String manipulation can be expensive, especially if it involves regular expressions or other complex operations. Try to minimize string manipulation, and consider using StringBuilder or StringBuffer for string concatenation.
- Use efficient network communication: Network communication can be a major bottleneck in Java applications. Use efficient protocols and data formats, and consider using compression or caching to reduce the amount of data that needs to be transmitted.
- Use modern Java features: Finally, remember that Java is a constantly evolving language, and new features are added with each release. Make sure that you’re using the latest Java version, and take advantage of new features like lambdas, streams, and modules to write more efficient code.
- Use the static keyword to create utility methods that can be used without instantiating an object
- Use final keyword to make variables and methods immutable or constant.
- Use the @Override annotation when overriding a method to ensure that you are actually overriding a method and not creating a new one.
---
## Java 8
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2d50633c-d41c-4644-b0a6-08c36453a5c7)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/0a039b27-5141-4cae-ac31-6b2d3098ce6c)
![java-8 drawio](https://github.com/jdbirla/jd-dev-notes/assets/69948118/48bcdbc0-6401-42fd-83c9-75d609fdfd90)


### Callback Functions in java
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

### Optional Use
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
## Generics in Java
- <https://salithachathuranga94.medium.com/generics-in-java-3c791555e924>
- <https://github.com/jdbirla/jd-dev-notes/blob/master/docs/java/Generics.pdf>
---
## java-date-time
<https://github.com/jdbirla/JD_JAVA_Learning/blob/master/JavaDateTime_A-Z.md>

---
## What is New in Java 17?
### New Features
- Sealed classes and interfaces
- Pattern matching for switch statements and expressions
- New rendering pipeline for MacOS
- New API for accessing large icons
- Pseudo-Random Number Generators
- New InstantSource Interface
#### Pattern matching for switch statements and expressions
```java
public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(5, 3);

        double area = switch (shape) {
            case Circle c -> c.calculateArea();
            case Rectangle r -> r.calculateArea();
            default -> throw new IllegalArgumentException("Unknown shape");
        };

        System.out.println("Area: " + area);
    }
}
```
---
## Common Java Mistakes and Learning
#### Remove Object from Collection
- Use Iterator for removing object from collection in loop
#### Don't use wrapper classes in loop instead use primitive Long -> long

---
## Java Performance
<https://github.com/jdbirla/JD_IP_All_Together/blob/master/Interview_Q_A.md#java-performance>
<https://medium.com/@ddwen/6-techniques-for-java-performance-optimization-c6d853d24e6d>

---


