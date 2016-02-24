/**
 * @author yucheng
 * @since 1
 * */
import React from 'react';
import Header from './components/header.js';
import Hero from './components/hero.js';
import Value from './components/value.js';
import SearchContainer from './components/search_container.js';

export default class HomePage extends React.Component {
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