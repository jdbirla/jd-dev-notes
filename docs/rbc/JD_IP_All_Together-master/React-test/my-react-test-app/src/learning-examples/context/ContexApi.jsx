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
