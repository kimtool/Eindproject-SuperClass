import React, {Component} from 'react'
import DemoDataService from '../api/DemoDataService.js'
import AuthenticationService from './AuthenticationService.js'
import {Link} from 'react-router-dom'

class ListDemosComponent extends Component {
    constructor(props){             //gets called when component is being initialized
        super(props)
        this.state = {
            demos: 
            [               //better not to do initial API call directly in the constructor, otherwise state will not be initialized until API call is completed
            //{id:1, description:"Learn React", done:false, targetDate:new Date()}, 
            ], 
            message : null
        }
    }

    // Base64 string data

    componentDidMount() { 
        this.refreshDemos();
    }    

    refreshDemos = () => {
        let username = AuthenticationService.getLoggedInUsername()
        DemoDataService.retrieveAllDemos(username)
        .then(
            response => {
            this.setState({demos : response.data})
        })
    }

    deleteDemoClicked = (id) => {
        let name = AuthenticationService.getLoggedInUsername()
        DemoDataService.deleteDemo(name, id)
        .then(response =>{
                this.setState({message:`Delete of demo ${id} Succesful`});
                this.refreshDemos();
            }
        )
    }

    updateDemoClicked = (id) => {
        this.props.history.push(`/demos/${id}`)
    }

    render(){
        return (
        <div>            
            {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
            <h1 className="title">DEMO'S</h1>
            <Link to="/demos/add" style={{textDecoration: "none"}}><button className="button">Add</button></Link>  
            <div className="container">            
            <table className="table">
                <thead>
                    <tr>
                        {/* <th>id</th> */}
                        <th>File</th>
                        <th>User</th>
                        <th>Title</th>
                        {/* <th>File</th> */}
                        <th>Description</th>
                        {/* <th>Upload Date</th>
                        <th>Status</th>
                        <th>Update</th> */}
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
//map() method is used to iterate over an array and calling function on every element of array.
                        this.state.demos.map (
                            demo =>                        
                            <tr key={demo.id}>
                                {/* <td>{demo.id}</td> */}
                                <td>
                                    <audio controls>  
                                        <source src={`data:audio/mp3;base64,${demo.data}`} type="audio/mpeg" controls="controls"/>
                                        Your browser does not support the audio element.
                                    </audio>
                                </td>
                                <td>{demo.username}</td>
                                <td>{demo.trackName}</td>
                                {/* <td>{demo.fileName}</td> */}
                                <td>{demo.description}</td>
                                {/* <td>{moment(demo.targetDate).format("YYYY-MM-DD")}</td>
                                <td>{demo.isDone.toString()}</td>                                 
                                <td><button className="button_small" onClick={() => this.updateDemoClicked(demo.id)}>Update</button></td>*/}
                                <td><button className="button_small" onClick={() => this.deleteDemoClicked(demo.id)}>Delete</button></td>
                            </tr>
                        )
                    }
                </tbody>
            </table>            
            </div>
        </div>
        )
    }
}

export default ListDemosComponent