import React, { Component } from 'react';
import './App.css';
import { Route } from "react-router-dom";
import Eow from './components/eow-form';
import Home from './components/home';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Route exact path="/" component={Home} />
        <Route path="/eow" component={Eow} />
      </div>
    );
  }
}

export default App;
