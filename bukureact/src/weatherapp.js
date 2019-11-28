import React, {Component} from 'react';
import './App.css'

class WeatherApp extends Component {
    constructor(props){
        super(props);
        this.state = {temp: 0, desc: "icon: ", loading: true}
    }
    render(){
        return(
            <div className="App">

            </div>
        )
    }
}

export default WeatherApp