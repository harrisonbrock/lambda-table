import React from "react";
// import axios from "axios";
import "./login.css";

class Login extends React.Component {
	state = {
		username: "",
		password: "",
		invalidCredentials: false
	};

	render() {
		return (
			<div className="wrapper">
				<h1>Log In</h1>
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
					<button className="login-button">Log in</button>
				</form>
				<button className="register-button" onClick={this.registerHandler}>Register</button>
				{this.state.invalidCredentials ? (
					<h3>Invalid Credentials</h3>
				) : null}
			</div>
		);
	}

	inputChangeHandler = event => {
		this.setState({ [event.target.name]: event.target.value });
	};

	loginHandler = event => {
		event.preventDefault();

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
	};

	registerHandler = event => {
		event.preventDefault();

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
	};
}

export default Login;
