import {Component} from "react";
import logo from './logo.svg';
import './App.css';
import axios from 'axios'

class App extends Component{
  state = {
    faq:[{id:0,
          title:"빈타이틀",
          contents:"빈내용",
          kind:"빈종류",
          top10:true},]
  }
  loadtable=() => axios.get('http://10.211.55.7:8000/faq')
                .then(response => this.setState({
                    faq:response.data
                }))
                .catch(e => {
                  console.error(e);
                })
  
  
  render(){
    this.loadtable();
    return(
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>

          <div>
            {this.state.faq.map((f, i) => {
                        return (<LOOP_FAQ  id={f.id}
                                    title={f.title}
                                    kind={f.kind}
                                    top10={f.top10}
                                    contents={f.contents}
                                    key={i} 
                                 />);
            })}
          </div>
        </header>
        </div>
    );
  }
}

class LOOP_FAQ extends Component{
  render(){
    return (
      <div>
        <div>{this.props.id}</div>
        <div>{this.props.title}</div>
        <div>{this.props.kind}</div>
        <div>{this.props.top10}</div>
        <div>{this.props.contents}</div>
      </div>
    );
  }
}
export default App;
