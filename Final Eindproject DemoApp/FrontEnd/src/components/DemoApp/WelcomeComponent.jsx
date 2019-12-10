import React, {Component} from 'react'
import AuthenticationService from "./AuthenticationService";
const username = AuthenticationService.getLoggedInUsername();

class WelcomeComponent extends Component {
    constructor(props) {
        super(props)
        this.state={welcomeMessage:""}
    }

    render(){
        return <div>
            <h1 className="title">Welcome {username}!</h1>
            <div className="container">
            </div>
        </div>
    }
}

export default WelcomeComponent