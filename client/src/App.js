import React, { Component } from 'react';
import './App.css';
import { Route } from "react-router-dom";
import Eow from './components/eow-form';
import Home from './components/home';
import Login from './components/login';
import Admin from './components/admin-dashboard';
import User from './components/user-dashboard';

class App extends Component {
	render() {
		return (
			<div className="App">
				<Route exact path="/" component={Home} />
				<Route path="/eow" component={Eow} />
				<Route path="/login" component={Login} />
				<Route path="/admin" component={Admin} />
				<Route path="/user" component={User} />
			</div>
		);
	}
}

export default App;
