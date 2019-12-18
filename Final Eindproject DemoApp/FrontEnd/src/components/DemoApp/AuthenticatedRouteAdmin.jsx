import React, {Component} from 'react'
import {Route,Redirect} from 'react-router-dom'
import AuthenticationService from './AuthenticationService.js'

//check if user is logged in, only then he can visit certain pages/urls
class AuthenticatedRouteAdmin extends Component {
    render(){
        if(AuthenticationService.isUserAdmin()){
            return <Route {...this.props}/>
        }
        else{
            return <Redirect to="/welcome"/>
        }
    }

}
export default AuthenticatedRouteAdmin