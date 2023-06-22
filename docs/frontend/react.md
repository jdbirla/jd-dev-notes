# React
## Debugging

### Double Rendering
   - In the Development environment components two times render because of React.StrictMode but not in production
### React Developer Tools
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/31ff09cd-4690-455a-b775-dddbbb5c12fa)
### Redux Devtool
- Add chrome extension Redux devtool
- install `npm I redux-devtools-extension`
- wrap inside `composeWithDevTools`
  ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f156d2a7-8d0c-4569-a533-13e6de09f7eb)

### Profiler
- go in profile and update setting for reson for re render
- start recroding
- change state means do any operation which will change state
- stop recording and you can see why each compone re render
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/89b22199-d1a1-4704-949f-5b50ff8aa73e)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/96a823f3-6248-42f2-b4ba-d916f1700d3e)
### React Query Dev Tool
 Install `@tanstack/react-query-devtools`
```
<QueryClientProvider client={queryClient}>
      <ReactQueryDevtools initialIsOpen={false} />
```

![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/68f8b5ab-1847-46d1-8dbc-f66a351926de)

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
```js
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

```js
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
###  Using Style Property
```js
<div style={{ display: showInfo ? "block" : "none" }}>info</div>
```
---
## Props
### Get all the props in props object or deconstruct at the time of receiving args
```js
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
![react-state-decision drawio](https://github.com/jdbirla/jd-dev-notes/assets/69948118/07685b16-e7f5-4829-ae03-c691e71a19bd)

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
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b1dfaec6-d591-4d85-b330-4bbb2901af56)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b2fadf48-f067-4730-88a5-2e93b18edc61)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6eaa0827-bac0-446e-a7f9-4eb5fdf96d87)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/9857aba8-c04c-4c6f-9059-08b085730c96)


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
### useContext
- This hook help child componet of provider to subcribe the context and get the value from providers
` const { onClearPosts } = useContext(PostContext);`


---
## Rendering
- React reacts to state changes by re-rendering the UI
- Rendering or re-rendering basically executes the component function
- Child component Re-render when props changed by parent

---
## React Router
- Routing
```js
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
```js
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
```js
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
## Redux
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/be7ddc3b-e958-457b-8177-318e78b7efc3)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/90b97cd3-2eb3-4931-ac26-9b447423ca5b)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a6f24c22-aa2d-4723-b89e-8be9d628b5eb)

### Redux in Isolation without react using classic redux
- We can't change state and no asynchronous logic
```js
import { combineReducers, createStore } from "redux";

const initialStateAccount = {
  balance: 0,
  loan: 0,
  loanPurpose: "",
};

const initialStateCustomer = {
  fullName: "",
  nationalID: "",
  createdAt: "",
};

function accountReducer(state = initialStateAccount, action) {
  switch (action.type) {
    case "account/deposit":
      return { ...state, balance: state.balance + action.payload };
    case "account/withdraw":
      return { ...state, balance: state.balance - action.payload };
    case "account/requestLoan":
      if (state.loan > 0) return state;
      // LATER
      return {
        ...state,
        loan: action.payload.amount,
        loanPurpose: action.payload.purpose,
        balance: state.balance + action.payload.amount,
      };
    case "account/payLoan":
      return {
        ...state,
        loan: 0,
        loanPurpose: "",
        balance: state.balance - state.loan,
      };

    default:
      return state;
  }
}

function customerReducer(state = initialStateCustomer, action) {
  switch (action.type) {
    case "customer/createCustomer":
      return {
        ...state,
        fullName: action.payload.fullName,
        nationalID: action.payload.nationalID,
        createdAt: action.payload.createdAt,
      };
    case "customer/updateName":
      return { ...state, fullName: action.payload };
    default:
      return state;
  }
}

const rootReducer = combineReducers({
  account: accountReducer,
  customer: customerReducer,
});

const store = createStore(rootReducer);

// store.dispatch({ type: "account/deposit", payload: 500 });
// store.dispatch({ type: "account/withdraw", payload: 200 });
// console.log(store.getState());
// store.dispatch({
//   type: "account/requestLoan",
//   payload: { amount: 1000, purpose: "Buy a car" },
// });
// console.log(store.getState());
// store.dispatch({ type: "account/payLoan" });
// console.log(store.getState());

// const ACOOUNT_DEPOSIT = "account/deposit";

function deposit(amount) {
  return { type: "account/deposit", payload: amount };
}

function withdraw(amount) {
  return { type: "account/withdraw", payload: amount };
}

function requestLoan(amount, purpose) {
  return {
    type: "account/requestLoan",
    payload: { amount, purpose },
  };
}

function payLoan() {
  return { type: "account/payLoan" };
}

store.dispatch(deposit(500));
store.dispatch(withdraw(200));
console.log(store.getState());

store.dispatch(requestLoan(1000, "Buy a cheap car"));
console.log(store.getState());
store.dispatch(payLoan());
console.log(store.getState());

function createCustomer(fullName, nationalID) {
  return {
    type: "customer/createCustomer",
    payload: { fullName, nationalID, createdAt: new Date().toISOString() },
  };
}

function updateName(fullName) {
  return { type: "account/updateName", payload: fullName };
}

store.dispatch(createCustomer("Jonas Schmedtmann", "24343434"));
store.dispatch(deposit(250));
console.log(store.getState());

```
### Create a slice of the store based on features

