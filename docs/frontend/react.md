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
### Styling options in React App
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3e2e817e-ccce-46dc-950c-6f39fcb366fd)

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

### useReducer
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/89763412-c7b5-4173-821d-6a008f68e444)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/65feea24-b104-414d-b785-9a5b0d8bb3aa)

### useParams
- This hooks help in getting param value from URL in react router

### useSearchParams
- This hook helps in getting and setting queryString values in URL

### useNavigate
- This hook helps us in automatically navigation and back navigation
- 
### useContext
- This hook help child componet of provider to subcribe the context and get the value from providers
` const { onClearPosts } = useContext(PostContext);`


---
## Rendering
- React reacts to state changes by re-rendering the UI
- Rendering or re-rendering basically executes the component function
- Child component Re-render when props changed by parent
- 
- 
---
## React Router
- Routing
```jsx
 <BrowserRouter>
          <Suspense fallback={<SpinnerFullPage />}>
            <Routes>
              <Route index element={<Homepage />} />
              <Route path="product" element={<Product />} />
              <Route path="pricing" element={<Pricing />} />
              <Route path="login" element={<Login />} />
              <Route
                path="app"
                element={
                  <ProtectedRoute>
                    <AppLayout />
                  </ProtectedRoute>
                }
              >
                <Route index element={<Navigate replace to="cities" />} />
                <Route path="cities" element={<CityList />} />
                <Route path="cities/:id" element={<City />} />
                <Route path="countries" element={<CountryList />} />
                <Route path="form" element={<Form />} />
              </Route>
              <Route path="*" element={<PageNotFound />} />
            </Routes>
          </Suspense>
        </BrowserRouter>
```
- Navingation using Link and Navlink
- The <NavLink> component extends the functionality of <Link> by providing additional features specifically for styling and active class assignment. It adds an extra CSS class to the rendered element when it matches the current URL, allowing you to apply custom styles to the active link. 
```jsx
      <nav className={styles.nav}>
      <Logo />

      <ul>
        <li>
          <NavLink to="/pricing">Pricing</NavLink>
        </li>
        <li>
          <NavLink to="/product">Product</NavLink>
        </li>
        <li>
          <NavLink to="/login" className={styles.ctaLink}>
            Login
          </NavLink>
        </li>
      </ul>
    </nav>
 ```
### Nested Routes
- in the above Routing you can check app link which has nested routing
- All the components of app router will render inside `  <AppLayout />` we can put it anywhere inside the app layout or child of `  <AppLayout />` component using ` <Outlet />` tag
### URL for State Management
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/56f0eba5-5a99-48a9-81d8-482a5d9491d0)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6f3b9068-c8ba-453e-ba1e-3724fe713698)
### for Param
- http://localhost:5173/app/cities/**17806751**
```js
// create new route
 <Route path="cities/:id" element={<City />} />

// Create link on items
  <Link
        className={`${styles.cityItem} ${
          id === currentCity.id ? styles["cityItem--active"] : ""
        }`}
  to={`${id}`}
>
// get that param value in componnet `<City />`
const { id } = useParams();
 <Link
        className={`${styles.cityItem} ${
          id === currentCity.id ? styles["cityItem--active"] : ""
        }`}
  to={`${id}`}
```
### For Query String
```js
// create link 
<Link
        className={`${styles.cityItem} ${
          id === currentCity.id ? styles["cityItem--active"] : ""
        }`}
        to={`${id}?lat=${position.lat}&lng=${position.lng}`}
>
// get the query string data
  const [searchParams, setSearchParams] = useSearchParams();
  const lat = searchParams.get("lat");
  const lng = searchParams.get("lng");


```
### Programmatic navigation
- Navigate automatically from one page to another page and even back in history
- Ex1
```js
   const navigate = useNavigate();
    navigate("/app/cities");
```
- Ex2
 ```js
function BackButton() {
  const navigate = useNavigate();

  return (
    <Button
      type="back"
      onClick={(e) => {
        e.preventDefault();
        navigate(-1);
      }}
    >
      &larr; Back
    </Button>
  );
}
```
---
## Context API
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2c5325a4-fa24-465f-929b-d4fcf0d13551)
- Context api mostly using by Custom Provider
- Create seprate context file
- Create custome componet like below `PostProvider` create context obejct in the file
- Put all your state logic here which we have to pass in all child components
- Return `    <PostContext.Provider value={value}>{children}</PostContext.Provider> ` whree value will be value object which contains all the states and function which are required for child components
- Create custom hook for `useContext` so that all subscribe can direcly use this custom hook and no required for `useContext` hook

