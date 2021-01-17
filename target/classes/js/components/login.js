import React, { Component } from 'react';
import ReactDOM from 'react-dom';

export default class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: ""};
        }
   validateForm() {
      return (this.state.email =="" && this.state.password == "");
    }
    render() {
        return (

        <div className="main"  >
                <div className="row justify-content-center">
                    <form name='login' action="/login" method='POST'>
                        <div className="form-group">
                            <label>Email</label>
                            <input type="email" className="form-control" placeholder="Email" name="email" id="email"/>
                        </div>
                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" placeholder="Password" name="password" id="email"/>
                        </div>
                        <button type="submit" className="btn btn-black"> Login</button>
                    </form>
                </div>

        </div>
        );
    }
}

if (document.getElementById('component-login')) {
    ReactDOM.render(<Login />, document.getElementById('component-login'));
}