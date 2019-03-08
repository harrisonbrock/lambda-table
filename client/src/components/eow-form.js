import React, { Component } from "react";
import "./Eow.css";
import Axios from "axios";

class Eow extends Component {
	state = {
		threeWords: "",
		wentWell: "",
		goneBetter: "",
		workedOn: "",
		projectURL: "",
		importedState: false
	};
	componentDidMount() {
		if (!localStorage.getItem("token")) this.props.history.push("/login");
		if (this.props.location.state !== undefined) {
			this.setState({
				threeWords: this.props.location.state.report.describeWeek || "",
				wentWell: this.props.location.state.report.whatWentWellThisWeek || "",
				goneBetter:
					this.props.location.state.report.whatCouldHaveWentBetter || "",
				workedOn:
					this.props.location.state.report.whatDidYouWorkOnThisWeek || "",
				projectURL: this.props.location.state.report.urlSubmission || "",
				importedState: true
			}); //if state is sent in from component calling eow
		}
	}
	onInputChange = e => {
		this.setState({ [e.target.name]: e.target.value });
	};

	render() {
		return (
			<div className="overall-div">
				<div className="centered-content-div">
					<header className="table-header">
						<div className="logo" />
					</header>
					<form>
						<div>
							<h3>Describe this week in 3 words</h3>
							<textarea
								value={this.state.threeWords}
								name="threeWords"
								onChange={this.onInputChange}
								className="textbox"
							/>
						</div>
						<div>
							<h3>What went well this week?</h3>
							<textarea
								value={this.state.wentWell}
								name="wentWell"
								onChange={this.onInputChange}
								className="textbox"
							/>
						</div>
						<div>
							<h3>What could have gone better?</h3>
							<textarea
								value={this.state.goneBetter}
								name="goneBetter"
								onChange={this.onInputChange}
								className="textbox"
							/>
						</div>
						<div>
							<h3>What did you work on this week?</h3>
							<textarea
								value={this.state.workedOn}
								name="workedOn"
								onChange={this.onInputChange}
								className="textbox"
							/>
						</div>
						<div>
							<h3>What is your project submission URL?</h3>
							<textarea
								value={this.state.projectURL}
								name="projectURL"
								onChange={this.onInputChange}
								className="textbox"
							/>
						</div>
						<button className="submit-btn" onClick={this.onSubmit}>
							Submit
						</button>
					</form>
				</div>
			</div>
		);
	}

	onSubmit = event => {
		event.preventDefault();

		const data = {
			describeWeek: this.state.threeWords,
			whatDidYouWorkOnThisWeek: this.state.workedOn,
			whatWentWellThisWeek: this.state.wentWell,
			whatCouldHaveWentBetter: this.state.goneBetter,
			urlSubmission: this.state.projectURL,
			teacher: "Beej",
			projectmanager: "Bonn"
		};

		if (this.state.importedState) {
			console.log("Attempting to update report for some reason?");
			//update path
		} else {
			console.log("Creating new report");
			Axios.post("http://localhost:8080/api/reports", data, {
				headers: { Authorization: "Bearer " + localStorage.getItem("token") }
			})
				.then(response => {
					console.log(response);
					this.props.history.push("/user");
				})
				.catch(err => {
					console.log(err);
				});
		}
	};
}

export default Eow;