### React- redux
- Connect redux with react
```js
import React from "react";
import ReactDOM from "react-dom/client";
import { Provider } from "react-redux";
import "./index.css";
import App from "./App";

import store from "./store";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>
);
//------------------------------------------------------
import { applyMiddleware, combineReducers, createStore } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";

import accountReducer from "./features/accounts/accountSlice";
import customerReducer from "./features/customers/customerSlice";

const rootReducer = combineReducers({
  account: accountReducer,
  customer: customerReducer,
});

const store = createStore(
  rootReducer
);

export default store;
//------------------------------------------------------
import { useSelector } from "react-redux";

function Customer() {
  const customer = useSelector((store) => store.customer.fullName);

  return <h2>👋 Welcome, {customer}</h2>;
}

export default Customer;

//------------------------------------------------------

  const dispatch = useDispatch();

  function handleClick() {
    if (!fullName || !nationalId) return;
    dispatch(createCustomer(fullName, nationalId));
  }
```
### Redux Middleware
- For Asynchronous API call
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c91c4ad1-1ac5-4a40-9455-3ddcf6058cea)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5c2f4485-d3dc-46fb-a9ff-1f109d408010)
- For thunk we should call sync function before returning the dispatch function in action creator funciton
- accountslice.js
```js
  export default function accountReducer(state = initialState, action) {
  switch (action.type) {
    case "account/deposit":
      return {
        ...state,
        balance: state.balance + action.payload,
        isLoading: false,
      };
    case "account/withdraw":
      return { ...state, balance: state.balance - action.payload };
    case "account/requestLoan":
      if (state.loan > 0) return state;
      // LATER
      return {
        ...state,
        loan: action.payload.amount,
        loanPurpose: action.payload.purpose,
        balance: state.balance + action.payload.amount,
      };
    case "account/payLoan":
      return {
        ...state,
        loan: 0,
        loanPurpose: "",
        balance: state.balance - state.loan,
      };
    case "account/convertingCurrency":
      return { ...state, isLoading: true };

    default:
      return state;
  }
}

export function deposit(amount, currency) {
  if (currency === "USD") return { type: "account/deposit", payload: amount };

  return async function (dispatch, getState) {
    dispatch({ type: "account/convertingCurrency" });

    const res = await fetch(
      `https://api.frankfurter.app/latest?amount=${amount}&from=${currency}&to=USD`
    );
    const data = await res.json();
    const converted = data.rates.USD;

    dispatch({ type: "account/deposit", payload: converted });
  };
}

export function withdraw(amount) {
  return { type: "account/withdraw", payload: amount };
}

export function requestLoan(amount, purpose) {
  return {
    type: "account/requestLoan",
    payload: { amount, purpose },
  };
}

export function payLoan() {
  return { type: "account/payLoan" };
}
```
- store.js
```js
import { applyMiddleware, combineReducers, createStore } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";

