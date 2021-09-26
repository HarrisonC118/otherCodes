class Hello(object):

    def __enter__(self):
        print('我进入了__enter__函数')
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        print('我进入了__exit__函数')

    def helloa(self):
        print("这是一个自定义的方法")


with Hello() as yoo:
    yoo.helloa()
yoo.helloa()