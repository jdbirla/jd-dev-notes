# Frontend-Interview
## React Interview

### What is promise

Ans : The phenomenon which happens when we nest multiple callbacks within a function is called a callback hell. The shape of the resulting code structure resembles a pyramid and hence callback hell is also called the “pyramid of the doom”. It makes the code very difficult to understand and maintain.

### Promise Channing

Ans : Promise chaining: Promise chaining is a syntax that allows you to chain together multiple asynchronous tasks in a specific order. This is great for complex code where one asynchronous task needs to be performed after the completion of a different asynchronous task.
```js
new Promise(function(resolve, reject) {

  setTimeout(() => resolve(1), 1000); // (*)

}).then(function(result) { // (**)

  alert(result); // 1
  return result * 2;

}).then(function(result) { // (***)

  alert(result); // 2
  return result * 2;

}).then(function(result) {

  alert(result); // 4
  return result * 2;

});
```
### Promise.all

- Ans : Promise.all in JavaScript is a built-in functional method that takes in an array of promises as input and returns a single promise only after resolving all the promises of the input array in sequential order. Promise.all in JavaScript throws an error if any one of the passed promises in the input gets rejected, independent of the results of other promises. If the promise returned by this function is resolved, it returns an array consisting of all the returned resolved values of the promises array that was passed as an argument.
```js
const p1 = Promise.resolve("pi"); //returns a promise of resolved value "pi"
const p2 = 3.14; 
const p3 = new Promise((resolve, reject) => { //promise method to resolve or reject values
    resolve("Maths"); //p3 contains a promise of resolving "maths" value 
});

let returned_promise = Promise.all([p1, p2, p3]); //checking fulfillment or rejection of any of the promises: p1,p2 and p3 passed as iterable in the function 

returned_promise.then((array)=>{ //returned_promise will contain final returned value of Promise.all() method
    console.log(array); //checking and printing the value returned as promised by Promise.all() method in JS
})
```
output:
```
[ 'pi', 3.14, 'Maths' ]
```
### Promise.allsettled
1. In terms of rejecting promises:
  - Promise.all() method rejects itself if any of the passed in promise input inside an array is rejected. That is, this method will only run if and only if all the promises are fulfilled or resolved successfully, otherwise, in the output, it would produce an error message.
Promise.allSettled() method will not reject itself if any of the passed in promise input inside an array is rejected. That is, this method will irrespective of any promise be in the rejected state too.
2. In terms of their outputs:
 
### Promise.all() : method returns an array as an output containing promise data inside several indexes.
Promise.allSettled() method returns an array of objects and each of these objects further contains two properties further status and value.

### Promise.race
Ans : The Promise.race() method returns a promise that fulfills or rejects as soon as one of the promises in an iterable fulfills or rejects, with the value or reason from that promise.
We may think of this particular method as in the form of a real-life example where several people are running in a race whosoever wins comes first wins the race, the same scenario is here, which ever promise successfully fulfills or rejects at early will be executed at first and rest one’s results will not be displayed as an output.

