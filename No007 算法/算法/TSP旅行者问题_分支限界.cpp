///*��֧�޽編���TSP����
//*/
//#include<iostream>
//#include<algorithm>
//#include<queue>
//#define MAXLENGTH 10
//using namespace std;
//
////���и���
//int n;
////���о�����۾���
//int value[MAXLENGTH][MAXLENGTH];
////������ʱ�ʶ��
//bool bfs_visited[MAXLENGTH];
////���庯���Ͻ�
//int up;
////�����½�
//int down;
////����������������
//void Modify();
////��֧�޽編���TSP����
//int solve();
////������ȷ������Ͻ�
//void get_up();
////�����½�
//void get_down();
////��������㷨
//int bfs(int, int, int);
////������ڵ��
//struct  Node
//{
//	//�ڵ���ʱ��
//	bool visited[MAXLENGTH];
//	//���ʴ���
//	int cixu[MAXLENGTH];
//	//��һ����
//	int start;
//	//��һ���ڵ���ڽӽڵ�
//	int start_p;
//	//���һ���ڵ�
//	int end;
//	//���һ���ڵ���ڽӽڵ�
//	int end_p;
//	//�߹��ĵ���
//	int k;
//	//����·���ľ���
//	int sumv;
//	//Ŀ�꺯��ֵ
//	int lb;
//	//���������
//	//Ŀ�꺯��ֵС���ȳ�����
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
////����Ŀ�꺯��ֵ
//int get_lb(Node);
////����һ�����ȶ���
//priority_queue<Node> pq;
//
//int main() {
//	cout << "��������и���:";
//	cin >> n;
//	cout << "������" << n << "*" << n << "�ĳ��о�����۾���" << endl;
//	for (int i = 1; i <= n; i++)
//	{
//		for (int j = 1; j <= n; j++)
//		{
//			cin >> value[i][j];
//		}
//	}
//	Modify();
//	//������ս��
//	cout << "���·������Ϊ" << solve() << endl;
//	for (int i = 1; i <= n; i++)
//	{
//		cout << result[i];
//	}
//	return 0;
//}
//
////������������
//void Modify() {
//	for (int i = 1; i <= n; i++)
//	{
//		value[i][i] = 999;
//	}
//}
//
//
////����������
//int solve() {
//	//1.�����νӺ�������Ŀ�꺯�����Ͻ硢�½�
//	get_up();
//	cout << "������ȷ�����Ͻ�Ϊ:" << up << endl;
//	get_down();
//	cout << "�½�Ϊ:" << down << endl;
//	//2.������ڵ��Ŀ�꺯��ֵ�������������ڵ����
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
//	//������·������
//	star.sumv = 0;
//	//�½�
//	star.lb = down;
//	//����Ľ�
//	int ret = 999;
//	//�����������
//	pq.push(star);
//	cout << "start��lb=" << star.lb << endl;
//	//3.ѭ��ֱ��ĳ��Ҷ�ӽڵ��Ŀ�꺯��ֵ�ڶ�����ȡ����Сֵ
//	while (pq.size())
//	{
//		//3.1��þ�����Сֵ�Ľڵ�
//		tmp = pq.top();
//		pq.pop();
//		//3.2�Խڵ��ÿ�����ӽڵ�ִ�����в���
//		//����Ѿ�����n-1���ڵ�
//		if (tmp.k == n - 1)
//		{
//			//�����һ��û�߹��Ľڵ�
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
//			//����ȫ����·�����Ⱥ�
//			int ans = tmp.sumv + value[tmp.end][p] + value[p][tmp.start];
//			//�����ǰ��·�������е�Ŀ�꺯��ֵ��С������
//			if (ans <= tmp.lb) {
//				ret = min(ans, ret);
//				for (int j = 1; j <= n; j++)
//				{
//					result[j] = tmp.cixu[j];
//				}
//			}
//			else
//			{
//				//�����Ͻ�
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
//				//��㲻��
//				next.start = tmp.start;
//				//����·����
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
//				//3.2.1����ÿ�����ӽڵ��Ŀ�꺯��ֵ
//				next.lb = get_lb(next);
//				//3.2.2�ж��Ƿ���Ҫ�����ý��
//				if (next.lb > up) {
//					continue;//���������
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
////���庯���Ͻ纯��
//void get_up() {
//	bfs_visited[1] = true;
//	up = bfs(1, 1, 0);
//}
//
////�����������㷨,�����Ͻ�
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
//	//��ǵ�ǰ������С�ڵ�Ϊ���ʹ�
//	bfs_visited[p] = true;
//	return bfs(p, k + 1, l + minlen);
//}
//
////�����½纯��
//void get_down() {
//	//ȡÿ����С������Ԫ������ٳ���2��ֵ��Ϊ�½�
//	down = 0;
//	for (int i = 1; i <= n; i++)
//	{
//		//����һ����ʱ���飬���ڴ洢ÿһ�е�����
//		int temp[MAXLENGTH];
//		for (int j = 1; j <= n; j++)
//		{
//			temp[j] = value[i][j];
//		}
//		//�������������,�����ֱ�Ϊ��ʼλ�ã�����λ��
//		sort(temp + 1, temp + n + 1);
//		//������С������ֵ
//		down = down + temp[1] + temp[2];
//	}
//	//��down����2
//	down /= 2;
//}
//
////����Ŀ�꺯��ֵ
//int get_lb(Node p) {
//	int ret = p.sumv * 2;//·���ϵĵ�ľ���Ķ���
//	int min1 = 999, min2 = 999;//�����յ��������ı�
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
