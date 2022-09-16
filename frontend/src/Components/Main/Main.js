import { Component } from "react";
import { Switch, Route, Redirect, Link, withRouter } from "react-router-dom";
import { addToken, deleteUser } from "../../Redux/actionCreators";
import { connect } from "react-redux";
import BreweriesPage from "../Pages/BreweriesPage";
import BeersPage from "../Pages/BeersPage";
import EditBreweriesPage from "../Pages/EditBreweriesPage";
import NewBreweryPage from "../Pages/NewBreweryPage";
import Login from "../Login/Login";
import Register from "../Register/Register";
import Home from "../Pages/Home";
import Footer from "../Footer";
import BreweryDetails from "../Pages/BreweryDetails";

const mapStateToProps = (state) => {
  return {
    token: state.token,
    user: state.user,
  };
};

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
    super(props);
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
            <Link to="/ListOfBeers">Beers</Link>
            <Link to="/BeerDetailReviews">Beer Info and Reviews</Link>

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
        <Switch>
          <Route exact path="/breweries" component={() => <BreweriesPage />} />
          <Route
            exact
            path="/breweries/:id"
            component={() => <BreweryDetails />}
          />
          <Route path="/beers" component={() => <BeersPage />} />
          <Route exact path="/ListOfBeers" component={() => <ListOfBeers />} />
          <Route exact path="/AddBrewery" component={() => <AddBrewery />} />
          <Route exact path="/edit" component={() => <EditBreweriesPage />} />
          <Route exact path="/edit/beers" component={() => <EditBeersPage />} />
          <Route
            exact
            path="/BeerDetailReviews"
            component={() => <BeerDetailReviews />}
          />
          <Route path="/new" component={() => <NewBreweryPage />} />
          <Route path="/login" component={() => <Login />} />
          <Route path="/register" component={() => <Register />} />
          <Route path="/home" component={() => <Home />} />
        </Switch>
        <Footer />
      </div>
    );
  }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));
