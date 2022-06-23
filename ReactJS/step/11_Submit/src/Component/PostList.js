/*
'https://jsonplaceholder.typicode.com/posts/'
에서 받아온 내용을 리스트로 만들어 보기
*/
import React, { Component } from 'react';

class PostList extends Component {
    render() {
        const {list} = this.props;
        console.log(list);
        let post_list = list.map(post => {
            return(
                <li key={post.id}>{post.title}</li>
            );
        });
        return (
            <ul>
                {post_list}
            </ul>
        );
    }
}

export default PostList;