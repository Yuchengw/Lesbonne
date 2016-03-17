/**
 * @author: yucheng
 * @since 1
 * */
import React from 'react';
import Header from './templates/common/header.js';
import Footer from './templates/common/footer.js';

require('../scss/app.scss');

export default class App extends React.Component {	
	constructor(props) {
		 super(props);
    }
	
	isHomePage() {
		return window.location.hash === '#/';
	}
	
	render() {
	  let children = React.cloneElement(this.props.children);
	  let appClassName = 'lesbonnes-app'
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