import accountReducer from "./features/accounts/accountSlice";
import customerReducer from "./features/customers/customerSlice";

const rootReducer = combineReducers({
  account: accountReducer,
  customer: customerReducer,
});

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(thunk))
);

export default store;

```
### Reduxc Tool Kit
- Modern way to write redux code
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/08774d5f-72e8-4da4-87f2-d20371908d46)
- We can write code that “mutates” state inside reducers (will be converted to immutable logic behind the scenes by “Immer” library)
- Action creators are automatically created and Automatic setup of thunk middleware and DevTools
- store.js
```js

import { configureStore } from "@reduxjs/toolkit";

import accountReducer from "./features/accounts/accountSlice";
import customerReducer from "./features/customers/customerSlice";

const store = configureStore({
  reducer: {
    account: accountReducer,
    customer: customerReducer,
  },
});

export default store;
```
- accountslice.js
```js
import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  balance: 0,
  loan: 0,
  loanPurpose: "",
  isLoading: false,
};

const accountSlice = createSlice({
  name: "account",
  initialState,
  reducers: {
    deposit(state, action) {
      state.balance += action.payload;
      state.isLoading = false;
    },
    withdraw(state, action) {
      state.balance -= action.payload;
    },
    requestLoan: {
      prepare(amount, purpose) {
        return {
          payload: { amount, purpose },
        };
      },

      reducer(state, action) {
        if (state.loan > 0) return;

        state.loan = action.payload.amount;
        state.loanPurpose = action.payload.purpose;
        state.balance = state.balance + action.payload.amount;
      },
    },
    payLoan(state) {
      state.balance -= state.loan;
      state.loan = 0;
      state.loanPurpose = "";
    },
    convertingCurrency(state) {
      state.isLoading = true;
    },
  },
});

export const { withdraw, requestLoan, payLoan } = accountSlice.actions;

export function deposit(amount, currency) {
  if (currency === "USD") return { type: "account/deposit", payload: amount };

  return async function (dispatch, getState) {
    dispatch({ type: "account/convertingCurrency" });

    const res = await fetch(
      `https://api.frankfurter.app/latest?amount=${amount}&from=${currency}&to=USD`
    );
    const data = await res.json();
    const converted = data.rates.USD;

    dispatch({ type: "account/deposit", payload: converted });
  };
}

export default accountSlice.reducer;
```
---
## React Router for 
- New way of fetching data right inside React Router (v6.4+) that is worth exploring (“render-as-you-fetch” instead of “fetch-onrender”). Not really state management, as it doesn't persist state.

---
## Performance Optimization
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/9a757535-1e74-4b83-9776-4cf572eb6c2a)

### 1. Child re render
- When parent componet has a state and a slow componet is child componet and when changing state in parent is re rendering the slow compone as well and if slow compone is not using that state it isolate then
- we have to pass that slow component as children prop in parent component so that children compone won't re render while changing state in parent component
```js
function Counter({ children }) {
  const [count, setCount] = useState(0);
  return (
    <div>
      <h1>Slow counter?!?</h1>
      <button onClick={() => setCount((c) => c + 1)}>Increase: {count}</button>

      {children}
    </div>
  );
}

