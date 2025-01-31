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
