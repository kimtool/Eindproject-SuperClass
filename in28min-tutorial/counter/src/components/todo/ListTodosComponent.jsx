import React, {Component} from 'react'
import TodoDataService from '../api/todo/TodoDataService.js'
import AuthenticationService from './AuthenticationService.js'
import moment from 'moment'

class ListTodosComponent extends Component {
    constructor(props){             //gets called when component is being initialized
        super(props)
        this.state = {
            todos: 
            [               //better not to do initial API call directly in the constructor, otherwise state will not be initialized until API call is completed
            //{id:1, description:"Learn React", done:false, targetDate:new Date()}, 
            //{id:2, description:"Cry", done:false, targetDate:new Date()}
            ], 
            message : null
        }
    }

    componentDidMount() {             //is called when component is called for the first time and put in the browser
        this.refreshTodos();
        // let username = AuthenticationService.getLoggedInUsername()
        // TodoDataService.retrieveAllTodos(username)
        // .then(
        //     response => {
        //     //console.log(response)
        //     this.setState({todos : response.data})
        // })
        //.catch(error => this.handleError(error))  
    }    

    refreshTodos = () => {
        let username = AuthenticationService.getLoggedInUsername()
        TodoDataService.retrieveAllTodos(username)
        .then(
            response => {
            //console.log(response)
            this.setState({todos : response.data})
        })
    }

    deleteTodoClicked = (id) => {
        // /todos/${id}
        let username = AuthenticationService.getLoggedInUsername()
        //console.log(id+" "+username);
        TodoDataService.deleteTodo(username, id)
        .then (
            response =>{
                this.setState({message:`Delete of todo ${id} Succesful`});
                this.refreshTodos();
            }
        )
    }

    updateTodoClicked = (id) => {
        let username = AuthenticationService.getLoggedInUsername()
        //console.log(id+" "+username);
        this.props.history.push(`/todos/${id}`)
        // TodoDataService.deleteTodo(username, id)
        // .then (
        //     response =>{
        //         this.setState({message:`Delete of todo ${id} Succesful`});
        //         this.refreshTodos();
        //     }
        // )
    }

    addTodoClicked = () => {
        this.props.history.push(`/todos/-1`)
    }

    render(){               //gets called when a state in the component changes, view must be updated
        return (
        <div>
            <h1>List Todo's</h1>
            {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
            <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>user</th>
                        <th>description</th>
                        <th>Target Date</th>
                        <th>Is Completed?</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.todos.map (
                            todo =>                        
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.username}</td>
                                <td>{todo.description}</td>
                                <td>{moment(todo.targetDate).format("YYYY-MM-DD")}</td>
                                <td>{todo.isDone.toString()}</td>                                
                                <td><button className="btn btn-success" onClick={() => this.updateTodoClicked(todo.id)}>Update</button></td>
                                <td><button className="btn btn-warning" onClick={() => this.deleteTodoClicked(todo.id)}>Delete</button></td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <div className="row">
                <button className="btn btn-success" onClick={this.addTodoClicked}>Add</button>
            </div>
            </div>
        </div>
        )
    }
}

export default ListTodosComponent