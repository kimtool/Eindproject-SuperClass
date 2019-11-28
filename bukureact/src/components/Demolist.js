import React, {Component} from 'react';
import {SERVER_URL} from '../constants.js';
import ReactTable from 'react-table';
//toastify to implement a toast message to show status of deletion, ToastContainer for showing toast messages
import {ToastContainer, toast} from 'react-toastify';
import AddDemo from './AddDemo';
import 'react-toastify/dist/ReactToastify.css'
import 'react-table/react-table.css'

class DemoList extends Component {
//add constructor to add a state for the demos that are fetched freom the REST API 
    constructor(props){
        super(props);
        this.state = { demos: []};
    }

//componentDidMount is called after mounting, suiteble for calling REST APIs to get data
    componentDidMount(){
        this.fetchDemos();
    }

//The demos from the JSON response data will be saved to the state called demos
    fetchDemos=()=>{
        fetch(`${SERVER_URL}/api/demoes`)
        .then((response) => response.json())
        .then((responseData) => {
            this.setState({
                demos: responseData._embedded.demoes,
            });
        }).catch(err => console.error(err));
    }

//Delete demo
    onDelClick=(link)=>{
//Confirm delete
        if(window.confirm("Are you sure to delete?")){
            fetch(link,{method:'DELETE'})        
            .then(res=>{
                toast.success("Demo deleted",{
                position: toast.POSITION.BOTTOM_LEFT
            });
                this.fetchDemos();
            })
            .catch(err => {
                toast.error("Error when deleting", { 
                position: toast.POSITION.BOTTOM_LEFT});
                console.error(err)
            })
        }
    }

//Add new demo
    addDemo(demo){
        fetch(`${SERVER_URL}/api/demoes`, {method: 'POST', headers: {"Content-Type": "application/json",},
    body:JSON.stringify(demo)})
    .then(res => this.fetchDemos())
    .catch(err => console.error(err))
    }

//create React Table. Data prop is this.state.demos, contains fetched demos.
//define columns, header is column title. accessor is the field of the demo object
    render(){
        const columns = [{
            Header: "Id",
            accessor: "id"
        },{
            Header: "Producer",
            accessor: "producer"
        },{
            Header: "Title",
            accessor: "title"
        },{
            Header: "Description",
            accessor: "description"
        },{
//create delete button for each row
            id: "delbutton",
            sortable: false,
            filterable: false,
            width: 100,
            accessor: "_links.self.href",
            Cell:({value})=>(<button onClick={()=>{this.onDelClick(value)}}>Delete</button>)
        }]
        return(
            <div className="App">
                <AddDemo addDemo={this.addDemo} fetchDemos={this.fetchDemos}/>
                <ReactTable data={this.state.demos} columns={columns} filterable={true}/>
                <ToastContainer autoClose={1500}/>
            </div>
        );
    }
}

export default DemoList