import React from 'react';
import ReactDom from 'react-dom';
import LocationSearchBox from '../../../modules/explore/search/locationsearchbox.js';
import TimePicker from './timepicker.js';
import FoodFilter from './foodfilter.js';
import FoodMap from './foodmap.js';

class FoodToolbar extends React.Component {
	render() {
		return (
			<section className="foodfilter">
			<div className="container">
				<form className="form-inline" role="search">
					<LocationSearchBox/>
					<TimePicker/>
					<FoodFilter/>
					<div className="col-md-2 pl-10">
						<div className="img-icon square-icon"></div>
					</div>
				</form>
				<FoodMap />
		    </div>
			</section>
		);
	}
}

export default FoodToolbar;