export default function Test() {
  // const [count, setCount] = useState(0);
  // return (
  //   <div>
  //     <h1>Slow counter?!?</h1>
  //     <button onClick={() => setCount((c) => c + 1)}>Increase: {count}</button>

  //     <SlowComponent />
  //   </div>
  // );

  return (
    <div>
      <h1>Slow counter?!?</h1>
      <Counter>
        <SlowComponent />
      </Counter>
    </div>
  )

```
### Memoization
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a843402c-9f99-4507-a3d5-0edacd2ebd39)
#### The Memo function
- Memoizing the component
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4d6664ac-22d1-4665-8e6a-c71df8ff983b)
- its required when child componets prop is not changing frequently,`memo` function chache the result if prop is not changing , if prop is changin only  then it will re rendered 
```js
const Archive = memo( component)
```
#### useMemo and useCALLBACK
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b469173e-b911-42e3-a16d-24c3c34809d8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a99b7e3e-cf8a-4278-8769-6fd9c4c43287)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/16f227b1-e81f-4b2a-9d61-f2cb8a72769e)
- useMemo
- memo not working in object and function when we pass as en prop for that for object we have to use `useMemo` and pass the dependency when this object has to re created else fetch from cache
```js
const archiveOptions = useMemo(() => {
    return {
      show: false,
      title: `Post archive in addition to ${posts.length} main posts`,
    };
  }, [posts.length]);
   <Archive
        archiveOptions={archiveOptions}
        onAddPost={handleAddPost}
        setIsFakeDark={setIsFakeDark}
      />
```
```js
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
```
- useCallback
- memo not working in object and function when we pass as an prop for that for function we have to use `useCallback` and pass the dependency when this function has to re created else fetch from cache
```js
  const handleAddPost = useCallback(function handleAddPost(post) {
    setPosts((posts) => [post, ...posts]);
  }, []);
  
   <Archive
        archiveOptions={archiveOptions}
        onAddPost={handleAddPost}
        setIsFakeDark={setIsFakeDark}
      />
```
### Optimizing Bundle size
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e28afdfd-9e0c-4f69-bfc7-340166c706c6)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d177785c-f63e-4032-b31d-13e207c368c5)
- Split bundle based on per page
```js
const Homepage = lazy(() => import("./pages/Homepage"));
const Product = lazy(() => import("./pages/Product"));
const Pricing = lazy(() => import("./pages/Pricing"));
const Login = lazy(() => import("./pages/Login"));
const AppLayout = lazy(() => import("./pages/AppLayout"));
const PageNotFound = lazy(() => import("./pages/PageNotFound"));


-  Suspense will suspend while js downloading from server       
```js
<Suspense fallback={<SpinnerFullPage />}>
```
---
## React Query
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1b765ed2-4f60-4717-bdd1-49f761dc6dda)

- setting the wild oasis project
- get the api key from supabase and put into supabase api variable
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/016c9885-46a3-4ca1-808c-f6b845fc30a5)
- app.js
```js
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      // staleTime: 60 * 1000,
      staleTime: 0,
    },
  },
});

<QueryClientProvider client={queryClient}>
      <ReactQueryDevtools initialIsOpen={false} />

      <GlobalStyles />
      <BrowserRouter>
        <Routes>
          <Route element={<AppLayout />}>
            <Route index element={<Navigate replace to="dashboard" />} />
            <Route path="dashboard" element={<Dashboard />} />
            <Route path="bookings" element={<Bookings />} />
            <Route path="cabins" element={<Cabins />} />
            <Route path="users" element={<Users />} />
            <Route path="settings" element={<Settings />} />
            <Route path="account" element={<Account />} />
          </Route>

          <Route path="login" element={<Login />} />
          <Route path="*" element={<PageNotFound />} />
        </Routes>
      </BrowserRouter>

      <Toaster
        position="top-center"
        gutter={12}
        containerStyle={{ margin: "8px" }}
        toastOptions={{
          success: {
            duration: 3000,
          },
          error: {
            duration: 5000,
          },
          style: {
            fontSize: "16px",
            maxWidth: "500px",
            padding: "16px 24px",
            backgroundColor: "var(--color-grey-0)",
            color: "var(--color-grey-700)",
          },
        }}
      />
    </QueryClientProvider>
```
- apiCabins.js
```js
export async function getCabins() {
  const { data, error } = await supabase.from("cabins").select("*");

  if (error) {
    console.error(error);
    throw new Error("Cabins could not be loaded");
  }

  return data;
}
```
- useCabins.js
```js
import { useQuery } from "@tanstack/react-query";
import { getCabins } from "../../services/apiCabins";

export function useCabins() {
  const {
    isLoading,
    data: cabins,
    error,
  } = useQuery({
    queryKey: ["cabins"],
    queryFn: getCabins,
  });

  return { isLoading, error, cabins };
}
```
- Cabins.js
```js
function Cabins() {
  const [showForm, setShowForm] = useState(false);

  return (
    <>
      <Row type="horizontal">
        <Heading as="h1">All cabins</Heading>
        <p>Filter / Sort</p>
      </Row>

      <Row>
        <CabinTable />

        <Button onClick={() => setShowForm((show) => !show)}>
          Add new cabin
        </Button>
        {showForm && <CreateCabinForm />}
      </Row>
    </>
  );
}s

export default Cabins;

```


