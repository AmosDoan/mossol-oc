module.exports = {
    devtool: 'source-map',
    module: {
        rules: [
            {
                test: /\.js?$/,
                exclude: /node_modules/,
                use : {
                    loader: "babel-loader",
                    options: {
                        presets: ['@babel/preset-env', '@babel/react']
                    }
                }
            }, 
            {
                test: /\.(png|jpe?g|gif)$/i,
                use: [
                    {
                        loader: 'file-loader',
                    },
                ],

            },
            {
                test: /\.css$/i,
                use: ['style-loader', 'css-loader'],
            },
        ]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};
