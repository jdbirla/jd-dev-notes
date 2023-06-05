# JavaScript

## The Scope Chain
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c3b72eee-ccb1-44f5-ae3d-404beeaae123)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/be8e44ae-efb1-4987-ab55-eb02de217186)

---
## Object vs Premitives
- Except primitives all are object even array is object and function is also object.

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3dce021f-13f2-432c-98d2-6ab679035d16)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/0ff3eacf-f92b-4efa-b8a1-45b9639f455a)

```js
let age = 30;
let oldAge = age;
age = 31;
console.log(age);
console.log(oldAge);
const me = {
  name: 'Jonas',
  age: 30,
};
const friend = me;
friend.age = 27;
console.log('Friend:', friend);
console.log('Me', me);
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/42fc5343-9a3f-4590-82a1-c19e5d4b1a55)

---
## DOM manupulation
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f4276cb2-fd04-4b69-acf2-382d32fd827f)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/19e41a89-fed6-44bc-9469-62d8c87fe698)

### Add event Listeners
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e595abac-ca4c-4507-831e-fbbd80b146af)

---

## Operations
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
1991 '1991'
2009
NaN
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
---

## Functions
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
### Higher order function and callback
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3680ce17-f921-444f-8008-323e3c01cef1)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5219b1fb-cb3f-4f43-8ffa-e60cf968ef6e)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e9f4f960-3b54-49cd-95a3-88ca6e5cb0a1)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/002c6f16-cfb1-48e0-886b-9dc5d4002819)

#### callback function
```js
// Functions Accepting Callback Functions
const oneWord = function (str) {
  return str.replace(/ /g, '').toLowerCase();
};

const upperFirstWord = function (str) {
  const [first, ...others] = str.split(' ');
  return [first.toUpperCase(), ...others].join(' ');
};

// Higher-order function
const transformer = function (str, fn) {
  console.log(`Original string: ${str}`);
  const rrt = fn(str);
  console.log(`Transformed string: ${rrt}`);

  console.log(`Transformed by: ${fn.name}`);
};

transformer('JavaScript is the best!', upperFirstWord);
transformer('JavaScript is the best!', oneWord);

// JS uses callbacks all the time
const high5 = function () {
  console.log('👋');
};
document.body.addEventListener('click', high5);
['Jonas', 'Martha', 'Adam'].forEach(high5);

const high6 = function (ele) {
  console.log('👋', ele);
};

['Jonas', 'Martha', 'Adam'].forEach(high6);

```

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a59fce23-e3ca-4ca1-8062-c70f9a6928f8)
####  JD's example with explicit function
```js
function addEvent(str, callback) {
  let innerObj = {
    name: 'jd',
    lastName: 'birla',
  };
  const rtnFromCallBackExec = callback(str, innerObj);
  // console.log('pass1 :', pass1);
  console.log('rtnFromCallBackExec :', rtnFromCallBackExec);
  return 'my value with call back result ' + rtnFromCallBackExec;
}

function calls(passValue, recivingVal) {
  console.log('passValue : ', passValue);
  console.log('recivingVal : ', recivingVal);

  return ' birla ';
}
const sa = addEvent('I am bad', calls);
console.log(sa);
/*
passValue :  I am bad
recivingVal :  {name: 'jd', lastName: 'birla'}
rtnFromCallBackExec :  birla 
my value with call back result  birla 
*/
```
####  JD's example with arrow function
```js
function addEvent(str, callback) {
  let innerObj = {
    name: 'jd',
    lastName: 'birla',
  };
  const rtnFromCallBackExec = callback(str, innerObj);
  // console.log('pass1 :', pass1);
  console.log('rtnFromCallBackExec :', rtnFromCallBackExec);
  return 'my value with call back result ' + rtnFromCallBackExec;
}

// function calls(passValue, recivingVal) {
//   console.log('passValue : ', passValue);
//   console.log('recivingVal : ', recivingVal);

//   return ' birla ';
// }
// const sa = addEvent('I am bad', calls);
// console.log(sa);

const sa = addEvent('I am bad', (passValue, recivingVal) => {
  console.log('passValue : ', passValue);
  console.log('recivingVal : ', recivingVal);

  return ' birla ';
});
console.log(sa);
/*
passValue :  I am bad
recivingVal :  {name: 'jd', lastName: 'birla'}
rtnFromCallBackExec :  birla 
my value with call back result  birla 
*/
```
#### Higher order function return function
```js
// Functions Returning Functions
const greet = function (greeting) {
  return function (name) {
    console.log(`${greeting} ${name}`);
  };
};

