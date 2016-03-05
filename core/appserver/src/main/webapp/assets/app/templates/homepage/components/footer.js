/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';

export default class Footer extends React.Component {
	render() {
		return(
			<section className="homgepage-footer">
				<div className="col-sm-2">
					<a> About </a>
				</div>
				<div className="col-sm-2">
					<a> How it works </a>
				</div>
				<div className="col-sm-2">
					<a> Be a Host </a>
				</div>
				<div className="col-sm-2">
					<a> Press </a>
				</div>
				<div className="col-sm-2">
					<a> Job </a>
				</div>
				<div className="col-sm-2">
					<a> Terms of Service </a>
				</div>
				<div className="col-sm-2">
					<a> Privacy Policy </a>
				</div>
				<div className="col-sm-2">
					<a> Help </a>
				</div>
				<div>
					<a className="button"> English </a>
				</div>
			</section>
		);
	}
}