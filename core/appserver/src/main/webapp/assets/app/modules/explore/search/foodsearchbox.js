import React from 'react';

require("typeahead.js/dist/typeahead.jquery.min.js");
import Bloodhound from "typeahead.js/dist/bloodhound.min.js";
import $ from 'jquery';

var _foodResults = ['Pecorino Pasta', 'Baked Ziti Pasta', 'Fast & Furious Pasta', 'Johnny Walker Paste', 'Pasta Lebron James',
             'Homemade Pasta', 'Good fortune Pasta'
           ];

var _food = null;

class FoodSearchBox extends React.Component {
	constructor(props) {
	    super(props);
	    this.state = { 
	    	selectedFood: null
	    };
	  }
	
	search (event) {
		event.preventDefault();
    }
    
    onEnter(event) {
    	if (event.keyCode===13) {
    		console.log('I am here1 ' + zipcode);
    	}
    }
    
    onSelected (event, data) {
    	console.log('I am here2 ' + data);
    }
    
    initTypeAhead () {
        var el = $(this.refs.foodInput.getDOMNode());
        el.typeahead({
            hint: true,
            highlight: true,
            minLength: 1
        },
        {
            name: 'food',
            source: _food.ttAdapter()
        }).on('typeahead:selected', this.onSelected);
        this.refs.foodInput.getDOMNode().placeholder="Find food here...";

        el.keypress(this.onEnter);
    }
    
    componentDidMount() {
    	_food = new Bloodhound({
            datumTokenizer(d) {return Bloodhound.tokenizers.whitespace(d);},
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            local: _foodResults
        });

        
    	_food.initialize();
        this.initTypeAhead();
    }
    
    componentDidUpdate() {
        this.initTypeAhead();
    }
	
	render(){
        return (
        		<div className="col-md-4">
        			<div className="input-group inner-addon">
        				<span className="img-icon food-icon"></span>
        				<input ref="foodInput" id="food-input" type="text" className="form-control no-border" placeholder="Find food here..."></input>
        			</div>
		        </div>
        );
    }
}

export default FoodSearchBox;

export default FoodSearchBox;