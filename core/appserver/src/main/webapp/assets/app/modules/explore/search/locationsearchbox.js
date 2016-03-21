import React from 'react';
import ReactDOM from 'react-dom';

import SearchService from '../service/SearchService.js';
import FoodSearchBox from './foodsearchbox.js';

require("typeahead.js/dist/typeahead.jquery.min.js");
import Bloodhound from "typeahead.js/dist/bloodhound.min.js";
import $ from 'jquery';

var _zipcodes = {};
var _geocoder = new google.maps.Geocoder();



/**Twitter typeahead javascript**/
class LocationSearchBox extends React.Component {
	constructor(props) {
	    super(props);
	    this.state = { 
	    	selectedZipcode: null
	    };
	  }
	
	search (event) {
		event.preventDefault();
		var selectedZipcode = ReactDOM.findDOMNode(this.refs.locationInput).value.trim();
		_geocoder.geocode({'address': selectedZipcode}, function(results, status) {
  			if (status == google.maps.GeocoderStatus.OK && results.length>0) { 		
  				var latitude = results[0].geometry.location.lat();
  				var longitude = results[0].geometry.location.lng();
  				SearchService.searchZipcodeLocations(selectedZipcode, latitude, longitude);
			} else {
				alert("no matching zipcode!");
			}
		});	
    }
    
    onEnter(event) {
    	if (event.keyCode===13) {
            var zipcode = event.target.value;
    		this.setState({selectedZipcode: zipcode});
    		console.log('I am here1 ' + zipcode);
    	}
    }
    
    onSelected (event, data) {
    	this.setState({selectedZipcode: data});
    	console.log('I am here2 ' + data);
    }
    
    initTypeAhead () {
        var el = $(this.refs.locationInput.getDOMNode());
        el.typeahead({
            hint: true,
            highlight: true,
            minLength: 1
        },
        {
            name: 'zipcodes',
            source: _zipcodes.ttAdapter()
        }).on('typeahead:selected', this.onSelected);
        this.refs.locationInput.getDOMNode().placeholder="Enter location here...";

        el.keypress(this.onEnter);

    }
    
    componentDidMount() {
    	_zipcodes = new Bloodhound({
            datumTokenizer(d) {return Bloodhound.tokenizers.whitespace(d);},
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            prefetch: {
                ttl: 1,
                url: "/service/address/getAllZipcodes"
            }
        });

        
    	_zipcodes.initialize();
        this.initTypeAhead();
    }
    
    componentDidUpdate() {
        this.initTypeAhead();
    }

    /*componentWillUnmount: function(){
        var el = $(this.refs.searchQuestionInput.getDOMNode());
        $(el).typeahead('destroy');
    },*/

    render(){
        return (
		        <div className="col-md-6 right-border">
		        	<FoodSearchBox/>
		        	<div className="col-md-8">
		        		<div className="input-group inner-addon">
		        			<div className="input-group-addon">
		        				<span className="img-icon marker-icon"></span>
		        				<span className="ml-25">Near</span>
		        			</div>
	        				<input ref="locationInput" id="location-input" type="text" className="form-control no-border" placeholder="Enter location here...">
	        				</input>
	        				<div className="input-group-addon">
	        					<a href="#" className="btn btn-success btn-small outline" onClick={this.search.bind(this)} >Search</a>
	        				</div>
	        			</div>
	        		</div>        		
		       </div>
        );
    }
}

export default LocationSearchBox;
