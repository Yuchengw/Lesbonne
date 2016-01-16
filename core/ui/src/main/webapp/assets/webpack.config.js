var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: 
	    // "app": path.resolve(__dirname, "./src/main/webapp/assets/js/entry.js")
	    getEntrySources(['./js/entry.js']),
	output: {
    	path: path.resolve(__dirname, './src/main/webapp/product'),
    	filename: 'bundle.js',
    	 publicPath: 'http://localhost:8090/',
    	 filename: 'prod/bundle.js'	
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
                loader: 'source-map'
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
                loaders: [
                    'react-hot',
                    'babel?stage=0'
                ]
            }
        ]
    },
	plugins: [
	]
};

function getEntrySources(sources) {
    if (process.env.NODE_ENV !== 'production') {
        sources.push('webpack-dev-server/client?http://localhost:8080');
        sources.push('webpack/hot/only-dev-server');
    }

    return sources;
}