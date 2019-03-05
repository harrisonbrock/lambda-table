import React, { Component } from 'react';
import logo from '../logo.svg';
// import './Eow.css';

class Eow extends Component {
    render() {
        return (
            <div className="overall-div">
                <div className="centered-content-div">
                    <header className="table-header">
                        <img src={logo} className="App-logo" alt="logo" />
                    </header>
                    <div>
                        <h3>Describe this week in 3 words</h3>
                        <textarea />
                    </div>
                    <div>
                        <h3>What went well this week?</h3>
                        <textarea />
                    </div>
                    <div>
                        <h3>What could have gone better?</h3>
                        <textarea />
                    </div>
                    <div>
                        <h3>What did you work on this week?</h3>
                        <textarea />
                    </div>
                    <button>Submit</button>
                </div>
            </div>
        )
    }
}

export default Eow;