const greeterHey = greet('Hey');
console.log(greeterHey);
greeterHey('Jonas');
greeterHey('Steven');
console.log('--------------------------------------------');

greet('Hello')('Jonas');
console.log('--------------------------------------------');

// Challenge
const greetArr = greeting => name => console.log(`${greeting} ${name}`);

greetArr('Hi')('Jonas');

console.log('--------------------------------------------');
const greet1 = function (greeting) {
  if (greeting === 'mor') {
    return function (name) {
      console.log(` morning:  ${greeting} ${name}`);
    };
  } else {
    return function (name) {
      console.log(` not a morning:  ${greeting} ${name}`);
    };
  }
};

const fn = greet1('mor');

fn('jd');

const fn1 = greet1('morasd');

fn1('jd');
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d90bf2cc-8a61-4a35-884e-7ec0f7410d04)

### call and apply and bind methods 
```js
// The call and apply Methods
const lufthansa = {
  airline: 'Lufthansa',
  iataCode: 'LH',
  bookings: [],
  // book: function() {}
  book(flightNum, name) {
    console.log(
      `${name} booked a seat on ${this.airline} flight ${this.iataCode}${flightNum}`
    );
    this.bookings.push({ flight: `${this.iataCode}${flightNum}`, name });
  },
};

lufthansa.book(239, 'Jonas Schmedtmann');
lufthansa.book(635, 'John Smith');
console.log('----------------------------------------------------');
const eurowings = {
  airline: 'Eurowings',
  iataCode: 'EW',
  bookings: [],
};

const book = lufthansa.book;

// Does NOT work
// book(23, 'Sarah Williams');

// // Call method
console.log(eurowings);
book.call(eurowings, 23, 'Sarah Williams');
console.log('----------------------------------------------------');
console.log(lufthansa);
book.call(lufthansa, 239, 'Mary Cooper');
console.log('----------------------------------------------------');

const swiss = {
  airline: 'Swiss Air Lines',
  iataCode: 'LX',
  bookings: [],
};

book.call(swiss, 583, 'Mary Cooper');
console.log('----------------------------------------------------');
console.log('---------------------Apply-------------------------------');

// Apply method
const flightData = [583, 'George Cooper'];
console.log(swiss);
book.apply(swiss, flightData);
console.log('----------------------------------------------------');

book.call(swiss, ...flightData);
console.log('----------------------------------------------------');

// book.call(eurowings, 23, 'Sarah Williams');
console.log('---------------------Bind-------------------------------');

const bookEW = book.bind(eurowings);
bookEW(23, 'Steven Williams');
console.log('----------------------------------------------------');

const bookEW23 = book.bind(eurowings, 23);
bookEW23('Jonas Schmedtmann');
console.log('----------------------------------------------------');

// With Event Listeners
lufthansa.planes = 300;
lufthansa.buyPlane = function () {
  console.log(this);

  this.planes++;
  console.log(this.planes);
};
// lufthansa.buyPlane();

document
  .querySelector('.buy')
  .addEventListener('click', lufthansa.buyPlane.bind(lufthansa));

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e5a973cc-0aeb-46ad-874b-6aa1012a89b0)

### Immediately Invoked Function Expressions (IIFE) 

```js
// Immediately Invoked Function Expressions (IIFE)
const runOnce = function () {
  console.log('This will never run again');
};
runOnce();

// IIFE
(function () {
  console.log('This will never run again');
  const isPrivate = 23;
})();

// console.log(isPrivate);

(() => console.log('This will ALSO never run again'))();

{
  const isPrivate = 23;
  var notPrivate = 46;
}
//console.log(isPrivate); //isPrivate is not defined
console.log(notPrivate);

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f35cd8ff-1855-4cc6-aff1-97e467426377)

 

---
## Array  
### Array Operations
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

### Array Methods
```js
// Simple Array Methods
let arr = ['a', 'b', 'c', 'd', 'e'];

// SLICE
console.log('---------------------------------slice----------------------');
console.log(arr.slice(2));
console.log(arr.slice(2, 4));
console.log(arr.slice(-2));
console.log(arr.slice(-1));
console.log(arr.slice(1, -2));
console.log(arr.slice());
console.log([...arr]);

// SPLICE
console.log('---------------------------------SPLICE----------------------');

// console.log(arr.splice(2));
arr.splice(-1);
console.log(arr);
arr.splice(1, 2);
console.log(arr);

// REVERSE
console.log('---------------------------------REVERSE----------------------');

arr = ['a', 'b', 'c', 'd', 'e'];
const arr2 = ['j', 'i', 'h', 'g', 'f'];
console.log(arr2.reverse());
console.log(arr2);

// CONCAT
console.log('---------------------------------CONCAT----------------------');

const letters = arr.concat(arr2);
console.log(letters);
console.log([...arr, ...arr2]);

// JOIN
console.log('---------------------------------JOIN----------------------');

console.log(letters.join(' - '));

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/95af17a5-a4ca-46f6-84df-a76c312dcec8)


### Array Destruring
```js
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],
};

