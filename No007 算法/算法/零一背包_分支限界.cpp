//#include<iostream>
//#include<queue>
//using namespace std;
//
//const int maxn = 99;
//// n: ��Ʒ������
//// c: ����������
//int n, c;
//// ��¼���нڵ������
//int w[maxn];
//// ��¼���нڵ�ļ�ֵ
//int v[maxn];
//// ��ǰ��ѵļ�ֵ�Ƕ���
//int bestv = 0;
//// ��ǰ��ѵļ�ֵ��Ӧ�����ĸ��ڵ�
//int bestx[maxn];
//// ��ռ��ж��ٸ��ڵ�
//int total = 1;
//
////�����еĽ������
//struct nodetype {
//    //����ţ���1��ʼ 
//    int no;
//    //��ǰ����������ռ����ǵڼ���
//    int i;
//    //��ǰ������������������
//    int w;
//    //��ǰ�����ܼ�ֵ����ֵ��
//    int v;
//    //��ǰ�������Ľ����� 
//    int x[maxn];
//    //�Ͻ� 
//    double ub;
//};
//
////�����֧���e���Ͻ� 
//void bound(nodetype& e)
//{
//    //���ǽ��e��������Ʒ
//    int i = e.i + 1;
//    int sumw = e.w;
//    double sumv = e.v;
//    while ((sumw + w[i] <= c) && i <= n)
//    {
//        sumw += w[i];
//        sumv += v[i];
//        i++;
//    }
//    //������Ʒֻ�ܲ���װ�� 
//    if (i <= n)            
//        e.ub = sumv + (c - sumw) * v[i] / w[i];
//    else e.ub = sumv;
//}
//
//void enqueue(nodetype e, queue<nodetype>& qu)
////���e����qu 
//{
//    //����Ҷ�ӽڵ㣬������չ��Ӧһ���� 
//    if (e.i == n)                
//    {
//        //�ҵ������ֵ�Ľ� 
//        if (e.v > bestv)        
//        {
//            bestv = e.v;
//            for (int j = 1; j <= n; j++)
//            {
//                bestx[j] = e.x[j];
//            }
//        }
//    }
//    //��Ҷ�ӽ�����
//    else qu.push(e);        
//}
//// �����������
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
//        //���ӽ��e 
//        e = qu.front(); qu.pop();   
//        //��֦��������ӽ�� 
//        if (e.w + w[e.i + 1] <= c)
//        {
//            //�������ӽ�� 
//            e1.no = total++;
//            e1.i = e.i + 1;
//            e1.w = e.w + w[e1.i];
//            e1.v = e.v + v[e1.i];
//            for (j = 1; j <= n; j++)
//                e1.x[j] = e.x[j];
//            e1.x[e1.i] = 1;
//            //�����ӵ��Ͻ� 
//            bound(e1);
//            //���ӽ����� 
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
//        //���Һ��ӽ����У�����ӣ����򱻼�֦ 
//        if (e2.ub > bestv)
//        {
//            enqueue(e2, qu);
//        }
//    }
//}
//
//void get_result()
//{
//    cout << "����ֵ��:" << bestv << endl;
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
//    cout << "������" << endl;
//    cin >> n;
//    cout << "ÿ����Ʒ��weight value:" << endl;
//    for (int i = 1; i <= n; i++)
//    {
//        cin >> w[i] >> v[i];
//    }
//    cout << "������" << endl;
//    cin >> c;
//    bfs();
//    get_result();
//    return 0;
//}