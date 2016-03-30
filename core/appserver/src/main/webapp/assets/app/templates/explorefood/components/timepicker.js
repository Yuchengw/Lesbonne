import React from 'react';
//import DatePicker from 'react-datepicker';
import moment from 'moment';

//require('react-datepicker/dist/react-datepicker.css');

class TimePicker extends React.Component {
	constructor(props) {
	    super(props);
	    this.state = { 
	    	startDate: moment()
	    };
	    this.handleChange = this.handleChange.bind(this)
	  }
	
	handleChange(date) {
	    this.setState({
	      startDate: date
	    });
	}
	
	render() {
		return (
				<li className="dropdown right-border">
				<div className="dropdown-toggle form-control no-border" id="timepicker" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<div>
						<span className="filter-text" id="timepicker-text">Dinner Tonight</span>
						<span className="img-icon arrow-icon"></span>
					</div>
				</div>
				<div className="dropdown-menu" aria-labelledby="timepicker">
				    <div className="col-md-6">
				    	<div className="row">
				    		<div className="col-md-12 dropdown-border">
				    			Today
				    		</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		All Day
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		Lunch Time(11:00am - 2:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		Dinner Tonight(5:00pm - 9:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12 dropdown-border">
				    		Late Night Grab(9:00pm - 11:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		Define
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		<input type="text" id="fromInput"></input>
				    		<span> To </span>
				    		<input type="text" id="toInput"></input>
				    	</div>
				    	</div>
				    </div>
				    <div className="col-md-6">
			    		<div className="row">
				    	<div className="col-md-12 dropdown-border">
				    		Tomorrow
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		All Day
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		Lunch Time(11:00am - 2:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		Dinner Tonight(5:00pm - 9:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12 dropdown-border">
				    		Late Night Grab(9:00pm - 11:00pm)
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		
				    	</div>
				    	</div>
				    	<div className="row">
				    	<div className="col-md-12">
				    		<a href="#" className="btn btn-success btn-small outline">Apply</a>
				    	</div>
				    	</div>
				    </div>
			    </div>
				</li>
		)
	}
}

export default TimePicker;