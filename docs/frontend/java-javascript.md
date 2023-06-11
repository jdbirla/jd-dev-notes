# JavaScript is Java's Script
- Here will compare are all java's logics , concept , systax , function way , OOPs with JavaScript which will prove that JavaScript is derived from java this is on lighter note.
- I am writing this artice because any Java developer is afraid to learn UI technologies like JavaScript but after this article any java developer can learn javascript most complex topic in 1 week if he is good in his java knoledge.

## Concept: Variables and Data Types

Java Example:
```java
Copy code
int age = 25;
String name = "John";
```
JavaScript Example:
```javascript
Copy code
let age = 25;
let name = "John";
```

## Concept: Conditional Statements (if-else)

Java Example:
```java
Copy code
if (age >= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are a minor.");
}
```
JavaScript Example:
```javascript
Copy code
if (age >= 18) {
    console.log("You are an adult.");
} else {
    console.log("You are a minor.");
}
```
## Concept: Loops (for loop)

Java Example:
```java
Copy code
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```
JavaScript Example:
```javascript
Copy code
for (let i = 0; i < 5; i++) {
    console.log(i);
}
```
## Concept: Arrays

Java Example:
```java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
```
## Concept: Functions

Java Example:
```java
Copy code
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}
```
JavaScript Example:

```javascript
Copy code
function greet(name) {
    console.log("Hello, " + name + "!");
}
```

## Concept: Object-Oriented Programming (Classes and Objects)

Java Example:
```java
Copy code
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public void sayHello() {
        System.out.println("Hello, my name is " + name + ".");
    }
}
Person person = new Person("John");
person.sayHello();
```
JavaScript Example:
```javascript
Copy code
class Person {
    constructor(name) {
        this.name = name;
    }
    sayHello() {
        console.log("Hello, my name is " + this.name + ".");
    }
}
let person = new Person("John");
person.sayHello();
```
## Concept: Exception Handling


Java Example:
```java
Copy code
try {
    // Code that may throw an exception
} catch (Exception e) {
    // Exception handling code
}
```
JavaScript Example:
```javascript
Copy code
try {
    // Code that may throw an error
} catch (error) {
    // Error handling code
}
```
## Concept: Asynchronous Programming (Callbacks/Promises/Async-await)

Java Example (Using CompletableFuture):

```java
Copy code
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    // Asynchronous task
    return 42;
});
future.thenAccept(result -> {
    // Callback executed when the future completes
    System.out.println("Result: " + result);
});
```
JavaScript Example (Using Promises):

```javascript
Copy code
let promise = new Promise((resolve, reject) => {
    // Asynchronous task
    resolve(42);
});
promise.then(result => {
    // Callback executed when the promise is resolved
    console.log("Result: " + result);
});

```
## Concept: Filtering an Array

Java Example:
```java
Copy code
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> filteredNumbers = numbers.stream()
                                       .filter(n -> n % 2 == 0)
                                       .collect(Collectors.toList());
System.out.println(filteredNumbers);  // Output: [2, 4]
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
let filteredNumbers = numbers.filter(n => n % 2 === 0);
console.log(filteredNumbers);  // Output: [2, 4]
Concept: Mapping an Array
```
## Concept: Mapping an Array
Java Example:
```java
Copy code
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squaredNumbers = numbers.stream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());
System.out.println(squaredNumbers);  // Output: [1, 4, 9, 16, 25]
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
let squaredNumbers = numbers.map(n => n * n);
console.log(squaredNumbers);  // Output: [1, 4, 9, 16, 25]
Concept: Reducing an Array
```
## Concept: Reducing an Array


Java Example:
```java
Copy code
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
System.out.println(sum);  // Output: 15
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
let sum = numbers.reduce((a, b) => a + b, 0);
console.log(sum);  // Output: 15
```
## Concept: Iterating over an Array
Java Example:
```java
Copy code
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach(n -> System.out.println(n));
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
numbers.forEach(n => console.log(n));
 ``` 
## Concept: Arrow Functions (Lambda Expressions)

Java Example:
```java
Copy code
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```
JavaScript Example:
```javascript
Copy code
let numbers = [1, 2, 3, 4, 5];
numbers.filter(n => n % 2 === 0)
       .forEach(console.log);
```
  
## Concept: Method References

Java Example:
```java
Copy code
List<String> names = Arrays.asList("John", "Mary", "Alice");
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
```
JavaScript Example:
```javascript
Copy code
let names = ["John", "Mary", "Alice"];
names.map(String.toUpperCase)
     .forEach(console.log);
```
 ## Concept: Type Conversion (String to Number)

Java Example:
```java
Copy code
String numberStr = "42";
int number = Integer.parseInt(numberStr);
```
JavaScript Example:
```javascript
Copy code
let numberStr = "42";
let number = parseInt(numberStr);
```
## Concept: Type Conversion (Number to String)

Java Example:
```java
Copy code
int number = 42;
String numberStr = String.valueOf(number);
```
JavaScript Example:
```javascript
Copy code
let number = 42;
let numberStr = String(number);
```
## Type Casting
- type converion (js) : explicity type casting (java)
- type coercion (js) : implicit type casting (java)
```js
const inputYear = "1991";
console.log (Number(inputYear), +18);
```
