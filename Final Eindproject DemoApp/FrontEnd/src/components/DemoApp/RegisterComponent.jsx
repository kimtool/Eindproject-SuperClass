import React, {Component} from 'react'
import {Formik, Form, Field, ErrorMessage} from 'formik'
import Hexagon_logo_vector from '../images/Hexagon logo Don Diablo vector FillWhite.png'
import UserDataService from '../api/UserDataService.js'
import {Link} from 'react-router-dom'
import '../../App.css'

//control component the React component that renders a form 
//also controls what happens in that form on subsequent user input (this.state)
class RegisterComponent extends Component {    
    constructor(props){
        super(props)
        this.state = {
            id: this.props.match.params.id,
            username: "",
            email: "",
            password: "",
            showErrorMessage: false
        }
    } 

    validate = (values) => {
        let errors = {}
        if(!values.username){
            errors.username = "Enter a username"
        } if(!values.email){
            errors.email = "Enter a email"
        } if(!values.password){
            errors.password = "Enter a password"
        } //else if(!values.username){
        //     errors.username = "Username already exists"
        // } 
        return errors;
    }  

    onSubmit = (values) =>{
        //console.log(values);
        let user = {id: this.state.id,
                    username: values.username,
                    email: values.email, 
                    password: values.password}
        
            UserDataService.createUser(user)        //create user
                .then(() => this.props.history.push("/login"))        //go back to                
                .catch(() => {
                    this.setState({showErrorMessage:true})
                });        
    }

    render(){
        let {username, email, password, showErrorMessage} = this.state

        return <div>
            {/* <h1 className="title">UPLOAD DEMO</h1> */}
            <div>
                <Formik                     
                    // initialValues={{description: description, targetDate: targetDate}}
                    initialValues={{username, email, password, showErrorMessage}}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >        
                    {(props) => (
                        <Form>
                            <img id="Hexagon_logo_vector" alt="" src={Hexagon_logo_vector}/>
                            <ErrorMessage name="username" component="div" className="alert alert-warning"/>
                            <ErrorMessage name="email" component="div" className="alert alert-warning"/>
                            <ErrorMessage name="password" component="div" className="alert alert-warning"/>
                            {this.state.showErrorMessage && <div className="alert alert-warning">Username or Email already exists</div>}                            
                            <div id="register_block">  
                                <div id="fields">
                                    <div id="login_padding">
                                        <fieldset className="form-group">
                                            <Field autoComplete="off" className="form-control" type="text" name="username" placeholder="Username"/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <Field autoComplete="off" className="form-control" type="email" name="email" placeholder="E-mail"/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <Field autoComplete="off" className="form-control" type="password" name="password" placeholder="Password"/>
                                        </fieldset>
                                    </div>
                                </div>
                                <div className="right_align">                       
                                    <Link className="menu-icon" to="/login" target="blank" style={{color: "white"}}>Login</Link>
                                </div> 
                            </div>
                            <button className="button" type="submit">Register</button>
                        </Form>                        
                    )}
                </Formik>                
            </div>            
        </div>
    }    
}

export default RegisterComponent