import React, { Component } from 'react';
import logo from '../logo.svg';
// import './Eow.css';

class Eow extends Component {
    state = {
        threeWords: "",
        wentWell: "",
        goneBetter: "",
        workedOn: ""
    }

    onInputChange = e => {
        this.setState({ [e.target.name]: e.target.value });
    };

    render() {
        return (
            <div className="overall-div">
                <div className="centered-content-div">
                    <header className="table-header">
                        <img src={logo} className="App-logo" alt="logo" />
                    </header>
                    <div>
                        <h3>Describe this week in 3 words</h3>
                        <textarea value={this.state.threeWords} name="threeWords" onChange={this.onInputChange} />
                    </div>
                    <div>
                        <h3>What went well this week?</h3>
                        <textarea value={this.state.wentWell} name="wentWell" onChange={this.onInputChange} />
                    </div>
                    <div>
                        <h3>What could have gone better?</h3>
                        <textarea value={this.state.goneBetter} name="goneBetter" onChange={this.onInputChange} />
                    </div>
                    <div>
                        <h3>What did you work on this week?</h3>
                        <textarea value={this.state.workedOn} name="workedOn" onChange={this.onInputChange} />
                    </div>
                    <button>Submit</button>
                </div>
            </div>
        )
    }
}

export default Eow;
