import React, {Component} from 'react'
import AuthenticationService, {PageRefresh, USER_NAME_SESSION_ATTRIBUTE_NAME} from "./AuthenticationService";
import Welcome_Image from '../images/afbeeldingen/welcomeBanner7.jpg'
export const USERROLE = "user"
const username = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)

class WelcomeComponent extends Component {
    emptyItem = {
        id: '',
        role: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
    }

    async componentDidMount() {
            const user = await (await fetch(`/members/${username}`)).json();
            this.setState({item: user});
    }

    render(){
        const {item} = this.state;
        console.log(item.role)
        sessionStorage.setItem(USERROLE, item.role);
        return <div>
            <h1 className="title" style={{letterSpacing: "5px"}}>Welcome {username}!</h1>
            <img id="welcome-image" alt="" src={Welcome_Image}/>
            <div className="container">
                
            </div>
        </div>
    }
}


export default WelcomeComponent
