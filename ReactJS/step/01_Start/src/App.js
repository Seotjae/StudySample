import logo from './logo.svg';
import './App.css';
import { Component } from 'react'; //class 컴포넌트 사용시 필수

//컴포넌트 (UI 의 특정 부분)
/* 1.기본 함수 스타일
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>React.js 에 오신것을 환영합니다!!!!</p>
      </header>
    </div>
  );
}
*/

/* 2.클래스 스타일 
class App extends Component{
  constructor(props){ //생성자가 있어야 한다.
    super(props);
  }

  //render 함수도 있어야 한다.
  render(){
    return(
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>React.js 에 오신것을 환영합니다 (클래스 컴포넌트)</p>
        </header>
      </div>
    );
  }

}
*/

//3. 화살표 함수 방식
//return 구문만 존재할 경우 {} 와 return 생략 가능
const App = () => (
    <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>React.js 에 오신것을 환영합니다 (화살표 험수 컴포넌트)</p>
        </header>
    </div>
);


export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
