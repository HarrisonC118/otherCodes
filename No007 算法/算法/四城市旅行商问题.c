//#include<stdio.h>
//#define N 100
//
//double INF = 1e7;//设置无穷大的值为10的七次方
//int g[N][N];//地图的无向带权邻接矩阵
//int x[N];//记录当前路径
//int bestx[N];//记录当前最优路径
//int cl;//当前路径长度
//int bestl;//当前最短路径长度
//int n, m;//城市个数n,边数m
//void swap(int array[], int a, int b) {//交换函数
//    int temp;
//    temp = array[a];
//    array[a] = array[b];
//    array[b] = temp;
//}
//void Traveling(int t) {
//    if (t > n) {//到达叶子节点
//        /*
//        推销货物的最后一个城市与住地城市有边相连并且路径长度比当前最优值小，说明找到了一条更好的路径，记录相关信息
//         */
//        if (g[x[n]][1] != INF && (cl + g[x[n]][1] < bestl)) {
//            for (int j = 1; j <= n; j++) {
//                bestx[j] = x[j];
//            }
//            bestl = cl + g[x[n]][1];
//        }
//    }
//    else {//没有到达叶子节点
//        for (int j = t; j <= n; j++) {//搜索扩展节点的所有分支
//            if (g[x[t - 1]][x[j]] != INF && (cl + g[x[t - 1]][x[j]] < bestl)) {//如果第t-1个城市与第t个城市有边相连并且有可能得到更短的路线
//                swap(x, t, j);//交换两个元素的值
//                cl = cl + g[x[t - 1]][x[t]];
//                Traveling(t + 1);//从第t+1层的扩展结点继续搜索
//                //第t+1层搜索完毕，回溯到第t层
//                cl = cl - g[x[t - 1]][x[t]];
//                swap(x, t, j);
//            }
//        }
//    }
//}
//
//
//void init() {
//    bestl = INF;
//    cl = 0;
//    for (int i = 1; i <= n; i++)
//        for (int j = i; j <= n; j++)
//            g[i][j] = g[j][i] = INF;
//    for (int i = 0; i <= n; i++) {
//        x[i] = i;
//        bestx[i] = 0;
//    }
//}
//void print() {
//    printf("最短路径");
//    for (int i = 1; i <= n; i++) {
//        printf("%d---->", bestx[i]);
//    }
//    printf("1", bestl);
//    printf("\n最短路径长度 %d\n", bestl);
//}
//void main() {
//    int u, v, w;//u,v代表城市，w代表城市u,v之间的距离。
//    printf("请输入城市数n：");
//    scanf_s("%d", &n);
//    init();
//    printf("请输入城市之间的连线数：");
//    scanf_s("%d", &m);
//    printf("请依次输入两个城市u,v以及之间的距离w:\n");
//    for (int i = 1; i <= m; i++) {
//        scanf_s("%d", &u);
//        scanf_s("%d", &v);
//        scanf_s("%d", &w);
//        g[u][v] = g[v][u] = w;
//    }
//    Traveling(2);//结合排列树的图，从第二层开始
//    print();
//}