import React from 'react';
import { useParams } from "react-router-dom";

const BreweryDetails = () => {
  const { id } = useParams();
  const [brewery, setBrewery] = React.useState({});

  React.useEffect(() => {
    fetch(`http://localhost:8081/api/brewery/${id}`)
      .then((res) => res.json())
      .then((data) => setBrewery(data));
  }, []);

  console.log(brewery)

  return (
    <div>
      <h1>Brewery Details</h1>
      <p>Name: {brewery.brewryName}</p>
      <p>Contact: {brewery.contactInfo}</p>
      <p>Address: {brewery.address}</p>
    </div>
  );
};

export default BreweryDetails;
