import React, {Component} from 'react'
import AuthenticationService, {PageRefresh, USER_NAME_SESSION_ATTRIBUTE_NAME} from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'
const refresh = sessionStorage.getItem(PageRefresh)

class WelcomeComponent extends Component {
    // trigger(){
    //     runrun = false
    // window.location.reload(runrun);
    // }
    refreshPage(){
        if(refresh != "change"){
            window.location.reload(false);
        }
    }
    render(){
        // setInterval(this.trigger,500);
        const username = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        const refresh = sessionStorage.getItem(PageRefresh)
        sessionStorage.setItem(PageRefresh, "change");
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
