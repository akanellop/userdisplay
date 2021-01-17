import React, { Component } from 'react';
import ReactDOM from 'react-dom';

export default class Home extends Component {
    render() {
        return (
            <div className="container">
                <div className="row justify-content-center">
                   <section>
                           <table className="table">
                             <thead class="thead-dark">
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
                                 <th scope="row">1</th>
                                 <td>John Doe</td>
                                 <td>john@example.com</td>
                                 <td>California Cll 100</td>
                                 <td>3101111111</td>
                                 <td>
                                   <a href="#" class="btn btn-light"> Edit </a>
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