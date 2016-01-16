import React from 'react';
import HelloText from './HelloText';

export default class HelloBox extends React.Component {
    constructor() {
        super();
    }

    render() {
        return <div>
            <HelloText name="Dan" />
        </div>
    }
}