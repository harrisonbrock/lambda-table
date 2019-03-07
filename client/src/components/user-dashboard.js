import React, { Component } from "react";
import Axios from "axios";
import ReportCard from "./report-card";

class User extends Component {
	state = {
		reports: []
	};

	componentDidMount() {
		if (!localStorage.getItem("token")) this.props.history.push("/login");
		Axios.get("http://localhost:8080/api/admin/reports", {
			headers: { Authorization: "Bearer " + localStorage.getItem("token") }
		})
			.then(response => {
				console.log(response.data);
				this.setState({ reports: response.data });
			})
			.catch(err => console.log(err));
	}

	render() {
		return (
			<div className="overall-div">
				<div className="centered-content-div">
					<header className="table-header">
						<div className="logo" />
					</header>
					{this.state.reports.map((report, index) => (
						<ReportCard
							onClick={this.handleCardClick}
							key={index}
							report={report}
						/>
					))}
				</div>
			</div>
		);
	}

	handleCardClick = e => {};
}

export default User;
