/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import AuthService from '../../global_services/auth_service.js';

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
	   this.state.name = ReactDOM.findDOMNode(this.refs.name).value.trim();
	   this.state.email = ReactDOM.findDOMNode(this.refs.email).value.trim();
	   this.state.password = ReactDOM.findDOMNode(this.refs.password).value.trim();
	   if (!this.state.name || !this.state.password || !this.state.email) {
		   console.log('signup form error.');
		   return;
	   }
	   AuthService.signup(this.state);
	 }
	  
	 render() {
		console.log("Signup");
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
				          <input type="text" id='name' ref='name' placeholder="name" />
				          <input type="text" id='email' ref='email' placeholder="email" />
				          <input type="password" id='password' ref='password' placeholder="password" />
				        </div>
				        <input type="submit" onClick={this.signup.bind(this)} className="navy-btn" value="Sign Up"> </input>
			        </form>
			     </div>
		     </div>
	      </div>
	    );
	 }
}