---
## Thinking in react at 10000 Feet
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dba0cf80-41af-446e-ac98-e80c69e41003)
![Untitled-2023-06-15-0819](https://github.com/jdbirla/jd-dev-notes/assets/69948118/98ade034-ac83-4332-abb2-9f577d3fd7f5)

### UI to components
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ea3687b9-18b5-4c5a-bb18-9eb6658031e8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3a6e6cf5-0342-486a-891e-55c94bd2da40)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/79f37268-d54a-4c03-a2f4-a3a05d862c12)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/12a1598d-449e-45fb-a0f1-486571b85365)




---
## React Behind the scene
![react-behind-scene](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b394b498-0c89-4816-8f43-974d19ab6da8)
![Untitled-2023-06-15-0819](https://github.com/jdbirla/jd-dev-notes/assets/69948118/31406045-d8ca-4215-8aba-5b122c10da53)

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
![Reusability drawio](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b18ecb6c-bd8a-4e95-99ff-44ac9d671349)

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
### Children Prop
- By using the children prop, you can create reusable components that can receive and render different child components or elements. This allows for flexible composition of components and promotes code reuse.
```js
function ParentComponent({ children }) {
  return (
    <div>
      <h1>Parent Component</h1>
      {children}
      <footer>Some footer content</footer>
    </div>
  );
}

<ParentComponent>
  <ChildComponent1 />
  <ChildComponent2 />
  <div>Some text</div>
</ParentComponent>

```
### Higher-Order Components (HOCs):
- HOCs are functions that take a component as input and return a new enhanced component. They allow you to add additional functionality or modify the behavior of a component without directly modifying its source code. HOCs can be used for cross-cutting concerns like authentication, data fetching, or logging. For example, you can create an withLogger HOC that wraps a component and adds logging capabilities to it.
- <https://codesandbox.io/s/react-render-props-final-elme76?file=/src/HOC.js>
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

- <https://codesandbox.io/s/react-render-props-final-elme76>
- 
```js

function List({ title, items, render1 }) {
  const [isOpen, setIsOpen] = useState(true);
  const [isCollapsed, setIsCollapsed] = useState(false);

  const displayItems = isCollapsed ? items.slice(0, 3) : items;

  function toggleOpen() {
    setIsOpen((isOpen) => !isOpen);
    setIsCollapsed(false);
  }

  return (
    <div className="list-container">
      <div className="heading">
        <h2>{title}</h2>
        <button onClick={toggleOpen}>
          {isOpen ? <span>&or;</span> : <span>&and;</span>}
        </button>
      </div>
      {isOpen && <ul className="list">{displayItems.map(render1)}</ul>}

      <button onClick={() => setIsCollapsed((isCollapsed) => !isCollapsed)}>
        {isCollapsed ? `Show all ${items.length}` : "Show less"}
      </button>
    </div>
  );
}

export default function App() {
  return (
    <div>
      <h1>Render Props Demo</h1>

      <div className="col-2">
        <List
          title="Products"
          items={products}
          render1={(product) => (
            <ProductItem key={product.productName} product={product} />
          )}
        />

        <List
          title="Companies"
          items={companies}
          render1={(company) => (
            <CompanyItem
              key={company.companyName}
              company={company}
              defaultVisibility={false}
            />
          )}
        />
      </div>
```

### Custom Hook: 
- By creating custom hooks, you can encapsulate complex logic and state management in a reusable manner
```js
import { useState, useEffect } from 'react';

function useCustomHook(initialValue) {
  const [count, setCount] = useState(initialValue);

  useEffect(() => {
    // Custom logic using useEffect
    document.title = `Count: ${count}`;
  }, [count]);

  const increment = () => {
    setCount(prevCount => prevCount + 1);
  };

  const decrement = () => {
    setCount(prevCount => prevCount - 1);
  };

  return { count, increment, decrement };
}

export default useCustomHook;

import React from 'react';
import useCustomHook from './useCustomHook';

function MyComponent() {
  const { count, increment, decrement } = useCustomHook(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
    </div>
  );
}

export default MyComponent;

```

### Component Libraries: 
- Utilizing component libraries or UI frameworks can provide pre-built, reusable components and styles for your application. Libraries like Material-UI, Ant Design, or Bootstrap offer a wide range of reusable components that you can leverage in your projects, saving development time and effort.

### Compound Components:
- Compound Components is a pattern where a parent component wraps multiple child components and controls their behavior and state. The child components are designed to work together as a group and are tightly coupled with the parent component. They share a common context or state managed by the parent.
- <https://codesandbox.io/s/react-compound-components-final-igzh7c>
```js
import { createContext, useContext, useState } from "react";

// 1. Create a context
const CounterContext = createContext();

// 2. Create parent component
function Counter({ children }) {
  const [count, setCount] = useState(0);
  const increase = () => setCount((c) => c + 1);
  const decrease = () => setCount((c) => c - 1);

  return (
    <CounterContext.Provider value={{ count, increase, decrease }}>
      <span>{children}</span>
    </CounterContext.Provider>
  );
}

// 3. Create child components to help implementing the common task
function Count() {
  const { count } = useContext(CounterContext);
  return <span>{count}</span>;
}

function Label({ children }) {
  return <span>{children}</span>;
}

function Increase({ icon }) {
  const { increase } = useContext(CounterContext);
  return <button onClick={increase}>{icon}</button>;
}

function Decrease({ icon }) {
  const { decrease } = useContext(CounterContext);
  return <button onClick={decrease}>{icon}</button>;
}
// 4. Add child components as proeprties to parent component
Counter.Count = Count;
Counter.Label = Label;
Counter.Increase = Increase;
Counter.Decrease = Decrease;

export default Counter;
//-------------
import Counter from "./Counter";
import "./styles.css";

export default function App() {
  return (
    <div>
      <h1>Compound Component Pattern</h1>
      {/* <Counter
        iconIncrease="+"
        iconDecrease="-"
        label="My NOT so flexible counter"
        hideLabel={false}
        hideIncrease={false}
        hideDecrease={false}
        positionCount="top"
      /> */}

      <Counter>
        <Counter.Label>My super flexible counter</Counter.Label>
        <Counter.Decrease icon="-" />
        <Counter.Increase icon="+" />
        <Counter.Count />
      </Counter>

      <div>
        <Counter>
          <Counter.Decrease icon="◀️" />
          <div>
            <Counter.Count />
          </div>
          <Counter.Increase icon="▶️" />
        </Counter>
      </div>
    </div>
  );
}

```
---
## React Quick Ref
### ApiMarsFetchList
```js
import { useState, useEffect } from "react";

export default function ApiMarsFetchList() {
  const [mars, setMars] = useState([]);
  useEffect(() => {
    fetch("https://fakestoreapi.com/products/")
      .then((res) => res.json())
      .then((data) => setMars(data))
      .catch((err) => console.log(err));
  }, []);

  mars.map((item, index) => console.log(item.id));

  return (
    <>
      <ul>
        {mars.map((item, index) => (
          <li>{item.title}</li>
        ))}
      </ul>
    </>
  );
}

```
### ApiMarsFetchTable
```js
import { useEffect, useState } from "react";

export function ApiMarsFetchTable() {
  const [mars, setMars] = useState([]);

  useEffect(() => {
    fetch(
      "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY"
    )
      .then((res) => {
        if (!res.ok) {
          throw new Error(`mars not found : ${res.status}`);
        }
        return res.json();
      })
      .then((data) => setMars(data.photos))
      .catch((err) => console.error(err))
      .finally(() => {
        console.log("finally");
      });
  }, []);

  return (
    <div className="container-fluid">
      <h2>Mars Rover Photos</h2>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Photo Id</th>
            <th>Preview</th>
            <th>Camera</th>
            <th>Rover</th>
          </tr>
        </thead>
        <tbody>
          {mars.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>
                <img src={item.img_src} width="100" height="100" />
              </td>
              <td>{item.camera.full_name}</td>
              <td>{item.rover.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

```

### ApiUserAxiosList
```js
import { useState, useEffect } from "react";
import axios from "axios";

export default function ApiUserAxiosList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get("https://reqres.in/api/users?page=1").then((response) => {
      setUsers(response.data.data);
    });
  }, []);

  return (
    <div>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.first_name} {user.last_name}
          </li>
        ))}
      </ul>
    </div>
  );
}

```
### Classlifecycle
```js
import React from "react";

export default class Header extends React.Component {
  constructor(props) {
    super(props);
    this.state = { favoritecolor: "red" };
  }
  // static getDerivedStateFromProps(props, state) {
  //   return { favoritecolor: props.favcol };
  // }
  componentDidMount() {
    setTimeout(() => {
      this.setState({ favoritecolor: "yellow" });
    }, 1000);
  }
  render() {
    return <h1>My Favorite Color is {this.state.favoritecolor}</h1>;
  }
}

```
### ContextApi
```js
import { useState, useContext } from "react";
import React from "react";
const CountContext = React.createContext();
const Counter = () => {
  const { count, increase, decrease } = useContext(CountContext);
  return (
    <h2>
      <button className="btn btn-danger" onClick={decrease}>
        Decrement
      </button>
      <span className="count">{count}</span>
      <button className="btn btn-success" onClick={increase}>
        Increment
      </button>
    </h2>
  );
};

// App.js

const ContextApi = () => {
  const [count, setCount] = useState(0);

  const increase = () => {
    setCount(count + 1);
  };
  const decrease = () => {
    setCount(count - 1);
  };

  return (
    <div>
      <CountContext.Provider value={{ count, increase, decrease }}>
        <Counter />
      </CountContext.Provider>
    </div>
  );
};

export default ContextApi;

```
### CounterReducer
```js
import { useReducer } from "react";

let initialState1 = { count: 0 };
function reducer1(state, action) {
  switch (action.type) {
    case "add":
      return { count: state.count + 1 };
    case "remove":
      return { count: state.count - 1 };
    case "reset":
      return { count: 0 };
    default:
      throw new Error("not a valide case");
  }
}

export function CounterApp() {
  const [state1, dispatch1] = useReducer(reducer1, initialState1);

  function AddClick() {
    dispatch1({ type: "add" });
  }
  function RemoveClick() {
    dispatch1({ type: "remove" });
  }
  function reset() {
    dispatch1({ type: "reset" });
  }
  return (
    <div className="container-fluid">
      {/* <p>Cat Itmes [{state1.count}]</p> */}
      <h2>Count: {state1.count}</h2>
      <button className="btn btn-warning m-2" onClick={AddClick}>
        Add
      </button>
      <button className="btn btn-dark m-2" onClick={RemoveClick}>
        Delete
      </button>
      <button className="btn btn-danger m-2" onClick={reset}>
        Reset
      </button>
    </div>
  );
}

```

### CounterUseState
```js
import React, { useState } from "react";

function CounterUseState() {
  const [count, setCount] = useState(0);

  function increment() {
    setCount((prevCount) => prevCount + 1);
  }

  function decrement() {
    setCount((prevCount) => prevCount - 1);
  }

  function reset() {
    setCount(0);
  }

  return (
    <div>
      <h2>Count: {count}</h2>
      <button className="btn btn-warning m-2" onClick={increment}>
        Increment
      </button>
      <button className="btn btn-dark  m-2" onClick={decrement}>
        Decrement
      </button>
      <button className="btn btn-danger  m-2" onClick={reset}>
        Reset
      </button>
    </div>
  );
}

export default CounterUseState;

```
### JsWithDifferentUIElement
```js
var product = {
  Name: "Samsung TV",
  Price: 46500.44,
  Stock: true,
  questions: ["small", "medium", "big"],
};
const questions = [
  {
    question: "Which is the most popular JavaScript framework?",
    options: ["Angular", "React", "Svelte", "Vue"],
    correctOption: 1,
    points: 10,
  },
  {
    question: "Which company invented React?",
    options: ["Google", "Apple", "Netflix", "Facebook"],
    correctOption: 3,
    points: 10,
  },
  {
    question: "What's the fundamental building block of React apps?",
    options: ["Components", "Blocks", "Elements", "Effects"],
    correctOption: 0,
    points: 10,
  },
];
export default function JsWithDifferentUIElement() {
  return (
    <div>
      <div className="container-fluid">
        <h3 className="text-success">
          -----------------Product Object Data List:Start-----------------
        </h3>

        <h5>Product Details</h5>
        <dl>
          <dt>Name</dt>
          <dd>{product.Name}</dd>
          <dd>
            <input type="text" defaultValue={product.Name} />
          </dd>
          <dt>Price</dt>
          <dd>{product.Price}</dd>
          <dt>Stock</dt>
          <dd>{product.Stock == true ? "Available" : "Out of Stock"}</dd>
          <dd>
            <input type="checkbox" defaultChecked={product.Stock} /> Available
          </dd>
          <dt>questions</dt>
          {product.questions.map((que, index) => (
            <dd key={index}>{que}</dd>
          ))}
        </dl>
        <h3 className="text-success">
          -----------------Product Object Data List:End-----------------
        </h3>
      </div>
      <div className="container-fluid mt-2">
        <div>
          <h3 className="text-success">
            -----------------questions Array Table:Start-----------------
          </h3>
          <table className="table table-hover table-dark">
            <thead>
              <tr>
                <th>Questions</th>
              </tr>
            </thead>
            <tbody>
              {questions.map((que, index) => (
                <tr key={index}>
                  <td>{que.question}</td>
                  <td>{que.options.join(",")}</td>
                  <td>{que.correctOption}</td>
                  <td>{que.points}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <h3 className="text-success">
            -----------------questions Array Table:End-----------------
          </h3>
        </div>
        <h3 className="text-success">
          -----------------questions Array button:Start-----------------
        </h3>

        <div className="w-25">
          {questions.map((que, index) => (
            <div key={index}>
              {que.options.map((opt, index) => (
                <button
                  key={index}
                  className="btn btn-link mb-2 w-100"
                >{`${index} -> ${opt}`}</button>
              ))}
            </div>
          ))}
        </div>
        <h3 className="text-success">
          -----------------questions Array button:End-----------------
        </h3>
        <div>
          <h2>Toolbar</h2>
          <div className="btn-toolbar bg-danger mb-2">
            <div className="btn-group">
              {questions.map((que, index) => (
                <button className="btn btn-danger">{que.question}</button>
              ))}
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <ol>
              {questions.map((que, index) => (
                <li key={index}>{que.question}</li>
              ))}
            </ol>
          </div>
          <div className="col">
            <select>
              {questions.map((que, index) => (
                <option key={index}>{que.question}</option>
              ))}
            </select>
          </div>
          <div className="col">
            <ul className="list-unstyled">
              {questions.map((que, index) => (
                <li key={index}>
                  <input type="checkbox" /> {que.question}{" "}
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

```
### PassDataFromChildToParent

```js
import React, { useState } from "react";

export function ParentComponent() {
  const [parentData, setParentData] = useState("");
  const [valueFromChild, setValueFromChild] = useState(0);

  function handleChildDataChange(data, valueFromChild) {
    setParentData(data);
    setValueFromChild(valueFromChild);
  }

  return (
    <div>
      <h2>Parent Data: {parentData}</h2>
      <h2>valueFromChild Data: {valueFromChild}</h2>

      <ChildComponent
        onChildDataChange={handleChildDataChange}
        counterValue={valueFromChild}
      />
    </div>
  );
}

function ChildComponent(props) {
  const [childData, setChildData] = useState("");
  let childCounterValue = props.counterValue;

  function handleInputChange(event) {
    setChildData(event.target.value);
    props.onChildDataChange(event.target.value, childCounterValue + 1);
  }

  return (
    <div>
      <input type="text" value={childData} onChange={handleInputChange} />
    </div>
  );
}

```
### 
