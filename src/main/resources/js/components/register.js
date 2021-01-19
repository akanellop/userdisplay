import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import userServices from "./services/user"

export default class Register extends Component {

    constructor(){
        super();
        this.state = {
            fieldName:"",
            fieldEmail:"",
            fieldPass1:"",
            fieldPass2:"",
            fieldCompany:"",
            fieldPhone:""
        }
    }

  render() {
    return (

      <div className="container">
        <div className="row justify-content-center">

            <form id="register" name='register'>

            <div className="form-group">
                <label >Full Name</label>
                <input id="name" name="name" type="text" className="form-control" placeholder="Name"
                    value={this.state.fieldName}
                    onChange={(event)=>this.setState({fieldName:event.target.value})}
                />
            </div>
            <div className="form-group">
                <label >Email</label>
                <input name="email" type="email" className="form-control" placeholder="you@example.com"
                    value={this.state.fieldEmail}
                    onChange={(event)=>this.setState({fieldEmail:event.target.value})}/>
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
                <label >Password </label>
                <input name="password1" type="password" className="form-control" placeholder="*****"
                value={this.state.fieldPass1}
                onChange={(event)=>this.setState({fieldPass1:event.target.value})}/>
            </div>

            <div className="form-group">
                <label >Repeat password </label>
                <input type="password" className="form-control" placeholder="*****"
                value={this.state.fieldPass2}
                onChange={(event)=>this.setState({fieldPass2:event.target.value})}/>
            </div>

            <div className="form-group">
                <button className="btn btn-primary btn-block" type="submit" onClick={()=>this.onClickSave()} >Save</button>
            </div>
        </form>
        </div>
      </div>
    )
  }

   async onClickSave(){
        const res = await userServices.create(this.state)
        if(res.success){
            //alert(res.message)
            window.location = "/login";
        }
        else{
            alert("Error : "+ res.message)
        }
   }
}

if (document.getElementById('component-register')) {
    ReactDOM.render(<Register />, document.getElementById('component-register'));
}