import numpy as np

rdm = np.random.RandomState(seed=1)  # seed用来设置随机种子，可以不写
a = rdm.rand()  # 返回一个随机标量
b = rdm.rand(2, 3, 3)  # 返回维度是2行3列的随机矩阵
print("a:", a)
print("b:", b)