import React, { Component } from 'react';
import { Link } from "react-router-dom";

class Home extends Component {
	render() {
		return (
			<div className="overall-div">
				<div className="centered-content-div">
					<header className="table-header">
						<h1>Home</h1>
						<Link to="/eow">End of Week Form</Link>
						<Link to="/login">Login</Link>
					</header>
				</div>
			</div>
		)
	}
}

export default Home;
