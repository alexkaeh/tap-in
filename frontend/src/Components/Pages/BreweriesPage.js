import React from "react";
import { Link } from "react-router-dom";


const BreweriesPage = () => {
  const [allBreweries, setAllBreweries] = React.useState([]);

  console.log(allBreweries)

  React.useEffect(() => {
    fetch("http://localhost:8081/api/brewery")
      .then((res) => res.json())
      .then((data) => setAllBreweries(data));
  }, []);

  console.log(allBreweries)

  function renderBreweries(allBreweries) {
    return allBreweries.map((item) => {
      return (
        <li key={item.breweryId}>
          <Link to={`/breweries/${item.breweryId}`}>{item.breweryName}</Link>
        </li>
    )});
  }

  return (
    <div>
      <h1>Breweries Page</h1>
      <ul>{renderBreweries(allBreweries)}</ul>
    </div>
  );
};

export default BreweriesPage;
