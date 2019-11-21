import React, {Component} from 'react'
import '../../App.css'
import LoginComponent from './LoginComponent.js'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

//terminal: npm add react-router-dom

class DemoApp extends Component {
    render(){
        return (
            <div className="DemoApp">
                <Router>
                    <main>
{/* Make sure only one route is used at a time */}
                        <Switch >
{/* Route defines wich page has wich url, AuthenticatedRoute can only be taken by authenticated users */}
                            <Route path="/" exact component={LoginComponent}/>
                            <Route path="/login" component={LoginComponent}/>
                        </Switch>
                    </main>
                </Router>
            </div>
        )
    }
}

export default DemoApp