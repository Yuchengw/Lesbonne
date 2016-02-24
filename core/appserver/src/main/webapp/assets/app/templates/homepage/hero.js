/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import Signup from './signup.js';
import AuthenticatedComponent from '../../global_components/AuthenticatedComponent.js'

export default AuthenticatedComponent(class Hero extends React.Component {
	constructor(props) {
		super(props);
	}
	
	render() {
		if (!this.props.userLoggedIn) {
			return (
			    <section className="hero">
			      <div className="container">
			        <div className="float-left">
			          <h2>Delicious Homemade Food, Delivered</h2>
			          <p className="mb-35">Meals starts at $5 and pickup is available</p>
			          <a className="btn">Explore Food</a>
			        </div>
			        <Signup />
			      </div>
			    </section>
		    )
		} else {
			return (
				 <section className="hero">
			      <div className="container">
			        <div className="float-left">
			          <h2>Welcome {this.props.user}, Explore more have have fun today!</h2>
			          <p className="mb-35">We have some recommendations for you, check it out!</p>
			          <a className="btn">Explore Food</a>
			        </div>
			      </div>
			      <div className="float-right signedin-block">

				  </div>
			    </section>
			)
		}
	}
});