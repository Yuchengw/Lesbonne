/**
 * @author yucheng
 * @since 1
 */
let CommentBox = React.createClass({
	render: function() {
		return {
			<div className="commentBox">
				I am a commentBox
			</div>
		}
	};
});

ReactDOM.render(
	<CommentBox />,
	document.getElementById('content')
);