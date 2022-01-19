const HtmlWebpackPlugin = require("html-webpack-plugin");
const path = require("path");
module.exports = {
    entry: "./src/main.ts",
    // 指定webpack模式，具体配置在package.json中
    mode: 'development',
    output: {
        path: path.resolve(__dirname, "./dist"),
        filename:"bundle.js"
    },
    resolve: {
        extensions: [".ts",".js",".json"]
    },
    module: {
        rules: [
            {
                test: /\.ts$/,
                use:[
                    "ts-loader"
                ]
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: "./index.html"
        })
    ]
}