import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'
import {Link, withRouter} from 'react-router-dom'
import hexagonlogo from '../images/hexagonlogo_A1_Rectangle_13_pattern.png'
import '../../Header.css'
import {USER_NAME_SESSION_ATTRIBUTE_NAME} from "./AuthenticationService";
import {API_URL} from "../../Constants";

class HeaderComponent extends Component{
    emptyItem = {
        id: '',
        name: '',
        email: '',
        password: '',
        role: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
    }

    async componentDidMount() {
        const username = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (username !== 'new') {
            const user = await (await fetch(`${API_URL}/members/${username}`)).json();
            this.setState({item: user});
        }
    }


    render(){
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        const isAdmin = this.state.role != 'ROLE_ADMIN';
        return (
            <header className="desktop-header">
                <div className="icon-block">{isUserLoggedIn && <Link className="menu-icon" to="/welcome">HOME</Link>}</div>
                <div className="icon-block left">
                {isAdmin ? (
                    <div className="icon-block left">{isUserLoggedIn && <Link className="menu-icon" to="/profile">MY PROFILE</Link>}</div>
                ) : (
                    <div className="icon-block left">{isUserLoggedIn && <Link className="menu-icon" to="/profile">MEMBERS</Link>}</div>
                )}
                </div>
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
