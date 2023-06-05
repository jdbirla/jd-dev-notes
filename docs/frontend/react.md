# React
## JSX
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/4ec16f61-f3fd-461b-8d4c-e4832fc232c0)
- {} this one for putting js in html
- ${} this one is for putting into js string 
```jsx
import React from "react";
import ReactDOM from "react-dom";

const name = "jitu";
const fullName = `${name} birla`;
console.log(fullName);

ReactDOM.render(<h1>Hello World! {name}</h1>, document.getElementById("root"));

```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/5ae77c9b-b917-46ba-9416-ddd2917fef65)

### JSX Attributes and Styling
- alt + click for mutiple select and edit
- We have use JavaScript attribute for html element like camelCase `className`
- <a>https://codesandbox.io/s/react-styling-practice-completed-forked-9cwg0n<a/>
- [sanbox](https://codesandbox.io/s/react-styling-practice-completed-forked-9cwg0n)

```jsx
import React from "react";
import ReactDOM from "react-dom";

const img = "https://picsum.photos/200";

ReactDOM.render(
  <div>
    <h1 className="heading">My Favourite Foods</h1>
    <img alt="random" src={img + "?grayscale"} />
  </div>,
  document.getElementById("root")
);
//-------------------------------------------------------
import React from "react";
import ReactDOM from "react-dom";

const customStyle = {
  color: "red",
  fontSize: "20px",
  border: "1px solid black"
};

customStyle.color = "blue";

ReactDOM.render(
  <div>
    <h1 style={{ color: "red" }}>Hello World!</h1>,
    <h1 style={customStyle}>Hello World!</h1>
  </div>,
  document.getElementById("root")
);


```


