import React from 'react';
import ReactDom from 'react-dom';
import LocationSearchBox from '../../../modules/explore/search/locationsearchbox.js';
import TimePicker from './timepicker.js';
import FoodFilter from './foodfilter.js';

class FoodToolbar extends React.Component {
	render() {
		return (
			<section className="foodtoolbar">
    		<nav className="navbar navbar-default navbar-fixed-top foodtoolbarnav">
			<div className="container">
				<div className="collapse navbar-collapse">
				<form className="navbar-form navbar-left form-inline right-border" role="search">
					<LocationSearchBox/>
				</form>
				<ul className="nav navbar-nav filter">
					<TimePicker/>
					<FoodFilter/>
					<li className="foodcart">
						<div className="img-icon square-icon filter-text"></div>
					</li>
				</ul>
				</div>
		    </div>
		    </nav>
			</section>
		);
	}
}

export default FoodToolbar;
