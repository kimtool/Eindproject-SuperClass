import React from 'react';
import './App.css';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import DemoList from './components/Demolist'

function App() {
  return (
    <div className="App">
      <AppBar position="static" color="default">
        <Toolbar>
          <Typography variant="h6" color="inherit">
            DemoList
          </Typography>
        </Toolbar>
      </AppBar>  
      <DemoList/>   
    </div>
  );
}

export default App;
