import {SEARCH_NEARBY, SEARCH_ZIPCODE} from './SearchConstants';
import BaseStore from '../../../global/store/BaseStore.js';

class SearchStore extends BaseStore {
	
	constructor() {
	    super();
	    this.subscribe(() => this._registerToActions.bind(this))
	    this._locations = null;
	    this._latitude = null;
	    this._longitude = null;
	}
	
	_registerToActions(action) {
	    switch(action.actionType) {
	      case SEARCH_NEARBY:
	        this._locations = action.locations;
	        this._latitude = action.latitude;
	        this._longitude = action.longitude;
	        this.emitChange();
	        break;
	      case SEARCH_ZIPCODE:
	        break;
	      default:
	        break;
	    };
	  }
	
	getLocations() {
		return this._locations;
	}
	
	getLatitude() {
		return this._latitude;
	}
	
	getLongitude() {
		return this._longitude;
	}
}

export default new SearchStore();