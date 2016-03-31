import SearchActions from '../search/SearchActions.js';
import when from 'when';
import request from 'reqwest';
import { SEARCH_NEARBY,SEARCH_CITY_ZIPCODE,SEARCH_NEARBY_URL,SEARCH_CITY_ZIPCODE_URL } from '../search/SearchConstants.js';

class SearchService {
	
	searchNearbyLocations(latitude, longitude) {
	    var requestUrl = SEARCH_NEARBY_URL.replace('{latitude}', latitude).replace('{longitude}', longitude);
		console.log('SEND request to - ' + requestUrl);
		return this.handleLocations(when(request({
	      url: requestUrl,
	      method: 'GET',
	      crossOrigin: true,
	      type: 'json'
	    })), latitude, longitude, requestUrl, SEARCH_NEARBY);
	}
	
	searchCityOrZipcodeLocations(cityOrZipcode, latitude, longitude) {
		console.log(latitude + ' ' + longitude);
		var requestUrl = SEARCH_CITY_ZIPCODE_URL.replace('{cityOrZipcode}', cityOrZipcode);
		console.log('SEND request to - ' + requestUrl);
		return this.handleLocations(when(request({
	      url: requestUrl,
	      method: 'GET',
	      crossOrigin: true,
	      type: 'json'
	    })), latitude, longitude, requestUrl, SEARCH_CITY_ZIPCODE);
	}
	
	handleLocations(locationsPromise, latitude, longitude, requestUrl, actionType) {
		return locationsPromise
				.then(
						function(responseBody) {
							console.log('SEND request to - ' + requestUrl +' success.');
							SearchActions.renderLocations(responseBody, latitude, longitude, actionType);
							return true;
						})
				.catch(
						function(error) {
							console.log('SEND request to - ' + requestUrl + ' failed.')
							console.log(error);
						});
	}
}

export default new SearchService();