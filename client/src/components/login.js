import React from "react";
// import axios from "axios";
import "./login.css";
import Axios from "axios";

class Login extends React.Component {
	state = {
		username: "",
		password: "",
		name: "",
		github: "",
		email: "",
		invalidCredentials: false,
		register: false
	};

	render() {
		return (
			<div className="wrapper">
				<div className="logo" />
				<h1 className="login">Log In</h1>
				<p className="noAcct">Don't have an acct?</p>
				<input
					name="register"
					type="checkbox"
					checked={this.state.register}
					onChange={this.handleCheck}
				/>
				<span className="regHere">Register Here</span>
				<form onSubmit={this.loginHandler}>
					<div>
						<label htmlFor="username" />
						<input
							name="username"
							placeholder="username"
							value={this.state.username}
							onChange={this.inputChangeHandler}
							type="text"
							className="text-entry"
						/>
					</div>
					<div>
						<label htmlFor="name" />
						{this.state.register ? (
							<input
								name="name"
								placeholder="name"
								value={this.state.name}
								onChange={this.inputChangeHandler}
								type="text"
								className="text-entry"
							/>
						) : null}
					</div>
					<div>
						<label htmlFor="github" />
						{this.state.register ? (
							<input
								name="github"
								placeholder="github"
								value={this.state.github}
								onChange={this.inputChangeHandler}
								type="text"
								className="text-entry"
							/>
						) : null}
					</div>
					<div>
						<label htmlFor="email" />
						{this.state.register ? (
							<input
								name="email"
								placeholder="email"
								value={this.state.email}
								onChange={this.inputChangeHandler}
								type="email"
								className="text-entry"
							/>
						) : null}
					</div>
					<div>
						<label htmlFor="password" />
						<input
							name="password"
							placeholder="password"
							value={this.state.password}
							onChange={this.inputChangeHandler}
							type="password"
							className="text-entry"
						/>
					</div>
					<button className="login-button">
						{this.state.register ? "Register" : "Log in"}
					</button>
				</form>
				{this.state.invalidCredentials ? <h3>Invalid Credentials</h3> : null}
			</div>
		);
	}

	inputChangeHandler = event => {
		this.setState({ [event.target.name]: event.target.value });
	};

	handleCheck = e => {
		this.setState({ register: !this.state.register });
	};

	loginHandler = event => {
		event.preventDefault();

		if (!this.state.register) {
			Axios.post("http://localhost:8080/api/auth/signin", {
				userNameOrEmail: this.state.username,
				password: this.state.password
			})
				.then(response => {
					console.log("login worked");
					if (response.data.accessToken) {
						localStorage.setItem("token", response.data.accessToken);
						// this.props.history.push("/eow");
						Axios.get("http://localhost:8080/api/admin/reports", {
							headers: {
								Authorization: "Bearer " + localStorage.getItem("token")
							}
						})
							.then(res => {
								this.props.history.push("/admin");
								console.log(res);
							})
							.catch(err => {
								this.props.history.push("/user");
								console.log(err);
							});
					}
				})
				.catch(err => {
					console.log(err);
					localStorage.removeItem("token");
					this.setState({ invalidCredentials: true, password: "" });
				});
		} else {
			Axios.post("http://localhost:8080/api/auth/signup", {
				userName: this.state.username,
				password: this.state.password,
				name: this.state.name,
				gitHubName: this.state.github,
				email: this.state.email
			})
				.then(response => {
					if (response.data.accessToken) {
						localStorage.setItem("token", response.data.accessToken);
						this.props.history.push("/user");
					}
				})
				.catch(err => {
					console.log(err);
					localStorage.removeItem("token");
					this.setState({ invalidCredentials: true, password: "" });
				});
		}
	};
}

export default Login;
