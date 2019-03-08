import React from "react";
import "./report-card.css";

const ReportCard = props => {
	return (
		<div className="cardContainer">
			<div className="card-class">
				<p className="title"></p>
				<p className="createdAt">Created At:</p>
				<h3 className="timestamp"> {props.report.createdAt}</h3>
				<span className="name">By: {props.report.user.name}</span>
			</div>
		</div>
	);
};

export default ReportCard;
