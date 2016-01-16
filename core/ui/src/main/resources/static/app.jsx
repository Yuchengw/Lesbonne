var React = require('react');

var App = React.createClass({
    getInitialState: function () {
        return ({employees: []});
    },
    componentDidMount: function () {
        client({method: 'GET', path: '/api/employees'}).done(response => {
            this.setState({employees: response.entity._embedded.employees});
        });
    },
    render: function () {
        return (
            <EmployeeList employees={this.state.employees}/>
        )
    }
})