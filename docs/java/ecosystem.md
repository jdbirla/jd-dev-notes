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
- [Failsafe](https://github.com/jhalterman/failsafe)
- [Retry4j](https://github.com/elennick/retry4j)
- [Twitter4j](http://twitter4j.org/en/)
- [JooQ](https://www.jooq.org/)
- [FlexyPool](https://github.com/vladmihalcea/flexy-pool)
- [Hibernate-Types](https://github.com/vladmihalcea/hibernate-types)
- [Resilience4j](https://github.com/resilience4j/resilience4j)
- [Zalando/problem-spring-web](https://github.com/zalando/problem-spring-web)
- [SpringFox](http://springfox.github.io/springfox/)
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
- [REST Assured](https://github.com/rest-assured/rest-assured/wiki/Usage)
- [Mock Server](http://www.mock-server.com/)
- [TestContainers](https://www.testcontainers.org/)
- [Mockito](https://site.mockito.org/)
- [Assertj](http://joel-costigliola.github.io/assertj/)
- [Awaitility](https://github.com/awaitility/awaitility)
- [Localstack](https://localstack.cloud/)
- [Jacoco](https://www.eclemma.org/jacoco/)
- [SonarQube](https://www.sonarqube.org/)
- [SonarCloud](https://sonarcloud.io/)

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
