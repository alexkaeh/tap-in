import { Component } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
import { addToken, deleteUser } from "../Redux/actionCreators";
//import { connect } from "react-redux";
import BreweriesPage from "./Breweries/BreweriesTilesPage";
import BeersPage from "./Beers/BeersListPage";
import EditBreweriesPage from "./Edit/EditBreweriesBeersPage";
import BeersListPage from "./Beers/BeersListPage";
import EditBreweriesBeersPage from "./Edit/EditBreweriesBeersPage";
import Login from "./Login/Login";
import Register from "./Login/Register";
import Home from "./Home/Home";
import Footer from "./Footer";
import BeerDetailPage from "./Beers/BeerDetailPage";
import BreweryDetails from "./Breweries/BreweryDetailsPage";
import AddBrewery from "./AddBrewery/AddBrewery";
//import { any } from "prop-types";

/*const mapStateToProps = (state) => {
  return {
    token: state.token,
    user: state.user,
  };
};
*/
const mapDispatchToProps = (dispatch) => ({
  addToken: () => {
    dispatch(addToken());
  },
  deleteUser: () => {
    dispatch(deleteUser());
  },
});

class Main extends Component {
  constructor(props) {
    // super(props);
  }

  handleLogout = () => {
    this.props.addToken("");
    this.props.deleteUser();
  };

  /*
    Links to
    - find breweries
    - find beers
    - edit brewery info
      - edit beer list
    - login / logout
    - add brewery

  */

  render() {
    return (
      <div className="main">
        <header>
          <h1>LOGO</h1>
          <nav className="nav-menu">
            <Link to="/breweries">Breweries</Link>
            <Link to="/beers">Beers</Link>
            <Link to="/BeersListPage">Beers</Link>
            <Link to="/BeerDetailPage">Beer Info and Reviews</Link>

            <Link to="/edit">Edit</Link>
            <Link to="/new">Add Brewery</Link>
            <Link to="/home">Home</Link>

            {this.props.token.token !== undefined ? (
              <Link to="/login" onClick={this.handleLogout}>
                Logout
              </Link>
            ) : (
              <Link to="/login">Login</Link>
            )}
          </nav>
        </header>
        <Routes>
          <Route path="/breweries" element={() => <BreweriesPage />} />
          <Route path="/breweries/:id" element={() => <BreweryDetails />} />
          <Route path="/beers" element={() => <BeersPage />} />
          <Route path="/BeersListPage" element={() => <BeersListPage />} />
          <Route path="/AddBrewery" element={() => <AddBrewery />} />
          <Route path="/edit" element={() => <EditBreweriesPage />} />
          <Route path="/edit/EditBreweriesBeersPage" element={() => <EditBreweriesBeersPage />} />
          <Route path="/BeerDetailPage" element={() => <BeerDetailPage />} />
          <Route path="/Login" element={() => <Login />} />
          <Route path="/register" element={() => <Register />} />
          <Route path="/home" element={() => <Home />} />
        </Routes>
        <Footer />
      </div>
    );
  }
}

export default mapDispatchToProps;

//export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));
