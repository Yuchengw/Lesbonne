

import SearchActions from '../search/SearchActions.js';
import when from 'when';
import request from 'reqwest';
import SearchConstants from '../search/SearchConstants.js';

class SearchService {
	
	searchNearbyLocations(latitude, longitude) {
	    console.log('HERE');
		return this.handleNearbyLocations(when(request({
	      url: SearchConstants.SEARCH_NEARBY_URL.replace('{latitude}', latitude).replace('{longitude}', longitude),
	      method: 'GET',
	      crossOrigin: true,
	      type: 'json'
	    })));
	}
	
	searchZipcodes(zipcode) {
		
	}
	
	handleNearbyLocations(nearbyLocationsPromise) {
		return nearbyLocationsPromise
				.then(function(response) {
					console.log(response);
			if (response.status === 200 && response.statusText == "OK") {
		        console.log(response);
	    		SearchActions.renderGoogleMap(response);
		        console.log("search nearbylocation success.");
		        return true;
	    	}
		return false;
	})
		.catch(function(error) {
			console.log('search nearbylocations failed.')
			console.log(error);
		});
	}
}

export default new SearchService();