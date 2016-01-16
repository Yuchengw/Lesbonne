import React from 'react'

export default class HelloText extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <p>Hello, {this.props.name}!</p>
    }
}