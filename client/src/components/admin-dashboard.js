import React, { Component } from 'react';
import './Eow.css';
import Axios from 'axios';

class Eow extends Component {
	state = {
		users: [],
		reports: []
	}

	componentDidMount() {
		// Axios
	}

	render() {
		return (
			<div className="overall-div">
				<div className="centered-content-div">
					<header className="table-header">
						<div className="logo" />
					</header>
					{this.state.users.map(user => (
						<>
							<h3>{user.name}</h3>
							<span>{this.state.reports.filter(report => report.user === user)}</span>
						</>
					))}
				</div>
			</div>
		)
	}
}

export default Eow;
