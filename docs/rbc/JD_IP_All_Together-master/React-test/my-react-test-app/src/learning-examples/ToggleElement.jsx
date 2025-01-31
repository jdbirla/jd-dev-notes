import React from "react";
export default function ToggleElement() {
  const [show, toggleShow] = React.useState(true);

  return (
    <div>
      <button onClick={() => toggleShow(!show)}>
        Toggle: {show ? "Hide" : "Show"}
      </button>
      {show && <h2>Hello World!</h2>}
    </div>
  );
}
