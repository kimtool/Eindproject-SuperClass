import React, {Component} from 'react';
import './Counter.css'

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
              <CounterButton incrementMethod={this.increment} decrementMethod={this.decrement}/>
              <CounterButton by={5} incrementMethod={this.increment} decrementMethod={this.decrement}/>
              <CounterButton by={10} incrementMethod={this.increment} decrementMethod={this.decrement}/>
              <span className="count">{this.state.counter}</span>
              <div><button onClick={this.reset}>Reset</button></div>
            </div>
          ); 
    }

    reset = () => { 
        this.setState({counter: 0});
    }
    increment = (by) => {
        this.setState( (prevState) => {
            return {counter: prevState.counter + by}
        });
    }
    decrement = (by) => {
        this.setState( (prevState) => {
            return {counter: prevState.counter - by}
        });
    }

}

class CounterButton extends Component{
    constructor(){
        super(); 
        // this.state = {
        //     counter : 0
        // }        
    }
    render(){
        return(
            <div className="Counter">
                <button onClick={() => this.props.incrementMethod(this.props.by)}>+{this.props.by}</button> 
                <button onClick={() => this.props.decrementMethod(this.props.by)}>-{this.props.by}</button> 
            </div>
        );
    }
    // increment = () => {
    //     this.setState( (prevState) => {      
    //         return {counter: prevState.counter+this.props.by}
    //     });
    //     this.props.incrementMethod(this.props.by);
    // }
    // decrement = () => {
    //     this.setState( (prevState) => {      
    //         return {counter: prevState.counter-this.props.by}
    //     });
    //     this.props.decrementMethod(this.props.by);
    // }
}

CounterButton.defaultProps = {
    by : 1
}

export default Counter