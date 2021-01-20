import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import userServices from "./services/user"

export default class Edit extends Component {

    constructor(){
        super();
        this.state = {
            fieldName:"Saved-Value",
            fieldPass1:"",
            fieldPass2:"",
            fieldCompany:"Saved-Value",
            fieldPhone:"Saved-Value",
            fieldOldPass:"",
        }
    }

  render() {
    return (

      <div className="container">
        <div className="row justify-content-center">

            <form id="edit" name='edit'>

            <div className="form-group">
                <label >Full Name</label>
                <input id="name" name="name" type="text" className="form-control" placeholder="Name"
                    value={this.state.fieldName}
                    onChange={(event)=>this.setState({fieldName:event.target.value})}
                />
            </div>

            <div className="form-group">
                <label >Company</label>
                <input type="text" className="form-control" placeholder=""
                value={this.state.fieldCompany}
                onChange={(event)=>this.setState({fieldCompany:event.target.value})}/>
            </div>

            <div className="form-group">
                <label >Phone </label>
                <input name="phone" type="text" className="form-control" placeholder="123467890"
                value={this.state.fieldPhone}
                onChange={(event)=>this.setState({fieldPhone:event.target.value})}/>
            </div>

            <div className="form-group">
                <label >New Password </label>
                <input id ="pass1" name="password1" type="password" className="form-control" placeholder="*****"
                value={this.state.fieldPass1}
                onChange={(event)=>this.setState({fieldPass1:event.target.value})}/>
            </div>

            <div className="form-group">
                <label >Please give password again. </label>
                <input id ="pass2" type="password" className="form-control" placeholder="*****"
                value={this.state.fieldPass2}
                onChange={(event)=>this.setState({fieldPass2:event.target.value})}/>
            </div>

            <h3>Enter your previous password to confirm.</h3>
            <div className="form-group">
                <input type="password" className="form-control" placeholder="*****"
                value={this.state.fieldOldPass}
                onChange={(event)=>this.setState({fieldOldPass:event.target.value})}/>
            </div>

            <button className="btn btn-primary btn-block" type="submit" onClick={()=>this.onClickSave()} >Save</button>

            </form>
            <a href="/home">  GO back </a>
        </div>
      </div>
    )
  }

   async onClickSave(){
        const res = await userServices.edit(this.state)
        if(res.success){
            window.location = "/home";
        }
        else{
            alert("Error : "+ res.body)
        }
   }
}

if (document.getElementById('component-edit')) {
    ReactDOM.render(<Edit />, document.getElementById('component-edit'));
}