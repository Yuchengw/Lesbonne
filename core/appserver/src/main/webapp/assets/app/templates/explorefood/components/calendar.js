import React from 'react';
import DatePicker from 'react-datepicker';
import moment from 'moment';

require('react-datepicker/dist/react-datepicker.css');

export default class Picker extends React.Component {
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
				<div className="form-group left-padding">
				<div className="inner-addon right-addon">
				<DatePicker
					className='form-control'
				    onChange={this.handleChange}
					selected={this.state.startDate}
					todayButton={'Today'}
					dateFormat='MM-DD'
					placeholderText='Click to select a date'>
				</DatePicker>
				<i className="lesbonnes-icon arrow"></i>
				</div>
				</div>
		)
	}
}