// Nested destructuring
const nested = [2, 4, [5, 6]];
// const [i, , j] = nested;
const [i, , [j, k]] = nested;
console.log(i, j, k);
// Default values
const [p = 1, q = 1, r = 1] = [8, 9];
console.log(p, q, r);
let [main, , secondary] = restaurant.categories;
console.log(main, secondary);
/*output 
256
891
Italian Vegetarian
*/
```

---

## Object
### Object Operations
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


### Object Methods
```js
const jonas = {
  firstName: "Jonas",
  lastName: "Schmedtmann",
  birthYeah: 1991,
  job: "teacher",
  friends: ["Michael", "Peter", "Steven"],
  hasDriversLicense: true,

  // calcAge: function (birthYeah) {
  //   return 2037 - birthYeah;
  // }

  // calcAge: function () {
  //   // console.log(this);
  //   return 2037 - this.birthYeah;
  // }

  calcAge: function () {
    this.age = 2037 - this.birthYeah;
    return this.age;
  },

  getSummary: function () {
    return `${this.firstName} is a ${this.calcAge()}-year old ${
      jonas.job
    }, and he has ${this.hasDriversLicense ? "a" : "no"} driver's license.`;
  },
};

console.log(jonas.calcAge());

console.log(jonas.age);
console.log(jonas.age);
console.log(jonas.age);

// Challenge
// "Jonas is a 46-year old teacher, and he has a driver's license"
console.log(jonas.getSummary());
/*output

Jonas is a 46-year old teacher, and he has a driver's license.
46
46
46
46
*/
```

### Object Destructring
```js
const weekdays = ['mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'sun'];

const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};
const { name, openingHours, categories } = restaurant;
console.log(name, openingHours, categories);

// different name
const {
  name: restaurantName,
  openingHours: hours,
  categories: tags,
} = restaurant;
console.log(restaurantName, hours, tags);

//Default values with diffrent name
const { menu = [], starterMenu: starters = [] } = restaurant;
console.log(menu, starters);

// Mutating variables
let a = 111;
let b = 999;
const obj = { a: 23, b: 7, c: 14 };

({ a, b } = obj);
console.log(a, b);

// Nested objects
const {
  fri: { open: o, close: c },
} = openingHours;
console.log(o, c);

const {
  name: rest,
  openingHours: {
    fri: { open, close },
  },
} = restaurant;
console.log(name, open, close);

// Passing object as argument and receiving function doing destructing for this object
restaurant.orderDelivery({
  time: '22:30',
  address: 'Via del Sole, 21',
  mainIndex: 2,
  starterIndex: 2,
});

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/120ebf59-f4b8-4050-bd78-e0ade0bbdb32)

---

## The SpreadOperator
```js
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};

// The Spread Operator (...)

const arr = [7, 8, 9];
const badNewArr = [1, 2, arr[0], arr[1], arr[2]];
console.log(badNewArr);

const newArr = [1, 2, ...arr];
console.log(newArr);

console.log(...newArr);
console.log(1, 2, 7, 8, 9);

const newMenu = [...restaurant.mainMenu, 'Gnocci'];
console.log(newMenu);
console.log('----------------------------------');

// Copy array shallow copy of the array
const mainMenuCopy = [...restaurant.mainMenu];
console.log(mainMenuCopy);
console.log('----------------------------------');

// Join 2 arrays
const menu = [...restaurant.starterMenu, ...restaurant.mainMenu];
console.log(menu);
console.log('----------------------------------');

// Iterables: arrays, strings, maps, sets. NOT objects
const str = 'Jonas';
const letters = [...str, ' ', 'S.'];
console.log(letters);
console.log(...str);
// console.log(`${...str} Schmedtmann`);
console.log('----------------------------------');

// Real-world example
const ingredients = [
  // prompt("Let's make pasta! Ingredient 1?"),
  // prompt('Ingredient 2?'),
  // prompt('Ingredient 3'),
];
console.log(ingredients);
console.log('----------------------------------');

restaurant.orderPasta(ingredients[0], ingredients[1], ingredients[2]);
restaurant.orderPasta(...ingredients);
console.log('----------------------------------');

// Objects
const newRestaurant = { foundedIn: 1998, ...restaurant, founder: 'Guiseppe' };
console.log(newRestaurant);

//Shallow copy of the object
const restaurantCopy = { ...restaurant };
restaurantCopy.name = 'Ristorante Roma';
console.log(restaurantCopy.name);
console.log(restaurant.name);
console.log('----------------------------------');


```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3f4dba1d-4a8e-421b-b203-a543d31d9c53)

