import React, {Component} from 'react'
import AuthenticationService from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'

class ProfileComponent extends Component {

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
            <h1 className="title">My profile</h1>
            <h2 className="title" style={{fontSize:"24px"}}>Under construction</h2>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">            
            </div>
        </div>
    }
}


export default ProfileComponent
