import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import userServices from "./services/user";
import {Link} from "react-router-dom"


export default class Home extends Component {

    constructor(){
        super();
        this.state = {
            user:""
        }
    }

    async componentDidMount(){
        console.log("Mounted info");
        const res = await userServices.info();
        if(res.success){
        console.log(res.user)
            this.setState({user:res.user})
        }
        else{
            alert("Error Server")
        }

    }

    render() {
        return (
            <div className="container">
                <div className="row justify-content-center">
                   <section>
                           <table className="table">
                             <thead className="thead-dark">
                               <tr>
                                 <th scope="col">#</th>
                                 <th scope="col">Name</th>
                                 <th scope="col">Email</th>
                                 <th scope="col">Company</th>
                                 <th scope="col">Phone</th>
                                 <th scope="col">Action</th>
                               </tr>
                             </thead>
                             <tbody>


                               <tr>
                                 <th scope="row">#</th>
                                 <td>{this.state.user.fullname}</td>
                                 <td>{this.state.user.email}</td>
                                 <td>{this.state.user.company}</td>
                                 <td>{this.state.user.phone}</td>
                                 <td>
                                   <a href="#" className="btn btn-light"> Edit </a>
                                 </td>
                               </tr>
                             </tbody>
                           </table>
                         </section>
                </div>
            </div>
        );
    }
}

if (document.getElementById('component-home')) {
    ReactDOM.render(<Home />, document.getElementById('component-home'));
}