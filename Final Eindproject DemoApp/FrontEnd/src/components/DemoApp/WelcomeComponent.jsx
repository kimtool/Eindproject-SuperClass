import React, {Component} from 'react'
import UserDataService from "../api/UserDataService";
import AuthenticationService from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'
const username = AuthenticationService.getLoggedInUsername();

class WelcomeComponent extends Component {

    render(){     
        return <div>
            <h1 className="title" style={{letterSpacing: "5px"}}>Welcome {username}!</h1>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">
                
            </div>
        </div>
    }
}


export default WelcomeComponent
