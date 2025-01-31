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
