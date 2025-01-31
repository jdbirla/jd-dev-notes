import React, { useState, useRef } from "react";

export default function OnScrollStyleChange() {
  const prevScrollY = useRef(0);
  const [goingUp, setGoingUp] = useState(false);

  const onScroll = (e) => {
    const currentScrollY = e.target.scrollTop;
    if (prevScrollY.current < currentScrollY && goingUp) {
      setGoingUp(false);
    }
    if (prevScrollY.current > currentScrollY && !goingUp) {
      setGoingUp(true);
    }
    prevScrollY.current = currentScrollY;
    console.log(goingUp, currentScrollY);
  };

  return (
    <div onScroll={onScroll} style={{ height: 200, overflowY: "scroll" }}>
      {Array(50)
        .fill("Get the scroll position on scroll in react.")
        .map((f, i) => {
          return <p key={i}>{f}</p>;
        })}
    </div>
  );
}
