/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';

export default class Chef extends React.Component {
	render() {
		return (
			<section className="chef">
		      <div className="container">
		        <div className="chef-slogan">
		          <h2>Share your food passion</h2>
		          <h2>Become a chef on Les Bonnes</h2>
		          <h5>It takes less than 5 minutes to apply, no credit card required</h5>
		        </div>
		        <div>
		          <a className="btn" type='button'>APPLY TO BE A CHEF</a>
		        </div>
		      </div>
			</section>
		);
	}
}
