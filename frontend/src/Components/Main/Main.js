import { Component } from "react";
import { Routes, Route, Link, withRouter } from "react-router-dom";
import { addToken, deleteUser } from "../../Redux/actionCreators";
import { connect } from "react-redux";
import BreweriesPage from "../Pages/BreweriesPage";
import BeersPage from "../Pages/BeersPage";
import EditPage from "../Pages/EditPage";
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

  render() {
    return (
      <div className="main">
        <header>
          <h1>LOGO</h1>
          <nav className="nav-menu">
            <Link to="/breweries">Breweries</Link>
            <Link to="/beers">Beers</Link>
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
          <Route path="/breweries" component={() => <BreweriesPage />} />
          <Route path="/breweries/:id" component={() => <BreweryDetails />} />
          <Route path="/beers" component={() => <BeersPage />} />
          <Route path="/edit" component={() => <EditPage />} />
          <Route path="/new" component={() => <NewBreweryPage />} />

          <Route path="/login" component={() => <Login />} />
          <Route path="/register" component={() => <Register />} />
          <Route path="/home" component={() => <Home />} />
        </Routes>
        <Footer />
      </div>
    );
  }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));