```js

function createRandomPost() {
  return {
    title: `${faker.hacker.adjective()} ${faker.hacker.noun()}`,
    body: faker.hacker.phrase(),
  };
}

// 1) CREATE A CONTEXT
const PostContext = createContext();

function PostProvider({ children }) {
  const [posts, setPosts] = useState(() =>
    Array.from({ length: 30 }, () => createRandomPost())
  );
  const [searchQuery, setSearchQuery] = useState("");

  // Derived state. These are the posts that will actually be displayed
  const searchedPosts =
    searchQuery.length > 0
      ? posts.filter((post) =>
          `${post.title} ${post.body}`
            .toLowerCase()
            .includes(searchQuery.toLowerCase())
        )
      : posts;

  function handleAddPost(post) {
    setPosts((posts) => [post, ...posts]);
  }

  function handleClearPosts() {
    setPosts([]);
  }

  const value = useMemo(() => {
    return {
      posts: searchedPosts,
      onAddPost: handleAddPost,
      onClearPosts: handleClearPosts,
      searchQuery,
      setSearchQuery,
    };
  }, [searchedPosts, searchQuery]);

  return (
    // 2) PROVIDE VALUE TO CHILD COMPONENTS
    <PostContext.Provider value={value}>{children}</PostContext.Provider>
  );
}

function usePosts() {
  const context = useContext(PostContext);
  if (context === undefined)
    throw new Error("PostContext was used outside of the PostProvider");
  return context;
}

export { PostProvider, usePosts };
//------------------------------------------
// 3) CONSUMING CONTEXT VALUE
  const { onClearPosts } = usePosts();


```
---
## Authentication
- Create login context
- Use that login xontext in login , logout components
- Create a protected componet and wrappe whole application inside the protected component
```js
import { createContext, useContext, useReducer } from "react";

const AuthContext = createContext();

const initialState = {
  user: null,
  isAuthenticated: false,
};

function reducer(state, action) {
  switch (action.type) {
    case "login":
      return { ...state, user: action.payload, isAuthenticated: true };
    case "logout":
      return { ...state, user: null, isAuthenticated: false };
    default:
      throw new Error("Unknown action");
  }
}

const FAKE_USER = {
  name: "Jack",
  email: "jack@example.com",
  password: "qwerty",
  avatar: "https://i.pravatar.cc/100?u=zz",
};

function AuthProvider({ children }) {
  const [{ user, isAuthenticated }, dispatch] = useReducer(
    reducer,
    initialState
  );

  function login(email, password) {
    if (email === FAKE_USER.email && password === FAKE_USER.password)
      dispatch({ type: "login", payload: FAKE_USER });
  }

  function logout() {
    dispatch({ type: "logout" });
  }

  return (
    <AuthContext.Provider value={{ user, isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

function useAuth() {
  const context = useContext(AuthContext);
  if (context === undefined)
    throw new Error("AuthContext was used outside AuthProvider");
  return context;
}

export { AuthProvider, useAuth };
```
- Protected component
```js
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/FakeAuthContext";

function ProtectedRoute({ children }) {
  const { isAuthenticated } = useAuth();
  const navigate = useNavigate();

  useEffect(
    function () {
      if (!isAuthenticated) navigate("/login");
    },
    [isAuthenticated, navigate]
  );

  return isAuthenticated ? children : null;
}

export default ProtectedRoute;

```
- Wrapping application in protected component
```jsx
  <Route
                path="app"
                element={
                  <ProtectedRoute>
                    <AppLayout />
                  </ProtectedRoute>
                }
              >
                <Route index element={<Navigate replace to="cities" />} />
                <Route path="cities" element={<CityList />} />
                <Route path="cities/:id" element={<City />} />
                <Route path="countries" element={<CountryList />} />
                <Route path="form" element={<Form />} />
              </Route>
```
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
![react-behind-scene](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b394b498-0c89-4816-8f43-974d19ab6da8)

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
## Utility
### Json server
- json server is creating a fake API using json file , we can use this for frontend development while backend is in development
- install json server `$ npm i json-server`
- Change in package.json file as below for json run command
```json
  "scripts": {
    "start": "react-scripts start",
    "build": "react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject",
    "server": "json-server --watch data/questions.json --port 9000"
  },
```
- put your json file in data folder questions.json
- start the json server `$ npm run server`
- use API using http://localhost:9000/questions
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

### Component Libraries: 
- Utilizing component libraries or UI frameworks can provide pre-built, reusable components and styles for your application. Libraries like Material-UI, Ant Design, or Bootstrap offer a wide range of reusable components that you can leverage in your projects, saving development time and effort.

### Compound Components:
- Compound Components is a pattern where a parent component wraps multiple child components and controls their behavior and state. The child components are designed to work together as a group and are tightly coupled with the parent component. They share a common context or state managed by the parent.
- https://codesandbox.io/s/react-compound-components-final-igzh7c

---
## State tool decision
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/72a2c252-23a2-4e06-8316-9c392dfce7e8)

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/db4482b3-1801-4ca0-b88b-66cb190d87af)

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b9cb0fbd-7eec-432d-965f-fcb0838b9ade)

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d5041f87-dc12-4e04-9d3f-6f7b75c1ddb5)

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/02a5c0ae-3a16-4def-a6cc-8d6c31fb571c)

