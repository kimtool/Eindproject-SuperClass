import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Registration from './Registration';
import Demo from './Demo';
import UserList from './UserList';
import DemoList from "./DemoList";
import Demos from "./Demos";
import UserEdit from "./UserEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
              <Route path='/' exact={true} component={Home}/>
              <Route path='/Demo' exact={true} component={Demo}/>
              <Route path='/Demos' exact={true} component={Demos}/>
              <Route path='/UserList' exact={true} component={UserList}/>
              <Route path='/UserEdit:id' exact={true} component={UserEdit}/>
              <Route path='/DemoList' exact={true} component={DemoList}/>
              <Route path='/Registration' exact={true} component={Registration}/>
          </Switch>
        </Router>
    )
  }
}

export default App;