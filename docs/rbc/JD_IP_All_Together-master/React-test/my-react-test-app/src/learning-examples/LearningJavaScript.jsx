var product = {
  Name: "Samsung TV",
  Price: 46500.44,
  Stock: true,
};
const categories = ["Electronics", "Footwear", "Fashion"];
export default function LearningJavaScript() {
  return (
    <div>
      <div className="container-fluid">
        <h2>=========Object========</h2>

        <h2>Product Details</h2>
        <dl>
          <dt>Name</dt>
          <dd>{product.Name}</dd>
          <dd>
            <input type="text" value={product.Name} />
          </dd>
          <dt>Price</dt>
          <dd>{product.Price}</dd>
          <dt>Stock</dt>
          <dd>{product.Stock == true ? "Available" : "Out of Stock"}</dd>
          <dd>
            <input type="checkbox" checked={product.Stock} /> Available
          </dd>
        </dl>
      </div>
      <div className="container-fluid mt-2">
        <div>
          <h2>=========Map========</h2>
          <table className="table table-hover table-dark">
            <thead>
              <tr>
                <th>Categories</th>
              </tr>
            </thead>
            <tbody>
              {categories.map((category) => (
                <tr>
                  <td>{category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="w-25">
          {categories.map((category) => (
            <div>
              <button className="btn btn-link mb-2 w-100">{category}</button>
            </div>
          ))}
        </div>
        <div>
          <h2>Toolbar</h2>
          <div className="btn-toolbar bg-danger mb-2">
            <div className="btn-group">
              {categories.map((category) => (
                <button className="btn btn-danger">{category}</button>
              ))}
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <ol>
              {categories.map((category) => (
                <li key={category}>{category}</li>
              ))}
            </ol>
          </div>
          <div className="col">
            <select>
              {categories.map((category) => (
                <option key={category}>{category}</option>
              ))}
            </select>
          </div>
          <div className="col">
            <ul className="list-unstyled">
              {categories.map((category) => (
                <li>
                  <input type="checkbox" /> {category}{" "}
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}
