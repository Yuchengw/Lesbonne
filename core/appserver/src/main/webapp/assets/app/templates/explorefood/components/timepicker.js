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
				<div className="col-md-2 right-border">
				<div className="dropdown">
				<div className="dropdown-toggle form-control no-border full-width" id="timepicker" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Dinner Tonight
					<span className="img-icon arrow-icon"></span>
				</div>
				<ul className="dropdown-menu" aria-labelledby="timepicker">
				    <li><a href="#">Action</a></li>
				    <li><a href="#">Another action</a></li>
				    <li><a href="#">Something else here</a></li>
				    <li role="separator" className="divider"></li>
				    <li><a href="#">Separated link</a></li>
			    </ul>
			    </div>
				</div>
		)
	}
}

export default TimePicker;