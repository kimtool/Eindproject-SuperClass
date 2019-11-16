import React, {Component} from 'react'
import '../../App.css'
import AuthenticatedRoute from './AuthenticatedRoute.jsx'
import LoginComponent from './LoginComponent.jsx'
import DemoListComponent from './DemoListComponent.jsx'
import HeaderComponent from './HeaderComponent.jsx'
import FooterComponent from './FooterComponent.jsx'
import LogoutComponent from './LogoutComponent.jsx'
import WelcomeComponent from './WelcomeComponent.jsx'
import ErrorComponent from './ErrorComponent.jsx'
import AddDemoComponent from './AddDemoComponent.jsx'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
//terminal: npm add react-router-dom

class DemoApp extends Component {
    render(){
        return (
            <div className="TodoApp">   
                <Router>
                    <HeaderComponent/>      {/* AuthenticatedRoute, only authenticated user can take this route */}
                    <Switch>                {/* Make sure only one route is used at a time */}
                        <Route path="/" exact component={LoginComponent}/>
                        <Route path="/login" component={LoginComponent}/>
                        <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                        <AuthenticatedRoute path="/todos/:id" component={AddDemoComponent}/>
                        <AuthenticatedRoute path="/todos" component={DemoListComponent}/>
                        <AuthenticatedRoute path="/logout" component={LogoutComponent}/>                        
                        <Route path="" component={ErrorComponent}/>
                    </Switch>
                    <FooterComponent/>
                </Router>                 
                {/* <LoginComponent/>
                <WelcomeComponent/> */}
            </div>
        )
    }
}

export default DemoApp