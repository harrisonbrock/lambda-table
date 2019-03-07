import React, { Component } from 'react';
// import './User.css';
import Axios from 'axios';

class User extends Component {
	state = {
		reports: []
	}

	componentDidMount() {
		if (!localStorage.getItem("token")) this.props.history.push("/login");
	}

	render() {
		return (
			<div className="overall-div">
				<div className="centered-content-div">
					<header className="table-header">
						<div className="logo" />
					</header>
					{this.state.reports.map(report => (
						<h3>{report.name}</h3>
					))}
				</div>
			</div>
		)
	}
}

export default User;
