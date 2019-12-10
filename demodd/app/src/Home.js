import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {

    submitHandle = (e) => {
        e.preventDefault()
        var data = {
            email: this.state.email,
            password: this.state.password
        }
        console.log(data)
        fetch("/api/login", {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        this.props.history.push('/');
    }
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/api/users">Welcome Haxagon!</Link></Button>
                    <div>
                        <Button color="success" tag={Link} to="/Registration">Registration</Button>
                        <Button color="success" tag={Link} to="/UserList">Userlist</Button>
                        <Button color="success" tag={Link} to="/DemoList">Demolist</Button>
                        <Button color="success" tag={Link} to="/Demo">one Demo</Button>
                        <Button color="success" tag={Link} to="/Demos">two Demo</Button>
                    </div>
                </Container>
            </div>
        );
    }
}

export default Home;