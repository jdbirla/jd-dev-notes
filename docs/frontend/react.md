# React
## Useful resources
Useful Resources for Part 2

Here are some high-quality resources that you might find helpful while studying this Part 2. (The list follows the order of sections in this part)

These resources are 100% optional, but might give you additional insights or provide ever deeper dives into some topics.

👉 Writing Resilient Components (By Dan Abramov from the React team) : ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 Things I think about when I write React code (GitHub repository):  ![](https://github.com/mithi/react-philosophies?ref=jonas.io)

👉 A (Mostly) Complete Guide to React Rendering Behavior (By Mark Erikson from the redux team):  ![](https://blog.isquaredsoftware.com/2020/05/blogged-answers-a-mostly-complete-guide-to-react-rendering-behavior/?ref=jonas.io)

👉 A Visual Guide to React Rendering (A multi-part series, check out the other ones):  ![](https://alexsidorenko.com/blog/react-render-always-rerenders/?ref=jonas.io)

👉 Inside Fiber: in-depth overview of the new reconciliation algorithm in React:  ![](https://indepth.dev/posts/1008/inside-fiber-in-depth-overview-of-the-new-reconciliation-algorithm-in-react?ref=jonas.io)

👉 A Cartoon Intro to Fiber (YouTube video):  ![](https://www.youtube.com/watch?v=ZCuYPiUIONs?ref=jonas.io)

👉 What Is React Fiber? React.js Deep Dive (YouTube video):  ![](https://www.youtube.com/watch?v=0ympFIwQFJw?ref=jonas.io)

👉 The React and React Native Event System Explained:  ![](https://levelup.gitconnected.com/how-exactly-does-react-handles-events-71e8b5e359f2?ref=jonas.io)

👉 Under the hood of event listeners in React:  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io) 

👉 A DIY guide to build your own React:  ![](https://gist.github.com/romain-trotard/76313af8170809970daa7ff9d87b0dd5?ref=jonas.io)

👉 useSyncExternalStore First Look:  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 Under the hood of React's hooks system:  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 Why Do React Hooks Rely on Call Order? (By Dan Abramov:  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 So you think you know everything about React refs:  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 react-use: Reusable React Hook Library (GitHub repository):  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)

👉 react-hookz: React hooks done right (GitHub repository):  ![](https://overreacted.io/writing-resilient-components/?ref=jonas.io)


I will try to keep this list updated over time. If you have additional suggestions, please add them to the Q&A of this lecture.

## JSX
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4ec16f61-f3fd-461b-8d4c-e4832fc232c0)
- {} this one for putting js in html
- ${} this one is for putting into js string 
```jsx
import React from "react";
import ReactDOM from "react-dom";

const name = "jitu";
const fullName = `${name} birla`;
console.log(fullName);

ReactDOM.render(<h1>Hello World! {name}</h1>, document.getElementById("root"));

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5ae77c9b-b917-46ba-9416-ddd2917fef65)

### JSX Attributes and Styling
- alt + click for mutiple select and edit
- We have use JavaScript attribute for html element like camelCase `className`
- [React Styling Practice ](https://codesandbox.io/s/react-styling-practice-completed-forked-9cwg0n)

```jsx
import React from "react";
import ReactDOM from "react-dom";

const img = "https://picsum.photos/200";

ReactDOM.render(
  <div>
    <h1 className="heading">My Favourite Foods</h1>
    <img alt="random" src={img + "?grayscale"} />
  </div>,
  document.getElementById("root")
);
//-------------------------------------------------------
import React from "react";
import ReactDOM from "react-dom";

const customStyle = {
  color: "red",
  fontSize: "20px",
  border: "1px solid black"
};

customStyle.color = "blue";

ReactDOM.render(
  <div>
    <h1 style={{ color: "red" }}>Hello World!</h1>,
    <h1 style={customStyle}>Hello World!</h1>
  </div>,
  document.getElementById("root")
);

```
---
## Conditional Rendering in JSX
### Using `&&`
- This will execute anything when isOpen will true and it work with truthy and falsy values
```js
isOpen && <anything>
```

### Using ternary operator
```js
  numPizzas > 0 ? when true :when false
```
### Multiple Returns
```js
   if (pizzaObj.soldOut) return null;
   
   retrun(
   <div>
   asdsad
   </div>
   )

```



