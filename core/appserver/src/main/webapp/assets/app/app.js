/**
 * @author: yucheng
 * @since 1
 * */
import React from 'react';
import Header from './templates/common/header.js';
import Footer from './templates/common/footer.js';
import $ from 'jquery';

require('../scss/app.scss');

export default class App extends React.Component {	
	constructor(props) {
		 super(props);
    }
	
	isHomePage() {
		return window.location.hash === '#/';
	}
	
	initScrollHeader() {
		 window.addEventListener('scroll', function(e){
	            let distanceY = window.pageYOffset || document.documentElement.scrollTop;
	            let shrinkOn = 850;
	            let header = $('header');
	            if (distanceY > shrinkOn) { 
	            	header.addClass('scroll-header');
	            } else {
	            	header.removeClass('scroll-header');          
	            }
	     });
	}
	
	componentDidMount() {
		if (this.isHomePage()) {
			window.onload = this.initScrollHeader();
		}
	}
	
	render() {
	  let children = React.cloneElement(this.props.children);
	  let appClassName = 'lesbonnes-app';
	  if (this.isHomePage()) {
		  appClassName += ' homepage';
	  }
	  
	  return (
	    <div className={appClassName}>
    	<Header />
    	{children}
    	<Footer />
    	</div>
    );
  }
};
