var product = {
  Name: "Samsung TV",
  Price: 46500.44,
  Stock: true,
  questions: ["small", "medium", "big"],
};
const questions = [
  {
    question: "Which is the most popular JavaScript framework?",
    options: ["Angular", "React", "Svelte", "Vue"],
    correctOption: 1,
    points: 10,
  },
  {
    question: "Which company invented React?",
    options: ["Google", "Apple", "Netflix", "Facebook"],
    correctOption: 3,
    points: 10,
  },
  {
    question: "What's the fundamental building block of React apps?",
    options: ["Components", "Blocks", "Elements", "Effects"],
    correctOption: 0,
    points: 10,
  },
];
export default function JsWithDifferentUIElement() {
  return (
    <div>
      <div className="container-fluid">
        <h3 className="text-success">
          -----------------Product Object Data List:Start-----------------
        </h3>

        <h5>Product Details</h5>
        <dl>
          <dt>Name</dt>
          <dd>{product.Name}</dd>
          <dd>
            <input type="text" defaultValue={product.Name} />
          </dd>
          <dt>Price</dt>
          <dd>{product.Price}</dd>
          <dt>Stock</dt>
          <dd>{product.Stock == true ? "Available" : "Out of Stock"}</dd>
          <dd>
            <input type="checkbox" defaultChecked={product.Stock} /> Available
          </dd>
          <dt>questions</dt>
          {product.questions.map((que, index) => (
            <dd key={index}>{que}</dd>
          ))}
        </dl>
        <h3 className="text-success">
          -----------------Product Object Data List:End-----------------
        </h3>
      </div>
      <div className="container-fluid mt-2">
        <div>
          <h3 className="text-success">
            -----------------questions Array Table:Start-----------------
          </h3>
          <table className="table table-hover table-dark">
            <thead>
              <tr>
                <th>Questions</th>
              </tr>
            </thead>
            <tbody>
              {questions.map((que, index) => (
                <tr key={index}>
                  <td>{que.question}</td>
                  <td>{que.options.join(",")}</td>
                  <td>{que.correctOption}</td>
                  <td>{que.points}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <h3 className="text-success">
            -----------------questions Array Table:End-----------------
          </h3>
        </div>
        <h3 className="text-success">
          -----------------questions Array button:Start-----------------
        </h3>

        <div className="w-25">
          {questions.map((que, index) => (
            <div key={index}>
              {que.options.map((opt, index) => (
                <button
                  key={index}
                  className="btn btn-link mb-2 w-100"
                >{`${index} -> ${opt}`}</button>
              ))}
            </div>
          ))}
        </div>
        <h3 className="text-success">
          -----------------questions Array button:End-----------------
        </h3>
        <div>
          <h2>Toolbar</h2>
          <div className="btn-toolbar bg-danger mb-2">
            <div className="btn-group">
              {questions.map((que, index) => (
                <button className="btn btn-danger">{que.question}</button>
              ))}
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <ol>
              {questions.map((que, index) => (
                <li key={index}>{que.question}</li>
              ))}
            </ol>
          </div>
          <div className="col">
            <select>
              {questions.map((que, index) => (
                <option key={index}>{que.question}</option>
              ))}
            </select>
          </div>
          <div className="col">
            <ul className="list-unstyled">
              {questions.map((que, index) => (
                <li key={index}>
                  <input type="checkbox" /> {que.question}{" "}
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}
