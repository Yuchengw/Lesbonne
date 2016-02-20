/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';

export default class SearchBox extends React.Component {
	render() {
		return (
			<div>
			<h2>What do you feel like for dinner today?</h2>
	        <div className="search-box">
	          <span></span>
	          <input type="text" placeholder="Type food type or name here"/>
	          <label htmlFor="zipcode">Next</label>
	          <input type="text" id="zipcode" className="middle-input" placeholder="City or Zipcode"/>
	        </div>
	        </div>
		);
	}
}
