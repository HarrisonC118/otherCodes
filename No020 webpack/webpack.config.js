// 在nodejs中引入一个叫Path的模块
const path = require('path');
// 导入插件，一般是一个类
const { CleanWebpackPlugin }  = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const { DefinePlugin } = require('webpack');

const CopyWebpackPlugin = require('copy-webpack-plugin');
// 导出这个模块
module.exports = {
    // 配置webpack的打包模式
    // development: 开发阶段使用
    // production: 打包上线的时候使用
    mode:"development",
    // 把打包好的压缩文件与真实的开发文件做映射，方便找错
    devtool:"source-map",
    // 定义入口文件的路径，可以写相对路径
    entry: "./src/main.js",
    // 定义输出的信息
    output: {
        // 输出的路径只支持绝对路径，使用path模块中的resolve可以拼接路径
        // __dirname是文件的绝对路径,后面加上build就是拼接好的路径
        path: path.resolve(__dirname, "./build"),
        // 定义输出的文件名
        filename: "bundle.js"
    },
    module: {
        // 配置模块的规则，告诉webpack什么类型的文件用什么loader
        rules: [
            {
                // 正则表达式，$表示以...结尾, '.'在正则表达式中有特殊含义，所以需要转义
                // 含义：以.css结尾的文件
                test: /\.css$/,
                // use里面写需要什么loader，因为可能需要多个，所以写成数组
                use: [
                    {
                        loader: "css-loader",
                        options: {
                            // options里面可以写传给loader的参数
                        }
                    },
                    // 如果不需要传参，也可以写下面这个简化形式
                    "css-loader"
                ]
            }
        ]
    },
    plugins: [
        // 在这里配置webpack的插件
        new CleanWebpackPlugin({
            // 配置html生成的模板
            tempalte: './public/index.html',
            title: "hahahahha"
        }),
        new DefinePlugin({
            // 如果是双引号里直接写字符串的话，他会默认去找对应的变量。
            // 如果要让他单纯的读一个字符串的内容，就应该双引号里面套单引号
            BASE_URL:"'./'"
        }),
        new CopyWebpackPlugin({
            patterns: [
                {
                    // 要复制哪个文件夹
                    from: "public",
                    // 复制到哪
                    to: "./",
                    globOptions: {
                        ignore: [
                            // 忽略所有的index.html
                            "**/index.html"
                        ]
                    }
                }
            ]
        })
    ]
}