### let vs var
![image](https://user-images.githubusercontent.com/69948118/213952229-6e9f3f0f-dca4-4e85-9fba-daa394cb537b.png)
  
### What are the advantages of using React?

- **Use of Virtual DOM to improve efficiency**: React uses virtual DOM to render the view. As the name suggests, virtual DOM is a virtual representation of the real DOM. Each time the data changes in a react app, a new virtual DOM gets created. Creating a virtual DOM is much faster than rendering the UI inside the browser. Therefore, with the use of virtual DOM, the efficiency of the app improves.
- **Gentle learning curve:** React has a gentle learning curve when compared to frameworks like Angular. Anyone with little knowledge of javascript can start building web applications using React.
- **SEO friendly:** React allows developers to develop engaging user interfaces that can be easily navigated in various search engines. It also allows server-side rendering, which boosts the SEO of an app.
- **Reusable components:** React uses component-based architecture for developing applications. Components are independent and reusable bits of code. These components can be shared across various applications having similar functionality. The re-use of components increases the pace of development.
    - **Huge ecosystem of libraries to choose from:** React provides you with the freedom to choose the tools, libraries, and architecture for developing an application based on your requirement.

### What are the limitations of React?
  -  The few limitations of React are as given below:
    - React is not a full-blown framework as it is only a library.
    - The components of React are numerous and will take time to fully grasp the benefits of all.
    - It might be difficult for beginner programmers to understand React.
    - Coding might become complex as it will make use of inline templating and JSX.

### Can we use class component life cycle method inside function component
  - https://legacy.reactjs.org/docs/hooks-faq.html#from-classes-to-hooks
 - useEffect allows you to perform side effects, such as fetching data or updating the DOM, after the component has rendered. It replaces the componentDidMount, componentDidUpdate, and componentWillUnmount lifecycle methods of class components.
- useLayoutEffect is similar to useEffect, but it is called synchronously after all DOM mutations. It can be used to perform DOM measurements or to make sure the component is fully rendered before doing any work.**
#### 1. Mounting:
  ##### constructor() : constructor: Function components don’t need a constructor. You can initialize the state in the useState call. If computing the initial state is expensive, you can pass a function to useState.
  ##### getDerivedStateFromProps() : Not required
  ##### render() : This is the function component body itself.
  ##### componentDidMount() : The componentDidMount() method is called after the component is rendered.
```js
 useEffect(() => {
        console.log("UseEffect hook after component mounted.")
    }, [])
```
#### 2. Updating
##### getDerivedStateFromProps(): Not required
##### shouldComponentUpdate()
  In the shouldComponentUpdate() method you can return a Boolean value based on prop comparions if its changes from previous value, that specifies whether React should continue with the rendering or not.
##### First Way :

```js
// props: {name}
// state: {visible}

useEffect(() => {
  // ... code to run

  // the dependency array below is "equivalent" to:
  // the effect will trigger if
  // props.name !== nextProps.name || state.enabled !== nextState.enabled
}, [name, visible]) 
```
##### Second Way :You can wrap a function component with React.memo to shallowly compare its props:
```
const Button = React.memo((props) => {
  // your component
});
```
#### render() : This is the function component body itself.
#### getSnapshotBeforeUpdate() : No Hooks
#### componentDidUpdate():
```js
import React, { useEffect, useState } from 'react'

function UseEffectAsDidUpdate() {

    const [name, setName] = useState("");

    /* runs on first render and whenever dependency array 
        state change.
    */
    useEffect(() => {
        console.log(`name is changed ${name}`);
    }, [name])

    return (
        <input
            placeholder="enter name"
            onChange={e => setName(e.target.value)}
        />
    )
}

export default UseEffectAsDidUpdate;

```
### 3. Unmounting
#### componentWillUnmount
```js
import React, { useEffect, useState } from 'react'

function UseEffectAsWillUnmount() {

    const [width, setWidth] = useState(window.innerWidth);

    /* This run after first render and set eventlistener on resize. 
        And before unmount we are returning cleanup function 
         which should run before unmount.
    */
    useEffect(() => {
        window.addEventListener("resize", updateWindowWidth)

        /* Cleanup process --->
            This run before unmount and remove eventlistener.
        */
        return () => {
            window.removeEventListener("resize", updateWindowWidth);
        }
    }, [])

    const updateWindowWidth = () => {
        setWidth(window.innerWidth)
    }

    return (
        <div>
            <h2>Windows Inner Width: {width}</h2>
        </div>
    )
}

export default UseEffectAsWillUnmount;
```
### What is the recommended ordering of methods in class component?
- static methods 
- constructor() 
- getChildContext() 
- componentWillMount() 
- componentDidMount() 
- componentWillReceiveProps() 
- shouldComponentUpdate() 
- componentWillUpdate() 
- componentDidUpdate() 
- componentWillUnmount() 
- click handlers or event handlers like onClickSubmit() or onChangeDescription() 
- getter methods for render like getSelectReason() or getFooterContent() 
- optional render methods like renderNavigation() or renderProfilePicture() 
- render()

### How do you optimize the performance of a React application?
#### Minimize Render Operations
   - Prevent  Child re render
#### Memoization
     - React.Memo for component memoization when input is changing then only the component will re-render
```js
     const Archive = memo( component)
```
     - useMemo : for Object value memoization
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
     - useCallback : for unction memoization
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
#### Use React Profiler
#### Lazy Loading
`const Homepage = lazy(() => import("./pages/Homepage"));`

### What is the difference between “client-side” and “server-side” rendering in React?
The difference between client-side rendering and server-side rendering in React relates to where the rendering process takes place—either on the client (browser) or the server.

**Client-side rendering**:
- In client-side rendering, the initial HTML is sent to the browser, typically a minimal HTML file with a reference to the JavaScript bundle.
- The JavaScript bundle, generated by tools like webpack, is responsible for rendering the React components in the browser.
- The browser downloads the JavaScript bundle and executes it, which then renders the React components and handles subsequent updates and interactions.
- The application's state and logic reside on the client-side, and the server primarily serves data through APIs or endpoints.

Advantages of client-side rendering:
- Provides a rich, interactive user experience with smooth transitions and dynamic updates.
- Allows for a single-page application (SPA) architecture where navigation occurs without full page reloads.
- Facilitates a separation between the client-side and server-side codebase, enabling front-end and back-end teams to work independently.

Disadvantages of client-side rendering:
- Initial load time can be slower since the browser needs to download the JavaScript bundle and render the components before displaying the content.
- Search engine optimization (SEO) can be challenging since search engine crawlers may have difficulty interpreting JavaScript-rendered content.
- Limited performance on low-powered devices or slower networks due to the reliance on client-side processing.

**Server-side rendering**:
- In server-side rendering (SSR), the server generates the HTML content with the pre-rendered React components and sends it to the browser.
- The server executes the React component code and renders the resulting HTML, including the initial data fetched from APIs or databases.
- The browser receives the fully rendered HTML and can display it immediately.
- Once the JavaScript bundle is downloaded and executed on the client, it takes over the rendering and handling of subsequent updates.

Advantages of server-side rendering:
- Faster initial page load since the server sends pre-rendered HTML, reducing the time needed for the client to display the content.
- Improved SEO as search engine crawlers can more easily parse and index server-rendered content.
- Better performance on low-powered devices or slower networks since the processing happens on the server.

Disadvantages of server-side rendering:
- More complex server setup and infrastructure requirements to handle rendering React components on the server.
- Increased server load as the server needs to handle the rendering for each incoming request.
- Limited interactivity on the initial page load until the JavaScript bundle is downloaded and executed on the client.

It's important to note that React supports both client-side rendering and server-side rendering. Developers can choose the approach based on their project's requirements, performance goals, and trade-offs. Additionally, hybrid approaches like hybrid rendering or dynamic rendering can be used to combine the benefits of both client-side and server-side rendering.

### How do you implement server-side rendering in a React application?
To implement server-side rendering (SSR) in a React application, you can follow these general steps:

1. **Set up a Node.js server**: Create a server using a Node.js framework like Express or Koa to handle incoming HTTP requests.

2. **Configure Babel**: Configure Babel to transpile your server-side code, including JSX syntax and ES modules, so that it can be executed on the server.

3. **Create a server-side entry point**: Create a server-side entry point file that will handle the server-side rendering logic. This file will typically import your React components, configure any necessary data fetching, and render the React components to HTML.

4. **Configure Webpack**: Set up Webpack to build a server-side bundle that includes your server-side entry point file and its dependencies. Configure the appropriate loaders for transpiling and bundling your server-side code.

5. **Implement server-side rendering logic**: In your server-side entry point file, use a server-side rendering library like ReactDOMServer (provided by React) or Next.js (a React framework that includes SSR capabilities) to render your React components to HTML on the server.

6. **Fetch data**: If your application requires data from APIs or databases, implement the necessary data fetching logic on the server before rendering the React components. This can be done using libraries like Axios, Fetch, or GraphQL clients.

7. **Pass initial state**: If your application uses Redux, React Context, or any other state management solution, you'll need to pass the initial state from the server to the client. This allows the client-side code to pick up where the server left off without re-fetching data.

8. **Handle routing**: Implement server-side routing if needed, ensuring that the server can handle different URLs and render the appropriate components accordingly.

9. **Send the rendered HTML to the client**: Once the server has rendered the React components to HTML, send the HTML response back to the client along with any necessary assets (e.g., CSS, JavaScript bundles) for the client to hydrate and take over the rendering on the client-side.

10. **Client-side hydration**: On the client-side, include the necessary JavaScript bundles and hydrate the rendered HTML using React's ReactDOM.hydrate method. This process attaches event handlers and initializes the client-side React components while preserving the server-rendered markup.

11. **Handle client-side navigation**: Ensure that client-side navigation works correctly by intercepting the clicks on internal links and handling them with client-side routing, allowing the React components to handle subsequent navigation without full page reloads.

By following these steps, you can implement server-side rendering in your React application. It's worth noting that libraries like Next.js abstract away much of the complexity involved in setting up SSR, making it easier to implement and manage server-side rendering in a React application.

### What is the purpose of the “PureComponent” class in React?
In React, `PureComponent` is a base class that you can use to create components that automatically optimize rendering performance. It is an alternative to the regular `Component` class provided by React.

The main difference between `PureComponent` and `Component` lies in how they handle the `shouldComponentUpdate` method:

1. **`Component`**: By default, the `shouldComponentUpdate` method of `Component` returns `true`, causing the component to re-render whenever its state or props change. This behavior can potentially lead to unnecessary re-renders if the component's props or state haven't actually changed.

2. **`PureComponent`**: The `PureComponent` class, on the other hand, implements a shallow comparison of the component's props and state in its `shouldComponentUpdate` method. If the shallow comparison indicates that the props and state haven't changed, the component won't re-render. This optimization can improve performance by preventing unnecessary renders when the component's output wouldn't be affected.

To implement a `PureComponent` in your React application, follow these steps:

1. Import the `PureComponent` class from the `react` package:
  
   import React, { PureComponent } from 'react';
```

2. Create your component by extending the `PureComponent` class instead of the regular `Component` class:
  
   class MyComponent extends PureComponent {
     // Component implementation
   }
```

3. Implement the necessary render method and any additional methods or lifecycle hooks required for your component.

4. Use the `MyComponent` in your application like any other React component:
  
   function App() {
     return <MyComponent />;
   }
```

By using `PureComponent`, React handles the optimization of shallow comparisons for you. It automatically compares the props and state of your component and determines whether a re-render is necessary. This can be particularly useful when dealing with large or complex components that may benefit from avoiding unnecessary renders.

However, it's important to note that `PureComponent` is not always the best choice. The shallow comparison performed by `PureComponent` can be less efficient for deeply nested or complex data structures. In such cases, it's recommended to use the `Component` class and manually implement the `shouldComponentUpdate` method with a more customized comparison logic to achieve optimal performance.

No, PureComponent is not available directly in function components. It is a class-based component that extends the Component class provided by React.

However, in React, you can achieve similar performance optimizations in function components by using React's memo higher-order component or the React.memo function. These allow you to memoize the component and prevent unnecessary re-renders.

### What is the purpose of the “lazy” and “suspense” APIs in React?
1. Lazy Loading (lazy API):
The "lazy" API enables you to load components asynchronously, i.e., on-demand when they are actually needed, rather than loading them all upfront when the application starts
2. Handling Loading States (suspense API):
By wrapping the lazy loaded components or other asynchronous operations with the <Suspense> component, you can provide a fallback UI while the content is being loaded. If an error occurs during the loading process, you can also define an error boundary to handle the error gracefully.
### What is portal?
In React, a portal is a way to render a component's content in a different location in the DOM hierarchy than its parent component. It allows you to render a component's UI to a different DOM element outside of its parent component's hierarchy.

Portals are useful in scenarios where you need to render a component's content outside of its current DOM context, such as rendering a modal or tooltip that overlays the entire application or rendering a component inside a specific container that is outside the normal component tree.

To create a portal in React, you can use the `ReactDOM.createPortal()` method, which takes two arguments: the content you want to render and the DOM element where you want to render it.

Here's an example of using a portal in React:

```jsx
import ReactDOM from 'react-dom';

function Modal(props) {
  return ReactDOM.createPortal(
    <div className="modal">
      <h2>{props.title}</h2>
      <p>{props.content}</p>
    </div>,
    document.getElementById('modal-root') // The DOM element where the portal content will be rendered
  );
}

function App() {
  return (
    <div>
      <h1>My App</h1>
      {/* Other components */}
      <Modal title="My Modal" content="This is a modal dialog." />
    </div>
  );
}

ReactDOM.render(<App />, document.getElementById('root'));
```

In the example above, the `Modal` component is rendered as a portal using `ReactDOM.createPortal()`. The content of the `Modal` component, including the title and content, will be rendered inside the DOM element with the ID `modal-root`, which can be located anywhere in the HTML document.

By using portals, you can render components outside of their normal parent-child hierarchy, giving you more flexibility in rendering and managing UI elements in your React application.
### what is Error boundary
In React, an Error Boundary is a component that catches JavaScript errors anywhere in its child component tree and handles them gracefully, preventing the entire application from crashing. Error Boundaries are used to display fallback UI or error messages when an error occurs within their subtree.

To create an Error Boundary in React, you need to define a component that implements the `componentDidCatch` lifecycle method. This method is called when an error is thrown in any of the component's descendants.

Here's an example of how to create and use an Error Boundary in React:

```jsx
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  componentDidCatch(error, errorInfo) {
    // Update state to display an error message
    this.setState({ hasError: true });
    // You can also log the error to an error reporting service
    console.error(error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      // Render fallback UI or error message
      return <div>Something went wrong.</div>;
    }

    // Render the normal component tree
    return this.props.children;
  }
}

