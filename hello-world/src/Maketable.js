import {Component} from "react";
import axios from 'axios'
import LOOP from './LOOP'

class Maketable extends Component{
    state = { //변수를 저장하는 곳
        posts:{ //변수
            content:[{id:0,
                title:"빈타이틀",
                content:"빈내용",
                author:"빈작성자"},]
        },
    }
    loadtable=() => axios.get('http://localhost:8080/api/posts') //백엔드 주소 GET 하겠다.
                    .then(response => this.setState({
                        posts:response.data.data
                    }))
                    .catch(e => {
                    console.error(e);
                    })
    componentDidMount() { //컴포트가 실행될때 1번 처음에 실행되는 함수.
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
                                    key={i} //LOOP 컴포넌트 안에 props 라는 변수에 들어가게됨.
                                    />);
            })}
            </div>
        );
    }
}
export default Maketable;
