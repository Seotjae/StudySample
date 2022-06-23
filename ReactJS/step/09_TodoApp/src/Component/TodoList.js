import React, { Component } from 'react';
import TodoItem from './TodoItem';

class TodoList extends Component {

    //todos 에 변화가 없으면 렌더링을 하지 않는다.
    shouldComponentUpdate(nextProps,nextState){
        return this.props.todos !== nextProps.todos;
    };

    render() {
        //console.log(this.props);
        const {todos,onRemove,onCheck} = this.props;

        const todoList = todos.map(item=>(
            <TodoItem 
                key={item.id} 
                done={item.done} 
                text={item.text} 
                onRemove={()=>{onRemove(item.id)}} 
                onCheck={()=>{onCheck(item.id)}} 
                done_yn={item.done === true ? 'done' : 'yet'}
            />));
        //console.log(todoList);

        return (
            <div>{todoList}</div>
        );
    }
}

export default TodoList;