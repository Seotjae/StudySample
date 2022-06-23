import React, { Component } from 'react';

class TodoInput extends Component {

    render() {

        //비구조 할당
        const {onChange,onInsert,value} = this.props;

        return (
            <div>
                <h2>일정관리</h2>
                <hr/>
                <input type="text" onChange={onChange} value={value}/>
                <button onClick={onInsert}>추가</button>
            </div>
        );
    }
}

export default TodoInput;