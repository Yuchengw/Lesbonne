import React from 'react';


class FoodFilter extends React.Component {
	render(){
        return (
		        <div className="col-md-2 right-border pl-10">
		        	<div className="form-control no-border">Filter</div>
		        	<span className="img-icon arrow-down-icon"></span>
		       </div>
        );
    }
}

export default FoodFilter;