---

## Rest Patterns and Parameters
```js

const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};

// Rest Pattern and Parameters
// 1) Destructuring

// SPREAD, because on RIGHT side of =
const arr = [1, 2, ...[3, 4]];
console.log(arr);

console.log('--------------------------------------------');
// REST, because on LEFT side of =
const [a, b, ...others] = [1, 2, 3, 4, 5];
console.log(a, b, others);
console.log('--------------------------------------------');

const [pizza, , risotto, ...otherFood] = [
  ...restaurant.mainMenu,
  ...restaurant.starterMenu,
];
console.log(pizza, risotto, otherFood);
console.log('--------------------------------------------');

// Objects
const { sat, ...weekdays } = restaurant.openingHours;
console.log(weekdays);
console.log('--------------------------------------------');

// 2) Functions
const add = function (...numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) sum += numbers[i];
  console.log(sum);
};

add(2, 3);
add(5, 3, 7, 2);
add(8, 2, 5, 3, 2, 1, 4);

const x = [23, 5, 7];
add(...x);
console.log('--------------------------------------------');

restaurant.orderPizza('mushrooms', 'onion', 'olives', 'spinach');
restaurant.orderPizza('mushrooms');
console.log('--------------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/18b91d85-b5af-45c9-9688-0077322bc6e6)

---
## The Nullish Coalescing Operator `??`
 - Nullish will give only true when nullish values are there not the falsy values
 - Nullish: null and undefined (`NOT 0 or ''`)
 
 ```js
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};
// The Nullish Coalescing Operator
restaurant.numGuests = 0;
const guests = restaurant.numGuests || 10;
console.log(guests);

// Nullish: null and undefined (NOT 0 or '')
const guestCorrect = restaurant.numGuests ?? 10;
console.log(guestCorrect);
console.log('---------------------------------');
restaurant.mehman = null;
const guests1 = restaurant.mehman || 10;
console.log(guests1);

// Nullish: null and undefined (NOT 0 or '')
const guestCorrect1 = restaurant.mehman ?? 10;
console.log(guestCorrect1);
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/74791eb2-00d7-44c2-acae-7fc19f1a0d89)

---
## All Loops in JS
### 1. for loop: The standard for loop is used when you know the exact number of iterations you want to perform.
```js
const numbers = [1, 2, 3, 4, 5];

for (let index = 0; index < numbers.length; index++) {
  const element = numbers[index];
  console.log(element);
}
/*Output 
1
2
3
4
5
*/
```
### 2. forEach :The forEach loop is used specifically with arrays to iterate over each element in the array.

```js
const numbers = [1, 2, 3, 4, 5];

numbers.forEach(element => {
  console.log(element);
});
/*Output 
1
2
3
4
5
*/
//------------------------------------------------------------
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

console.log('---- FOREACH ----');
movements.forEach(function (mov, i, arr) {
  if (mov > 0) {
    console.log(`Movement ${i + 1}: You deposited ${mov}`);
  } else {
    console.log(`Movement ${i + 1}: You withdrew ${Math.abs(mov)}`);
  }
});

/*Output
Movement 1: You deposited 200
Movement 2: You deposited 450
Movement 3: You withdrew 400
Movement 4: You deposited 3000
Movement 5: You withdrew 650
Movement 6: You withdrew 130
Movement 7: You deposited 70
Movement 8: You deposited 1300
*/
//-----------------------------------------------
const currencies = new Map([
  ['USD', 'United States dollar'],
  ['EUR', 'Euro'],
  ['GBP', 'Pound sterling'],
]);

// forEach With Maps and Sets

currencies.forEach(function (value, key, map) {
  console.log(`${key}: ${value}`);
});
/*
USD: United States dollar
EUR: Euro
GBP: Pound sterling
*/

// Set
const currenciesUnique = new Set(['USD', 'GBP', 'USD', 'EUR', 'EUR']);
console.log(currenciesUnique);
currenciesUnique.forEach(function (value, _, map) {
  console.log(`${value}: ${value}`);
});
/*
Set(3) {'USD', 'GBP', 'EUR'}
USD: USD
GBP: GBP
EUR: EUR
*/
```

