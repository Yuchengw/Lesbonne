import AppDispatcher from '../../../global/dispatcher/AppDispatcher.js';

export default {
	renderLocations: (locations, latitude, longitude, actionType) => {
		AppDispatcher.dispatch({
			actionType: actionType,
			locations: locations,
			latitude: latitude,
			longitude: longitude
		});
	}
}
