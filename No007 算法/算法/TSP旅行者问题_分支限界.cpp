///*分支限界法求解TSP问题
//*/
//#include<iostream>
//#include<algorithm>
//#include<queue>
//#define MAXLENGTH 10
//using namespace std;
//
////城市个数
//int n;
////城市距离代价矩阵
//int value[MAXLENGTH][MAXLENGTH];
////定义访问标识符
//bool bfs_visited[MAXLENGTH];
////定义函数上界
//int up;
////定义下界
//int down;
////距离修正函数声明
//void Modify();
////分支限界法求解TSP问题
//int solve();
////广度优先法计算上界
//void get_up();
////计算下界
//void get_down();
////广度优先算法
//int bfs(int, int, int);
////待处理节点表
//struct  Node
//{
//	//节点访问标记
//	bool visited[MAXLENGTH];
//	//访问次序
//	int cixu[MAXLENGTH];
//	//第一个点
//	int start;
//	//第一个节点的邻接节点
//	int start_p;
//	//最后一个节点
//	int end;
//	//最后一个节点的邻接节点
//	int end_p;
//	//走过的点数
//	int k;
//	//经过路径的距离
//	int sumv;
//	//目标函数值
//	int lb;
//	//运算符重载
//	//目标函数值小的先出队列
//	bool operator <(const Node& p) const {
//		return p.lb < lb;
//	}
//};
//
//Node tmp;
////int number[20];
//
//int result[MAXLENGTH];
//int times = 0;
////计算目标函数值
//int get_lb(Node);
////建立一个优先队列
//priority_queue<Node> pq;
//
//int main() {
//	cout << "请输入城市个数:";
//	cin >> n;
//	cout << "请输入" << n << "*" << n << "的城市距离代价矩阵：" << endl;
//	for (int i = 1; i <= n; i++)
//	{
//		for (int j = 1; j <= n; j++)
//		{
//			cin >> value[i][j];
//		}
//	}
//	Modify();
//	//输出最终结果
//	cout << "最短路径长度为" << solve() << endl;
//	for (int i = 1; i <= n; i++)
//	{
//		cout << result[i];
//	}
//	return 0;
//}
//
////距离修正函数
//void Modify() {
//	for (int i = 1; i <= n; i++)
//	{
//		value[i][i] = 999;
//	}
//}
//
//
////定义解决函数
//int solve() {
//	//1.根据衔接函数计算目标函数的上界、下界
//	get_up();
//	cout << "广度优先法求得上界为:" << up << endl;
//	get_down();
//	cout << "下界为:" << down << endl;
//	//2.计算根节点的目标函数值，并加入待处理节点队列
//	Node star;
//	star.start = 1;
//	star.end = 1;
//	star.k = 1;
//	for (int i = 1; i <= n; i++)
//	{
//		star.visited[i] = false;
//		star.cixu[i] = 1;
//	}
//	star.visited[1] = true;
//	star.cixu[1] = 1;
//	//number[times++] = 1;
//	//经过的路径距离
//	star.sumv = 0;
//	//下界
//	star.lb = down;
//	//问题的解
//	int ret = 999;
//	//将起点加入队列
//	pq.push(star);
//	cout << "start：lb=" << star.lb << endl;
//	//3.循环直到某个叶子节点的目标函数值在队列中取得最小值
//	while (pq.size())
//	{
//		//3.1获得具有最小值的节点
//		tmp = pq.top();
//		pq.pop();
//		//3.2对节点的每个孩子节点执行下列操作
//		//如果已经走了n-1个节点
//		if (tmp.k == n - 1)
//		{
//			//找最后一个没走过的节点
//			int p;
//			for (int i = 1; i <= n; i++)
//			{
//				if (!tmp.visited[i]) {
//					p = i;
//					//number[times++] = i;
//					tmp.cixu[tmp.k + 1] = i;
//					break;
//				}
//			}
//			//计算全部的路径长度和
//			int ans = tmp.sumv + value[tmp.end][p] + value[p][tmp.start];
//			//如果当前的路径比所有的目标函数值都小则跳出
//			if (ans <= tmp.lb) {
//				ret = min(ans, ret);
//				for (int j = 1; j <= n; j++)
//				{
//					result[j] = tmp.cixu[j];
//				}
//			}
//			else
//			{
//				//更新上界
//				up = min(ret, ans);
//				ret = min(ret, ans);
//				continue;
//			}
//		}
//
//		Node next;
//		for (int i = 1; i <= n; i++)
//		{
//			if (!tmp.visited[i])
//			{
//				//起点不变
//				next.start = tmp.start;
//				//更新路径和
//				next.sumv = tmp.sumv + value[tmp.end][i];
//				int tmpstart = tmp.end;
//				next.end = i;
//				next.k = tmp.k + 1;
//				for (int j = 1; j <= n; j++)
//				{
//					next.visited[j] = tmp.visited[j];
//					next.cixu[j] = tmp.cixu[j];
//				}
//				next.visited[i] = true;
//				next.cixu[next.k] = i;
//				//3.2.1估算每个孩子节点的目标函数值
//				next.lb = get_lb(next);
//				//3.2.2判断是否需要丢弃该结点
//				if (next.lb > up) {
//					continue;//不加入队列
//				}
//				pq.push(next);
//				//number[times++] = i;
//				cout << tmpstart << "->" << next.end << ":lb=" << next.lb << endl;
//			}
//		}
//	}
//	return ret;
//}
//
////定义函数上界函数
//void get_up() {
//	bfs_visited[1] = true;
//	up = bfs(1, 1, 0);
//}
//
////定义广度优先算法,计算上界
//int bfs(int u, int k, int l) {
//	int minlen = 999;
//	int p;
//	if (k == n)
//	{
//		return l + value[u][1];
//	}
//	for (int i = 1; i <= n; i++)
//	{
//		if (!bfs_visited[i] && value[u][i] < minlen)
//		{
//			minlen = value[u][i];
//			p = i;
//		}
//	}
//	//标记当前行中最小节点为访问过
//	bfs_visited[p] = true;
//	return bfs(p, k + 1, l + minlen);
//}
//
////定义下界函数
//void get_down() {
//	//取每行最小的两个元素相加再除以2的值作为下界
//	down = 0;
//	for (int i = 1; i <= n; i++)
//	{
//		//创建一个临时数组，用于存储每一行的数据
//		int temp[MAXLENGTH];
//		for (int j = 1; j <= n; j++)
//		{
//			temp[j] = value[i][j];
//		}
//		//对数组进行排序,参数分别为起始位置，结束位置
//		sort(temp + 1, temp + n + 1);
//		//加上最小的两个值
//		down = down + temp[1] + temp[2];
//	}
//	//将down除以2
//	down /= 2;
//}
//
////计算目标函数值
//int get_lb(Node p) {
//	int ret = p.sumv * 2;//路径上的点的距离的二倍
//	int min1 = 999, min2 = 999;//起点和终点连出来的边
//	for (int i = 1; i <= n; i++)
//	{
//		if (!p.visited[i] && min1 > value[p.start][i])
//		{
//			min1 = value[p.start][i];
//		}
//	}
//	ret += min1;
//	for (int i = 1; i <= n; i++)
//	{
//		if (!p.visited[i] && min2 > value[p.end][i])
//		{
//			min2 = value[p.end][i];
//		}
//	}
//	ret += min2;
//	for (int i = 1; i <= n; i++)
//	{
//		if (!p.visited[i])
//		{
//			min1 = min2 = 999;
//			for (int j = 1; j <= n; j++)
//			{
//				if (min1 > value[i][j])
//					min1 = value[i][j];
//			}
//			for (int j = 1; j <= n; j++)
//			{
//				if (min2 > value[i][j] && value[i][j] > min1)
//				{
//					min2 = value[i][j];
//				}
//			}
//			ret += min1 + min2;
//		}
//	}
//	return ret / 2;
//}
