const path = require('path');
const HTMLWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
module.exports = {
    // 定义入口文件
    entry: "./src/index.ts",

    output: {
        // 指定打包文件的输出路径
        path: path.resolve(__dirname, "dist"),
        // 指定打包后的文件
        filename: "bundle.js",
        environment: {
            arrowFunction: false
        }
    },
    // 指定webpack打包时要使用的模板
    module: {
        // 指定加载的规则
        rules: [
            {
                // test指定规则生效的文件
                test: /\.ts$/, //匹配所有以ts结尾的文件
                use: [
                    {
                        // 指定加载器
                        loader: "babel-loader",
                        // 设置babel
                        options: {
                            // 设置预定义的环境(设置要兼容哪些版本的浏览器)
                            presets: [
                                [
                                    // 指定环境的插件
                                    "@babel/preset-env",
                                    // 配置信息
                                    {
                                        targets: {
                                            // 指定目标浏览器
                                            "ie": "3"
                                        },
                                        // 指定corejs的版本
                                        "corejs": "3",
                                        // 使用corejs的方式 usage表示按需加载，需要哪个加载哪个
                                        "useBuiltIns": "usage"
                                    }
                                ]
                            ]
                        }
                    },
                    'ts-loader'
                ], //使用ts-loader来处理以ts结尾的文件
            },
            {
                test: /\.sass$/,
                use:[
                    "style-loader",
                    "css-loader",
                    "sass-loader"
                ]
            }
        ]
    },
    plugins: [
        new CleanWebpackPlugin(),
        new HTMLWebpackPlugin({
            template: './src/index.html', // 指定一个模板，以后插件生成的html文件都会以这个html文件为模板
        })
    ],
    resolve: {
        extensions: ['.ts', '.js'] //告诉webpack以ts和以js结尾的文件都可以作为模块引入
    }
}