/**
 * @author yucheng
 * @since 1
 * */
import React from 'react';
import FoodFilter from './components/foodfilter.js';
import SearchService from '../../modules/explore/service/SearchService.js';

require('./explore.scss');

export default class ExploreFood extends React.Component {	
	_setCurrentGeolocation (position) {
		console.log('Current location: (' + position.coords.latitude + ', ' + position.coords.longitude + ')');
	    SearchService.searchNearbyLocations(position.coords.latitude, position.coords.longitude);
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