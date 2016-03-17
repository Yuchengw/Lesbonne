
import React from 'react';


export default class FoodCategorySearchBox extends React.Component {
	render(){
        return (
		        <div className="form-group">
		        	<div className="input-group inner-addon left-addon">
		        		<input ref="foodCategory" id="food-category" type="text" className="form-control" placeholder="Ramen">
		        		</input>
		        		<i className="lesbonnes-icon food"></i>
	        		</div>
		       </div>
        );
    }
}