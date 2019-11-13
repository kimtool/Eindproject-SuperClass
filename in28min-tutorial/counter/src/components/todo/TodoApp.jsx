import React, {Component} from 'react'
import './Todo.css'
import AuthenticatedRoute from './AuthenticatedRoute.jsx'
import LoginComponent from './LoginComponent.jsx'
import ListTodosComponent from './ListTodosComponent.jsx'
import HeaderComponent from './HeaderComponent.jsx'
import FooterComponent from './FooterComponent.jsx'
import LogoutComponent from './LogoutComponent.jsx'
import WelcomeComponent from './WelcomeComponent.jsx'
import ErrorComponent from './ErrorComponent.jsx'
import TodoComponent from './TodoComponent.jsx'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

//terminal: npm add react-router-dom

class TodoApp extends Component {
    render(){
        return (
            <div className="TodoApp">
                <Router>
                    <HeaderComponent/>      {/* AuthenticatedRoute, only authenticated user can take this route */}
                    <Switch>                {/* Make sure only one route is used at a time */}
                        <Route path="/" exact component={LoginComponent}/>
                        <Route path="/login" component={LoginComponent}/>
                        <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                        <AuthenticatedRoute path="/todos/:id" component={TodoComponent}/>
                        <AuthenticatedRoute path="/todos" component={ListTodosComponent}/>
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

export default TodoApp