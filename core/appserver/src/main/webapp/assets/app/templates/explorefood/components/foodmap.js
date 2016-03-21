import {GoogleMapLoader, GoogleMap, Marker} from 'react-google-maps';
import SearchStore from '../../../modules/explore/search/SearchStore.js';
import React from 'react';
import _mapstyle from '../mapstyle.json';

class FoodMap extends React.Component {
	
	constructor(props, context) {
		console.log(_mapstyle);
		super(props, context);
	    this.state = this._getLocations();
	}
	
	_getLocations() {
		var latitude = SearchStore.getLatitude();
		var longitude = SearchStore.getLongitude();
		var locations = SearchStore.getLocations();
		var markers = [];
		
		if (latitude && longitude) {
			var centerLocation = {
					lat: latitude,
				    lng: longitude
			};
			var centerMarker = {
					position: centerLocation,
					animation: google.maps.Animation.DROP,
					key: 'center',
					draggable: false,
					title: 'Current Location',
					icon: {
						url: 'https://localhost:8083/scss/images/marker.png',
						size: new google.maps.Size(32, 32),
						scaledSize: new google.maps.Size(32, 32)
					}
			}
			markers.push(centerMarker);
			
			for (var i=0; i<locations.length; i++) {
				var location = locations[i];
				var foodMarker = {
						position: new google.maps.LatLng(location.latitude,location.longitude),
						animation: google.maps.Animation.DROP,
						key: 'food' + i,
						draggable: false,
						icon: {
							url: 'https://localhost:8083/scss/images/food.png',
							size: new google.maps.Size(32, 32),
							scaledSize: new google.maps.Size(32, 32)
						}	
				}
				markers.push(foodMarker);
			}			
		}
			
		return {
			shouldLoadMap: latitude!==null && longitude!==null,
			markers: markers,
			center: centerLocation
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
		if (this.state.shouldLoadMap) {
			console.log(this.state.markers);
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
	          	center={this.state.center}
	          defaultOptions={{
	              styles: _mapstyle,
	            }}>        
	          {this.state.markers.map((marker, index) => {
	              return (
	                <Marker
	                  {...marker}
	                />
	              );
	            })}
	          
	          </GoogleMap>
	        }
	      />
		}
		
		return (
	    <section className='map-container'>
	      {mapElement}
	    </section>
		);
	}
}

export default FoodMap;