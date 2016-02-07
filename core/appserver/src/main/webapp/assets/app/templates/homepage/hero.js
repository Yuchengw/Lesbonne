/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import Signup from './signup.js';

export default class Hero extends React.Component {
	render() {
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
	    );
	}
}