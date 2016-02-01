//let Router = require('react-router')
//let Route = Router.Route
//let Link = Router.Link
import React from 'react';
import Header from './templates/header.js';

require('../scss/app.scss');

export default class App extends React.Component {
  render() {
    return (
    	<Header />
    );
  }
}
