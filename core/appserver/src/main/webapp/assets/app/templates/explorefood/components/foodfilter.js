import React from 'react';

class FoodFilter extends React.Component {
	render(){
        return (
        		<li className="dropdown right-border">
				<div className="dropdown-toggle form-control no-border" id="foodfilter" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span className="filter-text" id="foodfilter-text">Filter</span>
					<span className="img-icon arrow-icon"></span>
				</div>
				<ul className="dropdown-menu" aria-labelledby="foodfilter">
						 <li className="row">
							<div className="col-md-4">
							Diet Preferences
							</div>
							<div className="col-md-4">
							Price
							</div>	
						    </li>
							<li className="row">
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Any food</input>
								</label>
								</div>
								</a>
								</div>
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Any price</input>
								</label>
								</div>
								</a>
								</div>
							</li>
							<li className="row">
									<div className="col-md-4">
										<a href="javascript:void(0);">
										<div className="checkbox">
										<label>
										<input type="checkbox">Vegeterian</input>
										</label>
										</div>
										</a>
									</div>
									<div className="col-md-4">
										<a href="javascript:void(0);">
										<div className="checkbox">
										<label>
										<input type="checkbox">$5 or less</input>
										</label>
										</div>
										</a>
									</div>
							</li>
							<li className="row">
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Gluten-Free</input>
								</label>
								</div>
								</a>
								</div>
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">$5-10</input>
								</label>
								</div>
								</a>
								</div>
							</li>
							<li className="row">
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Dairy-Free</input>
								</label>
								</div>
								</a>
								</div>
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">$10-20</input>
								</label>
								</div>
								</a>
								</div>
							</li>
							<li className="row">
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Nut-Free</input>
								</label>
								</div>
								</a>
								</div>
								<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">$20+</input>
								</label>
								</div>
								</a>
								</div>
							</li>
							<li className="row">
							<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Vegan</input>
								</label>
								</div>
								</a>
							</div>
							<div className="col-md-4"></div>
							</li>
							<li className="row">
							<div className="col-md-4">
								<a href="javascript:void(0);">
								<div className="checkbox">
								<label>
								<input type="checkbox">Egg-Free</input>
								</label>
								</div>
								</a>
							</div>
							<div className="col-md-4">
							</div>
							</li>
							<li>
							<div>
							<a href="#" className="btn btn-success btn-small outline float-right">Apply</a>
							</div>
						</li>
						</ul>
		        </li>
        );
    }
}

export default FoodFilter;