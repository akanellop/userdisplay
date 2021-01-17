import React, { Component } from 'react';
import ReactDOM from 'react-dom';

export default class Register extends Component {

  render() {
    console.log("dsad");
    return (
      <div className="container">
        <div className="row justify-content-center">
            <form name='register'>
            <div className="form-group">
                <label for="fullName">Full Name</label>
                <input type="text" className="form-control" placeholder="Name" />
            </div>
            <div className="form-group">
                <label for="email">Email</label>
                <input type="email" className="form-control" placeholder="you@example.com" />
            </div>

            <div className="form-group">
                <label for="company">Company</label>
                <input type="text" className="form-control" placeholder="" />
            </div>

            <div className="form-group">
                <label for="phone">Phone </label>
                <input type="text" className="form-control" placeholder="123467890" />
            </div>

            <div className="form-group">
                <label for="pass1">Password </label>
                <input type="password" className="form-control" placeholder="*****" />
            </div>

            <div className="form-group">
                <label for="pass2">Repeat password </label>
                <input type="password" className="form-control" placeholder="*****" />
            </div>

            <div className="form-group">
                <button className="btn btn-primary btn-block" type="submit">Save</button>
            </div>
        </form>
        </div>
      </div>
    )
  }
}

if (document.getElementById('component-register')) {
    ReactDOM.render(<Register />, document.getElementById('component-register'));
}