import React from "react";
// import axios from "axios";
import "./login.css";
import Axios from "axios";

class Login extends React.Component {
	state = {
		username: "",
		password: "",
		name: "",
		invalidCredentials: false,
		register: false
	};

	render() {
		return (
			<div className="wrapper">
				<h1>Log In</h1>
				<span>Register</span>
				<input name="register" type="checkbox" checked={this.state.register} onChange={this.handleCheck} />
				<form onSubmit={this.loginHandler}>
					<div>
						<label htmlFor="username" />
						<input
							name="username"
							placeholder="username or email"
							value={this.state.username}
							onChange={this.inputChangeHandler}
							type="text"
							className="text-entry"
						/>
					</div>
					<div>
						<label htmlFor="name" />
						{this.state.register ? <input
							name="name"
							placeholder="name"
							value={this.state.password}
							onChange={this.inputChangeHandler}
							type="text"
							className="text-entry"
						/> : null}
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
					<button className="login-button">{this.state.register ? "Register" : "Log in"}</button>
				</form>
				{this.state.invalidCredentials ? (
					<h3>Invalid Credentials</h3>
				) : null}
			</div>
		);
	}

	inputChangeHandler = event => {
		this.setState({ [event.target.name]: event.target.value });
	};

	handleCheck = e => {
		this.setState({ register: !this.state.register });
	}

	loginHandler = event => {
		event.preventDefault();

		if (!this.state.register) {
			Axios
				.post("localhost:8080/api/auth/signin", this.state)
				.then(response => {
					// if (response.data.accessToken) {
					//   localStorage.setItem("token", response.data.accessToken);
					//   this.props.history.push("/notes");
					// }
					console.log(response);
					this.setState({ invalidCredentials: true, password: "" });
				})
				.catch(err => {
					console.log(err);
					localStorage.removeItem("token");
					this.setState({ invalidCredentials: true, password: "" });
				});
		} else {
			// axios
			//   .post("https://cruise-backend.herokuapp.com/api/users/login", this.state)
			//   .then(response => {
			//     if (response.data.token) {
			//       localStorage.setItem("token", response.data.token);
			//       this.props.history.push("/notes");
			//     }
			//     this.setState({ invalidCredentials: true, password: "" });
			//   })
			//   .catch(err => {
			//     localStorage.removeItem("token");
			//     this.setState({ invalidCredentials: true, password: "" });
			//   });
		}
	};
}

export default Login;
