from sklearn import datasets
from pandas import DataFrame
import pandas as pd

x_data = datasets.load_iris().data  # 获取所有特征
y_data = datasets.load_iris().target  # 获取所有标签
print("x_data的内容是: \n", x_data)
print("y_data的内容是: \n", y_data)

x_data = DataFrame(x_data, columns=['花萼长度', '花萼宽度', '花瓣长度', '花瓣宽度'])  # 把数据处理为表格的形式
pd.set_option('display.unicode.east_asian_width', True)  # 设置列明对其
print("x_data add index: \n", x_data)

x_data['类别'] = y_data  # 添加一列名字为类别的标签
print("x_data add a column: \n", x_data)
