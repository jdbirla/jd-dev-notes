# JD Interview Q and A
- Code Decode : https://www.youtube.com/@CodeDecode
- https://dxc.udemy.com/course/java-interview-help/learn/lecture/26378360#overview
---
# Table of contents
 - [About Yourself](#about-yourself)
  - [Core Java](#core-java)
    - [Environment Variables vs System properties (or VM Arguments) vs Program arguments (or Command line arguments) | Java](#environment-variables-vs-system-properties-or-vm-arguments-vs-program-arguments-or-command-line-arguments--java)
    - [Syntax to pass all these variables to a jar would be as follows:](#syntax-to-pass-all-these-variables-to-a-jar-would-be-as-follows)
    - [Sample program to access these variables:](#sample-program-to-access-these-variables)
    - [Core Q and A](#core-q-and-a)
    - [Inheritance vs aggregation](#inheritance-vs-aggregation)
    - [Serialization deserialization](#serialization-deserialization)
    - [Externalization](#externalization)
    - [Collections](#collections)
    - [Concurrency Questions](#concurrency-questions)
    - [Apartment threading model](#apartment-threading-model)
    - [What is deadlock](#what-is-deadlock)
    - [Java Memory Leak Questions](#java-memory-leak-questions)
    - [Java8](#java8)
    - [Java9](#java9)
    - [Java11](#java11)
    - [java-date-time](#java-date-time)
    - [memory-managment](#memory-managment)
    - [Garbage-Collector](#garbage-collector)
  - [Spring](#spring)
  - [spring-interview-questions-with-answers](#spring-interview-questions-with-answers)
  - [Spring Boot](#spring-boot)
    - [Spring Boot Annotations (Interview Questions)](#spring-boot-annotations-interview-questions)
    - [Multiple DB configuration in Springboot](#multiple-db-configuration-in-springboot)
    - [Spring Boot offers several advantages that make it a popular choice for developing Java applications:](#spring-boot-offers-several-advantages-that-make-it-a-popular-choice-for-developing-java-applications)
    - [What is Spring Actuator? What are its advantages?](#what-is-spring-actuator-what-are-its-advantages)
    - [How to enable Actuator in spring boot application?](#how-to-enable-actuator-in-spring-boot-application)
    - [How to secure Spring Boot Actuator's endpoints?](#how-to-secure-spring-boot-actuators-endpoints)
    - [What do you understand by the shutdown in the actuator?](#what-do-you-understand-by-the-shutdown-in-the-actuator)
    - [Can you explain what happens in the background when a Spring Boot Application is “Run as Java Application”?](#can-you-explain-what-happens-in-the-background-when-a-spring-boot-application-is-run-as-java-application)
    - [How to enable HTTP/2 support in Spring Boot?](#how-to-enable-http2-support-in-spring-boot)
    - [What is graceful shutdown in Spring-Boot?](#what-is-graceful-shutdown-in-spring-boot)
    - [How to read yaml file values in application](#how-to-read-yaml-file-values-in-application)
    - [What is @Transactional annotation?](#what-is-transactional-annotation)
    - [What is Spring-Batch?](#what-is-spring-batch)
    - [Configuring Properties with Spring Boot](#configuring-properties-with-spring-boot)
    - [Spring boot @Scheduled annotation example](#spring-boot-scheduled-annotation-example)
    - [Profiles](#profiles)
    - [HTTP Status Codes (400 / 401 / 500 / )](#http-status-codes-400--401--500--)
    - [what is Jwt refresh tokens](#what-is-jwt-refresh-tokens)
    - [logging-in-spring-boot](#logging-in-spring-boot)
    - [Spring boot profile specific logging example](#spring-boot-profile-specific-logging-example)
    - [spring-boot-actuator-Info-endpoint](#spring-boot-actuator-info-endpoint)
    - [spring-boot-testing](#spring-boot-testing)
    - [Unit testing in spring boot](#unit-testing-in-spring-boot)
    - [What is @Async in Spring Boot?](#what-is-async-in-spring-boot)
    - [completablefuture](#completablefuture)
    - [bootstrap-properties](#bootstrap-properties)
    - [spring-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller](#spring-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller)
    - [Database Migration in Spring Boot using Flyway](#database-migration-in-spring-boot-using-flyway)
    - [How does auto-configuration work? How does it know what to configure?](#how-does-auto-configuration-work-how-does-it-know-what-to-configure)
    - [How to enable HTTP/2 support in Spring Boot?](#how-to-enable-http2-support-in-spring-boot)
    - [Explain how to register a custom auto-configuration?](#explain-how-to-register-a-custom-auto-configuration)
    - [How do you Configure Log4j for logging in springboot](#how-do-you-configure-log4j-for-logging-in-springboot)
    - [How to load multiple external configuration or properties files?](#how-to-load-multiple-external-configuration-or-properties-files)
    - [How to deploy Spring Boot application as a WAR?](#how-to-deploy-spring-boot-application-as-a-war)
    - [How to customize the support for multiple content-negotiation for returning XML or JSON?](#how-to-customize-the-support-for-multiple-content-negotiation-for-returning-xml-or-json)
    - [How to configure two databases and two EntityManager in Spring Boot?](#how-to-configure-two-databases-and-two-entitymanager-in-spring-boot)
    - [Write a file upload end-point in Springboot?](#write-a-file-upload-end-point-in-springboot)
    - [Is it possible to create a non-web application in Spring Boot?](#is-it-possible-to-create-a-non-web-application-in-spring-boot)
  - [- Spring Boot can be used to build various types of non-web applications, such as command-line applications, batch processing applications, integration applications, standalone services, and more. By excluding unnecessary web-related dependencies and configurations, you can create a lightweight Spring Boot application focused on your specific non-web use case.](#--spring-boot-can-be-used-to-build-various-types-of-non-web-applications-such-as-command-line-applications-batch-processing-applications-integration-applications-standalone-services-and-more-by-excluding-unnecessary-web-related-dependencies-and-configurations-you-can-create-a-lightweight-spring-boot-application-focused-on-your-specific-non-web-use-case)
  - [kafka](#kafka)
  - [REST API](#rest-api)
    - [Rest constraint](#rest-constraint)
    - [Rest Versioning](#rest-versioning)
    - [pagination](#pagination)
    - [Exception handling](#exception-handling)
    - [Rest API Documentation](#rest-api-documentation)
  - [Hibernate and JPA and Spring Data JPA](#hibernate-and-jpa-and-spring-data-jpa)
    - [How to store passwords safely in the database?](#how-to-store-passwords-safely-in-the-database)
    - [Resource/application.properties](#resourceapplicationproperties)
    - [HibernateDemo/src/main/java/com/example/demo/entities/Employee.java](#hibernatedemosrcmainjavacomexampledemoentitiesemployeejava)
    - [HibernateDemo/src/main/java/com/example/demo/controller/EmployeeController.java](#hibernatedemosrcmainjavacomexampledemocontrolleremployeecontrollerjava)
    - [HibernateDemo/src/main/java/com/example/demo/service/EmployeeService.java](#hibernatedemosrcmainjavacomexampledemoserviceemployeeservicejava)
    - [HibernateDemo/src/main/java/com/example/demo/repositories/](#hibernatedemosrcmainjavacomexampledemorepositories)
  - [Microservices](#microservices)
    - [Exception handling between microservices](#exception-handling-between-microservices)
    - [Microservices Design Pattern](#microservices-design-pattern)
  - [SQL](#sql)
  - [Lombok](#lombok)
  - [GIT](#git)
  - [Maven](#maven)
  - [clean-code-tips](#clean-code-tips)
    - [Code review](#code-review)
  - [Design](#design)
    - [DDD BDD TDD](#ddd-bdd-tdd)
    - [java-design-best-practices-guide](#java-design-best-practices-guide)
    - [Java Design Patterns](#java-design-patterns)
    - [Multi-tenant architecture](#multi-tenant-architecture)
    - [Java Coding Best Practices](#java-coding-best-practices)
    - [code-refactoring](#code-refactoring)
  - [java-performance](#java-performance)
    - [Why is my Java program so slow? The reasons of performance issues in Java](#why-is-my-java-program-so-slow-the-reasons-of-performance-issues-in-java)
    - [8 proven ways to improve Java performance](#8-proven-ways-to-improve-java-performance)
    - [Best Java performance monitoring tools](#best-java-performance-monitoring-tools)
    - [Medium](#medium)
    - [GFG](#gfg)
    - [Memory Leak](#memory-leak)
  - [DSA](#dsa)
    - [Java Collection Complexity](#java-collection-complexity)
  - [bydefault](#bydefault)
  - [Companies Interview Questions](#companies-interview-questions)
    - [Persistent](#persistent)
    - [Communication Protocols:](#communication-protocols)
    - [Rakuten](#rakuten)
    - [Difference between Latency and Throughput in Performance:](#difference-between-latency-and-throughput-in-performance)
    - [Relationship Between Latency and Throughput:](#relationship-between-latency-and-throughput)
    - [Achieving Low Latency and High Throughput in a Java Project:](#achieving-low-latency-and-high-throughput-in-a-java-project)
    - [Worldpay](#worldpay)
    - [Ascent Group](#ascent-group)
---
## About Yourself
I have started my career as a java developer in 2014.
Since then I hve worked across Domains running from Banking , Insurance and Automtive.

My first organization was Atos where I Ranult which french automobile MNC.
Then I joined OFSS , where I worked in India's top private bank HDFC in different project like NetBanking in which we implemented OBP.
Then I joined DXC where I am wokring for Zurich Insurance Group for the Japan localization, in which I working in 2 project Java implementation and Data migration.

While working across the Java Technology Stack i have designed and developed
applications using various Spring Boot Modules and also frontend JS frameworks react.


I was at client side for more than 3+ years in Japan where
I have worked closely with the product owners and business analysts to get the
requirements right and with the architects to implementation.


I have also worked with the Devops engineers to set up the CI/CD pipeline for our
projects using tools like Maven,Docker,Jenkins and Kubernetes.

I have also worked with various AWS Components such as EC2 ,S3 ,EKS,ELB, EBS,
SNS, Cloudwatch to deploy our apps to the cloud.

I have experince in working in agile scrum model.

I am a Continuous Learner and to be a honest I am giving an hourly for daily learning.
I also Like Sharing what i learn and I do it through my github public repo which jdbirla.

I have recently learnt creating serverless projects using AWS Lambdas.

---
## Core Java
### Environment Variables vs System properties (or VM Arguments) vs Program arguments (or Command line arguments) | Java

![image](https://user-images.githubusercontent.com/69948118/173704599-1dcf0189-18bf-4ce3-a526-8a543e8ef685.png)

### Syntax to pass all these variables to a jar would be as follows:
```
Windows:

D:> set envvar1=val1
D:> java -jar -Dsysprop1=val2 HelloWorld-0.0.1-SNAPSHOT.jar arg1
Linux:

@cloudshell:~ $ envvar1=val1 java -jar -Dsysprop1=val2 HelloWorld-1.0-SNAPSHOT.jar arg1
```
### Sample program to access these variables:
```
package com.infy;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Environment Variable envvar1 is: " + System.getenv("envvar1"));
		System.out.println("System property sysprop1 is: " + System.getProperty("sysprop1"));
		if (args != null && args.length > 0) {
			System.out.println("Command line arguments are: ");
			for (String arg : args) {
				System.out.println(arg);
			}
		}
	}
}
```
![image](https://user-images.githubusercontent.com/69948118/173704698-aaa3fe9e-df40-4ed4-a625-c1b36c0b9c3f.png)


1. How to Create an Immutable Object in Java?
Immutable classes in Java are classes whose state cannot be changed once created. This means that once you create an object of an immutable class, you cannot modify its fields or any other data that it contains.

There are a number of benefits to using immutable classes in Java, including:

- Thread safety: Immutable classes are inherently thread-safe, because there is no way for two threads to accidentally modify the same object.
- Cacheability: Immutable objects can be safely cached, because you know that their state will not change.
- Simplicity: Immutable classes are simpler to design and implement than mutable classes, because you don't have to worry about protecting their state from concurrent access.

- To create an immutable class in Java, you should follow these guidelines:

- Declare the class as final so that it cannot be extended.
- Declare all fields as private so that they can only be accessed through getter and setter methods.
- Make all fields final so that they cannot be modified after they are initialized.
- Provide getter methods for all fields, but do not provide setter methods.
- If the class contains any mutable objects, make sure to make deep copies of them before returning them from getter methods
- The following predefined classes in Java are immutable:

- Wrapper classes: Boolean, Byte, Character, Double, Float, Integer, Long, Short
String class
- Date and Time classes: Date, Time, Calendar, GregorianCalendar, DateFormat, SimpleDateFormat
- Number classes: BigDecimal, BigInteger
- Atomic classes: AtomicInteger, AtomicBoolean, AtomicLong, AtomicReference
- Unmodifiable collections: Collections.unmodifiableList(), Collections.unmodifiableMap(), Collections.unmodifiableSet()
- Immutable classes are often used in multithreaded programming, as they are inherently thread-safe. They are also often used in caching, as they can be safely cached - - without the risk of being modified by other threads.


3. Is Java Pass by Reference or Pass by Value?
- Java is strictly "pass-by-value." However, it's important to understand how this works, as it can sometimes be a source of confusion.

When you pass a primitive data type (e.g., `int`, `char`, `double`) to a method in Java, you are passing the actual value. Any changes made to the parameter inside the method do not affect the original value outside the method.

```java
public class PassByValueExample {
    public static void main(String[] args) {
        int x = 5;
        modifyPrimitive(x);
        System.out.println(x); // Output: 5
    }

    public static void modifyPrimitive(int num) {
        num = 10;
    }
}
```

In the example above, even though `num` is modified inside the `modifyPrimitive` method, the value of `x` outside the method remains unchanged.

When you pass an object (non-primitive) to a method, you are still passing the value of the reference to the object, not the actual object. However, the confusion often arises because the behavior can seem like "pass-by-reference" when dealing with object references.

```java
public class PassByValueExample {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello");
        modifyObjectReference(str);
        System.out.println(str); // Output: HelloWorld
    }

    public static void modifyObjectReference(StringBuilder s) {
        s.append("World");
    }
}
```

In the example above, the method `modifyObjectReference` modifies the contents of the `StringBuilder` object, and this modification is reflected outside the method. However, it's important to note that the reference to the `StringBuilder` object is still passed by value. If you were to assign a new object to the parameter `s` inside the method, it would not affect the original reference outside the method.

```java
public class PassByValueExample {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello");
        modifyObjectReference(str);
        System.out.println(str); // Output: Hello
    }

    public static void modifyObjectReference(StringBuilder s) {
        s = new StringBuilder("New StringBuilder");
    }
}
```

In this case, even though a new `StringBuilder` object is assigned to `s` inside the method, it does not affect the original `StringBuilder` reference outside the method.

To summarize, Java is always pass-by-value, but when you pass an object, you are passing the value of the reference to that object. Any modifications to the object's state will be reflected outside the method, but reassigning the reference inside the method won't affect the original reference.
4. what is the Difference between Deep Copy and Shallow Copy?
   - Deep cloning
-Deep cloning the Employee object
```java
//Modified clone() method in Employee class
@Override
protected Object clone() throws CloneNotSupportedException {
	Employee cloned = (Employee)super.clone();
	cloned.setDepartment((Department)cloned.getDepartment().clone());
	return cloned;
}
```
- Department.java
```java
//Defined clone method in Department class.
@Override
protected Object clone() throws CloneNotSupportedException {
	return super.clone();
}
```
4. Can We Assign ‘null‘ to ‘this‘ Reference Variable?
NO. We can’t. In java, left-hand side of an assignment statement must be a variable. ‘this‘ is a special keyword that represents the current instance always. This is not any variable.

Similarly, null can not be assigned to ‘super‘ or any such keyword for that matter.

5. Designing a Good Custom Key for HashMap
As the best practice:

a key class should be made immutable.
in most situations, default hashCode() and equals() methods are good enough, but if we override one method then we should override another method as well, to make sure they follow the contract between them.

6. Concurrentmodificationexcpetion
     - SingleThreaded environment iterator.remove works fine for removing items from list
     - Singelthreade Env if we are using list.remove("b") its not working throwing concurrentmodificationexception
     - In Adding item in list both iterator and listitertor throwing concurrentmodexception : we need to use CopyOnWriteArrayList and iterator
     - 
7. FailFast iterrator
    - it will throw ConcurrentModificationException as we are adding values in iteration as iterator take snapshot of map and when are changing modcount doesn't match and it throws exception
    - In ConcurrentHahMap we can modify value in iterator but there may be race conditions and other concurrency issues. in concurrenthahmap we need to use putIfAbsent, compute, computeIfAbsent, computeIfPresent, etc
       


![image](https://user-images.githubusercontent.com/69948118/178855655-2c93ce19-052b-44ac-a526-1bf7a8272777.png)
![image](https://user-images.githubusercontent.com/69948118/178955977-4bc7004e-41d4-4bff-bc48-b6f4fa6e617a.png)
![image](https://user-images.githubusercontent.com/69948118/178957708-43e49bdb-a2ec-435a-b4ab-b2c95e2d3789.png)
![image](https://user-images.githubusercontent.com/69948118/179176399-8f7db5f5-1118-4f52-bf9b-06387f5b6ccb.png)
![image](https://user-images.githubusercontent.com/69948118/179179205-ad749526-b4ee-4396-a37c-263e79352729.png)
![image](https://user-images.githubusercontent.com/69948118/179179515-25ea239d-915d-44fb-b7dd-b2208d949c38.png)
![image](https://user-images.githubusercontent.com/69948118/179182311-88c5c5c1-b62c-4799-b828-ac0a469dfe72.png)
![image](https://user-images.githubusercontent.com/69948118/179192598-29c3217c-d485-480d-bb7b-00d8f9fc3142.png)
![image](https://user-images.githubusercontent.com/69948118/179315818-0b983810-8ff0-4f64-812a-267e99ed24a5.png)
![image](https://user-images.githubusercontent.com/69948118/179316023-017c8906-f290-4e11-a298-dbacd659b2ee.png)
![image](https://user-images.githubusercontent.com/69948118/179316588-95aad8d0-d735-4154-9475-1e213b61bb54.png)
![image](https://user-images.githubusercontent.com/69948118/179316822-dd02ad4c-9a82-435f-a757-31b7bb2f6b8f.png)
![image](https://user-images.githubusercontent.com/69948118/179316856-68efdc6e-a767-4d06-9de0-6169dc2dbfca.png)
![image](https://user-images.githubusercontent.com/69948118/179317011-5f98fe51-308d-47fb-a683-3dcba59b4ee2.png)
![image](https://user-images.githubusercontent.com/69948118/179317284-37513fdb-a59b-445f-8069-e5933f065797.png)
![image](https://user-images.githubusercontent.com/69948118/179317602-07b2c122-b46d-4048-9715-eb1b40064ae0.png)
![image](https://user-images.githubusercontent.com/69948118/179317716-b70dc7d7-0bd7-4ba6-96cd-c45d3deeca62.png)
![image](https://user-images.githubusercontent.com/69948118/179317815-4f7d2b28-dc4d-45ca-9d4a-c6a1577e7cc7.png)
![image](https://user-images.githubusercontent.com/69948118/179318444-140f9a20-2c58-4adb-90aa-9bc2cec026ed.png)
![image](https://user-images.githubusercontent.com/69948118/179318544-4ab0728a-fbd2-47b5-bee9-b1979b5f92d9.png)
![image](https://user-images.githubusercontent.com/69948118/179318568-5f57f7c5-38b1-480b-8214-aff2111c1ea0.png)
![image](https://user-images.githubusercontent.com/69948118/179318638-6e722de0-a9d3-4804-8c38-a4fb2168ce8a.png)
![image](https://user-images.githubusercontent.com/69948118/179319016-4d538ddb-0911-453c-856e-02217ecbbfa3.png)
![image](https://user-images.githubusercontent.com/69948118/179319052-32b21d57-af70-454e-93f5-048232240656.png)
![image](https://user-images.githubusercontent.com/69948118/179322188-26cf8650-43be-498b-aba3-baff7f1f058a.png)
### Core Q and A
- 1. How to Create an Immutable Object in Java?
   - Don’t provide “setter” methods or methods that modify fields or objects referred to by fields. Setter methods are meant to change the state of object and this is what we want to prevent here.
  - Make all fields final and private. Fields declared private will not be accessible outside the class and making them final will ensure the even accidentally you can not change them.
  - Don’t allow subclasses to override methods. The simplest way to do this is to declare the class as final. Final classes in java can not be overridden.
  - Always remember that your instance variables will be either mutable or immutable. Identify them and return new objects with copied content for all mutable objects (object references). Immutable variables (primitive types) can be returned safely without extra effort.
- 4. Why there are two Date classes, One in java.util and another in java.sql?
  - A java.util.Date represents date and time of day, a java.sql.Date only represents a date.
- 14. Difference between sleep() and wait() Methods?
![image](https://user-images.githubusercontent.com/69948118/222676083-ee5c2ad7-6456-48f5-991b-dccb2aff48b3.png)
- Improving Performance of ConcurrentHashMap
  - ConcurrentHashMap<String, Integer> instance = new ConcurrentHashMap<String, Integer>(16, 0.9f, 1);
  - An initial capacity of 16 ensures a reasonably good number of elements before resizing happens.
  - A load factor of 0.9 ensures a dense packaging inside ConcurrentHashMap which will optimize memory use.
  - And concurrency level set to 1 will ensure that only one shard is created and maintained.
 
### == & equals on different data types
Here are **scenario-based questions** related to the `==` operator and the `equals()` method for primitive data types and their wrapper classes in Java, along with explanations of the results.



##### **1. `==` with primitives**
**Scenario**:  
What will be the result of the following code?

```java
public class ComparePrimitives {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
For primitive data types like `int`, the `==` operator compares the values directly. Since `a` and `b` both have the value `10`, the result is `true`.



##### **2. `==` with wrapper objects**
**Scenario**:  
What will happen here?

```java
public class CompareWrappers {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
Java caches wrapper objects for certain ranges of numbers (for `Integer`, the range is `-128` to `127`). Both `a` and `b` refer to the same cached object for the value `10`, so `a == b` returns `true`.



##### **3. `==` with wrapper objects outside the cached range**
**Scenario**:  
What will happen in this code?

```java
public class CompareWrappers {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `false`  
**Explanation**:  
For `Integer` values outside the range of `-128` to `127`, new objects are created instead of using the cache. Therefore, `a` and `b` refer to different objects in memory, and `a == b` returns `false`.



##### **4. `equals()` with wrapper objects**
**Scenario**:  
What will happen here?

```java
public class CompareWrappers {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a.equals(b));
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
The `equals()` method for `Integer` checks the values, not the object references. Since both `a` and `b` hold the value `128`, the result is `true`.



##### **5. Primitive and wrapper comparison**
**Scenario**:  
What will be the result of this comparison?

```java
public class ComparePrimitivesAndWrappers {
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
When comparing a primitive `int` with an `Integer`, the `Integer` is unboxed to its primitive value for the comparison. Therefore, `a` is unboxed to `10`, and `10 == 10` returns `true`.



##### **6. `equals()` with different data types**
**Scenario**:  
What will happen if we compare different data types using `equals()`?

```java
public class CompareWrappers {
    public static void main(String[] args) {
        Integer a = 10;
        Double b = 10.0;
        System.out.println(a.equals(b));
    }
}
```

**Answer**:  
Output: `false`  
**Explanation**:  
The `equals()` method checks both the value and the type. Since `a` is an `Integer` and `b` is a `Double`, they are not equal, even though their values are numerically equivalent.



##### **7. `==` with `String` literals**
**Scenario**:  
What happens when comparing `String` literals using `==`?

```java
public class CompareStrings {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
In Java, string literals are interned. Both `a` and `b` point to the same object in the string pool, so `a == b` returns `true`.



##### **8. `==` with `String` objects**
**Scenario**:  
What happens when comparing `String` objects created using `new`?

```java
public class CompareStrings {
    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: `false`  
**Explanation**:  
Using `new` creates new objects in memory. Even though the values are the same, `a` and `b` are different objects, so `a == b` returns `false`.



##### **9. `equals()` with `String` objects**
**Scenario**:  
What will happen here?

```java
public class CompareStrings {
    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a.equals(b));
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
The `equals()` method for `String` checks the actual value of the strings, not their references. Since both `a` and `b` have the value `"hello"`, the result is `true`.



##### **10. `==` with mixed primitive and wrapper comparisons**
**Scenario**:  
What will happen in this case?

```java
public class ComparePrimitivesAndWrappers {
    public static void main(String[] args) {
        Integer a = 10;
        Double b = 10.0;
        System.out.println(a == b);
    }
}
```

**Answer**:  
Output: **Compilation Error**  
**Explanation**:  
The `==` operator cannot directly compare different wrapper types like `Integer` and `Double`. Attempting to do so results in a compilation error.



##### **11. Using `equals()` with `null`**
**Scenario**:  
What happens when calling `equals()` on `null`?

```java
public class CompareNull {
    public static void main(String[] args) {
        Integer a = null;
        System.out.println(a.equals(10));
    }
}
```

**Answer**:  
Output: **NullPointerException**  
**Explanation**:  
Calling a method on a `null` reference results in a `NullPointerException`.


##### **12. Comparing `null` using `==`**
**Scenario**:  
What happens in this case?

```java
public class CompareNull {
    public static void main(String[] args) {
        Integer a = null;
        System.out.println(a == null);
    }
}
```

**Answer**:  
Output: `true`  
**Explanation**:  
The `==` operator can safely compare a reference with `null`. Since `a` is `null`, the result is `true`.

### Serialization and serailversionid
### **What is `serialVersionUID` in Serialization?**

- `serialVersionUID` is a unique identifier for a serializable class in Java. It is used during the deserialization process to verify that the sender and receiver of a serialized object have compatible versions of the class.


### **Key Points**
1. **Purpose**:
   - It ensures that the serialized data corresponds to the same version of the class during deserialization.
   - If the `serialVersionUID` of the class used for serialization does not match the one used during deserialization, a `InvalidClassException` is thrown.

2. **How to Declare**:
   It is a static and final field of type `long`:
   ```java
   private static final long serialVersionUID = 1L;
   ```

3. **Default Behavior**:
   - If not explicitly declared, the Java runtime generates a default `serialVersionUID` based on class details like fields, methods, etc.
   - This default value can change if the class is modified, which might lead to deserialization issues.



### **Example: Using `serialVersionUID`**

#### **Without `serialVersionUID`**:
```java
import java.io.*;

class Employee implements Serializable {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

1. Serialize the object:
   ```java
   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
   oos.writeObject(new Employee("John", 30));
   oos.close();
   ```

2. Modify the `Employee` class (e.g., add a new field):
   ```java
   private double salary; // New field
   ```

3. Deserialize the object:
   ```java
   ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"));
   Employee emp = (Employee) ois.readObject(); // Throws InvalidClassException
   ois.close();
   ```

#### **With `serialVersionUID`**:
If you explicitly define `serialVersionUID`, changes to the class structure won’t break deserialization unless the changes are incompatible:
```java
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double salary; // Added field

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
Here, deserialization will succeed, and the new field (`salary`) will have its default value (`0.0`).



### **Common Questions and Answers about `serialVersionUID`**

#### **Q1: What happens if `serialVersionUID` is not declared?**
**A**: If `serialVersionUID` is not declared, the Java runtime will generate one automatically based on the class's structure. However:
   - The generated value is highly sensitive to changes in the class.
   - Even a minor change (e.g., adding a field) will result in a different `serialVersionUID`, potentially causing deserialization failures.

#### **Q2: Why is it recommended to declare `serialVersionUID` explicitly?**
**A**: Declaring it explicitly:
   - Ensures backward compatibility during deserialization.
   - Prevents unexpected `InvalidClassException` caused by runtime-generated `serialVersionUID` changes.

#### **Q3: What happens if `serialVersionUID` values don’t match during deserialization?**
**A**: A `java.io.InvalidClassException` is thrown with a message like:
   ```
   InvalidClassException: Employee; local class incompatible: stream classdesc serialVersionUID = 12345, local class serialVersionUID = 67890
   ```

#### **Q4: Can `serialVersionUID` prevent all deserialization issues?**
**A**: No, `serialVersionUID` ensures that the serialized and deserialized classes are compatible, but it cannot handle:
   - Removing fields.
   - Changing field types.
   - Modifying the class hierarchy.
   - Adding incompatible changes.

#### **Q5: What are the best practices for using `serialVersionUID`?**
**A**:
1. Always explicitly declare `serialVersionUID` in serializable classes.
2. Use a meaningful value (e.g., `1L`, `1000L`) for easier management.
3. When making backward-incompatible changes, increment the `serialVersionUID`.

#### **Q6: What tools can help generate `serialVersionUID`?**
**A**: Use IDEs or the `serialver` command:
   ```bash
   serialver -classpath <path-to-class> <fully-qualified-class-name>
   ```

#### **Q7: Can a class without `serialVersionUID` be deserialized if no changes are made to it?**
**A**: Yes, if the class structure remains unchanged, deserialization will work fine, as the generated `serialVersionUID` remains consistent.

#### **Q8: What happens if a field is marked `transient`?**
**A**: Transient fields are not serialized, so their values will not affect the `serialVersionUID`. They will have default values upon deserialization.


#### **Advanced Scenarios**

#### **Scenario 1: Adding a New Field**
If a new field is added but `serialVersionUID` remains the same, the deserialization succeeds, and the new field is assigned its default value.

#### **Scenario 2: Removing a Field**
If a field is removed but `serialVersionUID` remains the same, deserialization succeeds, but the removed field's data is lost.

#### **Scenario 3: Changing a Field Type**
Changing a field type is considered an incompatible change, and deserialization fails with `InvalidClassException`.


#### **Summary**
- `serialVersionUID` ensures compatibility between serialized and deserialized versions of a class.
- Explicitly declare `serialVersionUID` to avoid issues with runtime-generated IDs.
- Always plan for backward compatibility when evolving serializable classes.


### Inheritance vs aggregation
- Inheritance is suitable when there is an "is-a" relationship and when code reuse is desired. Aggregation is suitable when there is a "has-a" relationship and when flexibility and independence of the contained object are important.



### Serialization deserialization
- Serialization and deserialization in Java are handled by the Java Object Serialization mechanism. When an object is serialized, its state is converted into a sequence of bytes that can be written to a file, sent over a network, or stored in a database. When an object is deserialized, its state is recreated from the sequence of bytes.

-During serialization, the writeObject() method is called to write the object's state to an output stream. This method can be overridden in a class to provide custom serialization logic, such as writing only certain fields or encoding the data in a specific way.

-During deserialization, the readObject() method is called to read the object's state from an input stream. This method can be overridden in a class to provide custom deserialization logic, such as reading only certain fields or decoding the data in a specific way.

-In addition to these methods, the Java Object Serialization mechanism also provides two other methods that can be used to customize serialization and deserialization: writeReplace() and readResolve(), which I explained in the previous question.

-When an object is serialized, its entire object graph is serialized recursively. This means that if an object contains references to other objects, those objects will also be serialized. If an object is not serializable, a NotSerializableException will be thrown at runtime.

- The writeReplace() method is called during the serialization process, just before the object is written to the stream. Its purpose is to allow the object to be replaced by another object before it is serialized. This can be useful for various purposes, such as providing a serialization proxy for an object or to ensure that only one instance of an object is ever created.

- The readResolve() method is called during the deserialization process, just after an object has been deserialized. Its purpose is to allow the deserialized object to be replaced by another object. This can be useful for various purposes, such as ensuring that only one instance of an object is ever created or to provide a different implementation of an object after deserialization.

### Externalization 
In Java, serialization and externalization are mechanisms used to convert Java objects into a format that can be easily stored or transmitted and then reconstructed back into Java objects.

1. **Serialization**:
   - Serialization is the process of converting a Java object into a stream of bytes so that it can be stored in a file, sent over a network, or saved in a database.
   - To make a Java class serializable, it must implement the `Serializable` interface, which is a marker interface (an interface with no methods).
   - The serialization process is handled by the `ObjectOutputStream` class, which writes the object to an output stream, and the `ObjectInputStream` class, which reads the object from an input stream.
   - Example:
     ```java
     import java.io.*;

     public class SerializeDemo {
         public static void main(String[] args) {
             try {
                 // Serialize object
                 FileOutputStream fileOut = new FileOutputStream("employee.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);
                 Employee employee = new Employee("John Doe", 30);
                 out.writeObject(employee);
                 out.close();
                 fileOut.close();

                 // Deserialize object
                 FileInputStream fileIn = new FileInputStream("employee.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 Employee serializedEmployee = (Employee) in.readObject();
                 in.close();
                 fileIn.close();
                 System.out.println("Deserialized Employee: " + serializedEmployee);
             } catch (IOException | ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }
     }

     class Employee implements Serializable {
         private String name;
         private int age;

         public Employee(String name, int age) {
             this.name = name;
             this.age = age;
         }

         @Override
         public String toString() {
             return "Employee{" +
                     "name='" + name + '\'' +
                     ", age=" + age +
                     '}';
         }
     }
     ```

2. **Externalization**:
   - Externalization is a mechanism similar to serialization but provides more control over the serialization process.
   - To make a Java class externalizable, it must implement the `Externalizable` interface, which has two methods: `writeExternal` for writing the object's state to a stream and `readExternal` for reading the object's state from a stream.
   - Example:
     ```java
     import java.io.*;

     public class ExternalizeDemo {
         public static void main(String[] args) {
             try {
                 // Serialize object
                 FileOutputStream fileOut = new FileOutputStream("employee.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);
                 ExternalizableEmployee employee = new ExternalizableEmployee("John Doe", 30);
                 out.writeObject(employee);
                 out.close();
                 fileOut.close();

                 // Deserialize object
                 FileInputStream fileIn = new FileInputStream("employee.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 ExternalizableEmployee externalizedEmployee = (ExternalizableEmployee) in.readObject();
                 in.close();
                 fileIn.close();
                 System.out.println("Deserialized Externalizable Employee: " + externalizedEmployee);
             } catch (IOException | ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }
     }

     class ExternalizableEmployee implements Externalizable {
         private String name;
         private int age;

         public ExternalizableEmployee() {} // Required for Externalizable

         public ExternalizableEmployee(String name, int age) {
             this.name = name;
             this.age = age;
         }

         @Override
         public void writeExternal(ObjectOutput out) throws IOException {
             out.writeObject(name);
             out.writeInt(age);
         }

         @Override
         public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
             name = (String) in.readObject();
             age = in.readInt();
         }

         @Override
         public String toString() {
             return "ExternalizableEmployee{" +
                     "name='" + name + '\'' +
                     ", age=" + age +
                     '}';
         }
     }
     ```

In summary, serialization is a way to convert Java objects into a stream of bytes, while externalization provides more control over the serialization process by allowing you to explicitly define how an object is serialized and deserialized.
#### Serialization Vs Externalization
The main differences between serialization and externalization in Java are as follows:

1. **Control Over Serialization**:
   - **Serialization**: In serialization, the serialization process is handled entirely by the JVM. You simply implement the `Serializable` interface, and the JVM takes care of serializing and deserializing the object.
   - **Externalization**: In externalization, you have more control over the serialization process. You explicitly implement the `Externalizable` interface and define the `writeExternal` and `readExternal` methods to specify how the object's state should be written to and read from a stream.

2. **Customization**:
   - **Serialization**: Serialization provides a default mechanism for serializing objects. You can customize the serialization process by using transient fields or implementing custom serialization methods (`writeObject` and `readObject`).
   - **Externalization**: Externalization gives you full control over the serialization process. You can write custom logic to serialize and deserialize the object's state, allowing for more flexibility and optimization.

3. **Performance**:
   - **Serialization**: Serialization is generally slower than externalization because it involves more overhead, such as reflection and object traversal.
   - **Externalization**: Externalization can be more efficient than serialization in terms of performance, especially for large objects, because you have more control over the serialization process.

4. **Use Cases**:
   - **Serialization**: Serialization is suitable for most cases where you need to serialize objects and don't require fine-grained control over the serialization process.
   - **Externalization**: Externalization is useful when you need more control over how an object is serialized and deserialized, such as when you want to optimize the serialization process or handle special cases that are not supported by the default serialization mechanism.

In general, you would use serialization for most cases where you need to serialize objects. However, if you need more control over the serialization process or want to optimize the serialization for performance, you might consider using externalization. Externalization is also useful when the default serialization mechanism does not meet your requirements, such as when you need to serialize non-serializable objects or handle complex object graphs.

### Collections
![image](https://user-images.githubusercontent.com/69948118/216813845-085dc08c-9c4f-47c4-b466-63b84b2a40fa.png)
- 27. How to Create Read-only Collections?
  - Collections.unmodifiableList( list );
- 28. How to Create Thread-safe Collections? 
  - Collections.synchronizedList( list );
- 30. What are Different Ways to Iterate a List?
```java
List<String> list = Arrays.asList(new String[]{"One","Two","Three","Four","Five"});
//Iterate List with Standard for Loop
//Using standard for loop
for (int i = 0; i < list.size(); i++) 
{
  System.out.println(list.get(i));
}
//Iterate List using Iterator
//Using Iterator
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
  System.out.println(iterator.next());
}
//Iterate List using Enhanced for Loop
//Using enhanced for loop
for (String str : list) {
  System.out.println(str);
}
//Iterate List using java 8 functional style
list.forEach(name -> System.out.println(name));
```
- 31. What is a Fail-fast Iterator?
  - Fail-fast Iterators fail as soon as they detect that structure of the Collection has been changed since iteration has begun.
    Structural changes mean adding, removing or updating items from the Collection while one thread is Iterating over that Collection.
     Fail-fast behavior is implemented by keeping a modification count, and if the iteration thread realizes the change in modification count it throws     ConcurrentModificationException.
- 32. Difference between Fail-fast and Fail-safe Iterators?
  -We have understood the fail-fast iterators in the previous question.
  - Fail-safe iterators are just the opposite of fail-fast. A Fail-safe iterator does not fail if we modify the underlying Collection on which they are iterating because    they work on a clone of Collection instead of the original Collection and that’s why they are called a fail-safe iterator.
  - Iterator of CopyOnWriteArrayList is an example of a fail-safe Iterator. Also, the iterator returned by ConcurrentHashMap keySet is a fail-safe iterator and never throw ConcurrentModificationException
- Guide to Sorting in Java
```java
//Sorting an array
Arrays.sort( arrayOfItems );
Arrays.sort( arrayOfItems, Collections.reverseOrder() );
Arrays.sort(arrayOfItems, 2, 6); //fromindex and toindex
Arrays.parallelSort(arrayOfItems);
//Sorting a List
Collections.sort(numbersList);
Collections.sort(numbersList, Collections.reverseOrder());
//Sorting a Set
//Unsorted set
HashSet<Integer> numbersSet = new LinkedHashSet<>(); //with Set items

List<Integer> numbersList = new ArrayList<Integer>(numbersSet) ;        //set -> list

//Sort the list
Collections.sort(numbersList);

//sorted set
numbersSet = new LinkedHashSet<>(numbersList);          //list -> set
//Sorting a Map
TreeMap<Integer, String> treeMap = new TreeMap<>(map);

unsortedeMap.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue())
    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//Java 8 Lambda
Comparator<Employee> nameSorter = (a, b) -> a.getName().compareToIgnoreCase(b.getName());
Collections.sort(list, nameSorter);

Collections.sort(list, Comparator.comparing(Employee::getName));

//Group By Sorting

Collections.sort(list, Comparator
                        .comparing(Employee::getName)
                        .thenComparing(Employee::getDob));
```
### Concurrency Questions
- Guide to ExecutorService in Java
  -  Java ExecutorService to execute a Runnable or Callable class in an asynchronous way
  -  The Executor framework consists of three main interfaces (and lots of child interfaces):
    - Executor (interface),
    - ExecutorService (inteface)
    - ThreadPoolExecutor (class)
  - With an executor, we have to create tasks that implement either Runnable or Callable interface and send them to the executor
  - ThreadPoolExecutor
    - 3.1. Fixed Sized Thread Pool Executor
    - 3.2. Cached Thread Pool Executor
    - 3.3. Scheduled Thread Pool Executor
    - 3.4. Single Thread Pool Executor
    - 3.5. Work Stealing Thread Pool Executor
  - Remember that the JVM stops only when all non-daemon threads are stopped. Here not shutting down the executor service simply prevents the JVM from stopping.
  - In the above examples, if we comment out the executor.shutdownNow() method call, then even after all tasks are executed, main thread remains active and JVM does not stop.

Both newFixedThreadPool and newCachedThreadPool are methods provided by the Executors class in Java to create instances of the ThreadPoolExecutor with specific configurations. These methods provide different strategies for managing threads in a thread pool.

 - newFixedThreadPool(int nThreads):
   - Description:
		- Creates a fixed-size thread pool where the number of threads is specified by nThreads.
		Key Characteristics:
		The thread pool has a fixed number of threads that are created at the time of pool creation and remain alive until the pool is explicitly shut down.
		If a thread terminates due to an exception, a new thread will be created to replace it.
		The pool size does not change dynamically.
		Use Case:
		Suitable when you have a predictable and limited number of tasks to execute concurrently.
		It can prevent resource exhaustion when a large number of tasks are submitted.
		Example:
		java
		Copy code
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

- newCachedThreadPool():
  - Description:
		- Creates a thread pool that creates new threads as needed and reuses existing ones.
		Key Characteristics:
		Threads that have been idle for 60 seconds are terminated and removed from the pool.
		The pool can dynamically adjust its size based on the workload. If the workload increases, it can create new threads; if the workload decreases, it can shrink the pool size.
		Suitable for scenarios with a varying number of tasks or when tasks may experience variable execution times.
		Use Case:
		Suitable for scenarios with a high volume of short-lived tasks, where the number of tasks can vary over time.
		Example:
		java
		Copy code
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
- Choosing Between newFixedThreadPool and newCachedThreadPool:
  - Predictability:
    - Use newFixedThreadPool when you have a predictable number of tasks, and you want to control the maximum number of concurrently running threads.
  - Dynamism:
    - Use newCachedThreadPool when the workload is variable, and you want the thread pool to dynamically adjust its size based on the current workload.
Resource Consumption:
- newFixedThreadPool can provide more predictable resource consumption, while newCachedThreadPool is more adaptive but may lead to resource contention in scenarios with a large number of tasks.
Remember that the choice between these two thread pool configurations depends on the specific characteristics of your application and the nature of the tasks you need to execute concurrently.

- What is CyclicBarrier
- CyclicBarrier is used to make threads wait for each other. It is used when different threads process a part of computation and when all threads have completed the execution, the result needs to be combined in the parent thread. In other words, a CyclicBarrier is used when multiple thread carry out different sub tasks and the output of these sub tasks need to be combined to form the final output. After completing its execution, threads call await() method and wait for other threads to reach the barrier. Once all the threads have reached, the barriers then give the way for threads to proceed.
- Working of CyclicBarrier
- CyclicBarriers are defined in java.util.concurrent package. First a new instance of a CyclicBarriers is created specifying the number of threads that the barriers should wait upon.
```java
CyclicBarrier newBarrier = new CyclicBarrier(numberOfThreads);
```
- Each and every thread does some computation and after completing it’s execution, calls await() methods as shown:
```java
public void run()
{
    // thread does the computation
    newBarrier.await();
}
```

- How to do Thread dump analysis in java?
   - Thread dump analysis is the process of examining the state of threads in a Java program to identify and diagnose issues such as deadlocks, high CPU usage, or performance bottlenecks. Here are the steps to perform a thread dump analysis in Java:
 Take a thread dump: A thread dump is a snapshot of the state of all threads in a Java program. To take a thread dump, you can use the jstack command-line tool or a Java profiler such as VisualVM or YourKit. For example, to take a thread dump using jstack, you can run `the following command : jstack <pid>`
   - Where <pid> is the process ID of the Java program.
   - Analyze the thread dump: Once you have a thread dump, you can analyze it to identify potential issues such as deadlocks or high CPU usage. Look for threads that are blocked or waiting, as these can indicate potential issues. Pay attention to the stack traces of        each thread, as they can provide valuable information about what the thread is doing and what resources it is waiting for.
   - Identify the root cause: Based on the information gathered from the thread dump analysis, you can identify the root cause of the issue and take appropriate action to address it. For example, if you identify a deadlock, you may need to modify the code to avoid     
     acquiring locks in a circular order or use a timeout on locks to avoid indefinite blocking.
   - In addition to thread dumps, there are other tools and techniques available for thread analysis in Java, such as profiling tools like VisualVM, JProfiler, or YourKit, or logging frameworks like log4j or SLF4J. These tools can provide more detailed information     
     about thread activity and performance in a Java program.
#### ThreadLocal
`ThreadLocal` in Java is a class that provides thread-local variables. These variables are typically used to associate a certain value with the current thread. Each thread that accesses the variable via its `ThreadLocal` instance gets its own, independently initialized copy of the variable. `ThreadLocal` instances are often used to store state that should be specific to a particular thread.

Here's a simple example to illustrate the use of `ThreadLocal`:

```java
public class ThreadLocalExample {

    // Declare a ThreadLocal variable
    private static ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        // Create and start multiple threads
        Thread thread1 = new Thread(() -> {
            threadLocalVariable.set("Value set by Thread 1");
            printThreadLocalValue();
        });

        Thread thread2 = new Thread(() -> {
            threadLocalVariable.set("Value set by Thread 2");
            printThreadLocalValue();
        });

        thread1.start();
        thread2.start();
    }

    private static void printThreadLocalValue() {
        // Access the ThreadLocal variable within each thread
        System.out.println(Thread.currentThread().getName() + " - ThreadLocal Value: " + threadLocalVariable.get());
    }
}
```

In this example:

- We declare a `ThreadLocal` variable named `threadLocalVariable`.
- Two threads (`Thread 1` and `Thread 2`) are created, each setting a different value in the `ThreadLocal` variable.
- The `printThreadLocalValue` method prints the value of the `ThreadLocal` variable for the current thread.

The output may look like this:

```
Thread-0 - ThreadLocal Value: Value set by Thread 1
Thread-1 - ThreadLocal Value: Value set by Thread 2
```

- Use Case:

A common use case for `ThreadLocal` is in web applications, where each request is typically handled by a separate thread. In a web application framework, you might want to store user-specific information, such as authentication details or user preferences, so that each thread handling a request has its own independent copy of this information.

Here's a simplified example in a web application context:

```java
public class UserContext {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void clearUser() {
        userThreadLocal.remove();
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
```

In this example, `UserContext` uses a `ThreadLocal` to store a `User` object representing the current user for each thread handling a request. This allows different threads to independently access and update the user-specific information without interfering with each other.

### Apartment threading model
- The Apartment threading model, also known as the Single-Threaded Apartment (STA) model, is a threading model used in some graphical user interface (GUI) frameworks, such as COM/ActiveX in Windows.
- In the Apartment threading model, each object belongs to a specific apartment, which is a logical unit of isolation for thread execution. An apartment can be either single-threaded or multithreaded. In the case of the STA model, each apartment is single-threaded, meaning that only one thread can execute the code within that apartment at any given time.

    
### What is deadlock
Deadlock is a situation in concurrent programming where two or more threads are blocked indefinitely, waiting for each other to release resources or complete certain actions. As a result, none of the threads can proceed, leading to a program freeze or a deadlock state.

Deadlocks can occur when the following conditions are met:

1. Mutual Exclusion: At least one resource must be held exclusively by a thread, preventing other threads from accessing it.

2. Hold and Wait: A thread must hold at least one resource while waiting to acquire another resource.

3. No Preemption: Resources cannot be forcefully taken away from a thread; only the thread itself can release them voluntarily.

4. Circular Wait: There must be a circular chain of two or more threads, each waiting for a resource held by the next thread in the chain.

To resolve deadlocks in Java, you can employ various strategies:

1. Prevention: Avoid the occurrence of deadlocks by ensuring that one or more of the deadlock conditions mentioned above are not met. This can be achieved by carefully designing the synchronization mechanisms, resource allocation, and thread interactions in your code. However, prevention can be complex and may not always be feasible.

2. Avoidance: Use algorithms and techniques to dynamically analyze and avoid potential deadlock situations at runtime. One common approach is to use a resource allocation graph and determine if a cycle exists. If a cycle is detected, the system can take actions to avoid the potential deadlock, such as denying resource requests or rolling back actions.

3. Detection and Recovery: Implement deadlock detection algorithms that periodically check for deadlock conditions. If a deadlock is detected, the system can take actions to recover from the deadlock state, such as terminating one or more threads or releasing resources. The `ThreadMXBean` class in Java's `java.lang.management` package provides methods to programmatically detect deadlocks.

4. Resource Ordering: Define an ordering for resource acquisition to prevent circular waits. Threads will always request resources in the same order, avoiding potential circular dependencies. This approach requires careful analysis of resource dependencies and may require reordering of resource access in your code.

It's important to note that resolving deadlocks can be challenging, and the appropriate approach may depend on the specific scenario and requirements of your application. Proper synchronization, resource management, and careful design of thread interactions can help prevent or minimize the occurrence of deadlocks in Java programs.

### Java Memory Leak Questions
![image](https://user-images.githubusercontent.com/69948118/179328375-1826eeed-97a6-4d79-af6f-a1f0984b2d30.png)
![image](https://user-images.githubusercontent.com/69948118/179329167-40191f27-fd56-4131-9b31-3e5b66ea318b.png)
![image](https://user-images.githubusercontent.com/69948118/179329177-68630b90-8f3f-4933-a0d8-de9cc4932531.png)
![image](https://user-images.githubusercontent.com/69948118/179329208-f78be0b5-83af-4d32-957d-41ed467a2171.png)

### Java8
![image](https://user-images.githubusercontent.com/69948118/179429923-8aec0da3-2fb7-4bdc-820e-15ab091cacb9.png)
![image](https://user-images.githubusercontent.com/69948118/178897063-0fca2225-329c-417a-b6c8-08378d1764c0.png)
![image](https://user-images.githubusercontent.com/69948118/178897460-3334ef65-d2c8-4fcb-af1c-e12df088ab89.png)
![image](https://user-images.githubusercontent.com/69948118/178897807-c2af8dc5-0a8d-4f37-a843-659a6018b684.png)
![image](https://user-images.githubusercontent.com/69948118/178898011-8166662d-9714-492d-a95d-374d17da8e00.png)

![image](https://user-images.githubusercontent.com/69948118/179335736-6ccd729a-249e-43ca-89d0-d75d988f8999.png)
![image](https://user-images.githubusercontent.com/69948118/179335852-48a5738c-c925-48db-a00b-26ef5992ebec.png)
![image](https://user-images.githubusercontent.com/69948118/179335864-33f507a0-8c1a-4607-b651-49f1231788ec.png)
![image](https://user-images.githubusercontent.com/69948118/179336286-bf339406-4c91-484a-8743-73220eb11351.png)
![image](https://user-images.githubusercontent.com/69948118/179336319-2027701b-1f3b-4cd4-aecc-10dcca240886.png)
![image](https://user-images.githubusercontent.com/69948118/179336541-8e88cf0f-67bd-426f-920b-ba9a587067cb.png)
![image](https://user-images.githubusercontent.com/69948118/179336593-d8b5f43f-10eb-4f11-9a98-8dbfc5e0567e.png)
![image](https://user-images.githubusercontent.com/69948118/179336628-a0312d21-1ba6-4404-a867-a6c0821c5261.png)
![image](https://user-images.githubusercontent.com/69948118/179336706-ffc9081e-e9c8-440d-978d-cfa44ddcbe32.png)
![image](https://user-images.githubusercontent.com/69948118/179336773-14e72328-244a-4a57-bc7b-405ba134d8a8.png)
![image](https://user-images.githubusercontent.com/69948118/179336817-a33ea615-8dab-40c7-b892-fb3c87cca748.png)
![image](https://user-images.githubusercontent.com/69948118/179336835-c17461c5-5418-43da-8129-c62beb6ebaf7.png)
![image](https://user-images.githubusercontent.com/69948118/179430363-c196d201-6d6f-44f1-8089-590152be49da.png)
![image](https://user-images.githubusercontent.com/69948118/179430418-308bd128-faec-4545-b94d-8da43d55034f.png)
![image](https://user-images.githubusercontent.com/69948118/179430424-d00f4c20-f600-47c4-a93a-e066e63fd149.png)
![image](https://user-images.githubusercontent.com/69948118/179451670-bef5ef23-aab9-43ba-82dc-4020f4d197f6.png)
![image](https://user-images.githubusercontent.com/69948118/179452009-186282bc-ef26-4ad6-a027-4667963169de.png)
![image](https://user-images.githubusercontent.com/69948118/179452167-6e2a0b4d-c580-4951-9903-8a2d577c71e0.png)
![image](https://user-images.githubusercontent.com/69948118/179452270-402af29d-8679-4f4a-9269-f4c05dfa57a5.png)
![image](https://user-images.githubusercontent.com/69948118/179452602-d9e01e04-5c5c-43f5-9d7d-475c23a1a554.png)
![image](https://user-images.githubusercontent.com/69948118/179452851-5fd9c05d-4ef0-499d-9ccc-343f9e001c1d.png)

### Java9

- 2. Modular System – Jigsaw Project
- A New HTTP Client
- Quick GET Request
- Small Language Modifications
  - Try-With-Resources
  -  Interface Private Method
- JShell Command Line Tool
- 12. New APIs

### Java11
- New String Methods : isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
- Collection to an Array : 
```java
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("cherry");

		String[] array = list.toArray(String[]::new);
		System.out.println(Arrays.toString(array));
		
```

### java-date-time
- https://github.com/jdbirla/JD_JAVA_Learning/blob/master/JavaDateTime_A-Z.md
  
### memory-managment
https://medium.com/@kiranchowdhary/java-memory-management-and-garbage-collection-e29d3c313d05
![image](https://user-images.githubusercontent.com/69948118/222110829-e11296d0-90c9-41c8-8599-be46ade267a3.png)
![image](https://user-images.githubusercontent.com/69948118/222111177-dbb3031a-269a-4c80-bc3e-97e625482f99.png)

- Metaspace: Java 8 introduced Metaspace to replace PermGen. Metaspace is a region of memory that is used to store class metadata, such as class names, field and method names, and method bytecode. Metaspace is part of the native memory heap, which means that it is not limited by the maximum heap size.
- G1 garbage collector: Java 8 introduced the G1 garbage collector as the default garbage collector. The G1 garbage collector is a concurrent garbage collector, which means that it can collect garbage while the application is still running. This can improve the performance of applications that have large heaps.
  
### Garbage-Collector
- https://iampravo.medium.com/journey-of-javas-garbage-collector-so-far-7c00af8c89dc
- For Java 8 and earlier versions, **the default GC is the Parallel GC**. It uses multiple threads to perform garbage collection, making it suitable for applications that need high throughput but can tolerate brief periods of unresponsiveness.
- The default strategy used by the Parallel GC is to divide the heap into young and old generations. Objects that are newly created are allocated in the young generation, which is further divided into an Eden space and two survivor spaces. The Parallel GC uses a combination of minor and major garbage collections to clean up the young and old generations, respectively.	
	
- Starting with Java 9, **the default GC is the G1 (Garbage First) GC**. It uses multiple threads and divides the heap into multiple regions, allowing it to perform more targeted garbage collection and reduce the pause times for application threads.
- For Java 9 and later versions, the default strategy used by the G1 (Garbage First) GC is to divide the heap into multiple regions and use a combination of concurrent and parallel garbage collection to clean up the regions. The G1 GC uses a generational model similar to the Parallel GC, with young and old generations. However, the G1 GC is designed to be more efficient than the Parallel GC by reducing the frequency and duration of stop-the-world pauses.
- ZGC (Z Garbage Collector) is a scalable low-latency garbage collector that debuted in Java 11 as an experimental option for Linux. JDK 14 introduced  ZGC under the Windows and macOS operating systems. ZGC has obtained the production status from Java 15 onwards
- It's important to note that the default strategy used by the GC can be changed by setting various flags, such as **-XX:+UseSerialGC, -XX:+UseParallelGC, and -XX:+UseG1GC, **depending on the application's requirements. Additionally, there are other GC algorithms available in Java, such as CMS (Concurrent Mark Sweep) and ZGC (Z Garbage Collector), which have their own unique strategies and characteristics.
---

## Spring

## spring-interview-questions-with-answers
-  What is circular dependencies in spring
- https://www.baeldung.com/circular-dependencies-in-spring
- 13. Are Singleton Beans Thread-safe?
- In summary, singleton beans in Spring Framework are thread-safe by default, but developers should ensure that any mutable state within the bean is modified in a thread-safe manner to avoid issues with concurrency.
- 2. What Is Inversion of Control?
 - Inversion of Control is a principle in software engineering which transfers the control of objects or portions of a program to a container or framework. We most often use it in the context of object-oriented programming.
- 3. What Is Dependency Injection?
 - Dependency injection is a pattern we can use to implement IoC, where the control being inverted is setting an object's dependencies.
 - Connecting objects with other objects, or “injecting” objects into other objects, is done by an assembler rather than by the objects themselves.
- 4. The Spring IoC Container
  - An IoC container is a common characteristic of frameworks that implement IoC.
  - In the Spring framework, the interface ApplicationContext represents the IoC container. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their life cycles.
- 5. Dependecny Injection
   - Constructor Injection: This involves injecting dependencies through the constructor of a class. Constructor injection is considered the preferred way of injecting dependencies because it ensures that all required dependencies are provided at the time of object creation, making the object fully initialized and ready to use. Constructor injection is also useful when you have mandatory dependencies that are required to create an object.

  - Setter Injection: This involves injecting dependencies through setter methods. Setter injection is useful when you have optional dependencies that can be set at any time after the object is created. It can also be used when you need to change the dependency at runtime.

  - Field Injection: This involves injecting dependencies directly into class fields. Field injection is the least preferred way of injecting dependencies because it can lead to hard-to-diagnose issues, such as circular dependencies and tight coupling between classes. However, it can be useful for prototyping or when using frameworks that do not support constructor or setter injection.

   - In general, it is recommended to use constructor injection wherever possible, as it provides clear dependencies and makes your code more testable and maintainable. Setter injection can be useful for optional dependencies or when you need to change the dependency at runtime. Field injection should be used sparingly, and only in cases where constructor or setter injection is not possible or practical.

- 6. Wiring (Autowiring)
 - The autowiring functionality has four modes. These are ‘no‘, ‘byName‘, ‘byType‘ and ‘constructor‘.
 - The default autowire mode in XML configuration is no.
 - The default autowire mode in java configuration is byType.
 - ![image](https://user-images.githubusercontent.com/69948118/222419584-72d318e6-c9b3-433c-975c-0dc116ee8520.png)
 - NO : This option is default for spring framework and it means that autowiring is OFF. You have to explicitly set the dependencies using <property> tags in bean definitions.
 - byName : This option enables the dependency injection based on bean names. When autowiring a property in a bean, the property name is used for searching a matching bean definition in the configuration file. If such a bean is found, it is injected into the property. If no such bean is found, an error is raised.
 - byType : This option enables the dependency injection based on bean types. When autowiring a property in bean, the property’s class type is used for searching a matching bean definition in the configuration file. If such a bean is found, it is injected into the property. If no such bean is found, an error is raised.
 - constructor : Autowiring by constructor is similar to byType, but applies to constructor arguments. In autowire enabled bean, it will look for class type of constructor arguments, and then do a autowire bytype on all constructor arguments. Please note that if there isn’t exactly one bean of the constructor argument type in the container, a fatal error is raised.
- @Autowired : Now, when annotation configuration has been enabled, you are free to autowire bean dependencies using @Autowired
	 - @Autowired on properties: When @Autowired is used on properties, it is equivalent to autowiring by ‘byType‘ in configuration file.
	 - @Autowired on property setters : When @Autowired is used on setters, it is also equivalent to autowiring by ‘byType‘ in configuration file.
	 - @Autowired on constructors : When @Autowired is used on bean’s constructor, it is also equivalent to autowiring by ‘constructor‘ in configuration file.

- The priority for autowiring modes is as follows:
	- Constructor autowiring takes the highest priority. If a bean can be autowired using a constructor, that will be preferred over other autowiring modes.

	- If constructor autowiring is not possible, "byType" autowiring takes the second priority. If there is only one bean of the required type, it will be autowired. Otherwise, an exception will be thrown.

	- If "byType" autowiring is not possible, "byName" autowiring takes the third priority. If a bean with the same name as the property is found, it will be autowired. Otherwise, an exception will be thrown.

	- If none of the above autowiring modes can be used, the "no" autowiring mode is used. In this mode, dependencies must be explicitly set via constructor or setter injection.

- What if we call singleton bean from prototype or prototype bean from singleton How many objects returned?
   - When a singleton bean is called from a prototype bean or vice versa, the behavior depends on how the dependency is injected.
	If a singleton bean is injected into a prototype bean, then each time the prototype bean is created, it will receive the same instance of the singleton bean. This is because the singleton bean is only created once during the startup of the application context, and that same instance is then injected into the prototype bean each time it is created.
	On the other hand, if a prototype bean is injected into a singleton bean, then each time the singleton bean is called, a new instance of the prototype bean will be created. This is because prototype beans are not managed by the container, and a new instance is created each time a dependency is injected.
	Here's an example to illustrate this:
```java
@Component
@Scope("singleton")
public class SingletonBean {
// code for singleton bean
}
@Component
@Scope("prototype")
public class PrototypeBean {
@Autowired
private SingletonBean singletonBean;
// code for prototype bean
}
```
- In this example, when a prototype bean is created and injected with the singleton bean, it will receive the same instance of the singleton bean each time it is created. However, if the singleton bean is created and injected with the prototype bean, it will receive a new instance of the prototype bean each time it is called.
	It's important to note that mixing singleton and prototype scopes in a single application context can lead to unexpected behavior and should be avoided unless necessary. It's best to use one scope consistently throughout the application context.

#### What is the Spring bean lifecycle?
- The Spring bean lifecycle can be divided into three phases: instantiation, configuration, and destruction.
- Instantiation: In this phase, Spring IoC container creates the instance of the bean. Spring Framework supports several ways of instantiating a bean, such as through a constructor, a static factory method, or an instance factory method.
- Configuration: In this phase, Spring IoC container configures the newly created bean. This includes performing dependency injection, applying any bean post
processors, and registering any initialization and destruction call-backs.
-  Destruction: In this phase, Spring IoC container destroys the bean instance. It is the last phase of the Spring bean lifecycle.
In addition to these three phases, Spring Framework also provides several callbacks that allow developers to specify custom initialization and destruction logic for a bean. These callbacks include:
-  @PostConstruct: Invoked after the bean has been constructed and all dependencies have been injected
-  init-method: Specifies a method to be called after the bean has been constructed and all dependencies have been injected
-  destroy-method: Specifies a method to be called just before the bean is destroyed.
-  @PreDestroy: Invoked before the bean is destroyed.

#### What if we call singleton bean from prototype or prototype bean from singleton How many objects returned?
When a singleton bean calls a prototype-scoped bean or vice versa, the behavior is influenced by the Spring container's default settings. By default, Spring does not manage the complete lifecycle of a prototype bean that is injected into a singleton bean. Let's explore the scenarios:

##### 1. Singleton Bean Calling Prototype Bean:

If a singleton bean calls a method on a prototype-scoped bean, Spring will create a new instance of the prototype bean for each method invocation. However, Spring does not manage the complete lifecycle of the prototype bean. This means that the prototype bean won't be destroyed automatically by the container when the calling singleton bean is destroyed.

Example:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}
```

```java
public class SingletonBean {

    private final PrototypeBean prototypeBean;

    public SingletonBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public void performOperation() {
        // Each invocation of performOperation will get a new instance of PrototypeBean
        PrototypeBean newPrototypeInstance = prototypeBean.createInstance();
        // Do something with the newPrototypeInstance
    }
}
```
##### 2. Prototype Bean Calling Singleton Bean:

If a prototype bean calls a method on a singleton bean, it will get the same instance of the singleton bean throughout its lifecycle. This is because the singleton bean is managed by the container, and the same instance is injected into the prototype bean when it is created.

Example:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean(SingletonBean singletonBean) {
        return new PrototypeBean(singletonBean);
    }
}
```

```java
public class PrototypeBean {

    private final SingletonBean singletonBean;

    public PrototypeBean(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }

    public void performOperation() {
        // The same instance of SingletonBean is used throughout the lifecycle of PrototypeBean
        // Do something with singletonBean
    }
}
```

In both cases, it's essential to be aware of the potential issues related to managing the lifecycle of beans with different scopes, especially when a prototype bean holds a reference to a singleton bean. If the prototype bean retains references to the singleton bean, it may lead to memory leaks or unexpected behavior. In such cases, consider managing the dependency in a way that aligns with the expected behavior of the application.

#### in first option when Singleton Bean Calling Prototype Bean its giving new incance everytime , how can we configure that prototype bean wich calling from singlton will give the same insace everytime
If you want a singleton bean to always receive the same instance of a prototype bean, you can use method injection along with the `lookup-method` element in XML-based configuration or the `@Lookup` annotation in Java-based configuration. This allows the singleton bean to obtain a new instance of the prototype bean on each method invocation.

Here's an example using the `@Lookup` annotation:

```java
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

    public void performOperation() {
        PrototypeBean prototypeBean = getPrototypeBean();
        // Use prototypeBean instance
    }

    @Lookup
    protected PrototypeBean getPrototypeBean() {
        // This method will be overridden by Spring to return a new instance of PrototypeBean
        return null;
    }
}
```

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    // Prototype bean logic
}
```

In this example, the `getPrototypeBean` method in the `SingletonBean` class is annotated with `@Lookup`. Spring will generate a runtime subclass of `SingletonBean` and override the `getPrototypeBean` method to return a new instance of `PrototypeBean` on each invocation.

Remember to use method injection carefully, as it introduces some degree of coupling between the singleton and prototype beans. Be aware of potential issues related to the state of the prototype bean and its lifecycle management.

#### when prototype Bean Calling singleton Bean its giving same incance everytime , how can we configure that singleton bean wich calling from prototype will give the new insace everytime

When a prototype bean calls a singleton bean, the default behavior is to provide the same instance of the singleton bean for the entire lifecycle of the prototype bean. This is because the prototype bean is created during the injection process, and the injected singleton bean is resolved and provided as a reference.

If you want the prototype bean to obtain a new instance of the singleton bean on each method invocation, you can use method injection with the `ObjectFactory` interface or the `Provider` interface. Here's an example using the `ObjectFactory` interface:

```java
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    private final ObjectFactory<SingletonBean> singletonBeanFactory;

    @Autowired
    public PrototypeBean(ObjectFactory<SingletonBean> singletonBeanFactory) {
        this.singletonBeanFactory = singletonBeanFactory;
    }

    public void performOperation() {
        SingletonBean singletonBean = singletonBeanFactory.getObject();
        // Use singletonBean instance
    }
}
```

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

    // Singleton bean logic
}
```

In this example, the `PrototypeBean` class receives an `ObjectFactory<SingletonBean>` in its constructor. The `ObjectFactory` allows the prototype bean to obtain a new instance of the singleton bean on each call to `getObject()`.

Alternatively, you can use the `Provider` interface, which serves a similar purpose:

```java
import javax.inject.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    private final Provider<SingletonBean> singletonBeanProvider;

    @Autowired
    public PrototypeBean(Provider<SingletonBean> singletonBeanProvider) {
        this.singletonBeanProvider = singletonBeanProvider;
    }

    public void performOperation() {
        SingletonBean singletonBean = singletonBeanProvider.get();
        // Use singletonBean instance
    }
}
```

Both approaches ensure that the prototype bean gets a new instance of the singleton bean on each method invocation. Choose the approach that aligns better with your preferences and the dependency injection style used in your application.

#### What is an HttpMessageConverter in Spring REST?
It's a key interface that handles the conversion of HTTP requests and responses between Java objects and their corresponding message formats (e.g., JSON, XML).
It acts as a bridge between the controller layer and the message payload, ensuring data compatibility.
How It Works:
• Incoming Request Handling:
• When a request arrives, Spring looks for a suitable HttpMessageConverter based on the Content-Type header of the request.
• If a match is found, the converter reads the request body and converts it into a Java object that the controller can process.
Outgoing Response Handling:
•When a controller returns an object, Spring again finds an appropriate HttpMessageConverter based on the Accept header of the request or a default converter.
•The converter serializes the object into the desired format (e.g., JSON, XML) and writes it to the response body.
Common Converters:
•MappingJackson2HttpMessageConverter (for JSON, using Jackson library)
•StringHttpMessageConverter (for plain text)
•FormHttpMessageConverter (for form data)
•ByteArrayHttpMessageConverter (for binary data)
•Jaxb2RootElementHttpMessageConverter (for XML, using JAXB)

#### How filter work in spring?
In Spring, filters act as interceptors for requests and responses, processing them before and after they reach the actual application logic. They're like "gatekeepers" that can modify, deny, or allow requests based on predefined rules.
Here's how they work in a nutshell:
1. Configuration:
• You define filters as beans in your Spring configuration.
• Specify the order in which filters should be executed.
2. Request Flow:
• When a client sends a request, it goes through each filter in the specified order.
• Each filter can:
• Inspect the request headers, body, and other attributes.
• Modify the request content or headers.
• Decide to continue processing the request or terminate it.
3. Response Flow:
• Once the request reaches the application logic and receives a response, the response flows back through the filters in reverse order.
• Filters can again:
• Inspect the response headers and body.
• Modify the response content or headers.
4. Common Use Cases:
• Security filters: Validate user authentication, authorize access, and prevent security vulnerabilities.
• Logging filters: Log information about requests and responses for debugging and analysis.
• Compression filters: Compress responses to reduce bandwidth usage.
• Caching filters: Cache frequently accessed resources to improve performance.
Benefits:
• Intercept and modify requests and responses: Provide more control over application behavior.
• Centralize common tasks: Avoid duplicating code for security, logging, etc.
• Chain multiple filters: Achieve complex processing logic by combining multiple filters.

---
## Spring Boot
###  Spring Boot Annotations (Interview Questions)
- @SpringBootApplication : Main spring boot application
   - @ComponentScan
   - @EanbleAutoConfiguration
       - exclude `@EnableAutoConfiguration(excludeName = {"multipartResolver","mbeanServer"})`
   - @Configuration
- @ImportAutoConfiguration
   It import and apply only the specified auto-configuration classes. The difference between @ImportAutoConfiguration and @EnableAutoConfiguration is that later attempts to configure beans that are found in the classpath during scanning, whereas @ImportAutoConfiguration only runs the configuration classes that we provide in the annotation.
   
```java
   @ComponentScan("path.to.your.controllers")
@ImportAutoConfiguration({WebMvcAutoConfiguration.class
    ,DispatcherServletAutoConfiguration.class
    ,EmbeddedServletContainerAutoConfiguration.class
    ,ServerPropertiesAutoConfiguration.class
    ,HttpMessageConvertersAutoConfiguration.class})
public class App 
{
  public static void main(String[] args) 
  {
    SpringApplication.run(App.class, args);
  }
}
   
 ```

We should use @ImportAutoConfiguration when we don’t want to enable the default auto-configuration.
- Stereotype annotation
  -  @Component : For maninging bean life cycle
  - @Service :  Derived from component
  - @RestController : @Controller / @ResponseBody
  - @Controller : Derived from component
  - @Repository : :  Derived from component
-Spring Core related Annotations:
	- @Configuration : This annotation using for spring configuration using this we can configure bean deifination
	- @Bean : When we used @configuration inside that we can use @ bean for creating object of any class and this is another way of cretion bean lifecycle like                  @component or xml configuration after that spring container will register this bean inside that and we can inject this anywere using @autowired
			ex. 
```java
			@Configuration
			public class BeanConfig {

			@Bean
			public TestBean testBean(){
			return new TestBean();
			}

			}
```
 - @Autowired:Inject the bean
 - @Qualifier: This is use when more than implentaiton is there and we are injecting the interface for selecting one of them we have to use qualifies
 - @Primary: Same as qualifier but in this case it will take primary class object only
 - @Lazy:By default the spring always create object of beans as eager when it start but if don't want to create object on startup then we can use @lazy and spring will create object when we use that object 
 - @Value : When we want to use values from property files then will go for value
 - @PropertySource: This is use for custom property files loading apart from application.property
 - @ConfigurationProperties: This one is use for load lot property values and bind with a bean/DTO
 - @Profile:Using this we can swtich over the different environment
 - @Scope:Everty time when contianer rquest for object bean will give new object

- REST API related Annotations:​
        - @RestController: @Controller / @ResponseBody
	- @RequestMapping:
	- @GetMappin :  inherited by RequestMapping
	- @PostMapping  :  inherited by RequestMapping
	- @PutMapping  :  inherited by RequestMapping
	- @DeleteMapping  :  inherited by RequestMapping
	- @RequestBody : Bind request body to bean 
	- @PathVariable: Pass the request parameter in path like /304 as id , in pathvariable its mandatory if we are not giving it will throw 404
	- @RequestParam: Pass the request parameter in ULR like id?304 as id, in rwquestparam its optional if we are not ginving it won't throq 404
	- @ControllerAdvice & @ExceptionHandler : Throwing cutomize exception via controller
- Spring Data JPA related annotations:​
     - @Entity: 
     - @Table:
     - @Column:
     - @Transactional:

- Entity class relationships ​
     - @OnetoOne ​
     - @OnetoMany ​
     - @ManytoOne​
     - @ManytoMany
       
- What is the most common Spring MVC annotations?
- Controller Annotations:
	- @Controller: Designates a class as a controller, responsible for handling HTTP requests and rendering responses.
	- @RestController: A specialized version of @Controller that implicitly adds @ResponseBody to all handler methods, indicating that they should directly write data to the response body, often in JSON or XML format.
- Request Mapping Annotations:
	- @RequestMapping: Maps web requests to specific controller methods based on URL patterns, HTTP methods (GET, POST, PUT, DELETE, etc.), request parameters, and headers.
	- @GetMapping,PostMapping, @PutMapping, @DeleteMapping, @PatchMapping: Convenient shortcuts for mapping specific HTTP methods.
	- @PathVariable: Binds a method parameter to a path segment variable in the URL.
	- @RequestParam: Binds a method parameter to a query parameter in the request URL.
- Data Binding Annotations:
	- @ModelAttribute: Populates a model attribute with an object, making it available to the view.
	- @RequestParam: Binds a request parameter to a method argument.
	- @RequestHeader: Binds a request header to a method argument.
	- @RequestBody: Maps the request body to a method argument, often used for JSON or XML data.
- Response Handling Annotations:
	- @ResponseBody: Indicates that the method's return value should be written directly to the response body, bypassing view resolution.
	- @ResponseStatus: Sets the HTTP status code of the response.
	- Exception Handling Annotations:
	- @ExceptionHandler: Defines a method to handle exceptions of a specific type, providing a centralized way to manage errors.
- Other Useful Annotations:
	- @SessionAttribute: Accesses a session attribute.
	- @ModelAttribute: Adds an attribute to the model for all handler methods in a controller.
	- @InitBinder: Customizes data binding and validation for a controller.
	- @CrossOrigin: Enables cross-origin requests for a controller or specific handler methods.
   
### Multiple DB configuration in Springboot
- https://github.com/jdbirla/JD_Spring_Microservices/blob/master/MultipleDS_SpringBoot.md
  
### Spring Boot offers several advantages that make it a popular choice for developing Java applications:

Easy and Rapid Application Development:
Spring Boot simplifies the development process by providing auto-configuration and opinionated defaults. It reduces boilerplate code, allowing developers to focus more on writing business logic rather than configuration.

Convention over Configuration:
Spring Boot follows the principle of convention over configuration, which means it provides sensible defaults and configurations based on conventions. This eliminates the need for explicit configuration in many cases, making development faster and less error-prone.

Embedded Server:
Spring Boot comes with an embedded servlet container (e.g., Tomcat, Jetty, or Undertow) by default. This eliminates the need for manual server configuration and deployment, making it easy to run and distribute applications as standalone JAR files.

Dependency Management:
Spring Boot simplifies dependency management by providing a dependency management plugin. It manages versions and resolves dependencies, ensuring that compatible libraries are used and reducing conflicts between dependencies.

Spring Ecosystem Integration:
Spring Boot seamlessly integrates with the wider Spring ecosystem, allowing developers to leverage various Spring projects and libraries. This includes Spring Data, Spring Security, Spring MVC, Spring Cloud, and many others. It provides pre-configured starters for these modules, making it easy to include and configure them in your application.

Production-Ready Features:
Spring Boot includes many production-ready features out-of-the-box. It provides health checks, metrics, logging, security, and monitoring capabilities, making it easier to build and deploy robust applications. It also supports externalized configuration, allowing you to configure your application for different environments without modifying the code.

Actuator:
Spring Boot Actuator provides powerful production-ready features for monitoring and managing applications. It exposes endpoints to monitor application health, gather metrics, view thread dumps, manage logging, and more. Actuator simplifies the process of gathering runtime information about your application.

Community and Ecosystem:
Spring Boot has a large and active community, which means there are abundant resources, tutorials, and community support available. It also has a vast ecosystem of third-party libraries and frameworks built on top of Spring Boot, providing additional functionality and integration options.

Easy Testing:
Spring Boot provides support for testing with its testing framework, making it easier to write unit tests, integration tests, and end-to-end tests. It provides utilities for mocking dependencies, configuring test environments, and performing assertions, helping developers ensure the quality of their applications.
![image](https://user-images.githubusercontent.com/69948118/178844470-d4b5a574-438f-48cc-a9c4-e5dfd83cb7db.png)
![image](https://user-images.githubusercontent.com/69948118/178844799-552b6ac8-4a55-4088-a514-586807b3ae5d.png)
![image](https://user-images.githubusercontent.com/69948118/178845783-8db13524-6b53-40ea-8288-670b2bb7d12f.png)
![image](https://user-images.githubusercontent.com/69948118/178846065-ac0fcd86-f193-480e-9853-798e28932ead.png)
![image](https://user-images.githubusercontent.com/69948118/178846285-6c9134d0-7aff-4cf6-b83c-6b65890cd28e.png)
![image](https://user-images.githubusercontent.com/69948118/178846452-2cbf6c0e-aa4c-4412-a25f-243b00c8348a.png)
![image](https://user-images.githubusercontent.com/69948118/178846777-95bec28c-4407-4fd8-ba53-c2e43aebcd04.png)
![image](https://user-images.githubusercontent.com/69948118/178846826-26355fe2-3c6e-4607-8764-ef9488b4d973.png)
![image](https://user-images.githubusercontent.com/69948118/178847247-d8116523-1a6c-4e9a-bffe-f4eeea4c9141.png)
![image](https://user-images.githubusercontent.com/69948118/178847766-8d5ba602-66c7-414c-b333-d7c1ac236f0a.png)
![image](https://user-images.githubusercontent.com/69948118/178848279-c3b10455-4ccd-4c70-9795-36756eb28fe8.png)
![image](https://user-images.githubusercontent.com/69948118/178848672-2682f0a1-0d61-4bb1-9b5b-2e8c8a98280b.png)
![image](https://user-images.githubusercontent.com/69948118/178848958-0f66ab2d-abc2-41f4-872b-4a6fc9e27643.png)
![image](https://user-images.githubusercontent.com/69948118/178849971-b8111ecd-508b-45a0-805c-b13511b95ad7.png)
![image](https://user-images.githubusercontent.com/69948118/178850468-c80d7b6d-f57d-4e46-a618-1e940a71b320.png)
![image](https://user-images.githubusercontent.com/69948118/178850502-70ed73af-0e17-4de7-a13c-de7e2b16fa6a.png)
![image](https://user-images.githubusercontent.com/69948118/178850540-8e9b36a5-b90b-49aa-a1ac-0eb7313dec74.png)
![image](https://user-images.githubusercontent.com/69948118/178850702-5b066377-122d-4fe0-a967-1563930c82b3.png)
![image](https://user-images.githubusercontent.com/69948118/178850836-224342b4-9560-472f-9dcc-a1dc21f259ff.png)
![image](https://user-images.githubusercontent.com/69948118/178850991-81f2d06f-d610-474c-9a62-95f7f29c018d.png)
![image](https://user-images.githubusercontent.com/69948118/178851065-45a05ad8-e678-49ad-a989-db1467b44943.png)
![image](https://user-images.githubusercontent.com/69948118/178851101-9ab29615-75d9-47d3-8869-a9286832977e.png)
![image](https://user-images.githubusercontent.com/69948118/178851233-984e2956-b01b-4524-ab57-30c457f103a0.png)
![image](https://user-images.githubusercontent.com/69948118/178851419-f2f5ec40-3987-4adf-9b8a-c75336273c03.png)
- ANS: https://howtodoinjava.com/spring-boot/info-endpoint-custom-info/
	- 1. Spring boot provide info endpoint where we can put the static information from application.property files
        - 2. InfoContributor : Using InfoContributor inteface we can add dynamic information to info endpoint , we have to implement this inteface and contribute method and we can give information inform of Map
         - 3.  We can generate our own endpoint 
```java

                        @Component
                        @Endpoint(id = "release-notes")
                        public class CustomEndpoint {


                            Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

                            @PostConstruct
                            public void initNotes() {
                                releaseNotesMap.put("version-1.0", Arrays.asList("Home page created", "Adding a new item form added", "View the watchlist page added"));
                                releaseNotesMap.put("version-1.1", Arrays.asList("Reading from OMDb API added", "Actuator endpoints added"));
                            }

                            @ReadOperation
                            public Map<String, List<String>> getReleaseNotes(){
                                return releaseNotesMap;
                            }

                            @ReadOperation
                            public List<String> getNotesByVersion(@Selector String version){
                                return releaseNotesMap.get(version);
                            }

                            @WriteOperation
                            public void addReleaseNotes(@Selector String version, String releaseNotes){
                                releaseNotesMap.put(version,Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
                            }

                            @DeleteOperation
                            public void  deleteNotes(@Selector String version){
                                releaseNotesMap.remove(version);
                            }
                        }
```

![image](https://user-images.githubusercontent.com/69948118/178851810-f22d8590-2471-435b-8e44-57f0f39bd474.png)

![image](https://user-images.githubusercontent.com/69948118/178852149-2969268a-56d7-4cc6-aa9a-ec344a692abb.png)
### What is Spring Actuator? What are its advantages?
- Spring Actuator is a module in the Spring Boot framework that provides production-ready features for monitoring and managing applications. It offers a set of built-in endpoints and metrics for monitoring the health, status, and performance of a Spring Boot application.
Advantages of Spring Actuator include
 - Monitoring and Health Checks Actuator exposes endpoints that provide valuable information about the application's health, such as /health and /info endpoints, allowing easy monitoring and health checks.
 - Metrics and Metrics Exports Actuator collects and exposes metrics about the application's performance and resource usage, which can be accessed via /metrics endpoint. It supports exporting metrics to external monitoring systems like Prometheus or Graphite.
- Operational Readiness Actuator assists in operational tasks by providing endpoints for managing the application, including features like /shutdown for graceful shutdown, /loggers for adjusting logging levels, and more.
- Custom Endpoint Exposure Actuator allows developers to create custom endpoints to expose application-specific information or perform specific actions, enabling better visibility and control over the application.
- Security Actuator provides security measures to protect sensitive endpoints by integrating with Spring Security, ensuring that only authorized users or roles can access certain endpoints.
- Integration with External Systems Actuator seamlessly integrates with various monitoring and management tools, such as Spring Cloud Sleuth for distributed tracing and Micrometer for centralized metric monitoring.

### How to enable Actuator in spring boot application?
build.gradle` (if using Gradle) file and ensure that the Actuator dependency is included. By default, Actuator is already included when using the `spring-boot-starter-parent` or `spring-boot-starter-web` dependencies.
For Maven
```XML
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
2. (Optional) Configure Actuator Endpoints You can customize Actuator's behavior by providing additional configuration. In your `application.properties` or `application.yml` file, add properties specific to Actuator, such as enabling or disabling specific endpoints, changing endpoint paths, or configuring security.
For example, to enable all Actuator endpoints and set the base path to `/manage`
management.endpoints.web.exposure.include=*
management.endpoints.web.base-path=/manage
3. (Optional) Secure Actuator Endpoints If you want to secure Actuator endpoints, you can configure Spring Security rules. By default, Actuator endpoints are secured using the same security configuration as your application's other endpoints.
For example, to permit unauthenticated access to Actuator endpoints
```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests()
.requestMatchers(EndpointRequest.toAnyEndpoint())
.permitAll()
.and()
.authorizeRequests()
.anyRequest().authenticated()
.and()
.formLogin();
}
}
```
4. Run the Application Start your Spring Boot application, and Actuator endpoints will be available under the `/actuator` (or your configured base path) context path. You can access Actuator endpoints by appending the endpoint path to the base path.
For example, to access the `/health` endpoint
GET /actuator/health
That's it! With these steps, Actuator will be enabled in your Spring Boot application, and you can start utilizing the various endpoints and features provided by Actuator.
### How to secure Spring Boot Actuator's endpoints?
- Securing Spring Boot Actuator endpoints is crucial to prevent unauthorized access to sensitive information and operations exposed by these endpoints. Actuator endpoints provide valuable insights into the application's health, metrics, and other internal details, so it's essential to secure them properly.
To secure Spring Boot Actuator endpoints:
 - Use Spring Security to control access.
 - Configure permissions for specific endpoints.
 - Consider HTTP Basic Auth or custom security measures.
 - Test thoroughly to ensure secure access.
### What do you understand by the shutdown in the actuator?
- The term "shutdown in actuators" can have a couple of different meanings depending on the context. To give you the most accurate response, I need some more information. Could you please clarify what you mean by "shutdown in actuators"?
Here are some possibilities:
 - Emergency Shutdown (ESD) Valves: If you're referring to actuators used for shutting down valves in emergency situations, then "shutdown" refers to the action of the actuator quickly closing the valve to stop the flow of fluid in case of a dangerous event.
 - Power Loss and Fail-Safe Mechanisms: Some actuators have specific shutdown behaviors associated with power loss. This could involve "fail-safe" mechanisms where the actuator automatically moves to a safe position in the absence of power.
- Application Shutdown and Actuator Control: It's also possible you're talking about controlling the state of actuators as part of a larger application shutdown process. For example, shutting down actuators before stopping a motor or machine.

### Can you explain what happens in the background when a Spring Boot Application is “Run as Java Application”?
When a Spring Boot application is "Run as Java Application," the following happens in the background
1. The main method of the Spring Boot application's entry point class is executed.
2. Spring Boot's SpringApplication class is invoked, which initializes and starts the application context.
3. The application context is configured, including component scanning to detect beans, auto-configuration, and loading external configurations.
4. The embedded server (e.g., Tomcat, Jetty) is started, allowing the application to handle incoming requests.
5. Application-specific beans and dependencies are instantiated and wired together via dependency injection.
6. The application context is refreshed, performing any necessary initialization and configuration.
7. Any initialization callbacks or lifecycle events defined in beans are triggered.
8. The application starts listening for incoming requests on the configured port and is ready to process them.
### How to enable HTTP/2 support in Spring Boot?
  - You can enable the HTTP/2 support in Spring Boot by server.http2.enabled=true
### What is graceful shutdown in Spring-Boot?
- Graceful shutdown in Spring Boot refers to the process of gracefully stopping a running Spring Boot application, allowing it to complete its ongoing tasks and clean up resources before shutting down. It ensures that all active requests are processed or interrupted in a controlled manner, preventing abrupt termination.
- During a graceful shutdown, Spring Boot initiates a sequence of steps to gracefully stop the application. These steps may include
1. Rejecting New Requests The application stops accepting new requests, ensuring that no new tasks are initiated.
2. Waiting for Active Requests to Complete The application waits for the ongoing requests to finish processing. This allows the application to complete any pending tasks or operations.
3. Shutting Down Components Once all active requests are completed, the application proceeds to shut down its components, releasing resources, closing connections, and performing any necessary cleanup.
4. Notifying External Systems Optionally, the application may notify external systems, such as service registries or load balancers, to mark the application as unavailable during the shutdown process.
Graceful shutdown is particularly important in scenarios where the application needs to perform cleanup tasks, release resources, or ensure data consistency. It helps prevent data loss, incomplete operations, or unexpected behavior during application shutdown.
Spring Boot provides mechanisms and hooks, such as the `ApplicationContext` events, `SmartLifecycle` interface, or custom shutdown hooks, to facilitate graceful shutdown in applications. These mechanisms allow developers to define custom behavior and perform necessary cleanup actions before the application terminates.
### How to read yaml file values in application
![image](https://user-images.githubusercontent.com/69948118/178852841-1358a625-0ddf-4726-8241-abf6380cd00a.png)
![image](https://user-images.githubusercontent.com/69948118/178852860-c1cc6e81-6f9d-4578-a8ec-e6400d6e90af.png)
![image](https://user-images.githubusercontent.com/69948118/178852899-76d56879-391a-4e42-9531-1f08a5052e28.png)
![image](https://user-images.githubusercontent.com/69948118/178853773-2d38c316-977f-4821-8e63-3fd5a89a50f9.png)
![image](https://user-images.githubusercontent.com/69948118/178853849-c9c53928-708c-47a4-9898-e5dd326647d8.png)
![image](https://user-images.githubusercontent.com/69948118/179342290-329b3c98-d996-4d33-9b3b-7765e4c14002.png)
![image](https://user-images.githubusercontent.com/69948118/179342314-31d5bdc7-ac1b-445c-991a-1f1eec1e9077.png)
![image](https://user-images.githubusercontent.com/69948118/179342319-ff41a81e-2821-4bd0-a3c8-c38788d9de1c.png)
![image](https://user-images.githubusercontent.com/69948118/179344588-bc886b7b-d285-4cc7-b5ae-4dba9851d2e8.png)

### What is @Transactional annotation?
- The @Transactional annotation is used in Spring to define the transactional behavior of a method or a class. It marks a method or class as participating in a transaction, ensuring that the method's execution occurs within a transactional context.
- When a method or class is annotated with @Transactional, Spring intercepts the method call and begins a transaction before the method is executed. If the method completes without any exceptions, the transaction is committed, resulting in the changes made during the method's execution being persisted to the database. If an exception occurs, the transaction is rolled back, and any changes made during the method's execution are discarded.
- The @Transactional annotation provides control over transaction boundaries, isolation levels, propagation behavior, and more through various attributes and parameters.
In summary, @Transactional is used to define transactional behavior in Spring, ensuring that the annotated method or class operates within a transactional context, providing data integrity and consistency in database operations.
### What is Spring-Batch?
- Spring Batch is a framework within the Spring ecosystem that provides support for batch processing of large volumes of data. It enables developers to build robust and scalable batch processing applications.
- To implement Spring Batch in a Spring Boot application, you need to add the following dependencies to your project's build file:
   - spring-boot-starter-batch
   - spring-boot-starter-data-jpa

- Then, you need to create a job definition by defining the steps involved in the batch processing. Each step specifies the necessary reader, processor, and writer components for the data processing task.
Here is an example of a job definition:
```java
@Configuration @EnableBatchProcessing public class BatchConfig {
@Bean
public Job job() {
return JobBuilder.job(JobConfiguration.class)
.start(step1())
.next(step2())
.build();
}
@Bean
public Step step1() {
return StepBuilder.step(StepConfiguration.class)
.tasklet(tasklet())
.build();
}
@Bean
public Step step2() {
return StepBuilder.step(StepConfiguration.class)
.tasklet(tasklet())
.build();
}
@Bean
public Tasklet tasklet() {
return new Tasklet() {
@Override
public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {     
{
// Do some batch processing here
GUIDE TO CLEAR SPRING-BOOT MICROSERVICE
INTERVIEW
72
return RepeatStatus.FINISHED;
}
};
}
}
```
- Once you have created a job definition, you can execute the job by calling the JobLauncher interface. You can trigger the job programmatically or schedule it using a scheduler like Quartz or Spring Scheduler.

### Configuring Properties with Spring Boot
```java
@Component
@PropertySources({
    @PropertySource("classpath:jms.properties"),
    @PropertySource("classpath:datasource.properties")
})
public class AppProperties {

  @Value("${application.name:My App}")
  private String appName;

  @Value("${spring.datasource.url}")
  private String datasourceUrl;
}
```
- Bind Fields to Property Values with @ConfigurationProperties
```java
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceProps {

  private String url;
  private String username;
  private String password;
  private String driverClassName;
  private String dialect;
}
```
### Spring boot @Scheduled annotation example
- @EnableScheduling and @Scheduled
- Add @EnableScheduling annotation to your spring boot application class. @EnableScheduling is a Spring Context module annotation. It internally imports the SchedulingConfiguration via the @Import(SchedulingConfiguration.class) instruction
```java
@SpringBootApplication
@EnableScheduling
public class SpringBootWebApplication {
   
}
```
- @Scheduled Annotation
- @Scheduled annotation is used for task scheduling. The trigger information needs to be provided along with this annotation.
- fixedDelay vs fixedRate vs cron
- fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running.
- fixedDelay specifically controls the next execution time when the last execution finishes.
- cron is a feature originating from Unix cron utility and has various options based on your requirements
```java
@Scheduled(fixedDelay =30000)
public void demoServiceMethod () {... }
 
@Scheduled(fixedRate=30000)
public void demoServiceMethod () {... }
 
@Scheduled(cron="0 0 * * * *")
public void demoServiceMethod () {... }
```
### Profiles
- 1.2. What is Default Profile? :default 
- 2. @Profile Annotation
  - 2.1. Using @Profile
```java
 @Profile("local")
@Configuration
public class LocalProfileConfiguration {

   @Bean
   public DataSource h2DataSource() {/*...*/}
}
@Profile("dev")
@Configuration
public class DevelopmentProfileConfiguration {

   @Bean
   public DataSource mySqlDataSource() {/*...*/}
}
```
- 3. Profile Specific Properties
   - application.properties – contains properties applicable to all environments
   - application-local.properties – configure the application when local profile is activated
   - application-dev.properties – configure the application when dev profile is activated
   - application-prod.properties – configure the application when prod profile is activated

- 5. Activating a Profile
    - spring.profiles.active=dev
    - As JVM startup argument: `export spring_profiles_active=dev`
    - While configuring WebApplicationInitializer:
```java
@Configuration
public class CustomWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.setInitParameter("spring.profiles.active", "dev");
    }
}
```

![image](https://user-images.githubusercontent.com/69948118/220291414-44940b55-753a-40af-98aa-0e3263131c52.png)
![image](https://user-images.githubusercontent.com/69948118/220292013-c97b8179-dc1c-4a0f-9aa4-0027963bfa67.png)
![image](https://user-images.githubusercontent.com/69948118/220293346-bf232500-260c-4cfd-9043-ac4c3fec1d47.png)
![image](https://user-images.githubusercontent.com/69948118/220294633-4ef9cd17-5849-4039-8057-abc518e00db1.png)
![image](https://user-images.githubusercontent.com/69948118/220294874-b1a588e6-8028-4672-b70e-fba7c201dcc6.png)
![image](https://user-images.githubusercontent.com/69948118/220295048-d2618a45-b307-45ef-9174-86817b053c73.png)


### HTTP Status Codes (400 / 401 / 500 / )
![image](https://user-images.githubusercontent.com/69948118/182381187-f2633f7b-f8b5-40b8-bb25-b79547e5bb11.png)
![image](https://user-images.githubusercontent.com/69948118/182381210-3bbf1f08-c808-40a1-aa38-52d88a56a39e.png)
![image](https://user-images.githubusercontent.com/69948118/182381237-4978cf81-db2a-4e3b-82af-299bbb8156d1.png)
![image](https://user-images.githubusercontent.com/69948118/182381273-b8337249-6d19-48e0-9b49-99d235691710.png)
![image](https://user-images.githubusercontent.com/69948118/182381291-f909a301-3d00-4ce6-a970-4ee2f5e722af.png)
![image](https://user-images.githubusercontent.com/69948118/182381310-05d8eebf-47f7-47cc-8e09-8973de8333ae.png)

### what is Jwt refresh tokens
JWT (JSON Web Token) refresh tokens are a mechanism used to extend the lifespan of a JWT-based authentication session. JWTs are commonly used for authentication and authorization in web applications and APIs.

Here's how the JWT refresh token flow typically works:

Authentication: When a user successfully logs in or authenticates with their credentials, the server generates a JWT access token containing relevant information (e.g., user ID, roles, permissions) and signs it with a secret key. The access token is typically short-lived and has an expiration time (e.g., 15 minutes).

Token Response: Along with the access token, the server also issues a separate refresh token. The refresh token is a long-lived token that is securely stored on the client-side, such as in an HTTP-only cookie or local storage.

Access Token Expiration: As the access token approaches its expiration time, the client includes it in each request's Authorization header to access protected resources.

Access Token Validation: On receiving a request with the access token, the server verifies its signature and checks if it has expired. If the token is valid and not expired, the server processes the request.

Token Refresh: If the access token has expired, the client sends a request to a specific endpoint (usually /refresh-token) along with the refresh token.

Refresh Token Validation: The server validates the refresh token, checking if it is still valid and has not been tampered with. If the refresh token is valid, the server generates a new access token with a fresh expiration time.

New Access Token: The server responds to the refresh token request with a new access token, which the client can use for subsequent requests.

The use of refresh tokens provides several benefits:

Enhanced Security: Refresh tokens can be securely stored and have a longer lifespan, reducing the risk of exposure compared to short-lived access tokens.

User Experience: With a longer-lived refresh token, users can maintain their session and avoid frequent logins, improving the user experience.

Revocation and Control: Refresh tokens can be tracked and revoked on the server-side, providing control over active sessions and improving security.

It's important to handle refresh tokens securely and protect them against unauthorized access. Best practices include encrypting refresh tokens, using secure storage mechanisms, and implementing mechanisms to detect and prevent token misuse or replay attacks.

Note that the exact implementation of JWT refresh tokens may vary depending on the specific authentication framework or library being used.

### logging-in-spring-boot
- 1. Default Zero Configuration Logging
    - 1.1. Default Logging Provider is Logback
    - 1.3. Log Statements using SLF4J
- 2. Custom Logging with Logback
   - Spring boot by default uses logback, so to customize its behavior, all we need to add logback.xml in classpath and define customization over the file.
```xml
    
<configuration>
	<property name="LOG_ROOT" value="c:/temp/logs" />
	<property name="LOG_FILE_NAME" value="application" />
	
	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>

	<appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${LOG_ROOT}/${LOG_FILE_NAME}.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
			<fileNamePattern>${LOG_ROOT}/${LOG_FILE_NAME}-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern>
			<!-- each archived file's size will be max 10MB -->
			<maxFileSize>10MB</maxFileSize>    
			<!-- 30 days to keep -->
			<maxHistory>30</maxHistory>
			<!-- total size of all archive files, if total size > 100GB, it will delete old archived file -->
			<totalSizeCap>100GB</totalSizeCap>
		</rollingPolicy>
		<encoder>
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>
	
	<logger name="com.howtodoinjava.app" level="INFO" additivity="false">
                <appender-ref ref="FILE"/>
        </logger>

	<root level="ERROR">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="FILE" />
	</root>
</configuration

```
- 3. Logging with Log4j2
 - 3.1. Excluding Logback and Including Log4j2
 - 3.2. Add Log4j2 Configuration File : log4j2.xml

### Spring boot profile specific logging example
- 1. Syntax - springProfile tag : Create logback-spring xml file in resources folder and use `<springProfile>` tags to provide profile specific logging configurations.
	
```java	
<springProfile name="prod">
  <!-- configuration to be enabled when the "prod" profile is active -->
</springProfile>
 
<springProfile name="dev | prod">
  <!-- configuration to be enabled when the "dev" or "prod" profiles are active -->
</springProfile>

<springProfile name="!prod">
  <!-- configuration to be enabled when the "prod" profile is not active -->
</springProfile>

```
	
### spring-boot-actuator-Info-endpoint	
- 1. Adding Spring Boot Actuator Module
- 2. Enabling ‘/info’ Endpoint
   `management.endpoints.web.exposure.include = info, shutdown, beans `
- 3. Default Information Provided by ‘/info’ Endpoint
   - blank response by default because we did not configure any properties for the /info endpoint.
   
![image](https://user-images.githubusercontent.com/69948118/222337043-0517da38-8da0-4e5a-9a0a-816f13637f29.png)
- https://github.com/jdbirla/JD_Spring_Boot_Master/blob/master/Actuator.md
```java
management.info.env.enabled=true
management.info.build.enabled=true
management.info.git.enabled=true
management.info.java.enabled=true
management.info.os.enabled=true
```
- 4. Adding Custom Information to /info Endpoint
 - 4.1. Using application.properties
   - Add static information that would not be changed often
```java
management.endpoints.web.exposure.include = info

info.application.name = Actuator info
info.application.description= A demo Spring project with information
info.organization = How to do in Java

```
  - 4.2. Using InfoContributor Interface
```java
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Autowired
    private Environment environment;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("port", environment.getProperty("local.server.port"));
        builder.withDetail("profiles", environment.getDefaultProfiles());
    }
}

```
  - 4.3. Adding Build Information using Spring Boot Maven Plugin
```java
<plugins>
  <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>2.7.3</version>
    <executions>
      <execution>
        <goals>
          <goal>build-info</goal>
        </goals>
      </execution>
    </executions>
  </plugin>
</plugins>  
```
![image](https://user-images.githubusercontent.com/69948118/222338043-cccfb670-d5ca-4ad0-b850-77d6f1039364.png)


### spring-boot-testing

- Verifying that the application has been initialized successfully
- Unit testing REST Controller with @WebMvcTest
- Unit testing Service Layer with Mockito
- Unit testing DAO Layer with @DataJpaTest and @AutoConfigureTestDatabase
- Integration testing using @SpringBootTest
- System testing using RestTemplate
  
### Unit testing in spring boot
- 3. Test runners
   - 3.1. @RunWith(SpringRunner.class) – [ Junit 4 ]
   - 3.2. @RunWith(MockitoJUnitRunner.class) – [ Junit 4 with Mockito ]
   - 3.3. @ExtendWith(SpringExtension.class) – [ Junit 5 ]
   - 3.4. @ExtendWith(MockitoExtension.class) – [ Junit 5with mockito ]
- Mockito
 - @MockBean annotation used to add mocks to a Spring ApplicationContext. It allows to mock a class or an interface and to record and verify behaviors on it.

### What is @Async in Spring Boot?
- Spring comes with @EnableAsync annotation and can be applied to a @Configuration class for asynchronous behavior. The @EnableAsync annotation will look for methods marked with @Async annotation and run them in background thread pools
- The @Async annotated methods are executed in a separate thread and return CompletableFuture to hold the result of an asynchronous computation.
- The @Async annotation in Spring Boot is used to indicate that a method should be executed asynchronously. When a method is annotated with @Async, it is executed in a separate thread, allowing the calling thread to continue its execution without waiting for the completion of the annotated method.
- By using @Async, time-consuming or blocking operations can be offloaded to separate threads, improving the overall responsiveness and performance of the application. This annotation is typically used in scenarios where certain methods can be executed independently and their results are not immediately needed by the calling thread.
- To enable asynchronous execution in Spring Boot, you need to configure a task executor bean and annotate the target method with @Async. Spring Boot will automatically detect the @Async annotation and execute the annotated method asynchronously using the specified task executor
### completablefuture
- https://www.callicoder.com/java-8-completablefuture-tutorial/
- Future vs CompletableFuture
  - A Future is used as a reference to the result of an asynchronous computation. It provides an isDone() method to check whether the computation is done or not, and a get() method to retrieve the result of the computation when it is done.
- Limitations of Future
  - It cannot be manually completed :
  - You cannot perform further action on a Future’s result without blocking:
  - Multiple Futures cannot be chained together :
  - You can not combine multiple Futures together :
  - No Exception Handling :

- Creating a CompletableFuture : CompletableFuture implements Future and CompletionStage interfaces
  - complete() : You can use CompletableFuture.complete() method to manually complete a Future
  - 2. Running asynchronous computation using runAsync() : If you want to run some background task asynchronously and don’t want to return anything from the task, then you can use CompletableFuture.runAsync() method. It takes a Runnable object and returns CompletableFuture<Void>.
  - 3. Run a task asynchronously and return the result using supplyAsync() : Well, CompletableFuture.supplyAsync() is your companion. It takes a Supplier<T> and returns CompletableFuture<T> where T is the type of the value obtained by calling the given supplier 

- CompletableFuture as Async
  - You can attach a callback to the CompletableFuture using thenApply(), thenAccept() and thenRun() methods -
- 1. thenApply() : You can use thenApply() method to process and transform the result of a CompletableFuture when it arrives. It takes a Function<T,R> as an argument. Function<T,R> is a simple functional interface representing a function that accepts an argument of type T and produces a result of type R -
```java
CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
       throw new IllegalStateException(e);
    }
    return "Rajeev";
}).thenApply(name -> {
    return "Hello " + name;
}).thenApply(greeting -> {
    return greeting + ", Welcome to the CalliCoder Blog";
});

System.out.println(welcomeText.get());
// Prints - Hello Rajeev, Welcome to the CalliCoder Blog
```
- 2. thenAccept() and thenRun() : If you don’t want to return anything from your callback function and just want to run some piece of code after the completion of the Future, then you can use thenAccept() and thenRun() methods. These methods are consumers and are often used as the last callback in the callback chain.
```java
// thenAccept() example
CompletableFuture.supplyAsync(() -> {
	return ProductService.getProductDetail(productId);
}).thenAccept(product -> {
	System.out.println("Got product detail from remote service " + product.getName())
});
```
- thenRun : thenRun() doesn’t even have access to the Future’s result. It takes a Runnable and returns CompletableFuture<Void> -
```java
// thenRun() example
CompletableFuture.supplyAsync(() -> {
    // Run some computation  
}).thenRun(() -> {
    // Computation Finished.
});
```
- Combining two CompletableFutures together
- 1. Combine two dependent futures using thenCompose() - While thenCompose() is used to combine two Futures where one future is dependent on the other,
   - So, Rule of thumb here - If your callback function returns a CompletableFuture, and you want a flattened result from the CompletableFuture chain (which in most cases you would), then use thenCompose().
```java
CompletableFuture<Double> result = getUserDetail(userId)
.thenCompose(user -> getCreditRating(user));	    
```
- 2. Combine two independent futures using thenCombine() -thenCombine() is used when you want two Futures to run independently and do something after both are complete.
```java
System.out.println("Retrieving weight.");
CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
       throw new IllegalStateException(e);
    }
    return 65.0;
});

System.out.println("Retrieving height.");
CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
       throw new IllegalStateException(e);
    }
    return 177.8;
});

System.out.println("Calculating BMI.");
CompletableFuture<Double> combinedFuture = weightInKgFuture
        .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
    Double heightInMeter = heightInCm/100;
    return weightInKg/(heightInMeter*heightInMeter);
});

System.out.println("Your BMI is - " + combinedFuture.get());
```
- Combining multiple CompletableFutures together :  you can use the following methods to combine any number of CompletableFutures -
  
```java
static CompletableFuture<Void>	 allOf(CompletableFuture<?>... cfs)
static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs)
```

- CompletableFuture Exception Handling
- 1. Handle exceptions using exceptionally() callback : The exceptionally() callback gives you a chance to recover from errors generated from the original Future. You can log the exception here and return a default value.
```java
	    nteger age = -1;

CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
    if(age < 0) {
        throw new IllegalArgumentException("Age can not be negative");
    }
    if(age > 18) {
        return "Adult";
    } else {
        return "Child";
    }
}).exceptionally(ex -> {
    System.out.println("Oops! We have an exception - " + ex.getMessage());
    return "Unknown!";
});

System.out.println("Maturity : " + maturityFuture.get()); 
```
- 2. Handle exceptions using the generic handle() method : The API also provides a more generic method - handle() to recover from exceptions. It is called whether or not an exception occurs.
```java
Integer age = -1;

CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
    if(age < 0) {
        throw new IllegalArgumentException("Age can not be negative");
    }
    if(age > 18) {
        return "Adult";
    } else {
        return "Child";
    }
}).handle((res, ex) -> {
    if(ex != null) {
        System.out.println("Oops! We have an exception - " + ex.getMessage());
        return "Unknown!";
    }
    return res;
});

System.out.println("Maturity : " + maturityFuture.get());
```
### bootstrap-properties 
- bootstrap.properties is a configuration file used in Spring Boot applications to specify properties that are used during the early stages of the application's startup. Specifically, these properties are used during the application's "bootstrap" phase, which is the phase before the application context is created.
- In a Spring Boot application, the bootstrap.properties file is typically used to configure properties related to the application's configuration, such as the location of external configuration files or the URLs of external configuration servers. By configuring these properties in the bootstrap.properties file, they can be loaded and used by the Spring Boot framework during the bootstrap phase
```properties
spring.application.name=config-client
spring.profiles.active=development
spring.cloud.config.uri=http://localhost:8888
spring.cloud.config.username=root
spring.cloud.config.password=s3cr3t
spring.cloud.config.fail-fast=true
management.security.enabled=false
```

### spring-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller
	- https://medium.com/javarevisited/spring-framework-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller-745aa34b08d8

![image](https://user-images.githubusercontent.com/69948118/223021347-a9010aa9-24c5-4a41-acf5-91c1d51bc8d6.png)

#### 1. What is a Filter?
	
   ![image](https://user-images.githubusercontent.com/69948118/223021559-5edd8706-bf7f-4d75-9670-b3061a76b96a.png)
- As seen in the diagram above, Filters are part of the Servlet Container of the web server. It does not belong to any framework like Struts or Spring. Filters are used to manipulate the requests and the requests can even be blocked before it reaches the Servlet. It can also act on responses, and modify them before reaching the client

- Spring Security uses filters for authentication and authorization. Spring Security can intercept all incoming and outgoing traffic and hence Spring Security can be used outside the Spring MVC framework.

- Following are the list of the task we can perform with servlet filters:

1. Server-side logging.
2. Logging request parameter to log files.
3. Auditing
4.Server-side authentication and authorization.
5.Compression and decompression.
6.Encryption and decryption.
7.Server-side validation.

#### Spring MVC and Dispatcher Servlet?
![image](https://user-images.githubusercontent.com/69948118/223021711-c268db56-fbdd-4573-8d39-d9f2fd0a816c.png)

- The core element of Spring MVC is the Dispatcher Servlet, which is the front controller that handles all requests and provides an entry point for all the requests inside the Spring framework. It is responsible for directing incoming HTTP requests to all of an application’s other handlers and controllers

#### What is a Handler Interceptor?

![image](https://user-images.githubusercontent.com/69948118/223022403-f873e7f5-0464-4e0e-90a3-5f83309b9d92.png)

- The HandlerInterceptor contains three main methods:

1. prehandle() — called before the execution of the actual handler
2. postHandle() — called after the handler is executed
3. afterCompletion() — called after the complete request is finished and the view is generated

- Handler Interceptors reduce duplication and allow for more fine-grained functionality such as:

1. Handling cross-cutting concerns such as application logging
2. Detailed authorization checks
3. Manipulating the Spring context or model
	
#### What is a Controller?
![image](https://user-images.githubusercontent.com/69948118/223022656-104ac810-6ff5-4c91-9284-a4369b417ee4.png)

### Database Migration in Spring Boot using Flyway
- https://medium.com/javarevisited/database-migration-in-spring-boot-using-flyway-ee791db8aea0

### How does auto-configuration work? How does it know what to configure?
Key Concepts:
Auto-configuration: A mechanism that automatically configures beans and settings for common Spring features based on dependencies and conditions.
Starters: Pre-defined sets of dependencies for common use cases (e.g., web, JPA, security), making it easier to include necessary libraries and trigger auto-configuration.
Conditionals: Annotations like @ConditionalOnClass, @ConditionalOnBean, @ConditionalOnProperty, etc., that control when certain configurations apply based on classpath scanning and properties.
How It Works:
Enabling Auto-configuration:
You typically enable auto-configuration by adding the @SpringBootApplication annotation to your main class, which includes @EnableAutoConfiguration.
Classpath Scanning and Condition Matching:
Spring Boot scans the classpath for classes annotated with @Conditional* annotations.
It evaluates these conditions based on factors like:
Presence or absence of specific classes on the classpath
Existence of certain beans in the context
Configuration properties being set
Applying Matching Configurations:
If conditions are met, Spring Boot applies the corresponding auto-configuration classes.
These classes create and configure beans as needed..

### How to enable HTTP/2 support in Spring Boot?
- You can enable the HTTP/2 support in Spring Boot by `server.http2.enabled=true`

### Explain how to register a custom auto-configuration?
To register a custom auto-configuration in Spring Boot, you can follow these steps
- 1. Create a Configuration Class Create a configuration class with the necessary bean definitions and configuration logic. Annotate the class with `@Configuration` to indicate that it is a configuration class.
- 2. Enable Auto-Configuration Annotate the configuration class with `@EnableAutoConfiguration` to enable auto-configuration in your custom configuration.
- 3. Register the Auto-Configuration Create a `META-INF/spring.factories` file in your project's resources directory. In the `spring.factories` file, specify the fully qualified name of your custom configuration class under the `org.springframework.boot.autoconfigure.EnableAutoConfiguration` key.
Example `spring.factories` file org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.example.MyCustomAutoConfiguration
- 4. Package and Deploy Package your application as a JAR or WAR file, ensuring that the `spring.factories` file is included in the resulting artifact.
By following these steps, your custom auto-configuration will be registered and activated when the Spring Boot application starts. The beans and configurations defined in your custom auto-configuration will be available for use in the application context, allowing for additional customization and configuration.

### How do you Configure Log4j for logging in springboot
To configure Log4j for logging in a Spring Boot application, you can follow these steps:

1. **Include Log4j Dependency:**
   First, make sure to include the Log4j 2 dependency in your project's `pom.xml` (if you're using Maven) or `build.gradle` (if you're using Gradle).

   For Maven:

   ```xml
   <dependency>
       <groupId>org.apache.logging.log4j</groupId>
       <artifactId>log4j-slf4j-impl</artifactId>
       <version>2.x.x</version> <!-- Use the latest version available -->
   </dependency>
   ```

   For Gradle:

   ```groovy
   implementation 'org.apache.logging.log4j:log4j-slf4j-impl:2.x.x' // Use the latest version available
   ```

2. **Exclude Spring Boot's Default Logging:**
   By default, Spring Boot uses Logback for logging. If you want to use Log4j instead, you can exclude Logback by adding the following exclusion in your `pom.xml` or `build.gradle`:

   For Maven:

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter</artifactId>
       <exclusions>
           <exclusion>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-logging</artifactId>
           </exclusion>
       </exclusions>
   </dependency>
   ```

   For Gradle:

   ```groovy
   implementation ('org.springframework.boot:spring-boot-starter') {
       exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
   }
   ```

3. **Add Log4j2 Configuration File:**
   Create a `log4j2.xml` or `log4j2.yaml` configuration file in the `src/main/resources` directory. Here's an example `log4j2.xml` configuration:

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <Configuration status="WARN">
       <Appenders>
           <Console name="Console" target="SYSTEM_OUT">
               <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
           </Console>
       </Appenders>
       <Loggers>
           <Root level="info">
               <AppenderRef ref="Console"/>
           </Root>
       </Loggers>
   </Configuration>
   ```

   This is a basic configuration that logs messages to the console. You can customize it based on your requirements.

4. **Run Your Spring Boot Application:**
   Start your Spring Boot application, and Log4j will be used for logging as per the configuration provided in the `log4j2.xml` file.

Remember to replace `"2.x.x"` with the latest version of Log4j available at the time of your project setup. Additionally, feel free to customize the Log4j configuration based on your logging preferences and requirements.

### How to load multiple external configuration or properties files?
Loading Multiple Configuration Files in Spring Boot
Spring Boot makes it easy to load multiple external configuration files, providing flexibility and modularity in your application's setup. Here are three ways to achieve this:
1. Specifying File Names:
Use the spring.config.name property to specify a comma-separated list of file names (excluding extensions).
By default, Spring Boot looks for files named application.
Example:
spring.config.name=config1,config2 (assuming files named config1.properties and config2.properties exist)
2. Specifying File Locations:
Use the spring.config.location property to define locations for files not in the default locations (e.g., classpath).
Use a comma-separated list of file paths or directories.
Example:
spring.config.location=file/path/to/file1.properties,file/path/to/dir/
3. Command-Line Arguments:
Pass file names or locations as arguments when starting the application.
Use the --spring.config.name and --spring.config.location flags.
Example:
java -jar myapp.jar --spring.config.name=config1,config2 --spring.config.location=file/path/to/file1.properties,file/path/to/dir/
Note:
If both spring.config.name and spring.config.location are used, files defined in spring.config.name will be searched for within directories listed in spring.config.location.
Configurations from multiple files are merged, with later files overriding earlier ones in case of conflicts.

### How to deploy Spring Boot application as a WAR?
To deploy a Spring Boot application as a WAR file, you need to make a few configurations changes
1. Update the Packaging Type In your project's build configuration file, such as `pom.xml` for Maven or `build.gradle` for Gradle, change the packaging type from `jar` to `war`.
For Maven
<packaging>war</packaging>
For Gradle
apply plugin 'war'
2. Adjust the Main Class By default, Spring Boot expects an executable JAR file. To make it work with a WAR file, you need to modify the main class by extending `SpringBootServletInitializer`.
Example
public class MyApplication extends SpringBootServletInitializer {
}
3. Exclude Embedded Container Exclude the embedded container dependency to prevent conflicts with the application server's own servlet container. Add the exclusion in your build configuration file.
Example for excluding Tomcat in Maven
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
<exclusions>
<exclusion>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
</exclusion>
</exclusions>
</dependency>
4. Build the WAR File Build the project using your build tool (Maven or Gradle) to generate the WAR file. This can be done using the build command specific to
your build tool, such as `mvn package` for Maven or `./gradlew build` for Gradle.
The resulting WAR file can be deployed to a servlet container, such as Tomcat or Jetty, following the standard deployment procedure for the chosen container.
By following these steps, you can package and deploy your Spring Boot application as a WAR file, enabling it to be deployed on a servlet container as a web application.
### How to customize the support for multiple content-negotiation for returning XML or JSON?
To customize the support for multiple content negotiation (returning XML or JSON) in a Spring Boot application, you can follow these steps:
1. Add Required Dependencies Make sure you have the necessary dependencies for XML and JSON support. For XML support, include the `spring-boot-starter-web` and `jackson-dataformat-xml` dependencies in your project's build configuration file (e.g., `pom.xml` for Maven or `build.gradle` for Gradle).
2. Configure Content Negotiation In your Spring Boot application's configuration file (e.g., `application.properties` or `application.yml`), configure the content negotiation settings.
Example in `application.properties`
spring.mvc.contentnegotiation.favor-parameter=true
spring.mvc.contentnegotiation.parameter-name=format
spring.mvc.contentnegotiation.media-types.xml=application/xml
spring.mvc.contentnegotiation.media-types.json=application/json
3. Use Accept Header or Request Parameter By default, Spring Boot uses the `Accept` header to determine the response format. If you want to use a request parameter for content negotiation, set the `spring.mvc.contentnegotiation.favor-parameter` property to `true` (as shown in the example above) and specify the parameter name using the `spring.mvc.contentnegotiation.parameter-name` property.
4. Customize Response Formats If you want to customize the response format based on the content negotiation, you can annotate your controller methods with `@RequestMapping` or `@GetMapping` and specify the desired response format using the `produces` attribute.
5. Example
```
@GetMapping(value = "/data", produces = { "application/xml", "application/json" })
public ResponseEntity<Data> getData() {
}
```
By following these steps, you can customize the support for multiple content negotiation in your Spring Boot application. This allows clients to request data in either XML or JSON format based on the configured content negotiation settings.
### How to configure two databases and two EntityManager in Spring Boot?
To configure two databases and two EntityManager instances in a Spring Boot application, you can follow these steps
1. Define Database Configuration Create two separate database configurations by creating two `@Configuration` classes, each annotated with `@EnableJpaRepositories` and `@EnableTransactionManagement`. In each configuration class, configure the necessary `DataSource`, `EntityManagerFactory`, and `JpaTransactionManager` beans specific to each database.
2. Specify Entity Manager Names In each database configuration class, specify unique names for the `EntityManagerFactory` beans using the `entityManagerFactoryRef` attribute of the `@EnableJpaRepositories` annotation. This ensures that each EntityManagerFactory has a distinct name.
3. Specify Transaction Manager Names Similarly, specify unique names for the `JpaTransactionManager` beans using the `transactionManagerRef` attribute of the `@EnableTransactionManagement` annotation in each database configuration class.
4. Define Entity Classes Annotate your entity classes with `@Entity` and configure them with the appropriate `@Table` and other annotations to map them to the corresponding databases.
5. Use EntityManager In your application code, inject the desired `EntityManager` using `@PersistenceContext` and specify the name of the EntityManagerFactory bean to be used.
By following these steps, you can configure two separate databases and manage them using their respective EntityManager instances in your Spring Boot application. This allows you to interact with multiple databases and perform database operations specific to each database using separate EntityManager instances.

### Write a file upload end-point in Springboot?
You will get these questions to verify if you have written springboot app or not, try to write one app end to end you will get to know the steps,
```java
@RestController
@RequestMapping("/upload")
public class FileUploadController {
@PostMapping
public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
if (file.isEmpty()) {
return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}
String fileName = file.getOriginalFilename();
String filePath = "./uploads/" + fileName;
try (InputStream inputStream = file.getInputStream()) {
Files.copy(inputStream, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
}
return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);
}
}
```
This code will create a file upload endpoint at /upload. When a POST request is made to this endpoint, the uploadFile() method will be called. The uploadFile() method will first check if the file is empty. If the file is empty, it will return a 400 Bad Request error. Otherwise, it will save the file to the ./uploads directory. Finally, it will return a 200 OK response with a message indicating that the file was uploaded successfully.
Be ready to explain what this code does in follow-up questions.


### Is it possible to create a non-web application in Spring Boot?

- Spring Boot can be used to build various types of non-web applications, such as command-line applications, batch processing applications, integration applications, standalone services, and more. By excluding unnecessary web-related dependencies and configurations, you can create a lightweight Spring Boot application focused on your specific non-web use case.
---
## kafka
![image](https://user-images.githubusercontent.com/69948118/220339582-7c763166-fe39-4650-98e4-66f027eb8127.png)
![image](https://user-images.githubusercontent.com/69948118/220339846-06ca4765-3732-48f7-8282-ab4406e1ae25.png)
![image](https://user-images.githubusercontent.com/69948118/220340312-ae06e105-2998-4f2a-8de3-970f245b00da.png)
![image](https://user-images.githubusercontent.com/69948118/220340751-d1e4cafd-2cc5-4df7-8497-345b7181bc00.png)
![image](https://user-images.githubusercontent.com/69948118/220340971-6532db02-3e38-4e5d-904c-5d0f3fdd711f.png)
![image](https://user-images.githubusercontent.com/69948118/220341588-02176af1-70df-4e11-b3a0-41c8867a10b9.png)
![image](https://user-images.githubusercontent.com/69948118/220342446-fd9691a0-5d5c-4636-894d-8a32af82f04a.png)
![image](https://user-images.githubusercontent.com/69948118/220342758-c9ff6cdc-ab09-44b9-a2b3-020253438f4e.png)

---
## REST API

### Rest constraint
![image](https://github.com/jdbirla/JD_IP_All_Together/assets/69948118/f9567a22-9c83-45ca-8e28-d1275100d483)

### Rest Versioning
![image](https://github.com/jdbirla/JD_IP_All_Together/assets/69948118/9c5e9ca7-47c4-41a1-b76f-5460ac9a0a27)

### pagination

```java
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORTING_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORTING_DIRECTION, required = false) String sortDir

    ) {

        return postService.getAllPosts(pageSize, pageNo, sortBy, sortDir);

    }

@Override
    public PostResponse getAllPosts(int pageSize, int pageNo, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> page = postRepository.findAll(pageable);
        List<Post> pagePosts = page.getContent();

        List<PostDto> content = pagePosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(page.getNumber());
        postResponse.setPageSize(page.getSize());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setTotalElements(page.getTotalElements());
        postResponse.setLast(page.isLast());

        return postResponse;
    }
```
### Exception handling
```java
package com.jd.blog.exception;

import com.jd.blog.payload.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jd birla on 18-12-2022 at 07:23
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //handle specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception , WebRequest webRequest)
    {
       ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(true) );
       return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogApiException.class)
    public ResponseEntity<ErrorDetails> blogApiExceptionException(BlogApiException exception , WebRequest webRequest)
    {
        System.out.println("jd  "+ exception.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    //Global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalException(Exception exception , WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException exception , WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

}

```
### Rest API Documentation
#### Swagger 2
- https://howtodoinjava.com/swagger2/code-generation-for-rest-api/
-Swagger is developed by SmartBear software and comes with tools like Swagger Editor, Swagger CodeGen, Swagger UI & Swagger Inspector. Swagger has provided it’s specification known as OpenAPI specification to follow while documenting REST API.
- Swagger can be integrated with REST APIs in below ways:
  - A top-down approach – First API specification and then code generation
  - A botton-up approach – First API code and then Swagger integration. This is quite familiar and mostly useful when there is already an existing REST APIs built in and Swagger documentation needs to be integrated.
#### top-down
- Using swagger editor we can create swagger doc
- Save the specification as yaml file from editor File>Save as YAML. It will be saved as swagger.yaml.
![image](https://user-images.githubusercontent.com/69948118/222321970-1ba23a04-d62b-40c7-a6d9-8b1bbc015906.png)
- Generate API code with swagger codegen tool
- To generate client execute below command with swagger cli.
```
java -jar swagger-codegen-cli-2.3.1.jar generate \
  -i swagger.yaml \
  --api-package com.howtodoinjava.example.employee.api \
  --model-package com.howtodoinjava.example.employee.model \
  --group-id com.howtodoinjava.example \
  --artifact-id spring-swagger-codegen-employee \
  --artifact-version 0.0.1-SNAPSHOT \
  -l spring \
  -o spring-swagger-codegen-employee

```
- After code generation open in ide and test using swagger ui or postman
#### botton-up
- use Swagger to generate REST API docs using swagger 2 annotations.
- Add Swagger2 Maven Dependencies : Open pom.xml file of the spring-boot-swagger2 project and add below two swagger related dependencies i.e. springfox-swagger2 and springfox-swagger-ui.
- Swagger2 Annotations
	- @Api – We can add this Annotation to the controller to add basic information regarding the controller. `@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
`  
        - @ApiOperation and @ApiResponses – We can add these annotations to any rest method in the controller to add basic information related to that method.
```java 
@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Success|OK"),
      @ApiResponse(code = 401, message = "not authorized!"), 
      @ApiResponse(code = 403, message = "forbidden!!!"),
      @ApiResponse(code = 404, message = "not found!!!") })
 
@RequestMapping(value = "/getStudents")
public List<Student> getStudents() {
    return students;
}
```
         - @ApiModelProperty – This annotation is used in the Model property to add some description to the Swagger output for that model attribute
	 
```java
@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
private String name;
```

- Swagger 2 
![image](https://user-images.githubusercontent.com/69948118/179428695-6971e9b0-50fc-4fe3-baac-bb9347effed7.png)
![image](https://user-images.githubusercontent.com/69948118/179428803-2041f6a1-9d20-434b-9fb9-0f29aa5c54b1.png)
![image](https://user-images.githubusercontent.com/69948118/179428828-3649ccbe-2d9d-423c-9a2c-3e304ed513aa.png)
![image](https://user-images.githubusercontent.com/69948118/179428896-430331de-6c15-4428-9ca3-cf1bc719f4c2.png)
![image](https://user-images.githubusercontent.com/69948118/179428940-7b31510e-dcb5-40e2-9c3b-b8164f2aaf2b.png)
![image](https://user-images.githubusercontent.com/69948118/179429424-226f061b-8191-4163-b6aa-d27eac83e524.png)
![image](https://user-images.githubusercontent.com/69948118/179429440-c9917749-0da2-47aa-9232-b9185f37ea28.png)

#### REST API Using OpenAPI 3.0
- https://howtodoinjava.com/spring-boot/springdoc-openapi-rest-documentation/
- 1. Introduction to OpenAPI 3.0 and SpringDoc
  - By default, SpringDoc automatically generates documentation in JSON/YAML formats. When Swagger UI is enabled, it uses Swagger API to generate the documentation in HTML format, too.
- 2. Setting up springdoc-openapi
```
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.11</version>
</dependency>
```
- JSON: https://server:port/application-context-path/v3/api-docs 
- Yaml : https://server:port/application-context-path/v3/api-docs.yaml
- 3. Support for Swagger UI
- https://server:port/context-path/swagger-ui.html
- customize the swagger UI
```java
 springdoc.swagger-ui.enabled = true
springdoc.swagger-ui.path = /swagger-ui.html
springdoc.swagger-ui.tryItOutEnabled = false
springdoc.swagger-ui.filter = false
springdoc.swagger-ui.syntaxHighlight.activated = true

```
- Disable swagger UI : springdoc.swagger-ui.enabled = false
- 4. Customizing Default Generated Documentation
 - 4.1. Only Selected REST Controllers and API Methods
 

```java
  @Hidden @RestController
public class EmployeeController {

}

//or skip the API methods

@Hidden @PostMapping("/employees")
Employee create(@RequestBody Employee employee)  {
  return employeeService.save(employee);
}
```
- 4.2. Custom HTTP Statuses using @ControllerAdvice and @ResponseStatus
- 4.3. Adding Pagination Information
  - we need to combine @ParameterObject annotation with the Pageable type to generate the paging information automatically.
- 4.4. JSR-303 Bean Validation Annotations Support
- 5. Generating Java Docs using Swagger 3 Annotations

```java
@Operation(summary = "Get All Employees")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", 
    		description = "Employee List",
        content = { @Content(mediaType = "application/json",
        schema = @Schema(implementation = Page.class)) }),
    @ApiResponse(responseCode = "204", 
    		description = "No employee found",
        content = @Content) })

@GetMapping("/employees")
Page<Employee> read(@ParameterObject Pageable pageable) {
  return null;
}
```

![image](https://user-images.githubusercontent.com/69948118/179429468-dcce2e4a-fbba-4d1e-84d3-863c7e3763d6.png)
![image](https://user-images.githubusercontent.com/69948118/179429491-36094518-f30f-4a63-a75e-00ad89e51519.png)
![image](https://user-images.githubusercontent.com/69948118/179429504-d5416029-06b6-457f-937a-0f370b9b43f1.png)


---
## Hibernate and JPA and Spring Data JPA
### How to store passwords safely in the database?
𝐓𝐡𝐢𝐧𝐠𝐬 𝐍𝐎𝐓 𝐭𝐨 𝐝𝐨
 - Storing passwords in plain text is not a good idea because anyone
with internal access can see them.
- Storing password hashes directly is not sufficient because it is
pruned to precomputation attacks, such as rainbow tables.
- To mitigate precomputation attacks, we salt the passwords.
𝐖𝐡𝐚𝐭 𝐢𝐬 𝐬𝐚𝐥𝐭?
According to OWASP guidelines, “a salt is a unique, randomly
generated string that is added to each password as part of the hashing
process”.
![image](https://github.com/user-attachments/assets/feee570f-22d4-4283-af16-3cffeddaa5b0)
![image](https://github.com/user-attachments/assets/8194c60d-329d-48b3-8d64-686946efc827)



### Resource/application.properties
```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/code_decodeDB
spring.datasource.username=root
spring.datasource.password=root

db.driver: com.mysql.jdbc.Driver

db.username: root
db.password: admin

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# Show or not log for each sql query
spring.jpa.show-sql = true

entitymanager.packagesToScan: com.example.demo
```
### HibernateDemo/src/main/java/com/example/demo/entities/Employee.java
```java
package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYEES")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
     
    @Column(name="first_name")
    private String firstName;
     
    @Column(name="last_name")
    private String lastName;
     
    @Column(name="email", nullable=false, length=200)
    private String email;
     
 
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}
```
### HibernateDemo/src/main/java/com/example/demo/controller/EmployeeController.java
```java
package com.example.demo.controller;


import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HibernateUtil;
import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
 
@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
	
	@Autowired
    EmployeeService service;
	
	@GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();
 
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/entityLifeCycle")
    public void showEntityLifeCycle() {
         service.showEntityLifeCycle();
 
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) 
                                                    throws Exception {
        Employee entity = service.getEmployeeById(id);
 
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)
                                                    throws Exception {
    	//here employee object will be in new state.
    	 Session session = HibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
		 
		//here employee object will be in new state hence its not in sesion / first level cache.
		 Boolean doesExist = session.contains(employee);
		 System.out.println(employee.getFirstName() + employee.getLastName()+ "exists status : " + doesExist);

		//here employee object will be in managed state as u can see query is fired.
    	 Employee employee2 = session.get(Employee.class, new Long(2));
    	 Boolean doesExistEmp2 = session.contains(employee2);
		 System.out.println(employee2.getFirstName() + employee2.getLastName()+ "exists status : " + doesExistEmp2);
		//after this its proved that employee object will be in managed state in the session.

		 //Query is not fired as sssion now has this object with id 2
		 Employee employee3 = session.get(Employee.class, new Long(2));
    	 Boolean doesExistEmp3 = session.contains(employee3);
		 System.out.println(employee3.getFirstName() + employee3.getLastName()+ "exists status : " + doesExistEmp3);
		
		 
//    	 System.out.println(employee2.getFirstName() + employee2.getLastName());
        Employee updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) 
                                                    throws Exception {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
	
}
```

### HibernateDemo/src/main/java/com/example/demo/service/EmployeeService.java
```java
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.HibernateUtil;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	
	 @Autowired
	 EmployeeRepo repository;
	 
	
	 
	 
	 public List<Employee> getAllEmployees()
	 {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();

		 Employee employee = session.get(Employee.class, new Long(2));
		 System.out.println(employee.getFirstName() + employee.getLastName());

		 List<Employee> employeeList = repository.findAll();

		 Employee employee1 = (Employee)session.get(Employee.class, new Long(2));
		 System.out.println(employee1.getFirstName() + employee1.getLastName());

		 if(employeeList.size() > 0) {
			 return employeeList;
		 } else {
			 return new ArrayList<Employee>();
		 }
	 }

	    public Employee getEmployeeById(Long id) throws Exception 
	    {
	        Optional<Employee> employee = repository.findById(id);
	         
	        if(employee.isPresent()) {
	            return employee.get();
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
	    }
	     
	    public Employee createOrUpdateEmployee(Employee entity) throws Exception 
	    {
	    	if(entity.getId() == null) {
	    		//It comes in managed state.
	    		entity = repository.save(entity);
	             
	            return entity;
	    	}
	    	//It comes in managed state.
	        Optional<Employee> employee = repository.findById(entity.getId());
	         
	        if(employee.isPresent()) 
	        {
	            Employee newEntity = employee.get();
	            newEntity.setEmail(entity.getEmail());
	            newEntity.setFirstName(entity.getFirstName());
	            newEntity.setLastName(entity.getLastName());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    } 
	     
	    public void deleteEmployeeById(Long id) throws Exception 
	    {
	        Optional<Employee> employee = repository.findById(id);
	         
	        if(employee.isPresent()) 
	        {
	            repository.deleteById(id);
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
	    }

		public void showEntityLifeCycle() {
			
			 Session session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();

			 Employee employee = session.get(Employee.class, new Long(2));
			 System.out.println(employee.getFirstName() + employee.getLastName());
			 
			 Boolean doesExist = session.contains(employee);
			 System.out.println(employee.getFirstName() + employee.getLastName()+ "exists status : " + doesExist);

			 //session cleared, it comes in detached state 
			 session.clear();
			 Boolean doesExistAfterCleared = session.contains(employee);
			 System.out.println(employee.getFirstName() + employee.getLastName()+ "exists status : " + doesExistAfterCleared);

			 //remove object it goes into removed state.
			 session.delete(employee);
			 Boolean doesExistAfterRemoved = session.contains(employee);
			 System.out.println(employee.getFirstName() + employee.getLastName()+ "exists status : " + doesExistAfterRemoved);
			 // this is the diff between JPA and hibernate -> hibernate allows us to remove even the detached entities.
		}

}
```

### HibernateDemo/src/main/java/com/example/demo/repositories/
```java
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;
 
 
//@Repository
public interface EmployeeRepo
        extends JpaRepository<Employee, Long> {
 
}

```
#### HibernateDemo/src/main/java/com/example/demo/HibernateUtil.java

```java
package com.example.demo;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Employee;

@Component
public class HibernateUtil {
	
	@Value("${db.driver}")
	private  String DRIVER;
 
	@Value("${spring.datasource.password}")
	private  String PASSWORD;
 
	@Value("${spring.datasource.url}")
	private  String URL;
 
	@Value("${spring.datasource.username}")
	private  String USERNAME;
 
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private  String DIALECT;
 
	@Value("${spring.jpa.show-sql}")
	private  String SHOW_SQL;
 
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private  String HBM2DDL_AUTO;
 
	@Value("${entitymanager.packagesToScan}")
	private  String PACKAGES_TO_SCAN;
 
	

    private static SessionFactory sessionFactory;
    
    public static  SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
    
    @PostConstruct
    public  void setSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, DRIVER);
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, DIALECT);

                settings.put(Environment.SHOW_SQL, SHOW_SQL);

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, HBM2DDL_AUTO);

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Employee.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

#### HibernateDemo/src/main/java/com/example/demo/DemoApplication.java
```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

```
---

## Microservices
### Exception handling between microservices

src : https://www.geeksforgeeks.org/spring-boot-exception-handling/

![image](https://user-images.githubusercontent.com/69948118/179457337-7f164af0-81be-4be1-a127-84adaee6ec07.png)
![image](https://user-images.githubusercontent.com/69948118/179457579-1eab1b28-8a10-4b43-9806-2b48b4b2f27b.png)
![image](https://user-images.githubusercontent.com/69948118/179458284-7d43a9cb-4ff8-426c-9c7c-39a574791287.png)
![image](https://user-images.githubusercontent.com/69948118/179458335-5e1f3b86-3688-4aa8-b790-5570c67e49b2.png)
![image](https://user-images.githubusercontent.com/69948118/179458437-80dbf9ec-85a3-445d-be6a-7ac2f78cee05.png)
![image](https://user-images.githubusercontent.com/69948118/179458484-38ab507c-3129-4266-a0ca-b47f9496636f.png)
![image](https://user-images.githubusercontent.com/69948118/179458817-8a203259-e98a-49fd-8576-0638872cef63.png)
![image](https://user-images.githubusercontent.com/69948118/179459221-03cf35cd-6ea3-49f0-a9af-d6bf486968a2.png)
![image](https://user-images.githubusercontent.com/69948118/179459401-80910b46-fa7d-46a3-826b-d7320a196f05.png)
![image](https://user-images.githubusercontent.com/69948118/179459994-29fa0d25-d8e4-477a-bad8-7f4929394987.png)
![image](https://user-images.githubusercontent.com/69948118/179461759-079808a8-053f-46b4-a272-6aadf3d8f40f.png)
![image](https://user-images.githubusercontent.com/69948118/179471549-24d02877-0a7e-4c26-8667-de0102e22ddf.png)

### Microservices Design Pattern

Src: https://medium.com/@madhukaudantha/microservice-architecture-and-design-patterns-for-microservices-e0e5013fd58a
src: https://microservices.io/patterns/decomposition/decompose-by-subdomain.html
![image](https://user-images.githubusercontent.com/69948118/182506406-96eda3d8-bab5-4f10-a1ac-130278a524fd.png)
![image](https://user-images.githubusercontent.com/69948118/182509521-b4072042-f2dd-4939-bb2a-061e6ebb51a5.png)

---
## SQL
-ACID properties in detail
![image](https://user-images.githubusercontent.com/69948118/181183661-50819086-a921-47c9-a2fa-20f43546d928.png)

![image](https://user-images.githubusercontent.com/69948118/179453761-5c1a407b-583b-451c-8dad-03d07c3fa446.png)
![image](https://user-images.githubusercontent.com/69948118/179453867-b6d042b7-4930-4437-972d-b14b83b38548.png)
![image](https://user-images.githubusercontent.com/69948118/179453881-5596e8ca-610e-472c-b73f-d563a63d9a99.png)
![image](https://user-images.githubusercontent.com/69948118/179453908-2dd9009e-647e-49c2-a9ae-32267e63dfb9.png)
![image](https://user-images.githubusercontent.com/69948118/179453942-3ac271b9-54ed-4079-aead-c46e89c1bad9.png)
![image](https://user-images.githubusercontent.com/69948118/179454726-92b1b72b-fe3d-46eb-9e88-c7762d0026c1.png)
![image](https://user-images.githubusercontent.com/69948118/179454981-a2cf96a0-aabf-431b-acad-4a5e07f088dc.png)
![image](https://user-images.githubusercontent.com/69948118/179455247-0b64d84d-e7cb-4f5c-bc1b-3ac6c3354660.png)

---
## Lombok
![image](https://user-images.githubusercontent.com/69948118/178953736-1f8fb9d8-642d-4621-b5af-29672a67a575.png)
![image](https://user-images.githubusercontent.com/69948118/178953780-e2df34b6-35cd-4b4b-9164-363f77511785.png)

---
## GIT
- src : https://www.youtube.com/watch?v=N05ksTiyu8w&list=PLyHJZXNdCXscpl6pxOnL2lRWJlzvzjyZE&index=2
- create organization on github
- ![image](https://user-images.githubusercontent.com/69948118/179345056-c127448b-d096-49c9-bb5a-a4ebba4ee3d7.png)
![image](https://user-images.githubusercontent.com/69948118/179345182-fac036c6-b085-4383-b5d9-410dd71f5b40.png)
![image](https://user-images.githubusercontent.com/69948118/179345193-70c0f5a2-2fae-4f31-9a14-d6c1434e8195.png)
![image](https://user-images.githubusercontent.com/69948118/179345273-7d763dd7-e95d-4475-b9e0-e0858700883c.png)
![image](https://user-images.githubusercontent.com/69948118/179345330-40df8bc5-9627-4e51-b3f1-ca06b5fae0f6.png)
![image](https://user-images.githubusercontent.com/69948118/179345370-32aa5973-c3b6-4c80-9651-00189d1dff4a.png)
![image](https://user-images.githubusercontent.com/69948118/179345401-534c8f27-20ef-4dd9-8751-39364caf3b7b.png)
![image](https://user-images.githubusercontent.com/69948118/179345417-fa94ffa3-ecdf-45cb-ac5a-ceb52e30f3b3.png)
![image](https://user-images.githubusercontent.com/69948118/179345424-d9643b6c-39d6-463f-8e16-8cf02a79dfc6.png)
![image](https://user-images.githubusercontent.com/69948118/179345436-b238ef89-0e21-433a-8950-4e02ce9b121e.png)
![image](https://user-images.githubusercontent.com/69948118/179345526-808a1808-b324-43ac-9412-ac3087f9a184.png)
![image](https://user-images.githubusercontent.com/69948118/179345919-09589d2f-c2d4-45b7-933d-5fda78b23bee.png)
![image](https://user-images.githubusercontent.com/69948118/179346017-fa0ef0e9-730e-4e2a-9339-77890f6a5fc1.png)
- Fork by user
![image](https://user-images.githubusercontent.com/69948118/179346124-7c112bab-690c-49b1-afbf-b0e695ee5b21.png)
![image](https://user-images.githubusercontent.com/69948118/179346173-1eaba3eb-a81a-4308-9d4a-90fa3ece0a6d.png)
![image](https://user-images.githubusercontent.com/69948118/179346402-0ffe34aa-772a-4c05-a45f-e14cb801fe01.png)

![image](https://user-images.githubusercontent.com/69948118/179346506-12134d0f-8df2-468a-b698-9c9900eaab65.png)
![image](https://user-images.githubusercontent.com/69948118/179346531-deb8ceb6-721a-4000-b1c1-b3e51c1583bb.png)
![image](https://user-images.githubusercontent.com/69948118/179348742-79f37d2b-ffec-497e-9519-7f0e29926c0e.png)

----
## Maven
- Maven  scopes exist?
![image](https://user-images.githubusercontent.com/69948118/218309750-747211f3-78f3-4f7d-9d80-65558d3fbbbc.png)
![image](https://user-images.githubusercontent.com/69948118/220229850-3c630b22-4100-4ba9-a0aa-254256339805.png)

----
## clean-code-tips
- use descriptive names for variables, functions, and classes to make the code more self-explanatory.
- write comments to explain what the code does and why it is written that way.
- follow coding best practices, such as don't repeat yourself (dry) and keep it simple, stupid (kiss).
- practice code indentation to make it easier to read.
- use functions and variables with a clear purpose and avoid functions that do too many things. keep it simple!
- keep the codebase wellorganized and avoid clutter or confusing folder structures.
- avoid hardcoding values and use constants or variables instead.
- use meaningful error messages that explain the issue and potential solutions.
 
     
### Code review

 - Code structure and organization: Check that the code is structured in a logical and organized manner. This includes checking that the code is modular, follows the SOLID principles, and that the naming conventions are consistent.

 - Code readability: Check that the code is easy to read and understand. This includes checking that the code is well-documented, that the comments are clear and informative, and that the code is formatted consistently.

 - Code quality: Check that the code is of high quality. This includes checking that the code follows best practices, that the code is efficient, and that it is optimized for performance.

 - Error handling: Check that the code handles errors and exceptions properly. This includes checking that the code uses try-catch blocks appropriately, that error messages are clear and informative, and that the code can recover gracefully from errors.

 - Security: Check that the code is secure. This includes checking that the code does not contain any vulnerabilities, that it is protected against attacks such as SQL injection, and that sensitive information is encrypted and protected.

 - sting: Check that the code is well-tested. This includes checking that the code has unit tests that cover all code paths, that the tests are comprehensive, and that they provide good coverage.

 - Code reuse: Check that the code is designed for reuse. This includes checking that the code is modular and can be easily integrated into other projects.

 - Performance: Check that the code is optimized for performance. This includes checking that the code does not contain any performance bottlenecks, that it uses efficient algorithms and data structures, and that it is designed to scale.

---
## Design
### DDD BDD TDD	
- **Domain-driven design (DDD)** is an approach to software development that focuses on building software that models the domain and business requirements of the application. DDD emphasizes the importance of understanding the business context and creating a shared language and model between the business and technical teams. This approach typically involves identifying and defining domain entities, aggregates, and bounded contexts, and developing the software in a way that aligns with these concepts.

- **Behavior-driven development (BDD)** is an extension of test-driven development (TDD) that emphasizes the behavior and interactions of the application with its stakeholders. BDD encourages collaboration between developers, testers, and business stakeholders to define the requirements and behaviors of the application using plain language scenarios. BDD tests are typically written in a Gherkin syntax that describes the expected behavior of the application from a user or stakeholder perspective.

- **Test-driven development (TDD)** is an approach to software development that emphasizes writing automated tests before writing the actual code. In TDD, developers write a failing test first, then write the code necessary to pass the test, and finally refactor the code to improve its design and maintainability. This approach encourages developers to focus on the behavior and requirements of the application and ensures that the code is thoroughly tested.

### java-design-best-practices-guide
#### DRY (Don't repeat yourself) and KISS (Keep it simple)
#### Top 8 Signs of Bad Unit Testcases (https://howtodoinjava.com/best-practices/8-signs-of-bad-unit-test-cases/)
   - 1) Test passes but not testing the actual feature
   - 2) Testing irrelevant things
   - 3) Testing multiple things in assertions
   - 4) Test accessing the testee using reflexion
   - 5) Tests swalloing exceptions
   - 6) Test which depends on excessive setup
   - 7) Test compatible to only developer machine
   - 8) Test filling log files with load of texts
#### SOLID Principles in Java (https://howtodoinjava.com/best-practices/solid-principles/)
- SOLID principles JD?
- https://www.educative.io/answers/what-are-the-solid-principles-in-java
    - 1. Introduction
	    ![image](https://user-images.githubusercontent.com/69948118/222891166-b316e6b9-e234-4a93-860a-96f90ef0a4f9.png)
  - 2. Single Responsibility Principle [SRP]
    - “One class should have one and only one responsibility”
    - An example of a Java class that does not follow the single responsibility principle (SRP)
```java
	    public class Vehicle {
    public void printDetails() {}
    public double calculateValue() {}
    public void addVehicleToDB() {}
}
```
	     - The Vehicle class has three separate responsibilities: reporting, calculation, and database. By applying SRP, we can separate the above class into three classes with separate responsibilities.
   - 3. Open-Closed Principle
        - “Software components (e.g., classes, modules, functions) should be open for extension, but closed for modification”
        - Doesn't follow 
```java
public class VehicleCalculations {
    public double calculateValue(Vehicle v) {
        if (v instanceof Car) {
            return v.getValue() * 0.8;
        if (v instanceof Bike) {
            return v.getValue() * 0.5;

    }
}
```
  - Suppose we now want to add another subclass called Truck. We would have to modify the above class by adding another if statement, which goes against the Open-Closed Principle.
 - A better approach would be for the subclasses Car and Truck to override the calculateValue method:
```java
public class Vehicle {
    public double calculateValue() {...}
}
public class Car extends Vehicle {
    public double calculateValue() {
        return this.getValue() * 0.8;
}
public class Truck extends Vehicle{
    public double calculateValue() {
        return this.getValue() * 0.9;
}
```
 - 4. Liskov’s Substitution Principle
	    - “Derived types must be completely substitutable for their base types”
 - 5. Interface Segregation Principle
   - “Clients should not be forced to implement unnecessary methods which they will not use”
```java
public interface Vehicle {
    public void drive();
    public void stop();
    public void refuel();
    public void openDoors();
}
public class Bike implements Vehicle {

    // Can be implemented
    public void drive() {...}
    public void stop() {...}
    public void refuel() {...}
    
    // Can not be implemented
    public void openDoors() {...}
}
```
- 6. Dependency Inversion Principle
    - “Depend on abstractions, not on concretions”

#### Unit Testing Best Practices  
   - 2.1. Test only one code unit at a time
   - 2.2. Do not make unnecessary assertions
   - 2.3. Do not write dependent tests
   - 2.4. Mock out all external services and state
   - 2.5. Do not test configurations
   - 2.6. Name your unit tests clearly and consistently
   - 2.7. Write tests for methods that have the fewest dependencies first, and work your way up
   - 2.8. All methods, regardless of visibility, should have appropriate unit tests
   - 2.9. Aim for each unit test method to perform exactly one assertion
   - 2.10. Create tests that target error cases
   - 2.11. Use the most appropriate assertion methods
   - 2.12. Put assertion parameters in the proper order
   - 2.13. Ensure that the test code is separated from the production code
   - 2.14. Do not print anything out in unit tests
   - 2.15. Do not use static members in a test class. If you have used then re-initialize it for each test case
   - 2.16. Do not write catch blocks that exist only to fail a test
   - 2.17. Do not rely on indirect testing
   - 2.18. Integrate tests with build script
   - 2.19. Do not skip unit tests
   - 2.20. Consider creating HTML Reports
	    
	    
#### Top 20 Java Exception Handling Best Practices 
- https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/


 
#### A new approach for exception handling
 - Let’s solve the above problem with inner classes where we will create one class per use-case, and then group them inside DBException class.
```java
// Make this class abstract so that developers are forced to create
// suitable exception types only
public abstract class BaseException extends Exception{
  //Each exception message will be held here
  private String message;
 
  public BaseException(String msg)
  {
    this.message = msg;
  }
  //Message can be retrieved using this accessor method
  public String getMessage() {
    return message;
  }
}	    

public class DBExeption
{
  //SQL execution error
  public static class BadExecution extends BaseException
  {
    private static final long serialVersionUID = 3555714415375055302L;
    public BadExecution(String msg) {
      super(msg);
    }
  }
 
  //No data exist where we expect at least one row
  public static class NoData extends BaseException
  {
    private static final long serialVersionUID = 8777415230393628334L;
    public NoData(String msg) {
      super(msg);
    }
  }
 
  //Multiple rows exist where we expect only single row
  public static class MoreData extends BaseException
  {
    private static final long serialVersionUID = -3987707665150073980L;
    public MoreData(String msg) {
      super(msg);
    }
  }
 
  //Invalid parameters error
  public static class InvalidParam extends BaseException
  {
    private static final long serialVersionUID = 4235225697094262603L;
    public InvalidParam(String msg) {
      super(msg);
    }
  }
}

public class TestExceptions {
  public static void main(String[] args)
  {
    try
    {
      throw new DBExeption.NoData("No row found for id : x");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
	    
```
#### Guide to ExecutorService in Java
 ![image](https://user-images.githubusercontent.com/69948118/222895863-28c588f6-d671-4ba7-8e54-fc7138a69564.png)

### Java Design Patterns

- Inversion of Control (IoC): This pattern is used throughout the Spring Framework to decouple the application code from the framework and its components. The IoC container is responsible for managing the lifecycle of beans and injecting dependencies between them.
- Singleton: A singleton pattern is used to ensure that there is only one instance of a bean created in the Spring IoC container. The singleton pattern is used to create a single instance of a class, which is shared across the entire application.
- Factory: The factory pattern is used in Spring to create objects of different classes based on the configuration. Spring provides a factory pattern to create beans, which is based on the factory method design pattern.
- Template Method: The template method pattern is used in Spring to provide a common structure for different types of operations. Spring provides several template classes such as JdbcTemplate, Hibernate Template, etc. that provide a common structure for performing database operations.
- Decorator: The decorator pattern is used in Spring to add additional functionality to existing beans. The Spring AOP (Aspect-Oriented Programming) module uses the decorator pattern to add additional functionality to existing beans through the use of proxies.
- Observer: The observer pattern is used in Spring to notify other beans of changes to the state of a bean. Spring provides the ApplicationEvent and ApplicationListener interfaces, which can be used to implement the observer pattern.
- Command: The command pattern is used in Spring to encapsulate the execution of a particular piece of code in a command object. This pattern is used in Spring to create reusable and testable code.
- Façade: The façade pattern is used in Spring to simplify the interface of a complex system. The Spring Framework uses the façade pattern to provide a simplified interface for interacting with its components.
These are just a few examples of the design patterns used in Spring, there are many more. Spring framework makes use of these patterns to provide a consistent and simple way to build applications, making it easier to manage complex systems.

- Project related Design Patterns
![image](https://user-images.githubusercontent.com/69948118/178937269-51cd5ae1-c7b3-454e-a78b-43d9c54928c4.png)
![image](https://user-images.githubusercontent.com/69948118/178938571-783a5a40-0e3c-426c-8de1-39defcd1fa94.png)
![image](https://user-images.githubusercontent.com/69948118/178941143-68bcd295-7505-400d-ba17-859eb1934e6a.png)
- Abstract Factory
![image](https://user-images.githubusercontent.com/69948118/178855857-eb20ef2d-0597-40ea-ba0d-f3ad8481b8fa.png)

![image](https://user-images.githubusercontent.com/69948118/178953018-85bc1fd5-24b5-4feb-97eb-adaca49dcad3.png)

- How to prevent Singleton Pattern from Reflection, Serialization and Cloning?
https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/

### Multi-tenant architecture
Multi-tenancy is an architectural pattern where a single instance of a software application serves multiple tenants. A tenant is a group of users who share a common access to the same instance of the application but have their own isolated data and configuration. Multi-tenancy is commonly used in software as a service (SaaS) applications, cloud computing, and enterprise systems where different customers or user groups need to use the same application while keeping their data and configurations separate.

Here are key characteristics and components of multi-tenant architecture:

1. **Tenant Isolation:**
   - Each tenant's data and configuration are logically isolated from other tenants. Tenants are unaware of each other, and their activities do not impact each other.

2. **Single Software Instance:**
   - There is a single instance of the software application running on the server, and it is shared among multiple tenants. This reduces operational overhead compared to maintaining separate instances for each tenant.

3. **Shared Resources:**
   - Resources such as codebase, databases, infrastructure, and services are shared among multiple tenants. This allows for more efficient resource utilization.

4. **Configurable and Customizable:**
   - The multi-tenant application is designed to be configurable and customizable to accommodate the specific needs and preferences of each tenant. Customization options may include branding, workflows, and user interfaces.

5. **Tenant Identification:**
   - The application must be able to identify and authenticate tenants. This can be done through various mechanisms, such as subdomains, separate URLs, or headers in the HTTP requests.

6. **Data Isolation:**
   - Tenants have their own dedicated database schema or data partition, ensuring that their data is separate from other tenants. This prevents accidental data leakage between tenants.

7. **Scaling:**
   - Multi-tenant architectures should be designed to scale horizontally to handle the increasing number of tenants and the associated workload. This involves scaling both the application layer and the underlying infrastructure.

8. **Security:**
   - Security measures must be in place to prevent unauthorized access to a tenant's data and to ensure that tenants cannot interfere with each other's operations.

9. **Upgrade and Maintenance:**
   - Upgrades and maintenance activities need to be performed without disrupting the services for other tenants. Careful planning and execution are required to maintain high availability.

10. **Elasticity and Efficiency:**
    - Multi-tenancy enables efficient resource utilization, as resources are shared among tenants. It also allows for elasticity, where resources can be dynamically allocated based on the varying needs of tenants.

Multi-tenant architecture provides cost savings, efficient resource utilization, and easier management for SaaS providers. However, it requires careful design and implementation to address challenges related to data isolation, security, and customization for different tenants.


---
	
### Java Coding Best Practices	    
#### Serializable interface guide
  - We all know what Serializable interface does. But do we really know, what changes in your class can break your design?
  - https://howtodoinjava.com/java/serialization/java-serialization/
#### Object initialization best practices
  - Creating new objects is always an expensive process. Let’s learn how java utilize object pooling to solve this problem.
  - all wrapper classes provide instance pooling.
  - IntegerCache
  - java.lang.Boolean store two inbuilt instances TRUE and FALSE, and return their reference if new keyword is not used.
  - java.lang.Character has a cache for chars between unicodes 0 and 127 (ascii-7 / us-ascii).
  - java.lang.Long has a cache for long between -128 to +127.
#### How to make a java class immutable
#### Consider reloading log4j levels on runtime
 - Learn how to use WatchService to reload your logging configuration at runtime. Use them to reload other configurations as well.
#### Override toString() effectively with ToStringBuilder
 - ToStringBuilder is a utility class provided by apache commons lang library. Learn to use it to write highly customized toString() methods.

#### Java Performance Best Practices 
	- (https://howtodoinjava.com/tag/performance/)
#### Performance comparison of different ways to iterate over HashMap
#### JDBC Performance Optimization Tips [https://howtodoinjava.com/java/jdbc/best-practices-to-improve-jdbc-performance/]
	    
### code-refactoring
- https://github.com/jdbirla/JD_Clean_Code_with_Java/blob/master/README.md

---	    

## java-performance
	
### Why is my Java program so slow? The reasons of performance issues in Java
  - Databases : query 
  - Caching
  - Memory : memory leak
### 8 proven ways to improve Java performance
  - 1. Use the latest version of Java
  - 2. Avoid writing long methods
  - 3. If-else statements optimization
  - 4. Use primitive data types as often as possible
  - 5. Use PreparedStatement instead of the Statement
  - 6. Optimize only when necessary
  - 7. Use profilers to identify bottlenecks : JProfiler / Java VisualVM
  - 8. Logging
### Best Java performance monitoring tools
	- Popular tools include Glowroot, Pinpoint, JavaMelody, Scouter, Stagemonitor or MoSKito.

### Medium
- https://medium.com/@ddwen/6-techniques-for-java-performance-optimization-c6d853d24e6d
#### Reuse Optimization
   - lot of repetitive code can be extracted and made into public methods
   - buffering and caching
   - Similarly, object pooling operations, such as database connection pools, thread pools, etc., are used frequently in Java.
#### Computational optimization
   ##### 1. Parallel execution
  - The first mode is multimachine, which uses load balancing to split traffic
  - The second mode uses multiple processes For example, Nginx adopts the NIO programming model
  - The third mode uses multithreading, which is also the most exposed to Java programmers.
    ##### 2. Synchronous to asynchronous
    ##### 3. Lazy loading
	
#### Result set optimization
#### Resource conflict optimization
#### Algorithm optimization
#### JVM optimization

### GFG
- 12 Tips to Optimize Java Code Performance
  - 1. Avoid Writing Long Methods
 - 2. Avoid Multiple If-else Statements
 - 3. Avoid Getting the Size of the Collection in the Loop  : While iterating through any collection get the size of the collection beforehand and never get it during iteration
 - 4. Avoid Using String Objects For Concatenation
 - 5. Use Primitive Types Wherever Possible
 - 6. Avoid Using BigDecimal Class
 - 7. Avoid Creating Big Objects Often : DB connection objects or system configuration objects or session objects for the user after login. : use singleton
 - 8. Use Stored Procedures Instead of Queries
 - 9. Using PreparedStatement instead of Statement
 - 10. Use of Unnecessary Log Statements and Incorrect Log Levels
 - 11. Select Required Columns in a Query
 - 12. Fetch the Data Using Joins

### Memory Leak
A memory leak in Java occurs when objects are no longer needed by a program, but the Java Virtual Machine (JVM) fails to reclaim their memory. This can lead to a gradual increase in memory usage over time, which may eventually result in an OutOfMemoryError.

##### Causes of Memory Leaks:

1. **Unused References:**
   - Objects that are no longer needed still have references, preventing them from being garbage collected.
   - Examples include not releasing resources (closing files, database connections) or holding references in long-lived data structures.

2. **Circular References:**
   - A circular reference occurs when a group of objects reference each other, forming a cycle.
   - If there are no external references to this group, they will not be garbage collected.

##### How to Prevent Memory Leaks:

1. **Release Resources:**
   - Explicitly release resources like file handles, database connections, and network sockets using `close` or `try-with-resources` constructs.

2. **Clear References:**
   - Set object references to `null` when they are no longer needed, allowing the garbage collector to reclaim memory.

3. **Use Weak References:**
   - In situations where you want an object to be eligible for garbage collection even if there are references to it, consider using `WeakReference` or `SoftReference`.

##### Identifying Memory Leaks:

1. **Memory Profilers:**
   - Tools like VisualVM, YourKit, or Eclipse Memory Analyzer can help identify memory leaks.
   - Profilers provide insights into memory usage, object allocations, and help identify objects preventing garbage collection.

2. **Heap Dumps:**
   - Generate heap dumps using tools like jmap or -XX:+HeapDumpOnOutOfMemoryError.
   - Analyze heap dumps to identify objects and their references.

##### Fixing Memory Leaks:

1. **Analyze Code:**
   - Review your code and identify areas where resources are not being released or where circular references may occur.

2. **Use try-with-resources:**
   - Always use `try-with-resources` for managing resources that implement `AutoCloseable` or `Closeable`.

3. **Clear References:**
   - Set object references to `null` when they are no longer needed.

##### Example:

Consider a simple example where a resource (like a file reader) is not closed properly, leading to a potential memory leak.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    public String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        // Resource not properly closed, potential memory leak
        return content.toString();
    }

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        try {
            String content = fileProcessor.readFile("example.txt");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, the `BufferedReader` is not closed explicitly, which can lead to a memory leak. To fix this, you should close the resource using `try-with-resources`:

```java
try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    // Process file content
} catch (IOException e) {
    e.printStackTrace();
}
```

---
## DSA
### Java Collection Complexity

- Below are the Big O performance of common functions of different Java Collections.

List                 | Add  | Remove | Get  | Contains | Next | Data Structure
---------------------|------|--------|------|----------|------|---------------
ArrayList            | O(1) |  O(n)  | O(1) |   O(n)   | O(1) | Array
LinkedList           | O(1) |  O(1)  | O(n) |   O(n)   | O(1) | Linked List
CopyOnWriteArrayList | O(n) |  O(n)  | O(1) |   O(n)   | O(1) | Array



Set                   |    Add   |  Remove  | Contains |   Next   | Size | Data Structure
----------------------|----------|----------|----------|----------|------|-------------------------
HashSet               | O(1)     | O(1)     | O(1)     | O(h/n)   | O(1) | Hash Table
LinkedHashSet         | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Hash Table + Linked List
EnumSet               | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Bit Vector
TreeSet               | O(log n) | O(log n) | O(log n) | O(log n) | O(1) | Red-black tree
CopyOnWriteArraySet   | O(n)     | O(n)     | O(n)     | O(1)     | O(1) | Array
ConcurrentSkipListSet | O(log n) | O(log n) | O(log n) | O(1)     | O(n) | Skip List



Queue                   |  Offer   | Peak |   Poll   | Remove | Size | Data Structure
------------------------|----------|------|----------|--------|------|---------------
PriorityQueue           | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedList              | O(1)     | O(1) | O(1)     |  O(1)  | O(1) | Array
ArrayDequeue            | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List
ConcurrentLinkedQueue   | O(1)     | O(1) | O(1)     |  O(n)  | O(n) | Linked List
ArrayBlockingQueue      | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Array
PriorirityBlockingQueue | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
SynchronousQueue        | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | None!
DelayQueue              | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedBlockingQueue     | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List


Map                   |   Get    | ContainsKey |   Next   | Data Structure
----------------------|----------|-------------|----------|-------------------------
HashMap               | O(1)     |   O(1)      | O(h / n) | Hash Table
LinkedHashMap         | O(1)     |   O(1)      | O(1)     | Hash Table + Linked List
IdentityHashMap       | O(1)     |   O(1)      | O(h / n) | Array
WeakHashMap           | O(1)     |   O(1)      | O(h / n) | Hash Table
EnumMap               | O(1)     |   O(1)      | O(1)     | Array
TreeMap               | O(log n) |   O(log n)  | O(log n) | Red-black tree
ConcurrentHashMap     | O(1)     |   O(1)      | O(h / n) | Hash Tables
ConcurrentSkipListMap | O(log n) |   O(log n)  | O(1)     | Skip List

---

---
## bydefault
#### Java


#### Spring
- Default scope : singleton
- When a bean is declared as a singleton, Spring creates an instance of the bean when the application context is first started up
- Lazy:By default the spring always create object of beans as eager when it start but if don't want to create object on startup then we can use @lazy and spring will create object when we use that object
- Singleton Beans with Prototype-bean Dependencies : A common problem arises when we want to inject a prototype-scoped bean into a singleton-scoped bean. In this case, as the singleton bean is initialized only once per application context, we need to apply extra logic to initialize the prototype-scoped bean so that it is created every time. This problem is known as the scoped bean injection problem.
- https://howtodoinjava.com/spring-core/scoped-bean-injection-problem/
#### SprinBoot
- Spring boot by default uses logback, so to customize its behavior, all we need to add logback.xml in classpath and define customization over the file.

#### Hibernate
- By default, Hibernate uses lazy loading for `OneToMany` and `ManyToMany` 
-  By default, eager loading for `ManyToOne` and `OneToOne`



