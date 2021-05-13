import {Component} from "react";
import logo from './logo.svg';
import './App.css';
import Maketable from './Maketable'

class App extends Component{
  render(){
    return(
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <Maketable/>
        </header>
        </div>
    );
  }
}
export default App;
