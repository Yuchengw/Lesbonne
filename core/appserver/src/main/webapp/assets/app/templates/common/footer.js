import React from 'react';

export default class Footer extends React.Component {
	render() {
	    return (
	    		<footer className="footer">
	    	      <div className="container">
		    	    <ul className="nav nav-pills">
		    	      <li role="presentation"><a href="#">About</a></li>
		    	      <li role="presentation"><a href="#">How it Works</a></li>
		    	      <li role="presentation"><a href="#">Be A Host</a></li>
		    	      <li role="presentation"><a href="#">Press</a></li>
		    	      <li role="presentation"><a href="#">Jobs</a></li>
		    	      <li role="presentation"><a href="#">Terms of Service</a></li>
		    	      <li role="presentation"><a href="#">Privacy Policy</a></li>
		    	      <li role="presentation"><a href="#">Help</a></li>
		    	      <li role="presentation" className="dropdown language">
		    	      	<a className="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> Language <span className="caret"></span></a>
		    	      	<ul className="dropdown-menu"> 
		    	      		<li><a href="#">English</a></li>
		    	      		<li><a href="#">Chinese</a></li>
		    	      	</ul>
		    	      </li>
		    	    </ul>
	    	      </div>
	    	    </footer>
	    );
	  }
}