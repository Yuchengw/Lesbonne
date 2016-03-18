/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import Signup from '../../../modules/authentication/signup/signup.js';
import AuthenticatedComponent from '../../../global/components/AuthenticatedComponent.js'
import { Link }  from 'react-router';

class Hero extends React.Component {
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
			          <a href="#/explorefood" className="btn btn-success btn-lg">Explore Food</a>
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
			          <h2>Hey {this.props.user.split(' ')[0]}, Explore more and have fun today!</h2>
			          <p className="mb-35">We have some recommendations for you, check it out!</p>
			          <Link to="/explorefood" className="btn btn-success btn-lg">Explore Food</Link>
			        </div>
			      </div>
			      <div className="float-right signedin-block">

				  </div>
			    </section>
			)
		}
	}
};

export default AuthenticatedComponent(Hero);
