import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import LearningJavaScript from "./learning-examples/LearningJavaScript";
import Header from "./learning-examples/ClassLifecycle";
import { CounterApp } from "./learning-examples/CounterApp";
import CounterUseState from "./learning-examples/CounterUseState";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import "../node_modules/bootstrap-icons/font/bootstrap-icons.css";
import FirstComponent from "./learning-examples/FirstComponent";
import ErrorBoundryEx from "./learning-examples/ErrorBoundryEx";
import { ParentComponent } from "./learning-examples/PassDataFromChildToParent";
import TestApi from "./learning-examples/TestApi";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <LearningJavaScript></LearningJavaScript> */}
    {/* <CounterApp></CounterApp> */}
    {/* <CounterUseState></CounterUseState> */}
    {/* <Header></Header> */}
    {/* <ParentComponent></ParentComponent> */}
    <TestApi></TestApi>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
