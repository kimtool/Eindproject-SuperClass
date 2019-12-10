import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'
const username = AuthenticationService.getLoggedInUsername();


class WelcomeComponent extends Component {

    render(){     
        return <div>
            <h1 className="title">Welcome {username}!</h1>
<!--        <h1 className="title">Welcome {this.props.match.params.name}!</h1> -->
            <div className="container">
                {/* {AuthenticationService.isUserAdmin() && <div>You are logged in as Admin</div>} */}
            </div>
        </div>
    }
}

export default WelcomeComponent
