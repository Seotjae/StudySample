import { Component } from 'react';
import './App.css';
import TodoInput from './Component/TodoInput';
import TodoList from './Component/TodoList';



class App extends Component {

  constructor(props){
    super(props);
    this.state={
      input:'',
      list:[
        {id:0,text:'Spring 공부하기',done:true},
        {id:1,text:'React JS 공부하기',done:false},
        {id:2,text:'프로젝트 진행하기',done:false}
      ]
    }
  }

  onChangeFunction=(e)=>{
    const {value} = e.target
    this.setState({input:value});
  };

  id = 2; //클래스 컴포넌트에서는 변수나 함수에 키워드가 들어가지 않는다
  onInsertFunction=()=>{
    this.id++;
    let todo = {id:this.id,text:this.state.input,done:false}
    //기존에 있는 배열을 그대로 놔두고 뒤에 붙이고 싶다.
    this.setState({
      'list':[...this.state.list,todo]
    });
    //console.log(this.state);
  };

  onDeleteFunction=(id)=>{
    const index = this.state.list.findIndex(todo=>todo.id === id);
    let new_list = [...this.state.list];
    new_list.splice(index,1);
    this.setState({list:new_list});
    
  };

  
  onCheckToggleFunction=(id)=>{
    const index = this.state.list.findIndex(todo=>todo.id === id);
    let new_list = [...this.state.list];
    new_list[index].done = !this.state.list[index].done;
    this.setState({list:new_list});
  };
  



  render(){
    return(
      <div className='app'>
        <TodoInput onChange={this.onChangeFunction} onInsert={this.onInsertFunction} value={this.state.input}/>
        <TodoList todos={this.state.list} onRemove={this.onDeleteFunction} onCheck={this.onCheckToggleFunction}/>
      </div>
    );
  };
}
  

export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
