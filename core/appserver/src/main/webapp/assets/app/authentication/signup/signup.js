/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import AuthService from '../service/AuthService.js';

require ('./signup.scss');

export default class Signup extends React.Component {
	
	 constructor(props) {
		 super(props);
	     this.state = {
	         email: '',
	         password: '',
	         name: ''
	     };
     }

	 signup(event) {
	   event.preventDefault();
	   this.state.email = ReactDOM.findDOMNode(this.refs.email).value.trim();
	   this.state.password = ReactDOM.findDOMNode(this.refs.password).value.trim();
	   this.state.name = ReactDOM.findDOMNode(this.refs.username).value.trim();
	   AuthService.signup(this.state.email, this.state.password, this.state.name);
	 }
	  
	 render() {
	    return (
	      <div>
		      <div className="float-right signup-block">
			      <div className="signup-block-header">
			        <h3>Get First Meal Free</h3>
			        <p className="mb-0">by signing up now</p>
			      </div>
			      <div className="signup-block-content">
			        <div className="signup-social">
			          <p>Sign Up with Social Connect</p>
			          <div>
			            <button className="btn-social btn-facebook">Facebook</button>
			            <button className="btn-social btn-googleplus">Google</button>
			          </div>
			          <span>We will not send you spam with this</span>
			        </div>
			        <form role="form" className="signupForm">
				        <div className="signup-email">
				          <p>Or, Sign Up with Email</p>
				          <input type="text" id="username" ref="username" placeholder="Your Full Name"/>
				          <input type="text" id='email' ref='email' placeholder="Email" />
				          <input type="password" id='password' ref='password' placeholder="Password" />
				        </div>
				        <input type="submit" onClick={this.signup.bind(this)} className="navy-btn" value="Sign Up"> </input>
			        </form>
			     </div>
		     </div>
	      </div>
	    );
	 }
}
