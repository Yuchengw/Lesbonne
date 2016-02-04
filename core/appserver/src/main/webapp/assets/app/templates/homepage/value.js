/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';

export default class Value extends React.Component {
	render() {
		return (
			 <section className="value-pop">
		      <div className="container">
		        <div className="column-3">
		          <img src="/as/scss/images/homemade-icon.png"/>
		          <h3>Home made food with love</h3>
		          <p>Extra portion of home made food coming from people share their passion</p>
		        </div>
		        <div className="column-3">
		          <img src="/as/scss/images/instant-icon.png"/>
		          <h3>Instant Order</h3>
		          <p>Browse and order food instantly</p>
		        </div>
		        <div className="column-3">
		          <img src="/as/scss/images/pickup-icon.png"/>
		          <h3>Pick it up, or have it delivered</h3>
		          <p>It's free to pick it up at the door, chat with the chef. Some offer task rabbit delivery services</p>
		        </div>
		      </div>
		    </section>
		);
	}
}