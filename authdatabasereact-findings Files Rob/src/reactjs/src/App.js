import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import FormLogin from "./hexagon/FormLogin";
import MenuBar from "./hexagon/MenuBar";
import EditProfile from "./hexagon/EditProfile";
import DropDemo from "./hexagon/DropDemo";
import Profile from "./hexagon/Profile";

function App() {
    const [href, setHref] = useState("");
    const [authenticated, setAuthenticated] = useState(false);
    const query = new URLSearchParams(window.location.search);
    useEffect(() => {
        setHref(window.location.href);
        console.log("setHref", href)
    },[href]);

    const reBrowse = ()=>{
        setAuthenticated(false);
    }
    return (
    <div className="App">
        <Router>
        <div  className="App-header">
            <MenuBar authenticated={true}/>
        </div>
         <div className="App-body">
             <Switch>
                 <Route path="/editprofile">
                     <EditProfile />
                 </Route>
                 <Route path="/dropdemo">
                     <DropDemo />
                 </Route>
                 <Route path="/profile">
                     <Profile/>
                 </Route>
                 <Route path="/">
                     <FormLogin/>
                 </Route>
             </Switch>
        </div>
        </Router>
    </div>
  );
}

export default App;
