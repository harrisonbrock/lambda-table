import React, { Component } from "react";
import "./report-card.css";
import Axios from "axios";

class ReportCard extends Component {
	render() {
		return (
			<div className="cardContainer">
				<div className="card-class">
					<button className="delete-form" onClick={this.deleteForm}>
						X
					</button>
					<p>End of Week Form</p>
					<p className="createdAt">Created At:</p>
					<h3 className="timestamp">
						{this.props.report.createdAt.slice(0, 10)}
					</h3>
					{/* <span className="name">By: {this.props.report.user.name}</span> */}
				</div>
			</div>
		);
	}

	deleteForm = e => {
		e.preventDefault();

		Axios.delete(
			"http://localhost:8080/api/reports/id/" + this.props.report.id,
			{
				headers: { Authorization: "Bearer " + localStorage.getItem("token") }
			}
		)
			.then(response => {
				console.log(response);
				this.props.callback();
			})
			.catch(err => {
				console.log(err);
			});
	};
}

export default ReportCard;
