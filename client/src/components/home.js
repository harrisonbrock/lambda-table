import React, { Component } from "react";
import { Link } from "react-router-dom";
import "./login.css";

class Home extends Component {
	render() {
		return (
			<div className="wrapper">
			{/* <div className="overall-div"> */}
				<div className="centered-content-div">
					<header className="table-header">
					<div className="logo" />
						<h1 className="login">Home</h1>
						<Link to="/eow" className="eowForm">End of Week Form</Link>
						<br />
						<Link to="/login" className="log-in">Login</Link>
					</header>
				</div>
				<div className="puff" />
			</div>
		);
	}
}

export default Home;
