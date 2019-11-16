import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'
import {Link, withRouter} from 'react-router-dom'
import hexagonlogo from '../images/hexagonlogo_A1_Rectangle_13_pattern.png'
import '../../App.css'

class HeaderComponent extends Component{
    render(){
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">                    
                    <ul className="navbar-nav navbar-collapse menu-bar">
                        {isUserLoggedIn && <li><Link className="nav-link menu-icon" to="/welcome/name">HOME</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link menu-icon" to="/todos">MY PROFILE</Link></li>}
                        <li><Link className="nav-link menu-icon" to="/welcome/name"><img className="hexagonlogo" src={hexagonlogo}/></Link></li>
                        {/* {!isUserLoggedIn && <li><Link className="nav-link menu-icon" to="/login">LOGIN</Link></li>} */}
                        {isUserLoggedIn && <li><Link className="nav-link menu-icon"  to="/todos">DEMO'S</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link menu-icon" to="/logout" onClick={AuthenticationService.logout}>LOGOUT</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(HeaderComponent)      //ensure header menus are updated whenever the router is called