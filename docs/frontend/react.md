# React
## Debugging
### Double Rendering
   - In the Development environment components two times render because of React.StrictMode but not in production
### React Developer Tools
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/31ff09cd-4690-455a-b775-dddbbb5c12fa)
---
## Immutable Operations in React
### Add object to array
```js
const newBook = {
  id: 6,
  title: "Harry Potter and the Chamber of Secrets",
  author: "J. K. Rowling",
};
const booksAfterAdd = [...books, newBook];
```
```js
function handleAddItems(item) {
    setItems((items) => [...items, item]);
  }
```
### Delete book object from array
```js
const booksAfterDelete = booksAfterAdd.filter((book) => book.id !== 3);
```
```js
function handleDeleteItem(id) {
    setItems((items) => items.filter((item) => item.id !== id));
  }
```

### Update book object in the array
```js
const booksAfterUpdate = booksAfterDelete.map((book) =>
  book.id === 1 ? { ...book, pages: 1210 } : book
);
```
```js
  function handleToggleItem(id) {
    setItems((items) =>
      items.map((item) =>
        item.id === id ? { ...item, packed: !item.packed } : item
      )
    );
  }
  
```
  

### Add property in Object
```js
const originalObject = { foo: 'bar' };
const newObject = { ...originalObject, baz: 'qux' };

console.log(originalObject); // Output: { foo: 'bar' }
console.log(newObject); // Output: { foo: 'bar', baz: 'qux' }
```

### Update a property in Object
```js
const originalObject = { foo: 'bar', baz: 'qux' };
const updatedObject = { ...originalObject, baz: 'updated value' };

console.log(originalObject); // Output: { foo: 'bar', baz: 'qux' }
console.log(updatedObject); // Output: { foo: 'bar', baz: 'updated value' }
```
### Deletea property in Object
```js
const originalObject = { foo: 'bar', baz: 'qux' };
const { baz, ...newObject } = originalObject;

console.log(originalObject); // Output: { foo: 'bar', baz: 'qux' }
console.log(newObject); // Output: { foo: 'bar' }

```
---

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
- //5 falsy values: 0, '', undefined, null, NaN

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
### Get all the props in props object or deconstruct at the time of receiving args
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
### Children Prop
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/51772edf-bd6c-40af-a4de-0f69df62ad12)

### Passing element (jsx) as prop 
- it alternative to children's prop
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/05cd42f9-04d0-404a-8160-438076db0019)

---
## State
### Always update state using callback
```js
 if (step < 3) {
      setStep((s) => s + 1);  // Correct way
      // setStep(step + 1); //incorrect way
    }
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ca249702-402b-4ccb-97a7-d2f3453d98e2)


### State uplifting
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4ef0ba05-4667-4f0f-adcc-1397dd125ee8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4b2876ed-7b67-4b38-a3ea-65e9fe6fa4cf)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/fa0c32ca-d30c-4a76-859c-366bda326572)

```js
export default function App() {
  const [items, setItems] = useState([]);
   
    function handleAddItems(item) {
    setItems((items) => [...items, item]);
  }

   
<Form onAddItems={handleAddItems} />
      <PackingList
        items={items}
   />
}

export default function Form({ onAddItems }) {
onAddItems(newItem);
}

```
### Derived State
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8def28cb-e36c-443e-969d-d8acf5661481)
---
## Hooks
### useEffect
- Sideeffect must be run in evenhandler or useEffect not in render logic
- useEffect always executes after browser paint
- ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/14137f9c-7feb-4c5f-8149-f2b143b3a729)
- _Every state variable and prop used inside the effect MUST be included in the dependency array_
- ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dbaed0fb-629a-4561-b042-5c1d4b1e119e)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e2d0a3c6-4046-4378-a220-23c5d535b181)
- cleaning up a data fetching
```js
useEffect(
    function () {
      const controller = new AbortController();
      async function fetchMovies() {
        try {
          setIsLoading(true);
          setError("");

          const res = await fetch(
            `http://www.omdbapi.com/?apikey=${KEY}&s=${query}`,
            { signal: controller.signal }
          );

          if (!res.ok)
            throw new Error("Something went wrong with fetching movies");

          const data = await res.json();
          if (data.Response === "False") throw new Error("Movie not found");

          setMovies(data.Search);
          setError("");
        } catch (err) {
          if (err.name !== "AbortError") {
            console.log(err.message);
            setError(err.message);
          }
        } finally {
          setIsLoading(false);
        }
      }

      if (query.length < 3) {
        setMovies([]);
        setError("");
        return;
      }

      handleCloseMovie();
      fetchMovies();

      return function () {
        controller.abort();
      };
    },
    [query]
  );

```
### useRef
- How not to select DOM element in react
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2b39cc70-d24a-46af-862c-2e20a96c9fcd)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/044faef8-2b92-4a62-b5ad-583dac841bd1)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8bcd0280-2868-4fda-96c7-18c800f6fb81)

### custom Hooks
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/bdd82100-ab04-4b64-8fc7-62e3e8045e63)

---
## Rendering
- React reacts to state changes by re-rendering the UI
- Rendering or re-rendering basically executes the component function
- Child component Re-render when props changed by parent
- 
- 

---
## Thinking in react at 10000 Feet
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dba0cf80-41af-446e-ac98-e80c69e41003)
### UI to components
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ea3687b9-18b5-4c5a-bb18-9eb6658031e8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3a6e6cf5-0342-486a-891e-55c94bd2da40)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/79f37268-d54a-4c03-a2f4-a3a05d862c12)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/12a1598d-449e-45fb-a0f1-486571b85365)

---
## React Behind the scene
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/cf36def3-9a0d-44f8-881c-120546b16706)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6b190f85-a807-4cc7-a309-ff3ad3f95dd5)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/91a448e5-2c5e-4f51-b467-5f0b18f4c31f)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4f7daf1e-1e0d-4539-852b-d9582b38a665)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2dcae7c2-8bde-43d0-996f-a93e8bf1ba1c)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4731d726-5805-473f-83ab-1d24f4b02a3b)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3f288117-a426-4ed8-b878-8fdb6d357143)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/eeb75ec8-4642-4bdf-b642-12c2e05e84c7)
### Practical Summary
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2aec1dbb-314c-4146-b2c0-90245fa5efc5)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d939836d-b8e4-4ba0-80c7-510f441b6e90)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3d14da2b-4057-4a48-9ff6-6c5c37602348)

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
