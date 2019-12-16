import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'
import {Link, withRouter} from 'react-router-dom'
import hexagonlogo from '../images/hexagonlogo_A1_Rectangle_13_pattern.png'
import '../../Header.css'

class HeaderComponent extends Component{
    render(){
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <header className="desktop-header">                                     
                <div className="icon-block">{isUserLoggedIn && <Link className="menu-icon" to="/welcome">HOME</Link>}</div>
                <div className="icon-block left">{isUserLoggedIn && <Link className="menu-icon" to="/profile">MY PROFILE</Link>}</div>
                <Link to="/welcome"><img className="hexagonlogo" alt="" src={hexagonlogo}/></Link>
                <div className="icon-block right">{isUserLoggedIn && <Link className="menu-icon"  to="/demos">DEMO'S</Link>}</div>
                <div className="icon-block">{isUserLoggedIn && <Link className="menu-icon" to="/logout" onClick={AuthenticationService.logout}>LOG OUT</Link>}</div>
            </header>
        )
    }
}
//To ensure that header menus are updated whenever the router is called 
//we need to wrap HeaderComponent with a call to withRouter 
export default withRouter(HeaderComponent) 