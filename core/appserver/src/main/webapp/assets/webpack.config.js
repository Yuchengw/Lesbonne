var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: 
	    getEntrySources(['./entrypoints/entry.js']),
	output: {
    	path: path.resolve(__dirname, './build'),
    	filename: 'bundle.js',
	},
	externals: {
        'react': 'React'
	},
	resolve: {

	},
	devtool: 'eval',
	sassLoader: {
		includePaths:[
		    path.resolve(__dirname, './scss')
		]
	},
    module: {
        preLoaders: [
            {
                test: /\.jsx?$/,
                exclude: /(node_modules)/,
				loader: 'eslint',
                query: {
                    fix: true,
                    failOnError: true
                },            }
        ],
        loaders: [
            {
                test: /\.scss$/,
                loaders: [
                    'style',
                    'css',
                    'autoprefixer?browsers=last 3 versions',
                    'sass?outputStyle=expanded'
                ]
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/i,
                loaders: [
                    'url?limit=8192',
                    'img'
                ]
            },
            {
                test: /\.jsx?$/,
                exclude: /(node_modules)/,
                loader: 'react-hot'
            },
            {
            	test: /\.jsx?$/,
                exclude: /(node_modules)/,
                loader: ['react-hot','babel-loader'],
            	query: {
            		presets: ['stage-0','react','es2015'],
            		cacheDirectory: true
            	}
            }
        ]
    },
	plugins: [
	    new ExtractTextPlugin("style.css")
	]
};

function getEntrySources(sources) {
    if (process.env.NODE_ENV !== 'production') {
    }

    return sources;
}
