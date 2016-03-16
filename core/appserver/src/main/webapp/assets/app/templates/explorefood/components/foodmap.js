import {GoogleMapLoader, GoogleMap, Marker} from 'react-google-maps';
import SearchStore from '../../../modules/explore/search/SearchStore.js';
import React from 'react';

export default class FoodMap extends React.Component {
	
	constructor(props) {
	      super(props);
	      this.state = this._getLocations();
	}
	
	_getLocations() {
		return {
			latitude: SearchStore.getLatitude(),
			longitude: SearchStore.getLongitude(),
			locations: SearchStore.getLocations()
		};
	}
	
	componentDidMount() {
        this.changeListener = this._onChange.bind(this);
        SearchStore.addChangeListener(this.changeListener);
    }

    _onChange() {
        this.setState(this._getLocations());
    }

    componentWillUnmount() {
        SearchStore.removeChangeListener(this.changeListener);
    }
	
	render() {
		console.log(this.state);
		var mapElement = '';
		if (this.latitude!==null && this.state.longitude!==null) {
			mapElement = <GoogleMapLoader
	        containerElement={
	          <div
	            {...this.props}
	            style={{
	              height: "100%",
	            }}
	          />
	        }
	        googleMapElement={
	          <GoogleMap
	            ref={(map) => console.log(map)}
	            defaultZoom={16}
	            defaultCenter={{lat: this.state.latitude, lng: this.state.longitude}}>
	          </GoogleMap>
	        }
	      />
		}
		
		return (
	    <section style={{height: "100%"}}>
	      {mapElement}
	    </section>
		);
	}
}