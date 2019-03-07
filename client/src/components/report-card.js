import React from "react";
import "./report-card.css";

const ReportCard = props => {
	return (
		<div className="card-class">
			<h3>{props.report.createdAt}</h3>
			<span>{props.report.user.name}</span>
		</div>
	);
};

export default ReportCard;
