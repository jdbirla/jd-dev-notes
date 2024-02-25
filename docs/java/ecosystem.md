# Java
Java is a popular general purpose programming language. 

## Installation
Easy way to install Java is using [SDKMAN](https://sdkman.io/)
- The Software Development Kit Manager
Meet SDKMAN! – your reliable companion for effortlessly managing multiple Software Development Kits on Unix systems. Imagine having different versions of SDKs and needing a stress-free way to switch between them. SDKMAN! steps in with its easy-to-use Command Line Interface (CLI) and API. Formerly known as GVM, the Groovy enVironment Manager, SDKMAN! draws inspiration from familiar tools like apt, pip, RVM, and rbenv and even Git. Think of it as your helpful toolkit friend, ready to streamline SDK management for you. 🛠️
``` bash
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk version
$ sdk list java
$ sdk install java 11.0.2-open
```

## IDEs
- [Intellij IDEA](https://www.jetbrains.com/idea/)
- [Eclipse](https://www.eclipse.org/downloads/packages/)
- [Spring Tool Suite](https://spring.io/tools/sts/all)
- [NetBeans](https://netbeans.org/)

## Java Libraries and Tools
- [Lombok](https://projectlombok.org/)
   - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
- [AutoValue](https://github.com/google/auto/blob/master/value/userguide/index.md)
    - https://www.baeldung.com/introduction-to-autovalue
    - Value classes are extremely common in Java projects. These are classes for which you want to treat any two instances with suitably equal field values as interchangeable. That's right: we're talking about those classes where you wind up implementing equals, hashCode and toString in a bloated, repetitive, formulaic yet error-prone fashion.
    - AutoValue is a source code generator for Java, and more specifically it’s a library for generating source code for value objects or value-typed objects.
In order to generate a value-type object all you have to do is to annotate an abstract class with the @AutoValue annotation and compile your class. What is generated is a value object with accessor methods, parameterized constructor, properly overridden toString(), equals(Object) and hashCode() methods.
- [Immutable objects](https://immutables.github.io/immutable.html)
    - Java annotation processors to generate simple, safe and consistent value objects. Do not repeat yourself, try Immutables, the most comprehensive tool in this field!
- [Jasypt](http://www.jasypt.org/)
    - Jasypt is a Java library which allows developers to add basic encryption capabilities to projects with minimum effort, and without the need of having an in-depth knowledge about implementation details of encryption protocols.
    - https://www.baeldung.com/jasypt
- [JJwt](https://github.com/jwtk/jjwt)
    - JJWT aims to be the easiest to use and understand library for creating and verifying JSON Web Tokens (JWTs) and JSON Web Keys (JWKs) on the JVM and Android.
    - https://www.baeldung.com/java-json-web-tokens-jjwt
- [Jackson JSON](https://github.com/FasterXML/jackson)
    - Jackson has been known as "the Java JSON library" or "the best JSON parser for Java". Or simply as "JSON for Java".
    - https://www.baeldung.com/jackson
- [Vavr](http://www.vavr.io/)
    - Vavr is a functional library for Java 8+ that provides immutable data types and functional control structures.
    - https://github.com/vavr-io/vavr
    - https://www.baeldung.com/vavr
    - https://docs.vavr.io/
- [FF4j](https://ff4j.github.io/)
    - FEATURE FLAGS FOR JAVA MADE EASY
    - Enable. and disable features at runtime - no deployments. In your code implement multiple paths protected by dynamic predicates (if/then/else).
    - Enable features not only with flag values but also drive access with roles and groups (Canary Release). Different frameworks supported starting by Spring Security.
- [Failsafe](https://github.com/jhalterman/failsafe)
   - Failsafe is a lightweight, zero-dependency library for handling failures in Java 8+, with a concise API for handling everyday use cases and the flexibility to handle everything else. It works by wrapping executable logic with one or more resilience policies, which can be combined and composed as needed.
   - Policies include Retry, CircuitBreaker, RateLimiter, Timeout, Bulkhead, and Fallback. Additional modules include OkHttp and Retrofit.
- [Retry4j](https://github.com/elennick/retry4j)
    - Retry4j is no longer maintained and has had no releases for several years. Please feel free to fork and make your own changes/releases if you want to build upon it. Also consider checking out more modern libraries such as:
    - Failsafe - https://github.com/jhalterman/failsafe
    - Spring Retry - https://github.com/spring-projects/spring-retry
    - resilience4j - https://github.com/resilience4j/resilience4j
- [Twitter4j](http://twitter4j.org/en/)
    - https://www.baeldung.com/twitter4j
    - Twitter4J is an open source Java library, which provides a convenient API for accessing the Twitter API. 
    - Simply put, here’s how we can interact with the Twitter API; we can:
    - Post a tweet
    - Get timeline of a user, with a list of latest tweets
    - Send and receive direct messages
    - Search for tweets and much more
    - This library ensures that we can easily do these operations, and it also ensures the security and privacy of a user – for which we naturally need to have OAuth credentials configured in our app.
- [JooQ](https://www.jooq.org/)
    - Great Reasons for Using jOOQ Our customers spend most time on their business-logic. Because jOOQ takes care of all their Java/SQL infrastructure problems.
    - https://www.baeldung.com/jooq-intro
    -  jOOQ (Java Object Orientated Query). This library generates Java classes based on the database tables and lets us create type-safe SQL queries through its fluent API.
- [FlexyPool](https://github.com/vladmihalcea/flexy-pool)
    - The FlexyPool library adds metrics and flexible strategies to a given Connection Pool, allowing it to resize on demand. This is very handy since most connection pools offer a limited set of dynamic configuration strategies.
    - https://www.baeldung.com/spring-flexypool-guide
    - In this tutorial, we’ll learn how to use FlexyPool with Spring Boot and H2 using HikariCP. It’s a powerful connection pool manager built on top of major connection pools.
- [Resilience4j](https://github.com/resilience4j/resilience4j)
   - Resilience4j is a lightweight fault tolerance library designed for functional programming. Resilience4j provides higher-order functions (decorators) to enhance any functional interface, lambda expression or method reference with a Circuit Breaker, Rate Limiter, Retry or Bulkhead. You can stack more than one decorator on any functional interface, lambda expression or method reference. The advantage is that you have the choice to select the decorators you need and nothing else.
- [Zalando/problem-spring-web](https://github.com/zalando/problem-spring-web)
    - https://www.baeldung.com/problem-spring-web
    - In this tutorial, we’re going to explore how to produce application/problem+json responses using the Problem Spring Web library. This library helps us to avoid repetitive tasks related to error handling.
   - By integrating Problem Spring Web into our Spring Boot application, we can simplify the way we handle exceptions within our project and generate responses accordingly.
- [SpringFox](http://springfox.github.io/springfox/)
    - Automated JSON API documentation for API's built with Spring
     - https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- [eclipse-collections](https://github.com/eclipse/eclipse-collections)
    - Eclipse Collections is a comprehensive collections library for Java. The library enables productivity and performance by delivering an expressive and efficient set of APIs and types. The iteration protocol was inspired by the Smalltalk collection framework, and the collections are compatible with the Java Collection Framework types.
    - Eclipse Collections is compatible with Java 8+. Eclipse Collections is a part of the OpenJDK Quality Outreach program, and it is validated for different versions of the OpenJDK.
- [RecordBuilder](https://github.com/Randgalt/record-builder)
    - Java 16 introduces Records. While this version of records is fantastic, it's currently missing some important features normally found in data classes: a builder and "with"ers. This project is an annotation processor that creates:
       a companion builder class for Java records an interface that adds "with" copy methods an annotation that generates a Java record from an Interface template
- [MapStruct ](https://mapstruct.org/)
   - MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach. 
   - The generated mapping code uses plain method invocations and thus is fast, type-safe and easy to understand.
- [hypersistence-utils](https://github.com/vladmihalcea/hypersistence-utils)
    - The Hypersistence Utils project gives you general-purpose utilities for both Spring and Hibernate.
    - The main advantage of this project is that it supports a broad range of Hibernate versions, spanning from Hibernate ORM 6.4, 6.3 to 6.2, 6.1, 6.0, 5.6, 5.5, 5.4, 5.3, and Hibernate 5.2.
- [high-performance-java-persistence](https://github.com/vladmihalcea/high-performance-java-persistence)
    - The High-Performance Java Persistence book and video course code examples. I wrote this article about this repository since it's one of the best way to test JDBC, JPA, Hibernate or even jOOQ code. Or, if you prefer videos, you can watch this presentation on YouTube.
- [ArchUnit ](https://www.archunit.org/)
   - ArchUnit is a free, simple and extensible library for checking the architecture of your Java code using any plain Java unit test framework. That is, ArchUnit can check dependencies between packages and classes, layers and slices, check for cyclic dependencies and more. It does so by analyzing given Java bytecode, importing all classes into a Java code structure. You can find examples for the current release at ArchUnit Examples and the sources on GitHub.
   - https://www.baeldung.com/java-archunit-intro
- 
### Testing
- [JUnit 5 Docs](https://junit.org/junit5/docs/current/user-guide/)
   - JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
- [REST Assured](https://github.com/rest-assured/rest-assured/wiki/Usage)
    - https://rest-assured.io/
    - https://www.baeldung.com/rest-assured-tutorial
    - REST-assured was designed to simplify the testing and validation of REST APIs and is highly influenced by testing techniques used in dynamic languages such as Ruby and Groovy.
   - The library has solid support for HTTP, starting of course with the verbs and standard HTTP operations, but also going well beyond these basics.
   - In this guide, we are going to explore REST-assured and we’re going to use Hamcrest to do assertion. If you are not already familiar with Hamcrest, you should first brush up with the tutorial: Testing with Hamcrest.
- [Mock Server](http://www.mock-server.com/)
    - https://www.baeldung.com/mockserver
    - MockServer is a tool for mocking/stubbing external HTTP APIs.
- [TestContainers](https://www.testcontainers.org/)
   - https://www.baeldung.com/docker-test-containers
   - In this tutorial, we’ll be looking at Java TestContainers library. It allows us to use Docker containers within our tests. As a result, we can write self-contained integration tests that depend on external resources.
   - We can use any resource in our tests that have a docker image. For example, there are images for databases, web browsers, web servers, and message queues. Therefore, we can run them as containers within our tests.
- [Mockito](https://site.mockito.org/)
    - https://www.baeldung.com/mockito-series
- [Assertj](http://joel-costigliola.github.io/assertj/)
  - https://www.baeldung.com/introduction-to-assertj
  - In this article we will be exploring AssertJ – an opensource community-driven library used for writing fluent and rich assertions in Java tests.
   - This article focuses on tools available in the basic AssertJ module called AssertJ-core.
- [Awaitility](https://github.com/awaitility/awaitility)
    - http://www.awaitility.org/
    - https://www.baeldung.com/awaitility-testing
    - A common problem with asynchronous systems is that it’s hard to write readable tests for them that are focused on business logic and are not polluted with synchronizations, timeouts, and concurrency control.
    - In this article, we are going to take a look at Awaitility — a library which provides a simple domain-specific language (DSL) for asynchronous systems testing.
    - With Awaitility, we can express our expectations from the system in an easy-to-read DSL.
- [Localstack](https://localstack.cloud/)
   - Develop and test your AWS applications locally to reduce development time and increase product velocity. Reduce unnecessary AWS spend and remove the complexity and risk of maintaining AWS dev accounts.
- [Jacoco](https://www.eclemma.org/jacoco/)
   - Code coverage is a software metric used to measure how many lines of our code are executed during automated tests.
   - In this tutorial, we’re going to stroll through some practical aspects of using JaCoCo, a code coverage reports generator for Java projects.
   - https://www.baeldung.com/jacoco
- [SonarQube](https://www.sonarqube.org/)
    - Empower development teams with a code quality and security solution that deeply integrates into your enterprise environment; enabling you to deploy clean code consistently and reliably.
- [SonarCloud](https://sonarcloud.io/)
   - Development teams love SonarCloud for a reason. It provides instant feedback, in the right context, with minimal distractions so Clean Code is delivered every day.

### Performace Testinng
- [Gatling](https://gatling.io/)
- [JMeter](https://jmeter.apache.org/)

### Database Migration
- [Flyway DB Migration](https://flywaydb.org/)
- [Liquibase](https://www.liquibase.org/)

### CI/CD
- [Jenkins](https://jenkins.io/)
- [TravisCI](https://travis-ci.org/)
- [CircleCI](https://circleci.com/)

### Monitoring
- [Grafana](https://grafana.com/)
- [Prometheus](https://prometheus.io/)
- [ELK Stack](https://www.elastic.co/elk-stack)

## References
* <https://www.oracle.com/technetwork/java/javase/downloads/index.html>
* <https://www.reddit.com/r/java>
