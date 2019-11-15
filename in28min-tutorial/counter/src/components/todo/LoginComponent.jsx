import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'

class LoginComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            username: "in28min",
            password: "",
            wasLoginSuccesful: false,
            showErrorMessage: false
        }
    }
    handleChange = (event) => {
        this.setState(
            {
                [event.target.name]
                :event.target.value
            }
        )
    }
    loginClicked = () => {   
        // if(this.state.username==="in28min" && this.state.password==="pass123"){   
        //     AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password);
        //     this.props.history.push(`/welcome/${this.state.username}`)
        // }
        // else {             
        //     this.setState({showErrorMessage:true})
        //     this.setState({wasLoginSuccesful:false})
        // }
        // AuthenticationService
        // .executeBasicAuthenticationService(this.state.username,this.state.password)
        // .then(() => {                
        //     AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password);
        //     this.props.history.push(`/welcome/${this.state.username}`)
        //     }).catch(() => {
        //         this.setState({showErrorMessage:true})
        //         this.setState({wasLoginSuccesful:false})
        //     })


        //instead of password we need a token, token comes from response.data
        AuthenticationService
        .executeJwtAuthenticationService(this.state.username,this.state.password)
        .then((response) => {                
            AuthenticationService.registerSuccessfulLoginForJws(this.state.username, response.data.token);
            this.props.history.push(`/welcome/${this.state.username}`)
            }).catch(() => {
                this.setState({showErrorMessage:true})
                this.setState({wasLoginSuccesful:false})
            })
        }        

       
    render(){
        return (
            <div>
                <h1>Login</h1>
                <div className="conainer">
                {this.state.wasLoginSuccesful && <div>Login Succesful</div>}
                {this.state.showErrorMessage && <div className="alert alert-warning">Invalid Login</div>}
                Username: <input type="text" name="username" value={this.state.username} onChange={this.handleChange}/><br/>
                Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange}/><br/>
                <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}

export default LoginComponent