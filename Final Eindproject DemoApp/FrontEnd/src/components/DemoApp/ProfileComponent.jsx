import React, {Component} from 'react'
import AuthenticationService from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'
import UserDataService from "../api/UserDataService"
import axios from 'axios'
import {API_URL} from "../../Constants"
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';

const username = AuthenticationService.getLoggedInUsername();


class ProfileComponent extends Component {
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
        // this.handleChange = this.handleChange.bind(this);
        // this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (username !== 'new') {
            const user = await (await fetch(`${API_URL}/members/${username}`)).json();
            this.setState({item: user});
        }
    }
    //
    // constructor(props){
    //     super(props)
    //     this.state = {
    //         username: AuthenticationService.getLoggedInUsername(),
    //         password: "",
    //         role: "",
    //         wasLoginSuccesful: false,
    //         showErrorMessage: false
    //     }
    // }

    render(){
        const {item} = this.state;
        console.log(item.role)
        return <div>
            <h1 className="title">My profile</h1>
            <p>your id is {item.id}</p>
            <p>your id is {item.email}</p>
            <form>
                <Label for="email">E-mail</Label>
                <Input type="text" name="email" id="email" value={item.email || ''}
                       onChange={this.handleChange} autoComplete="address-level1"/>
            </form>
            {/*<h2 className="title" style={{fontSize:"24px"}}>Under construction</h2>*/}
            {/*<img id="welcome-image" alt="" src={Welcome_Image}/>*/}
            <div className="container">
            </div>
        </div>
    }
}


export default ProfileComponent
