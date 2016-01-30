var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: 
	    getEntrySources(['./app/app.js']),
	output: {
//		publicPath: 'http://localhost:8081/',
    	path: path.resolve(__dirname, './build'),
    	filename: './build/bundle.js',
	},
	resolve: {
		root: [
		       path.resolve('./node_modules'),
		       path.resolve('./')
		],
	},
	devtool: 'eval',
//	sassLoader: {
//		includePaths:[
//		    path.resolve(__dirname, './scss')
//		]
//	},
    module: {
        preLoaders: [
        ],
        loaders: [
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'react-hot'
            },
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'jsx'
            },
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                	presets: ['es2015','react']
                }
            },
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('css!sass')
//                loaders: [
//                    'style',
//                    'css',
//                    'autoprefixer?browsers=last 3 versions',
//                    'sass?outputStyle=expanded'
//                ]
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/i,
                loaders: [
                    'url?limit=8192',
                    'img'
                ]
            }
        ]
    },
	plugins: [
	    new ExtractTextPlugin("./css/style.css")
	]
};

function getEntrySources(sources) {
    if (process.env.NODE_ENV !== 'production') {
//        sources.push('webpack-dev-server/client?http://localhost:8081');
    	sources.push('webpack/hot/only-dev-server');
    }
    return sources;
}
