//#include<iostream>
//#include<queue>
//using namespace std;
//
//const int maxn = 99;
//// n: 物品的数量
//// c: 背包的容量
//int n, c;
//// 记录所有节点的重量
//int w[maxn];
//// 记录所有节点的价值
//int v[maxn];
//// 当前最佳的价值是多少
//int bestv = 0;
//// 当前最佳的价值对应的是哪个节点
//int bestx[maxn];
//// 解空间有多少个节点
//int total = 1;
//
////队列中的结点类型
//struct nodetype {
//    //结点编号，从1开始 
//    int no;
//    //当前结点在搜索空间中是第几层
//    int i;
//    //当前结点的总重量（重量）
//    int w;
//    //当前结点的总价值（价值）
//    int v;
//    //当前结点包含的解向量 
//    int x[maxn];
//    //上界 
//    double ub;
//};
//
////计算分支结点e的上界 
//void bound(nodetype& e)
//{
//    //考虑结点e的余下物品
//    int i = e.i + 1;
//    int sumw = e.w;
//    double sumv = e.v;
//    while ((sumw + w[i] <= c) && i <= n)
//    {
//        sumw += w[i];
//        sumv += v[i];
//        i++;
//    }
//    //余下物品只能部分装入 
//    if (i <= n)            
//        e.ub = sumv + (c - sumw) * v[i] / w[i];
//    else e.ub = sumv;
//}
//
//void enqueue(nodetype e, queue<nodetype>& qu)
////结点e进队qu 
//{
//    //到达叶子节点，不在扩展对应一个解 
//    if (e.i == n)                
//    {
//        //找到更大价值的解 
//        if (e.v > bestv)        
//        {
//            bestv = e.v;
//            for (int j = 1; j <= n; j++)
//            {
//                bestx[j] = e.x[j];
//            }
//        }
//    }
//    //非叶子结点进队
//    else qu.push(e);        
//}
//// 广度优先搜索
//void bfs()
//{
//    int j;
//    nodetype e, e1, e2;
//    queue<nodetype> qu;
//    e.i = 0;
//    e.w = 0;
//    e.v = 0;
//    e.no = total++;
//
//    for (j = 1; j <= n; j++) {
//        e.x[j] = 0;
//    }
//    bound(e);
//    qu.push(e);
//
//    while (!qu.empty())
//    {
//        //出队结点e 
//        e = qu.front(); qu.pop();   
//        //剪枝，检查左孩子结点 
//        if (e.w + w[e.i + 1] <= c)
//        {
//            //建立左孩子结点 
//            e1.no = total++;
//            e1.i = e.i + 1;
//            e1.w = e.w + w[e1.i];
//            e1.v = e.v + v[e1.i];
//            for (j = 1; j <= n; j++)
//                e1.x[j] = e.x[j];
//            e1.x[e1.i] = 1;
//            //求左孩子的上界 
//            bound(e1);
//            //左孩子结点进队 
//            enqueue(e1, qu);
//        }
//        e2.no = total++;
//        e2.i = e.i + 1;
//        e2.w = e.w;
//        e2.v = e.v;
//        for (j = 1; j <= n; j++)
//        {
//            e2.x[j] = e.x[j];
//        }
//        e2.x[e2.i] = 0;
//        bound(e2);
//        //若右孩子结点可行，则进队，否则被剪枝 
//        if (e2.ub > bestv)
//        {
//            enqueue(e2, qu);
//        }
//    }
//}
//
//void get_result()
//{
//    cout << "最优值是:" << bestv << endl;
//    cout << "(";
//    for (int i = 1; i <= n; i++)
//    {
//        cout << bestx[i] << " ";
//    }
//    cout << ")";
//}
//
//int main()
//{
//    cout << "个数：" << endl;
//    cin >> n;
//    cout << "每个物品的weight value:" << endl;
//    for (int i = 1; i <= n; i++)
//    {
//        cin >> w[i] >> v[i];
//    }
//    cout << "容量：" << endl;
//    cin >> c;
//    bfs();
//    get_result();
//    return 0;
//}