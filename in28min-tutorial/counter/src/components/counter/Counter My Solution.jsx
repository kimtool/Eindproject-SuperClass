import React, {Component} from 'react';
import './Counter.css'

//Add - buttons and add reset button
class Counter extends Component{
    constructor(){
        super();       
        this.state = {
            counter : 0
        }        
    }
    render(){
        return (
            <div className="counter">
              <CounterButton plus={"+"} by={1} incrementMethod={this.increment}/>
              <CounterButton plus={"+"} by={5} incrementMethod={this.increment}/>
              <CounterButton plus={"+"} by={10} incrementMethod={this.increment}/>
              <CounterButton by={-1} incrementMethod={this.increment}/>
              <CounterButton by={-5} incrementMethod={this.increment}/>
              <CounterButton by={-10} incrementMethod={this.increment}/>
              <span className="count">{this.state.counter}</span><br/>
              <button onClick={this.reset}>Reset</button>
            </div>
        );
    }
    increment = (by) => {
        this.setState( (prevState) => {
            return {counter: prevState.counter + by}
        });
    }
    reset = () => {
        this.setState( () => {
            return {counter: 0}
        });
    }
}
class CounterButton extends Component{
    constructor(){
        super(); 
        this.state = {
            counter : 0
        }        
    }
    render(){
        return(
            <div className="Counter">
                <button onClick={this.increment}>{this.props.plus}{this.props.by}</button>  
            </div>
        );
    }
    increment = () => {
        this.setState( (prevState) => {      
            return {counter: prevState.counter+this.props.by}
        });
        this.props.incrementMethod(this.props.by);
    }
}
export default Counter