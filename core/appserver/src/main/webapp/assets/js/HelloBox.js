import React from 'react'
import HelloText from './HelloText'

export default class HelloBox extends React.Component {
    constructor() {
        super();
    }

    render() {
        return <div><h1> <HelloText name="Y Hey, This is Lesbonne Appserver!" /> </h1></div>
    }
}