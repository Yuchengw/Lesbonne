//let Router = require('react-router')
//let Route = Router.Route
//let Link = Router.Link
import React from 'react';
import Header from './templates/homepage/header.js';
import Hero from './templates/homepage/hero.js';
import Value from './templates/homepage/value.js';
import SearchContainer from './templates/homepage/searchcontainer.js';

require('../scss/app.scss');

export default class App extends React.Component {
  render() {
    return (
    	<div className='homepage'>
    		<Header />
    		<Hero />
    		<Value />
    		<SearchContainer />
    	</div>
    );
  }
}
