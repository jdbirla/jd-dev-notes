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
