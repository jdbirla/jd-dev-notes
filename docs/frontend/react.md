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
## Debugging
### Double Rendering
   - In the Development environment components two times render because of React.StrictMode but not in production
### React Developer Tools
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/31ff09cd-4690-455a-b775-dddbbb5c12fa)



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
---
## Props
- Get all the props in props object or deconstruct at the time of receiving args
 ```jsx
  <Pizza pizzaObj={pizza} key={pizza.name} jd="birla" />
function Pizza(props) {
  console.log(props); 
/*  {
    "pizzaObj": {
        "name": "Pizza Prosciutto",
        "ingredients": "Tomato, mozarella, ham, aragula, and burrata cheese",
        "price": 18,
        "photoName": "pizzas/prosciutto.jpg",
        "soldOut": false
    },
    "jd": "birla"
    -----
    birla
}*/
function Pizza({ pizzaObj }) {}
  
```
---
## State
### Always update state using callback
```js
 if (step < 3) {
      setStep((s) => s + 1);  // Correct way
      // setStep(step + 1); //incorrect way
    }
```
### Thinking in react for State

---
## Rendering
- React reacts to state changes by re-rendering the UI
- Rendering or re-rendering basically executes the component function
- Child component Re-render when props changed by parent
---
## Thinking in react at 10000 Feet

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dba0cf80-41af-446e-ac98-e80c69e41003)


---
## Reusability in react
### Component Composition: 
- This technique involves composing smaller, reusable components together to build larger components or user interfaces. By breaking down your UI into smaller, self-contained components, you can reuse them across different parts of your application. For example, you can create a Button component and reuse it in various places wherever a button is needed.
- Component Composition is a pattern where smaller, reusable components are composed together to build larger components or user interfaces. Each component remains independent and doesn't rely on specific knowledge or state from other components.
- 
```js
// Reusable components
function Header() {
  return <h1>Header</h1>;
}

function Sidebar() {
  return <div>Sidebar</div>;
}

function Content() {
  return <div>Content</div>;
}

// Composition of components
function App() {
  return (
    <div>
      <Header />
      <div className="container">
        <Sidebar />
        <Content />
      </div>
    </div>
  );
}


```
### Props:
- Props allow you to pass data from a parent component to its child components. By passing different values to the props, you can reuse a component with varying data and behavior. For example, you can create a List component that receives an array of items as props, making it reusable for displaying different lists of items.
```js

// Reusable List component
function List(props) {
  return (
    <ul>
      {props.items.map((item) => (
        <li key={item.id}>{item.name}</li>
      ))}
    </ul>
  );
}

// Example usage
function App() {
  const items = [
    { id: 1, name: "Item 1" },
    { id: 2, name: "Item 2" },
    { id: 3, name: "Item 3" },
  ];

  return (
    <div>
      <h1>Props Example</h1>
      <List items={items} />
    </div>
  );
}

```
### Higher-Order Components (HOCs):
- HOCs are functions that take a component as input and return a new enhanced component. They allow you to add additional functionality or modify the behavior of a component without directly modifying its source code. HOCs can be used for cross-cutting concerns like authentication, data fetching, or logging. For example, you can create an withLogger HOC that wraps a component and adds logging capabilities to it.
- https://codesandbox.io/s/react-render-props-final-elme76?file=/src/HOC.js
```js
// HOC that adds logging functionality to a component
function withLogger(WrappedComponent) {
  return function WithLogger(props) {
    useEffect(() => {
      console.log(`Component ${WrappedComponent.name} mounted`);
      return () => {
        console.log(`Component ${WrappedComponent.name} unmounted`);
      };
    }, []);

    return <WrappedComponent {...props} />;
  };
}

// Example usage
function MyComponent(props) {
  return <div>My Component</div>;
}

const EnhancedComponent = withLogger(MyComponent);

function App() {
  return (
    <div>
      <h1>HOC Example</h1>
      <EnhancedComponent />
    </div>
  );
}

```
### Render Props: 
- The Render Props pattern involves passing a function as a prop to a component, allowing the component to render the content provided by that function. It enables sharing logic or data between components by making the rendering behavior customizable. For example, you can create a Toggle component that uses a render prop to determine what to render when a button is toggled.

- https://codesandbox.io/s/react-render-props-final-elme76

### Hooks: 
- Hooks are a feature introduced in React 16.8 that allow you to reuse stateful logic within functional components. By creating custom hooks, you can encapsulate reusable logic and use it in multiple components. Hooks like useState, useEffect, and useContext are built-in hooks that promote code reuse and modularity.

## Component Libraries: 
- Utilizing component libraries or UI frameworks can provide pre-built, reusable components and styles for your application. Libraries like Material-UI, Ant Design, or Bootstrap offer a wide range of reusable components that you can leverage in your projects, saving development time and effort.

## Compound Components:
- Compound Components is a pattern where a parent component wraps multiple child components and controls their behavior and state. The child components are designed to work together as a group and are tightly coupled with the parent component. They share a common context or state managed by the parent.
- https://codesandbox.io/s/react-compound-components-final-igzh7c
