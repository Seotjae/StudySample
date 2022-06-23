import axios from 'axios';
import React, { useState } from 'react';
import PostList from './PostList';

const AsyncComp = () => {
    /*
    const ajaxSend=()=>{
        axios.get('https://jsonplaceholder.typicode.com/posts/').then(({data})=>{console.log(data)});
        //data 가 Promise 로 찍힌다. 진짜 데이터만 가져올 방법은?
    };
    
    const ajaxSend2=()=>axios.get('https://jsonplaceholder.typicode.com/posts/');
    async function getResult() {
        var result = await ajaxSend2();
        console.log(result.data);
    }
    */
    let [list,setList] = useState([]);
    const ajaxSend= async()=>{
        try {

            //data 와 {data} 의 차이는 ?
            //data 에서 원하는 값을 꺼내오려면 data.data 로 해야한다.
            //{data} 는 해당 객체에서 data 라는 속성을 가져온다. (비구조 할당)
            //변수명도 가져온 속성과 같이 data가 된다.
            let {data} = await axios.get('https://jsonplaceholder.typicode.com/posts/');
            console.log(data);

            setList(data);
        } catch (e) {
            console.log(e);
        }
    }


    return (
        <div>
            <button onClick={ajaxSend}>AXIOS 전송</button>
            <PostList list = {list}/>
        </div>
    );
};

export default AsyncComp;