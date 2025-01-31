import { useState } from "react";
import React from "react";
export default function SearchKeyword() {
  const people = [
    "Shashi Koshy",
    "Dhriti Taneja",
    "Dipa Mishra",
    "Ansh Thakkar",
    "Lakshmi Thaker",
    "Sushila Matthai",
    "Shresth Nigam",
    "Bhavana Biswas",
    "Vasudha Mangat",
    "Priya Saran",
  ];

  const [searchTerm, setSearchTerm] = React.useState("");
  const [searchResults, setSearchResults] = React.useState([]);

  const handleChange = (e) => {
    setSearchTerm(e.target.value);
    const results = people.filter((person) =>
      person.toLowerCase().includes(e.target.value)
    );
    setSearchResults(results);
  };

  // React.useEffect(() => {
  //   const results = people.filter((person) =>
  //     person.toLowerCase().includes(searchTerm.toLowerCase())
  //   );
  //   setSearchResults(results);
  // }, [searchTerm]);

  return (
    <div className="App">
      <input
        type="text"
        placeholder="Search"
        value={searchTerm}
        onChange={handleChange}
      />
      <ul>
        {searchResults.length > 0
          ? searchResults.map((item) => <li>{item}</li>)
          : people.map((item) => <li>{item}</li>)}
      </ul>
    </div>
  );
}
