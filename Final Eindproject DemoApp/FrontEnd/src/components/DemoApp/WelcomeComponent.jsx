import React, {Component} from 'react'
import AuthenticationService, {USER_NAME_SESSION_ATTRIBUTE_NAME} from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'

class WelcomeComponent extends Component {

    render(){
        const username = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        // console.log(username)
        return <div>
            <h1 className="title" style={{letterSpacing: "5px"}}>Welcome {username}!</h1>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">
                
            </div>
        </div>
    }
}


export default WelcomeComponent
