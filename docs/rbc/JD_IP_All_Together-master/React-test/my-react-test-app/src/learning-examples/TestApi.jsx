import { useReducer } from "react";
import React, { useState } from "react";
import { useEffect, useRef } from "react";

function TestApi() {
  const [data, setData] = useState([]);
  useEffect(() => {
    fetch("https://datausa.io/api/data?drilldowns=Nation&measures=Population")
      .then((res) => res.json())
      .then((data) => setData(data));
  }, []);

  return <div className="container-fluid">{JSON.stringify(data)}</div>;
}
export default TestApi;