### 3. for...in :The for...in loop is used to iterate over the enumerable properties of an object.
```js
const person = {
  name: 'John',
  age: 30,
  city: 'New York',
};

for (let key in person) {
  console.log(key + ': ' + person[key]);
}
/*Output 
name: John
age: 30
city: New York
*/

```
### 4. for...of loop: The for...of loop is used to iterate over iterable objects like arrays, strings, or other collections.
```js
const colors = ['red', 'green', 'blue'];

for (let color of colors) {
  console.log(color);
}
/*Output
red
green
blue
*/

/////////////////////////////////////////////
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// for (const movement of movements) {
for (const [i, movement] of movements.entries()) {
  if (movement > 0) {
    console.log(`Movement ${i + 1}: You deposited ${movement}`);
  } else {
    console.log(`Movement ${i + 1}: You withdrew ${Math.abs(movement)}`);
  }
}

/*output
Movement 1: You deposited 200
Movement 2: You deposited 450
 Movement 3: You withdrew 400
 Movement 4: You deposited 3000
 Movement 5: You withdrew 650
Movement 6: You withdrew 130
 Movement 7: You deposited 70
Movement 8: You deposited 1300

*/


```
### 5. Iterate object using keys, values and entries
```js

const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};

// Looping Objects: Object Keys, Values, and Entries
const { openingHours } = restaurant;
// Property NAMES
const properties = Object.keys(openingHours);
console.log(properties);
console.log('----------------------------------------');
let openStr = `We are open on ${properties.length} days: `;
for (const day of properties) {
  openStr = openStr + `${day}, `;
}
console.log(openStr);
console.log('----------------------------------------');

// Property VALUES
const values = Object.values(openingHours);
console.log(values);
console.log('----------------------------------------');

// Entire object
const entries = Object.entries(openingHours);
// console.log(entries);

// [key, value]
for (const [day, { open, close }] of entries) {
  console.log(`On ${day} we open at ${open} and close at ${close}`);
}
console.log('----------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2b8deafb-88fa-491a-9216-aabb189d2c90)

### 6. Looping sets
```js

const ordersSet = new Set([
  'Pasta',
  'Pizza',
  'Pizza',
  'Risotto',
  'Pasta',
  'Pizza',
]);

for (const order of ordersSet) console.log(order);
console.log('------------------------------------------------');
/*output
Pasta
Pizza
Risotto
*/
```
### 7. Looping maps
```js
const question = new Map([
  ['question', 'What is the best programming language in the world?'],
  [1, 'C'],
  [2, 'Java'],
  [3, 'JavaScript'],
  ['correct', 3],
  [true, 'Correct 🎉'],
  [false, 'Try again!'],
]);

// Quiz app
for (const [key, value] of question) {
  if (typeof key === 'number') console.log(`Answer ${key}: ${value}`);
}
/*
Answer 1: C
Answer 2: Java
Answer 3: JavaScript
*/
```
---
## optional chaining ?. like Optionla in Java
- This will be used when we are not sure about the value or properties is avaiable instead of throwing error with give undefined
```js

const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  // ES6 enhanced object literals
  openingHours: {
    thu: { open: 12, close: 22 },
    fri: { open: 11, close: 23 },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order(starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
  },

  orderDelivery({ starterIndex = 1, mainIndex = 0, time = '20:00', address }) {
    console.log(
      `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}`
    );
  },

  orderPasta(ing1, ing2, ing3) {
    console.log(
      `Here is your declicious pasta with ${ing1}, ${ing2} and ${ing3}`
    );
  },

  orderPizza(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient);
    console.log(otherIngredients);
  },
};

// Optional Chaining
if (restaurant.openingHours && restaurant.openingHours.mon)
  console.log(restaurant.openingHours.mon.open);
console.log('-------------------------------------');
// console.log(restaurant.openingHours.mon.open);

// WITH optional chaining
console.log(restaurant.openingHours.mon?.open);
console.log(restaurant.openingHours?.mon?.open);
console.log(restaurant?.openingHours?.mon?.open);

console.log('-------------------------------------');

// Example
const days = ['mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'sun'];

for (const day of days) {
  const open = restaurant.openingHours[day]?.open ?? 'closed';
  console.log(`On ${day}, we open at ${open}`);
}
console.log('-------------------------------------');
// Methods
console.log(restaurant.order?.(0, 1) ?? 'Method does not exist');
console.log(restaurant.orderRisotto?.(0, 1) ?? 'Method does not exist');
console.log('-------------------------------------');

// Arrays
const users = [{ name: 'Jonas', email: 'hello@jonas.io' }];
// const users = [];

console.log(users[0]?.name ?? 'User array empty');

if (users.length > 0) console.log(users[0].name);
else console.log('user array empty');
console.log('-------------------------------------');
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/83a584b5-eb7a-4549-ad03-b964838fa631)
---

