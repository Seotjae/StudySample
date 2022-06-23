import React, { useEffect } from 'react';
import $ from 'jquery';

function FncComp(props) {
    
    useEffect(()=>{
        $('#func_btn').on('click',()=>{
            console.log('버튼클릭');
            $('#func_msg').html('제이쿼리 불러오기');
            $('#func_msg').css({'color':'red'});
        });
    });

    return (
        <div>
            <h3 id="func_msg"></h3>
            <button id='func_btn'>함수 버튼</button>
        </div>
    );
}

export default FncComp;