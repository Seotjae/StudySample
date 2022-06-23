import React, { Component } from 'react';

class TodoItem extends Component {
    render() {
        //console.log(this.props);
        const {done,text,onRemove,onCheck,done_yn} = this.props
        let class_name = `text ${done_yn}`;

        
        return (
            <div className='item'>
                <input type="checkbox" checked={done} readOnly onClick={onCheck}/>
                {/* <div className={class_name}>{text}</div> */}
                <div className={done ? 'text checked' : 'text'}>{text}</div>
                <div className='delete' onClick={onRemove}>[삭제]</div>
            </div>
        );
    }
}

export default TodoItem;