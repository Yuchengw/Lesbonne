var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: {
	    "app": path.resolve(__dirname, "./src/main/webapp/assets/js/app/app.js")
	},
	output: {
    	path: path.resolve(__dirname, './src/main/webapp/assets/js/app/app.js'),
    	filename: 'bundle.js',		
	},
	externals: {

	},
	resolve: {

	},
	devtool: 'eval',
	sassLoader: {

	},
	module: {
		preLoaders: [
		],
		loaders: [
		],
	},
	plugins: [
	]
};
