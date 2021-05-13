import {Component} from "react";


class LOOP extends Component{
    render(){
      return (
        <div>
          <div>{this.props.id}</div>
          <div>{this.props.title}</div>
          <div>{this.props.content}</div>
          <div>{this.props.author}</div>
        </div>
      );
    }
}
export default LOOP;
