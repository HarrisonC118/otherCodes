//#include<stdio.h>
//#define N 100
//
//double INF = 1e7;//����������ֵΪ10���ߴη�
//int g[N][N];//��ͼ�������Ȩ�ڽӾ���
//int x[N];//��¼��ǰ·��
//int bestx[N];//��¼��ǰ����·��
//int cl;//��ǰ·������
//int bestl;//��ǰ���·������
//int n, m;//���и���n,����m
//void swap(int array[], int a, int b) {//��������
//    int temp;
//    temp = array[a];
//    array[a] = array[b];
//    array[b] = temp;
//}
//void Traveling(int t) {
//    if (t > n) {//����Ҷ�ӽڵ�
//        /*
//        ������������һ��������ס�س����б���������·�����ȱȵ�ǰ����ֵС��˵���ҵ���һ�����õ�·������¼�����Ϣ
//         */
//        if (g[x[n]][1] != INF && (cl + g[x[n]][1] < bestl)) {
//            for (int j = 1; j <= n; j++) {
//                bestx[j] = x[j];
//            }
//            bestl = cl + g[x[n]][1];
//        }
//    }
//    else {//û�е���Ҷ�ӽڵ�
//        for (int j = t; j <= n; j++) {//������չ�ڵ�����з�֧
//            if (g[x[t - 1]][x[j]] != INF && (cl + g[x[t - 1]][x[j]] < bestl)) {//�����t-1���������t�������б����������п��ܵõ����̵�·��
//                swap(x, t, j);//��������Ԫ�ص�ֵ
//                cl = cl + g[x[t - 1]][x[t]];
//                Traveling(t + 1);//�ӵ�t+1�����չ����������
//                //��t+1��������ϣ����ݵ���t��
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
//    printf("���·��");
//    for (int i = 1; i <= n; i++) {
//        printf("%d---->", bestx[i]);
//    }
//    printf("1", bestl);
//    printf("\n���·������ %d\n", bestl);
//}
//void main() {
//    int u, v, w;//u,v������У�w�������u,v֮��ľ��롣
//    printf("�����������n��");
//    scanf_s("%d", &n);
//    init();
//    printf("���������֮�����������");
//    scanf_s("%d", &m);
//    printf("������������������u,v�Լ�֮��ľ���w:\n");
//    for (int i = 1; i <= m; i++) {
//        scanf_s("%d", &u);
//        scanf_s("%d", &v);
//        scanf_s("%d", &w);
//        g[u][v] = g[v][u] = w;
//    }
//    Traveling(2);//�����������ͼ���ӵڶ��㿪ʼ
//    print();
//}