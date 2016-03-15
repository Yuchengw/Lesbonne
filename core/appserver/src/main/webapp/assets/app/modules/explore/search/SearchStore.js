import {SEARCH_NEARBY, SEARCH_ZIPCODE} from './SearchConstants';
import BaseStore from '../../../global/store/BaseStore.js';

class SearchStore extends BaseStore {
	
	constructor() {
	    super();
	    this.subscribe(() => this._registerToActions.bind(this))
	    this._locations = null;
	}
	
	_registerToActions(action) {
	    switch(action.actionType) {
	      case SEARCH_NEARBY:
	    	 console.log('HERE1');
	    	 console.log(action.locations);
	        this._locations = action.locations;
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
}

export default new SearchStore();