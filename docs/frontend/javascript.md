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