## Sets
```js
const ordersSet = new Set([
  'Pasta',
  'Pizza',
  'Pizza',
  'Risotto',
  'Pasta',
  'Pizza',
]);
console.log(ordersSet);
console.log('------------------------------------------------');
console.log(new Set('Jonas'));
console.log('------------------------------------------------');

console.log(ordersSet.size);
console.log(ordersSet.has('Pizza'));
console.log(ordersSet.has('Bread'));
console.log('------------------------------------------------');

ordersSet.add('Garlic Bread');
ordersSet.add('Garlic Bread');
ordersSet.delete('Risotto');
// ordersSet.clear();
console.log(ordersSet);
console.log('------------------------------------------------');

for (const order of ordersSet) console.log(order);
console.log('------------------------------------------------');

// Example
const staff = ['Waiter', 'Chef', 'Waiter', 'Manager', 'Chef', 'Waiter'];
const staffUnique = [...new Set(staff)];
console.log(staffUnique);
console.log('------------------------------------------------');

console.log(
  new Set(['Waiter', 'Chef', 'Waiter', 'Manager', 'Chef', 'Waiter']).size
);
console.log('------------------------------------------------');

console.log(new Set('jonasschmedtmann').size);
console.log('------------------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d50ca2b9-bbbc-464f-9831-fe37de648dcd)

---

## Maps
```js
const rest = new Map();
rest.set('name', 'Classico Italiano');
rest.set(1, 'Firenze, Italy');
console.log(rest.set(2, 'Lisbon, Portugal'));
console.log('----------------------------------------------');
rest
  .set('categories', ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'])
  .set('open', 11)
  .set('close', 23)
  .set(true, 'We are open :D')
  .set(false, 'We are closed :(');

console.log(rest.get('name'));
console.log(rest.get(true));
console.log(rest.get(1));
console.log('----------------------------------------------');

const time = 8;
console.log(rest.get(time > rest.get('open') && time < rest.get('close')));
console.log('----------------------------------------------');

console.log(rest.has('categories'));
rest.delete(2);
// rest.clear();
console.log('----------------------------------------------');

const arr = [1, 2];
rest.set(arr, 'Test');
rest.set(document.querySelector('h1'), 'Heading');
console.log(rest);
console.log(rest.size);

console.log(rest.get(arr));
console.log('----------------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1f756d83-7f74-4e8c-87af-54e39c4413d5)

---
## Data Transformation
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3a64152c-add2-41c0-83b7-45736d440367)

### Map
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// The map Method
const eurToUsd = 1.1;

const movementsUSD = movements.map(mov => mov * eurToUsd);
const movementsUSD1 = movements.map(mov => mov);

console.log(movements);
console.log(movementsUSD1);
console.log(movementsUSD);

const movementsDescriptions = movements.map(
  (mov, i) =>
    `Movement ${i + 1}: You ${mov > 0 ? 'deposited' : 'withdrew'} ${Math.abs(
      mov
    )}`
);
console.log(movementsDescriptions);

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/9caf699e-2135-4399-8e00-a052d2c300bd)


### Filter

```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// The filter Method
const deposits = movements.filter(function (mov, i, arr) {
  return mov > 0;
});
console.log(movements);
console.log(deposits);

const depositsFor = [];
for (const mov of movements) if (mov > 0) depositsFor.push(mov);
console.log(depositsFor);

const withdrawals = movements.filter(mov => mov < 0);
console.log(withdrawals);


```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/fb3a6122-ab5a-42d2-a04e-f959ddc12da4)


### Reduce
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// The reduce Method
console.log(movements);
console.log('---------------------------------------------------------');
// accumulator -> SNOWBALL
const balance = movements.reduce(function (acc, cur, i, arr) {
  console.log(`Iteration ${i}: ${acc}`);
  return acc + cur;
}, 0);
console.log(balance);
console.log('---------------------------------------------------------');

const balance1 = movements.reduce((acc, cur) => acc + cur, 0);
console.log(balance1);
console.log('---------------------------------------------------------');

let balance2 = 0;
for (const mov of movements) balance2 += mov;
console.log(balance2);
console.log('---------------------------------------------------------');

// Maximum value
const max = movements.reduce((acc, mov, i) => {
  console.log(`Iteration ${i}: ${acc}`);

  if (acc > mov) return acc;
  else return mov;
}, movements[0]);
console.log(max);
console.log('---------------------------------------------------------');
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a5f1fb24-038e-459c-8621-ae96e9a4bdf9)

### The Magic of Chaining Methods
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// The Magic of Chaining Methods
const eurToUsd = 1.1;
console.log(movements);

