var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: 
	    getEntrySources(['./js/entry.js']),
	output: {
    	path: path.resolve(__dirname, './build'),
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
            {
                test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/,
                loader: 'source-map-loader'
            }
        ],
        loaders: [
            {
                test: /\.scss$/,
                include: /src\/main\/webapp\/assets/,
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
                exclude: /(node_modules|bower_components)/,
                loader: 'react-hot'
            },
            {
            	test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/,
                loader: 'babel',
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
        sources.push('webpack-dev-server/client?https://localhost:8080');
        sources.push('webpack/hot/only-dev-server');
    }

    return sources;
}