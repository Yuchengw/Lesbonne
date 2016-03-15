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
			locations: SearchStore.getLocations()
		};
	}
	
	componentDidMount() {
      this.changeListener = this._onChange.bind(this);
      SearchStore.addChangeListener(this.changeListener);
    }

    _onChange() {
      console.log('On changes');
      console.log(this._getLocations());
      this.setState(this._getLocations());
    }

    componentWillUnmount() {
      SearchStore.removeChangeListener(this.changeListener);
    }
	
	render() {
		console.log('LOCATIONS1');
		console.log(this.state.locations);
		return (
	    <section style={{height: "100%"}}>
	      <GoogleMapLoader
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
	            defaultZoom={3}
	            defaultCenter={{lat: -25.363882, lng: 131.044922}}>
	          </GoogleMap>
	        }
	      />
	    </section>
		);
	}
}