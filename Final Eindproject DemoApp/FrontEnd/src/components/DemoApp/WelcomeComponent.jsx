import React, {Component} from 'react'
import UserDataService from "../api/UserDataService"
import AuthenticationService from "./AuthenticationService";
const username = AuthenticationService.getLoggedInUsername();

class WelcomeComponent extends Component {

    // constructor(props){
    //     super(props)
    //     this.state = {
    //         username: "",
    //         password: "",
    //         role: "",
    //         wasLoginSuccesful: false,
    //         showErrorMessage: false
    //     }
    // }

    // getUserRole(username){
    //     UserDataService.retrieveUserByUsername(username)
    //     .then(response => this.setState({
    //         role: response.data.role
    //     }))
    //     return this.state.role;
    // }

    // buttonClicked = () => {
    //     this.getUserRole(this.state.username); 
    //     console.log(this.state.role)
    // }

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
            <h1 className="title">Welcome {username}!</h1>

 {/* <h1 className="title">Welcome {this.props.match.params.name}!</h1>  */}

            <div className="container">
            {/* <button className="button" onClick={this.buttonClicked}>BUTTON</button> */}
                {/* {AuthenticationService.isUserAdmin() && <div>You are logged in as Admin</div>} */}
            </div>
        </div>
    }
}

export default WelcomeComponent