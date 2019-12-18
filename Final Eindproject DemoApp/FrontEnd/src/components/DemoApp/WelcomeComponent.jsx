import React, {Component} from 'react'
import AuthenticationService from "./AuthenticationService";
import UserDataService from "../api/UserDataService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'
export const USERROLE = "ROLE"

class WelcomeComponent extends Component {

    constructor(props){             //gets called when component is being initialized
        super(props)
        this.state = {
            user: []
        }
    }

    componentDidMount() {
        let username = AuthenticationService.getLoggedInUsername()
        UserDataService.retrieveUserByUsername(username)
        .then(
            response => {
            this.setState({user : response.data})            
        })
    }

    render(){
        let username = AuthenticationService.getLoggedInUsername()
        sessionStorage.setItem(USERROLE, this.state.user.role);
        return <div>
            <h1 className="title" style={{letterSpacing: "5px"}}>Welcome {username}!</h1>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">           
            </div>         
        </div>         
    }
}


export default WelcomeComponent
