import React from "react";
import { Link } from "react-router-dom";

const BeersListPage = () => {
  const [allBeers, setAllBeers] = React.useState([]);

  React.useEffect(() => {
    fetch("http://localhost:8081/api/beers")
      .then((res) => res.json())
      .then((data) => setAllBeers(data));
  }, []);

  function renderBeers(allBeers) {
    return allBeers.map((item) => {
      return (
        <li key={item.beerId}>
          <Link to={`/beers/${item.beerId}`}>{item.beerName}</Link>
        </li>
      );
    });
  }

  return (
    <div>
      <h1>Beers Page</h1>
      <ul>{renderBeers(allBeers)}</ul>
    </div>
  );
};

export default BeersListPage;
