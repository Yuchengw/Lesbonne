/**
 * @author yucheng
 * @since 1
 * */
import React from 'react';
import FoodFilter from './components/foodfilter.js';
import SearchService from '../../modules/explore/service/SearchService.js'

require('./explore.scss');

var _coordinates = {}

export default class ExploreFood extends React.Component {	
	_setCurrentGeolocation (position) {
		console.log(position);
	    _coordinates = position ;
	    SearchService.searchNearbyLocations(37.7890183, -122.3915063);
	}
	
	getGeolocationFromBrowser() {
		if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(this._setCurrentGeolocation);
	    } else { 
	        alert("Geolocation is not supported by this browser.");
	    }
	}
	
	componentWillMount() {
		this.getGeolocationFromBrowser();
	}
	
	render() {
	    return (
	    		<div className='explorefood'>
		    		<FoodFilter />
		    	</div>
	    );
	  }
}