// PIPELINE
const totalDepositsUSD = movements
  .filter(mov => mov > 0)
  .map((mov, i, arr) => {
    // console.log(arr);
    return mov * eurToUsd;
  })
  .reduce((acc, mov) => acc + mov, 0);
console.log(totalDepositsUSD);

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5ef3012d-349b-4dad-94e6-25fa9d6937cb)

### find 
- is same like findFirst in java
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// The find Method
const firstWithdrawal = movements.find(mov => mov < 0);
console.log(movements);
console.log(firstWithdrawal);

console.log(accounts);

const account = accounts.find(acc => acc.owner === 'Jessica Davis');
console.log(account); // single value

const asd = accounts.filter(acc => acc.owner === 'Jessica Davis');
console.log(asd);  // array of value
```
### some and every
- some : anyMatch and every: allMatch in java
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// some and every
console.log(movements);
console.log('--------------------------------------------------------');
// EQUALITY
console.log(movements.includes(-130));
console.log('--------------------------------------------------------');

// SOME: CONDITION
console.log(movements.some(mov => mov === -130));
console.log('--------------------------------------------------------');

const anyDeposits = movements.some(mov => mov > 0);
console.log(anyDeposits);
console.log('--------------------------------------------------------');

// EVERY
console.log(movements.every(mov => mov > 0));
console.log(account4.movements.every(mov => mov > 0));
console.log('--------------------------------------------------------');

// Separate callback
const deposit = mov => mov > 0;
console.log(movements.some(deposit));
console.log(movements.every(deposit));
console.log(movements.filter(deposit));
console.log('--------------------------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/9d6d85c9-ffb6-4e5c-b1eb-0dfe91874d8d)

### Flat an FlatMap

```js
// flat and flatMap
const arr = [[1, 2, 3], [4, 5, 6], 7, 8];
console.log(arr.flat());

const arrDeep = [[[1, 2], 3], [4, [5, 6]], 7, 8];
console.log(arrDeep.flat(2));

// flat
const overalBalance = accounts
  .map(acc => acc.movements)
  .flat()
  .reduce((acc, mov) => acc + mov, 0);
console.log(overalBalance);

// flatMap
const overalBalance2 = accounts
  .flatMap(acc => acc.movements)
  .reduce((acc, mov) => acc + mov, 0);
console.log(overalBalance2);
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6f3f8b2a-394a-4308-9992-f2bd9ea937f1)

### Sorting
```js
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// Strings
const owners = ['Jonas', 'Zach', 'Adam', 'Martha'];
console.log(owners.sort());
console.log(owners);
console.log('------------------------------------------------------');
// Numbers
console.log(movements);
console.log(movements.sort());
console.log('------------------------------------------------------');

// return < 0, A, B (keep order)
// return > 0, B, A (switch order)

// Ascending
// movements.sort((a, b) => {
//   if (a > b) return 1;
//   if (a < b) return -1;
// });
movements.sort((a, b) => a - b);
console.log(movements);

// Descending
// movements.sort((a, b) => {
//   if (a > b) return -1;
//   if (a < b) return 1;
// });
movements.sort((a, b) => b - a);
console.log(movements);
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2eb6ea92-d3ff-4cb7-a44e-e22f523b1887)

### More Ways of Creating and Filling Arrays
```js
// More Ways of Creating and Filling Arrays
const arr = [1, 2, 3, 4, 5, 6, 7];
console.log(new Array(1, 2, 3, 4, 5, 6, 7));
console.log('-----------------------------------------');
// Emprty arrays + fill method
const x = new Array(7);
console.log(x);
console.log('-----------------------------------------');

// console.log(x.map(() => 5));
x.fill(1, 3, 5);
console.log(x);

x.fill(1);
console.log(x);
console.log('-----------------------------------------');

arr.fill(23, 2, 6);
console.log(arr);
console.log('-----------------------------------------');

// Array.from
const y = Array.from({ length: 7 }, () => 1);
console.log(y);
console.log('-----------------------------------------');

const z = Array.from({ length: 7 }, (_, i) => i + 1);
console.log(z);
console.log('-----------------------------------------');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/06b0ddb6-eb91-4f21-a615-c9af26e53642)

---
## Asnchronous JavaScript
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c75fa25e-b69a-4529-8e03-894f657aff80)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/cf8ab2a7-8edc-4ff7-9da7-5693acb4e132)

### Promises
- Promises is same like future and competableFuture in java
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/da167a77-9a58-4f3c-9808-89d12f560605)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c66e5deb-8e02-41b1-a5c9-758da6cc2e2d)

#### Consum fullfilled Promise 

