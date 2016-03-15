
import React from 'react';

require("typeahead.js/dist/typeahead.jquery.min.js");
import Bloodhound from "typeahead.js/dist/bloodhound.min.js";
import $ from 'jquery';

var _zipcodes = {};

/**Twitter typeahead javascript**/
export default class SearchBox extends React.Component {
	constructor(props) {
	    super(props);
	    this.state = { 
	    	zipcodes: null
	    };
	  }
	
	search (keyword) {
        console.log('I am here');
    }
    
    onEnter(event) {
        //each time the user hits enter, send a search request
    	console.log('I am here1');
    }
    
    onSelected (event, data) {
    	console.log('I am here2');
    }
    
    initTypeAhead () {
        var el = $(this.refs.searchInput.getDOMNode());
        el.typeahead({
            hint: true,
            highlight: true,
            minLength: 1
        },
        {
            name: 'zipcodes',
            source: _zipcodes.ttAdapter()
        }).on('typeahead:selected', this.onSelected);
        this.refs.searchInput.getDOMNode().placeholder="Enter zipcode here...";

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
		        <div className="form-group left-padding">
		        	<div className="input-group">
		        		<div className="input-group-addon inner-addon left-addon"><i className="lesbonnes-icon marker"></i><span className="left-margin">Near</span></div>
		        			<input ref="searchInput" id="search-input" type="text" className="form-control" placeholder="">
		        			</input>
		        		<div className="input-group-addon inner-addon right-addon">
		        			<i className="lesbonnes-icon magnify"></i>
		        		</div>
	        		</div>
	        		
		       </div>
        );
    }
}