import React from 'react';
import ReactDom from 'react-dom';
import SearchBox from '../../../modules/explore/search/searchbox.js';
import FoodCategorySearchBox from '../../../modules/explore/search/foodcategorysearchbox.js';
import SelectDate from './calendar.js';
import FilterCriteria from './filter.js';
import FoodMap from './foodmap.js';

export default class FoodFilter extends React.Component {
	render() {
		return (
			<section className="foodfilter">
			<div className="container">
				<form className="form-inline" role="search">
					<FoodCategorySearchBox/>
					<SearchBox/>
					<SelectDate/>
					<FilterCriteria/>
					<div className="form-group left-margin">
						<div className="square"></div>
					</div>
				</form>
				<FoodMap />
		    </div>
			</section>
		);
	}
}
