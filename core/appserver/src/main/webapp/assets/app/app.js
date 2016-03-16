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
	
	render() {
	  var children = React.cloneElement(this.props.children);
		
	  return (
	    <div className="lesbonnes-app">
    	<Header />
    	{children}
    	<Footer />
    	</div>
    );
  }
};
