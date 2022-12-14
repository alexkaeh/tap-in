import React from "react";
import { useParams } from "react-router-dom";

const BreweryDetailsPage = () => {
  const { id } = useParams();
  const [brewery, setBrewery] = React.useState({});

  React.useEffect(() => {
    fetch(`http://localhost:8081/api/brewery/${id}`)
      .then((res) => res.json())
      .then((data) => setBrewery(data));
  }, [id]);

  console.log(brewery);

  return (
    <div>
      <h1>Brewery Details</h1>
      <p>Name: {brewery.breweryName}</p>
      <p>Contact: {brewery.contactInfo}</p>
      <p>Address: {brewery.address}</p>
    </div>
  );
};

export default BreweryDetailsPage;
