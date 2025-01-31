import { useEffect, useState } from "react";

export function ApiMarsFetchTable() {
  const [mars, setMars] = useState([]);

  useEffect(() => {
    fetch(
      "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY"
    )
      .then((res) => {
        if (!res.ok) {
          throw new Error(`mars not found : ${res.status}`);
        }
        return res.json();
      })
      .then((data) => setMars(data.photos))
      .catch((err) => console.error(err))
      .finally(() => {
        console.log("finally");
      });
  }, []);

  return (
    <div className="container-fluid">
      <h2>Mars Rover Photos</h2>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Photo Id</th>
            <th>Preview</th>
            <th>Camera</th>
            <th>Rover</th>
          </tr>
        </thead>
        <tbody>
          {mars.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>
                <img src={item.img_src} width="100" height="100" />
              </td>
              <td>{item.camera.full_name}</td>
              <td>{item.rover.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
