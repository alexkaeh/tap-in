import useFetch from "../useFetch";
import BreweryDetails from "./BreweryDetails";

const BreweriesPage = () => {
  const {
    data: breweries,
    error,
    isPending,
  } = useFetch("http://localhost:8001/api/brewery/");

  return (
    <div>
      <h1>Breweries Page</h1>
      {error && <div>{error}</div>}
      {isPending && <div>Loading...</div>}
      {breweries && <BreweryDetails breweries={breweries} />}
    </div>
  );
};

export default BreweriesPage;
