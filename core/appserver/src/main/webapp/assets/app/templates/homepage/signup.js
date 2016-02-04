/**
 * @author 
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';

export default class Signup extends React.Component {
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
		        <div className="signup-email">
		          <p>Or, Sign Up with Email</p>
		          <input type="text" placeholder="Your Full Name"/>
		          <input type="text" placeholder="Password"/>
		          <input type="text" placeholder="Email"/>
		        </div>
		        <input type="submit" className="navy-btn" value="Sign Up"> </input>
		     </div>
	     </div>
      </div>
    );
  }
}
