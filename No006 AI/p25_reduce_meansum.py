import tensorflow as tf

x = tf.constant([[1, 2, 3], [3, 2, 8]])
print("x:", x)
print("mean of x:", tf.reduce_mean(x, axis=0))  # 求x中所有数的均值
print("sum of x:", tf.reduce_sum(x, axis=1))  # 求每一行的和
