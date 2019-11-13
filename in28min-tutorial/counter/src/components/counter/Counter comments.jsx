import React, {Component} from 'react';
import './Counter.css'

class Counter extends Component{

    constructor(){
        super();        //Important!!!, otherwise not availible
        this.state = {
            counter : 0
        }
        //this.increment = this.increment.bind(this);        //bind a method to the class
    }

    render(){
        return (
            <div className="counter">
              <CounterButton incrementMethod={this.increment}/>
              <CounterButton by={5} incrementMethod={this.increment}/>
              <CounterButton by={10} incrementMethod={this.increment}/>
              <span className="count">{this.state.counter}</span>
            </div>
          );
    }

    increment = (by) => {        //update state - counter +1      arrowfunction no need for binding
        //console.log(`increment from parent - ${by}`)
        //this.state.counter++        //don't mutate state directly, use setState()
        // this.setState({         //pass object with updated value, merge with initial state
        //     counter: this.state.counter + by     //+this.props.by
        // });
        this.setState( (prevState) => {
            return {counter: prevState.counter + by}
        });
    }

}

class CounterButton extends Component{

    //define the initial state in a constructor
    //state => counter 0
    constructor(){
        super();        //Important!!!, otherwise not availible
        this.state = {
            counter : 0,
        }
        //this.increment = this.increment.bind(this);        //bind a method to the class
    }

    render(){
        return(
            <div className="Counter">
                <button onClick={this.increment}>+{this.props.by}</button>       
                {/* <span className="count">{this.state.counter}</span> */}
            </div>
        );
    }

    increment = () => {        //update state - counter +1      arrowfunction no need for binding
        //this.state.counter++        //don't mutate state directly, use setState()
        this.setState( (prevState) => {         //pass object with updated value, merge with initial state
            return {counter: prevState.counter+this.props.by}
        });
        this.props.incrementMethod(this.props.by);
    }
}

CounterButton.defaultProps = {
    by : 1
}

export default Counter