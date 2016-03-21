import React from 'react';
import DatePicker from 'react-datepicker';
import moment from 'moment';

require('react-datepicker/dist/react-datepicker.css');

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
				<div className="col-md-2 right-border pl-10">
				<DatePicker
					className='form-control no-border'
				    onChange={this.handleChange}
					selected={this.state.startDate}
					todayButton={'Today'}
					dateFormat='MM-DD'
					placeholderText='Click to select a date'>
				</DatePicker>
				<span className="img-icon arrow-down-icon"></span>
				</div>
		)
	}
}

export default TimePicker;