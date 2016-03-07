/**
 * @author yucheng
 * @since 1
 * */
import React from 'react';
import Header from './components/header.js';
import Hero from './components/hero.js';
import Value from './components/value.js';
import SearchContainer from './components/search_container.js';
import Chef from './components/chef.js';
import Media from './components/media.js';
import Footer from './components/footer.js';

require('./homepage.scss');


export default class HomePage extends React.Component {
	render() {
	    return (
	    	<div className='homepage'>
	    		<Header />
	    		<Hero />
	    		<Value />
	    		<SearchContainer />
	    		<Chef />
	    		<Media />
	    		<Footer />
	    	</div>
	    );
	  }
}