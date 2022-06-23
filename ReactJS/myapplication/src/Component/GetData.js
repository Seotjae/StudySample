import axios from 'axios';
import React, { Component} from 'react';

class GetData extends Component {
    constructor(props){
        super(props);
        this.state = {list:[]}; 
    }
    render() {
        const ajax = async () => {
            let {data} = await axios.get('https://jsonplaceholder.typicode.com/posts/');
            console.log(data);
            this.setState({list:data});
            console.log(this.state.list);
        }
        let post_list = this.state.list.map(post => {
            return(
                <li key={post.id}><b>{post.title}</b> : {post.body}</li>
            );
        });
        return (
            <div>
                <button onClick={ajax}>Data</button>
                <ul>{post_list}</ul>
            </div>
        );
    }
}

export default GetData;