import { useReducer } from "react";
import React, { useState } from "react";
import { useEffect, useRef } from "react";

export default function FirstComponent() {
  const node = useRef(null);

  useEffect(() => {
    node.current.scrollIntoView();
  }, []);

  return (
    <div>
      <div ref={node} />
    </div>
  );
}
