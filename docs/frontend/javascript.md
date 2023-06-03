# JavaScript
### DOM manupulation
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f4276cb2-fd04-4b69-acf2-382d32fd827f)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/19e41a89-fed6-44bc-9469-62d8c87fe698)
### Add event Listeners
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e595abac-ca4c-4507-831e-fbbd80b146af)
### Higher order function and callback
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3680ce17-f921-444f-8008-323e3c01cef1)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5219b1fb-cb3f-4f43-8ffa-e60cf968ef6e)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e9f4f960-3b54-49cd-95a3-88ca6e5cb0a1)

### Type conversion (manually) and Type Coersion (Auto)
```js
// type conversion
const inputYear = "1991";
console.log(Number(inputYear), inputYear);
console.log(Number(inputYear) + 18);

console.log(Number("Jonas"));
console.log(typeof NaN);

console.log(String(23), 23);

// type coercion

console.log("I am " + 23 + " years old");
console.log("23" - "10" - 3);
console.log("23" / "2");

let n = "1" + 1; // '11'
n = n - 1;
console.log(n);
/* output
1991
Nan
'1991'
number
23 23
I am 23 years old
10
11.5
10
*/
```
### Truthy and Falsy values
- fasly value means whe we convert those value into boolean it will give false , 5 false values in js
```js
//5 falsy values: 0, '', undefined, null, NaN
console.log(Boolean(0));
console.log(Boolean(undefined));
console.log(Boolean("Jonas"));
console.log("balnk obj :" + Boolean({}));
console.log(Boolean(""));

const money = 100;
if (money) {
  console.log("Don't spend it all ;)");
} else {
  console.log("You should get a job!");
}

let height = 0;
if (height) {
  console.log("YAY! Height is defined");
} else {
  console.log("Height is UNDEFINED");
}
/*
 output
 false
false
true
balnk obj : true
false
Don •t spend it all ; )
Height is UNDEFINED
*/
```

### Equality Operators: == vs. ===
```js
// Equality Operators: == vs. ===
const age = "18";
if (age === 18) console.log("You just became an adult :D (strict)");

if (age == 18) console.log("You just became an adult :D (loose)");

const favourite = Number(prompt("What's your favourite number?"));
console.log(favourite);
console.log(typeof favourite);

if (favourite == 23) {
  // 22 === 23 -> FALSE
  console.log("Cool! 23 is an amzaing number!");
} else if (favourite === 7) {
  console.log("7 is also a cool number");
} else if (favourite === 9) {
  console.log("9 is also a cool number");
} else {
  console.log("Number is not 23 or 7 or 9");
}
const fav1 = "23";
if (fav1 !== 23) console.log("Why not 23?");

/* Output
You just became an adult
23
number
(loose)
Cool! 23 is an amzaing number!
Why not 23?

*/
```
### Function 
```js
// Function declaration
function calcAge1(birthYeah) {
  return 2037 - birthYeah;
}
const age1 = calcAge1(1991);

// Function expression
const calcAge2 = function (birthYeah) {
  return 2037 - birthYeah;
};
const age2 = calcAge2(1991);

console.log(age1, age2);
/*output
46 46
*/
//----------------------
// Arrow functions

const calcAge3 = (birthYeah) => 2037 - birthYeah;
const age3 = calcAge3(1991);
console.log(age3);

const yearsUntilRetirement = (birthYeah, firstName) => {
  const age = 2037 - birthYeah;
  const retirement = 65 - age;
  // return retirement;
  return `${firstName} retires in ${retirement} years`;
};

console.log(yearsUntilRetirement(1991, "Jonas"));
console.log(yearsUntilRetirement(1980, "Bob"));
/*output
46
Jonas retires in 19 years
Bob retires in 8 years
*/

```

## Array Operations 
```js
const friends = ["Michael", "Steven", "Peter"];

// Add elements
const newLength = friends.push("Jay");
console.log(friends);
console.log(newLength);

friends.unshift("John");
console.log(friends);

// Remove elements
friends.pop(); // Last
const popped = friends.pop();
console.log("popped :" + popped);
console.log("friends :" + friends);

friends.shift(); // First
console.log(friends);

console.log(friends.indexOf("Steven"));
console.log(friends.indexOf("Bob"));

friends.push(23);
console.log(friends.includes("Steven"));
console.log(friends.includes("Bob"));
console.log(friends.includes(23));

if (friends.includes("Steven")) {
  console.log("You have a friend called Steven");
}

```
- output
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ac0c3732-6d65-48ed-ad72-d9f137db470d)

## Object
```js
// Dot vs. Bracket Notation
const jonas = {
  firstName: "Jonas",
  lastName: "Schmedtmann",
  age: 2037 - 1991,
  job: "teacher",
  friends: ["Michael", "Peter", "Steven"],
};
console.log(jonas);

console.log(jonas.lastName);
console.log(jonas["lastName"]);

const nameKey = "Name";
console.log(jonas["first" + nameKey]);
console.log(jonas["last" + nameKey]);

// console.log(jonas.'last' + nameKey)

const interestedIn = "firstName";

if (jonas[interestedIn]) {
  console.log(jonas[interestedIn]);
} else {
  console.log(
    "Wrong request! Choose between firstName, lastName, age, job, and friends"
  );
}

jonas.location = "Portugal";
jonas["twitter"] = "@jonasschmedtman";
console.log(jonas);

// Challenge
// "Jonas has 3 friends, and his best friend is called Michael"
console.log(
  `${jonas.firstName} has ${jonas.friends.length} friends, and his best friend is called ${jonas.friends[0]}`
);

```
- output
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1544c67a-d456-4b14-b82e-3d1cc67c80ef)






