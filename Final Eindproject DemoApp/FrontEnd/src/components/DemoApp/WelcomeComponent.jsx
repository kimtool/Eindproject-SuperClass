import React, {Component} from 'react'
import AuthenticationService from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'

class WelcomeComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            username: AuthenticationService.getLoggedInUsername(),
            password: "",
            role: "",
            wasLoginSuccesful: false,
            showErrorMessage: false
        }
    }

    render(){     
        return <div>
            <h1 className="title" style={{letterSpacing: "5px"}}>Welcome {this.state.username}!</h1>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">
                
            </div>
        </div>
    }
}


export default WelcomeComponent
