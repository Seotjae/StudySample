/*
import React from 'react';

//비구조 할당 : 객체 주에서 number 속성만 골라서 가져옴

const NumberList = ({numbers}) => {

    const itemList = numbers.map(number => <li key={number}>{number}</li>);

    return (
        <ul>
            {itemList}
        </ul>
    );
};

export default NumberList;
*/

import React, { Component } from 'react';

class NumberList extends Component {
    render() {
        const {numbers} = this.props;
        const itemList = numbers.map(number => <li key={number}>{number}</li>);
        return (
            <ul>
                {itemList}
            </ul>
        );
    }
}

export default NumberList;

