import React, { Component } from 'react';

class BlogList extends Component {
    render() {
        const {posts} = this.props;
        const list = posts.map(post => {
            return( 
                <div key={post.id}>
                    <h3>{post.title}</h3>
                    <p>{post.content}</p>
                </div>
            );
        });
        return (
            <div>
                {list}        
            </div>
        );
    }
}

export default BlogList;