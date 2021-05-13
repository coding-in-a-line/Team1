import {Component} from "react";
import axios from 'axios'
import LOOP from './LOOP'

class Maketable extends Component{

    state = {
        posts:{
        content:[{id:0,
            title:"빈타이틀",
            content:"빈내용",
            author:"빈작성자"},]
        },
    }
    loadtable=() => axios.get('http://localhost:8080/api/posts')
                    .then(response => this.setState({
                        posts:response.data.data
                    }))
                    .catch(e => {
                    console.error(e);
                    })
    componentDidMount() {
        this.loadtable();
    }
    render(){
        return(
            <div>
            {this.state.posts.content.map((f, i) => {
                        return (<LOOP  id={f.id}
                                    title={f.title}
                                    content={f.content}
                                    author={f.author}
                                    key={i} 
                                    />);
            })}
            </div>
        );
    }
}
export default Maketable;
