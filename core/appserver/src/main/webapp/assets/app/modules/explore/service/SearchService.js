

import SearchActions from '../search/SearchActions.js';
import when from 'when';
import request from 'reqwest';
import SearchConstants from '../search/SearchConstants.js';

class SearchService {
	
	searchNearbyLocations(latitude, longitude) {
	    console.log('SEND request to - ' + SearchConstants.SEARCH_NEARBY_URL.replace('{latitude}', latitude).replace('{longitude}', longitude));
		return this.handleNearbyLocations(when(request({
	      url: SearchConstants.SEARCH_NEARBY_URL.replace('{latitude}', latitude).replace('{longitude}', longitude),
	      method: 'GET',
	      crossOrigin: true,
	      type: 'json'
	    })), latitude, longitude);
	}
	
	searchZipcodes(zipcode) {
		
	}
	
	handleNearbyLocations(nearbyLocationsPromise, latitude, longitude) {
		return nearbyLocationsPromise
				.then(
						function(responseBody) {
							console.log('search nearbylocations success.');
							SearchActions.renderGoogleMaps(responseBody, latitude, longitude);
							return true;
						})
				.catch(
						function(error) {
							console.log('search nearbylocations failed.')
							console.log(error);
						});
	}
}

export default new SearchService();