import React, {Component} from 'react'
import UserDataService from "./UserDataService";
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

    getUserRole(username){
        UserDataService.retrieveUserByUsername(username)
        .then(response => this.setState({
            role: response.data.role
        }))
        return this.state.role;
    }

    buttonClicked = () => {
        this.getUserRole(this.state.username); 
        console.log(this.state.role)
    }

    loginClicked = () => {
        //instead of password we need a token, token comes from response.data
                AuthenticationService.executeJwtAuthenticationService(this.state.username,this.state.password)
                .then((response) => {
                    console.log(this.getUserRole(this.state.username));       
                    AuthenticationService.registerSuccessfulLoginForJwt(this.state.username, response.data.token, this.state.role);
                    this.props.history.push(`/welcome/${this.state.username}`)
                    }).catch(() => {
                        this.setState({showErrorMessage:true})
                        this.setState({wasLoginSuccesful:false})
                    })
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