function App() {
  return (
    <div>
      <h1>My App</h1>
      <ErrorBoundary>
        {/* Components that may throw errors */}
        <Component1 />
        <Component2 />
      </ErrorBoundary>
    </div>
  );
}

ReactDOM.render(<App />, document.getElementById('root'));
```

In the example above, the `ErrorBoundary` component is defined as a class component that implements the `componentDidCatch` lifecycle method. If an error occurs within its child components (`Component1` and `Component2`), the `componentDidCatch` method is triggered. It updates the component's state to indicate that an error has occurred (`hasError: true`). The `render` method of the `ErrorBoundary` component conditionally renders the fallback UI or error message when `hasError` is `true`.

To use the Error Boundary, you wrap the components that you want to handle errors with the `ErrorBoundary` component. In this example, `Component1` and `Component2` are wrapped with the `ErrorBoundary` component to catch any errors they might throw.

By using Error Boundaries, you can prevent the entire application from crashing when an error occurs in a specific component tree. Instead, you can display a fallback UI or an error message to the user, providing a better user experience and making it easier to diagnose and fix the error.



### Medium
- <https://medium.com/@stevenjinyi/study-sheet-for-react-interview-questions-2020-2fe25b8fa316>
- <https://tapajyoti-bose.medium.com/11-advanced-react-interview-questions-you-should-absolutely-know-with-detailed-answers-e306083ecb7d>
- <https://juliuskoronci.medium.com/react-interview-questions-13f8839f2711>
- <https://javascript.plainenglish.io/10-entry-level-react-interview-questions-5a8ea74e2130>
