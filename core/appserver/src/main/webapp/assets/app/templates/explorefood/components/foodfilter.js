import React from 'react';


class FoodFilter extends React.Component {
	render(){
        return (
		        <div className="col-md-2 right-border">
		        <div className="dropdown">
				<div className="dropdown-toggle form-control no-border full-width" id="foodfilter" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Filter
					<span className="img-icon arrow-icon"></span>
				</div>
				<ul className="dropdown-menu" aria-labelledby="foodfilter">
				    <li><a href="#">Action</a></li>
				    <li><a href="#">Another action</a></li>
				    <li><a href="#">Something else here</a></li>
				    <li role="separator" className="divider"></li>
				    <li><a href="#">Separated link</a></li>
			    </ul>
			    </div>
		       </div>
        );
    }
}

export default FoodFilter;