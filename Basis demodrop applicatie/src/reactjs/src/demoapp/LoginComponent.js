import React, {useRef, Component} from 'react';
import './App.css';

class LoginComponent extends Component {
render(){
    const formData = useRef(null);

    const handleSubmit = (event) => {
        event.preventDefault();
        let data = new FormData(formData.current);
//        data.append("test", "value");
        fetch(formData.current.action, {
            method: formData.current.method,
            body: new URLSearchParams(data)
        })
            .then(v => {
                console.log("login", v)
                fetch("/security/verify", {
                    mode: 'no-cors'})
                    .then(i => {console.log("secure", i); return i.json()})
                    .then(i=> console.log("secure", i) )

                //if(v.redirected) window.location = v.url
            })
            .catch(e => console.warn(e))
    };
    }
    render(){
      return (
        <div className="App">
            <form method="post" action="/login" onSubmit={handleSubmit} ref={formData}>
                <input type="text" name="username" placeholder="username"/>
                <input type="password" name="password" placeholder="password"/>
                <button type="submit">login</button>
            </form>
        </div>
      );
    }
}

export default LoginComponent;
