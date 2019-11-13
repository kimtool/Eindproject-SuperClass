import React, {Component} from 'react'

class TodoApp extends Component {
    render(){
        return (
            <div className="TodoApp">
                <LoginComponent/>
            </div>
        )
    }
}

class LoginComponent extends Component {            //control component
    constructor(props){
        super(props)
        this.state = {
            username: "in28min",
            password: "",
            wasLoginSuccesful: false,
            showErrorMessage: false

        }
        //this.handleUsernameChange = this.handleUsernameChange.bind(this)
    }

    // handleUsernameChange = (event) =>{
    //     console.log(event.target.value);
    //     this.setState({username:event.target.value})
    // }
    // handlePasswordChange = (event) =>{
    //         console.log(event.target.value);
    //         this.setState({password:event.target.value})
    //     }

    handleChange = (event) =>{
        //console.log(event.target.name);
        this.setState(
            {                   //create object
                [event.target.name]           //name of object, can't be variable, needs to be constant, or put in []
                :event.target.value
            }
        )
    }
    loginClicked = () => {        
        //in28min, pass123
        if(this.state.username==="in28min" && this.state.password==="pass123"){            
            this.setState({showErrorMessage:false})
            this.setState({wasLoginSuccesful:true})
        }
        else {             
            this.setState({showErrorMessage:true})
            this.setState({wasLoginSuccesful:false})
        console.log(this.state)
        }
    }   

    render(){
        return (
            <div>
                {/* <ShowLoginMessage wasLoginSuccesful={this.state.wasLoginSuccesful}/> */}
                {this.state.wasLoginSuccesful && <div>Login Succesful</div>}            {/*if true && return */}
                {this.state.showErrorMessage && <div>Invalid Login</div>}
                {/* <ShowLoginError showErrorMessage={this.state.showErrorMessage}/> */}
                Username: <input type="text" name="username" value={this.state.username} onChange={this.handleChange}/>
                Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange}/>
                <button onClick={this.loginClicked}>Login</button>
            </div>
        )
    }
}
// function ShowLoginMessage(props){
//     if(props.wasLoginSuccesful){
//         return 
//     }
//     else {
//         return <div>Invalid Login</div>
//     }
//     //return null
// }
// function ShowLoginError(props){
//     if(props.showErrorMessage){
//         return <div>Invalid Login</div>
//     }
//     return null
// }

export default TodoApp