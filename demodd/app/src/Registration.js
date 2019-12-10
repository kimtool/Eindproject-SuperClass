import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import './App.css';



class Registration extends Component{
    constructor(props){
        super(props)
        this.state = {
            name: "",
            email: "",
            password: "",
            isactive: "1",
            role: "ROLE_USER"
        }
        this.handelChange = this.handelChange.bind(this);
        this.submitHandle = this.submitHandle.bind(this);
    }
    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const user = await (await fetch(`/api/user/${this.props.match.params.id}`)).json();
            this.setState({item: user});
        }
    }
    handelChange = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandle = (e) => {
        e.preventDefault()
        var data = {
            name: this.state.name,
            email: this.state.email,
            password: this.state.password,
            isactive: this.state.isactive,
            role: this.state.role
        }
        console.log(data)
        fetch("/api/user", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        this.props.history.push('/');
    }


    render() {
        const {name, email, password} = this.state
        return (
            <div>
                <AppNavbar/>
                <form onSubmit={this.submitHandle}>
                    <div>
                        <input type="text" name="name" placeholder="username" value={name} onChange={this.handelChange}/>
                    </div>
                    <div>
                        <input type="email" name="email" placeholder="e-mail" value={email} onChange={this.handelChange}/>
                    </div>
                    <div>
                        <input type="password" name="password" placeholder="password" value={password} onChange={this.handelChange}/>
                    </div>
                    <div>
                        <input type="submit" value="submit"/>
                    </div>
                </form>
                <Button color="success" tag={Link} to="/">Cancel</Button>
            </div>
        )
    }
}

export default Registration;