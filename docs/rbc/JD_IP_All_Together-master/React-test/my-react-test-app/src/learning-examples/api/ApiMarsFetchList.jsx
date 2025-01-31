import { useState, useEffect } from "react";

export default function ApiMarsFetchList() {
  const [mars, setMars] = useState([]);
  useEffect(() => {
    fetch("https://fakestoreapi.com/products/")
      .then((res) => res.json())
      .then((data) => setMars(data))
      .catch((err) => console.log(err));
  }, []);

  mars.map((item, index) => console.log(item.id));

  return (
    <>
      <ul>
        {mars.map((item, index) => (
          <li>{item.title}</li>
        ))}
      </ul>
    </>
  );
}
