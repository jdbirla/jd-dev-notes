import React, { useState } from "react";
import _uniqueId from "lodash/uniqueId";

export default function GenerateIdFromLabel() {
  // id will be set once when the component initially renders, but never again
  // (unless you assigned and called the second argument of the tuple)
  const [id] = useState(_uniqueId("prefix-"));
  return (
    <div>
      <input id={id} type="checkbox" />
      <label htmlFor={id}>label</label>
    </div>
  );
}