```js
const getCountryData = function (country) {
  fetch(`https://restcountries.com/v3.1/name/${country}`)
    .then(response => {
      console.log('response :', response);
      return response.json();
    })
    .then(data => {
      console.log(data);
      console.log(data[0]);
    });
};
getCountryData('India');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d102639e-b3f7-4438-9619-a0fa32a40b7d)

#### Chaining Promises
```js
const getCountryData = function (country) {
  fetch(`https://restcountries.com/v3.1/name/${country}`)
    .then(response => {
      console.log('response :', response);
      return response.json();
    })
    .then(data => {
      console.log(data);
      console.log(data[0]);
      const neightbour = data[0].borders?.[4];
      return fetch(`https://restcountries.com/v3.1/alpha/${neightbour}`);
    })
    .then(res => {
      console.log('res :', res);
      return res.json();
    })
    .then(data1 => {
      console.log('data1 :', data1);
      return data1;
    });
};
getCountryData('India');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ec435fc9-c90b-4cca-ab35-06329a42b935)

#### Consum Handling rejected Promise 
```js
const getCountryData = function (country) {
  fetch(`https://restcountries.com/v3.1/name/${country}`)
    .then(response => {
      console.log('response :', response);
      return response.json();
    })
    .then(data => {
      console.log(data);
      console.log(data[0]);
      const neightbour = data[0].borders?.[4];
      return fetch(`https://restcountries.com/v3.1/alpha/${neightbour}`);
    })
    .then(res => {
      console.log('res :', res);
      return res.json();
    })
    .then(data1 => {
      console.log('data1 :', data1);
      return data1;
    })
    .catch(err => console.error(err))
    .finally(() => {
      console.log('finally');
    });
};
getCountryData('India');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b380f7c6-b6b9-4dad-b492-dc96e10c5cd9)


#### Throwing error manually if promise not rejected even 404 
```js

const getCountryData = function (country) {
  fetch(`https://restcountries.com/v3.1/name/${country}`)
    .then(response => {
      console.log('response :', response);
      if (!response.ok) {
        throw new Error(`Country not found : ${response.status}`);
      }
      return response.json();
    })
    .then(data => {
      console.log(data);
      console.log(data[0]);
      const neightbour = data[0].borders?.[4];
      return fetch(`https://restcountries.com/v3.1/alpha/${neightbour}`);
    })
    .then(res => {
      console.log('res :', res);
      return res.json();
    })
    .then(data1 => {
      console.log('data1 :', data1);
      return data1;
    })
    .catch(err => console.error(err))
    .finally(() => {
      console.log('finally');
    });
};
getCountryData('Indiadfgfd');

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7b841e9e-ae21-4ed0-a963-f31742e797ab)

#### Bulding promises

```js
const lotteryPromise = new Promise((resolve, reject) => {
  console.log('lotery is happing');
  setTimeout(() => {
    if (Math.random() >= 0.5) {
      resolve('You win 🚗🚗');
    } else {
      reject(new Error('You lost money 🤢'));
    }
  }, 2000);
});

lotteryPromise.then(res => console.log(res)).catch(err => console.error(err));
```
#### Consuming promises using async/await
```js
const whereAmi = async country => {
  try {
    const res = await fetch(`https://restcountries.com/v3.1/name/${country}`);
    const data = await res.json();
    console.log(data?.[0]);
  } catch (error) {
    console.log(error);
  }
};
whereAmi('India');
console.log('FIRST');
```

#### Promise All
- ALL : When all promise will fulifilled
- Rance :  When one of the promise hs been settleted
- AllSettled : It will give all promise result even one of them is rejected
```js
const get3Countrues = async (c1, c2, c3) => {
  try {
    // const res1 = await fetch(`https://restcountries.com/v3.1/name/${c1}`);
    // const data1 = await res1.json();
    // console.log(data1?.[0]);

    // const res2 = await fetch(`https://restcountries.com/v3.1/name/${c2}`);
    // const data2 = await res2.json();
    // console.log(data2?.[0]);

    // const res3 = await fetch(`https://restcountries.com/v3.1/name/${c3}`);
    // const data3 = await res3.json();
    // console.log(data3?.[0]);
    const res = await Promise.all([
      fetch(`https://restcountries.com/v3.1/name/${c1}`),
      fetch(`https://restcountries.com/v3.1/name/${c2}`),
      fetch(`https://restcountries.com/v3.1/name/${c3}`),
    ]);

    res.map(async r => {
      const data = await r.json();
      console.log(data?.[0]);
    });
  } catch (error) {
    console.log(error);
  }
};

get3Countrues('India', 'canada', 'china');
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/db127aa4-6d5d-42c4-906c-aaba5310b93d)
