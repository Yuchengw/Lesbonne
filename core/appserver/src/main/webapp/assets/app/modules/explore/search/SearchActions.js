import AppDispatcher from '../../../global/dispatcher/AppDispatcher.js';
import {SEARCH_NEARBY, SEARCH_ZIPCODE} from './SearchConstants.js';
import RouterContainer from '../../../global/router/RouterContainer.js';


export default class SearchActions {
	renderGoogleMaps (locations) {
		AppDispatcher.dispatch({
			actionType: SEARCH_NEARBY,
			locations: locations
		});
	}
}