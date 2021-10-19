//// Ԥ��������
//#include "iostream"
//#include "stdlib.h"
//using namespace std;
//
////���̴�С
//#define size 3
//
////�����ά�������洢���ݱ�ʾĳһ���ض�״̬
//typedef int status[size][size];
//
////����״̬ͼ�еĽڵ����ݽṹ�����ڵ��״̬��Ϣ��
//typedef struct Node
//{
//	status data;					//�ڵ����洢��״̬
//	struct Node* parent;			//ָ��ڵ�ĸ��׽ڵ�
//	struct SpringLink* child;		//ָ��ڵ�ĺ�̽ڵ�
//	struct Node* next;			    //ָ������ĺ�һ���ڵ�
//	int f_value;					//�ɳ�ʼ״̬���ɵ�ǰ�ڵ���Ŀ��״̬���ܺ�ɢֵ
//	int g_value;					//�ɳ�ʼ״̬������ǰ�ڵ�ʵ�ʺ�ɢֵ
//	int h_value;					//�ɵ�ǰ�ڵ㵽Ŀ��״̬��Ԥ�ƺ�ɢֵ
//}NNode, * PNode;
//
//
////�������ָ��ǰ�ڵ����չ�ڵ������
//typedef struct SpringLink
//{
//	struct Node* pointData;		//ָ��ڵ��ָ��
//	struct SpringLink* next;		//ָ��ǰ�ڵ��������չ�ڵ�
//}SPLink, * PSPLink;
//
////����OPEN���CLOSED��
//PNode open;
//PNode closed;
//
////��������״̬��������
//int InverseNumber(status a)
//{
//	int i, j, sum = 0;
//	int data_chang[size * size] = { 0 };
//
//	//����ά����ת����һά���飬�Է�����������
//	for (i = 0; i < size; i++)
//	{
//		for (j = 0; j < size; j++)
//		{
//			data_chang[i * size + j] = a[i][j];
//		}
//	}
//
//
//	//���������г������������
//	for (i = 0; i <= size * size; i++)
//	{
//		if (data_chang[i] != 0)
//		{
//			//Ҫ�Ƚ϶��ٴ�,�����һ��Ԫ�ؿ�ʼ�Ƚ�
//			for (j = i; j >= 0; j--)
//			{
//				//����һ������ǰһ����Сʱ
//				if (data_chang[i] < data_chang[j])
//				{
//					sum++;
//				}
//			}
//		}
//	}
//	return sum;
//}
//
////�ж��Ƿ���ڽ������
//bool hasSolution(status startStatus, status targetStatus)
//{
//	int startInverseNumber = InverseNumber(startStatus);
//	int tatgetInverseNumber = InverseNumber(targetStatus);
//
//	//�жϳ�ʼ״̬��Ŀ��״̬�������������������ż�ԣ���ͬ�����ֵ����ͬ�򲻿���
//	if ((startInverseNumber % 2) != (tatgetInverseNumber % 2))
//	{
//		return false;
//	}
//	else
//	{
//		return true;
//	}
//}
//
//
////��ʼ��һ��������
//void initLink(PNode& Head)
//{
//	Head = (PNode)malloc(sizeof(NNode));
//	Head->next = NULL;
//}
//
//
////�ж������Ƿ�Ϊ��
//bool isEmpty(PNode Head)
//{
//	if (Head->next == NULL)
//	{
//		return true;
//	}
//	else
//	{
//		return false;
//	}
//}
//
//
////���������ó�һ������
//void popNode(PNode& Head, PNode& FNode)
//{
//	if (isEmpty(Head))
//	{
//		FNode = NULL;
//		return;
//	}
//	FNode = Head->next;
//	Head->next = Head->next->next;
//	FNode->next = NULL;
//}
//
////��ڵ�����պ�̽ڵ�����������µ��ӽڵ�
//void addSpringNode(PNode& Head, PNode newData)
//{
//	PSPLink newNode = (PSPLink)malloc(sizeof(SPLink));
//	newNode->pointData = newData;
//
//	newNode->next = Head->child;
//	Head->child = newNode;
//}
//
////�ͷ�״̬ͼ�д�Žڵ��̽ڵ��ַ�Ŀռ�
//void freeSpringLink(PSPLink& Head)
//{
//	PSPLink tmm;
//
//	while (Head != NULL)
//	{
//		tmm = Head;
//		Head = Head->next;
//		free(tmm);
//	}
//}
//
////�ͷ�open����closed���е���Դ
//void freeLink(PNode& Head)
//{
//	PNode tmn;
//
//	tmn = Head;
//	Head = Head->next;
//	free(tmn);
//
//	while (Head != NULL)
//	{
//		//�����ͷŴ�Žڵ��̽ڵ��ַ�Ŀռ�
//		freeSpringLink(Head->child);
//		tmn = Head;
//		Head = Head->next;
//		free(tmn);
//	}
//}
//
////����ͨ���������һ���ڵ�
//void addNode(PNode& Head, PNode& newNode)
//{
//	newNode->next = Head->next;
//	Head->next = newNode;
//}
//
////��ǵݼ����е����������һ���ڵ�
//void addAscNode(PNode& Head, PNode& newNode)
//{
//	PNode P;
//	PNode Q;
//
//	P = Head->next;
//	Q = Head;
//	while (P != NULL && P->f_value < newNode->f_value)
//	{
//		Q = P;
//		P = P->next;
//	}
//	//�����жϺ�λ��֮��������Ǽ򵥵Ĳ���ڵ���
//	newNode->next = Q->next;
//	Q->next = newNode;
//}
//
////����ڵ㵽Ŀ��״̬��Ԥ�ƺ�ɢֵ
//int computeh_value(PNode theNode, status targetStatus)
//{
//	int num = 0;
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 3; j++)
//		{
//			if (theNode->data[i][j] != targetStatus[i][j])
//			{
//				num++;
//			}
//		}
//	}
//	return num;
//}
//
////����ڵ��f��g��hֵ
//void computeAllValue(PNode& theNode, PNode parentNode, status targetStatus)
//{
//	if (parentNode == NULL)
//	{
//		theNode->g_value = 0;
//	}
//	else
//	{
//		theNode->g_value = parentNode->g_value + 1;
//	}
//
//	theNode->h_value = computeh_value(theNode, targetStatus);
//	theNode->f_value = theNode->g_value + theNode->h_value;
//}
//
////��ʼ�������������㷨��ʼ����������
//void initial(status startStatus, status targetStatus)
//{
//	//��ʼ��open�Լ�closed��
//	initLink(open);
//	initLink(closed);
//
//	//��ʼ����ʼ�ڵ㣬���ʼ�ڵ�ĸ��ڵ�Ϊ�սڵ�
//	PNode NULLNode = NULL;
//	PNode StartNode = (PNode)malloc(sizeof(NNode));
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 3; j++)
//		{
//			StartNode->data[i][j] = startStatus[i][j];
//		}
//	}
//	StartNode->parent = NULL;
//	StartNode->child = NULL;
//	StartNode->next = NULL;
//	computeAllValue(StartNode, NULLNode, targetStatus);
//
//	//��ʼ�ڵ����OPEN��
//	addAscNode(open, StartNode);
//}
//
////��B�ڵ��״̬��ֵ��A�ڵ�
//void statusAEB(PNode& ANode, PNode BNode)
//{
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 3; j++)
//		{
//			ANode->data[i][j] = BNode->data[i][j];
//		}
//	}
//}
//
//
////�����ڵ��Ƿ�����ͬ��״̬
//bool hasSameStatus(PNode ANode, PNode BNode)
//{
//	for (int i = 0; i < size; i++)
//	{
//		for (int j = 0; j < size; j++)
//		{
//			if (ANode->data[i][j] != BNode->data[i][j])
//				return false;
//		}
//	}
//	return true;
//}
//
////�ڵ��������Ƚڵ��Ƿ�����ͬ��״̬
//bool hasAnceSameStatus(PNode OrigiNode, PNode AnceNode)
//{
//	while (AnceNode != NULL)
//	{
//		if (hasSameStatus(OrigiNode, AnceNode))
//			return true;
//		AnceNode = AnceNode->parent;
//	}
//	return false;
//}
//
////ȡ�÷����пյĸ��ӵ�λ��
//void getPosition(PNode theNode, int& row, int& col)
//{
//	for (int i = 0; i < size; i++)
//	{
//		for (int j = 0; j < size; j++)
//		{
//			if (theNode->data[i][j] == 0)
//			{
//				row = i;
//				col = j;
//				return;
//			}
//		}
//	}
//}
//
////�����������ֵ�ֵ
//void changeAB(int& a, int& b)
//{
//	int c;
//	c = b;
//	b = a;
//	a = c;
//}
//
////�����Ӧ��״̬�Ƿ���ĳһ��������
//bool inLink(PNode spciNode, PNode theLink, PNode& theNodeLink, PNode& preNode)
//{
//	preNode = theLink;
//	theLink = theLink->next;
//
//	while (theLink != NULL)
//	{
//		if (hasSameStatus(spciNode, theLink))
//		{
//			theNodeLink = theLink;
//			return true;
//		}
//		preNode = theLink;
//		theLink = theLink->next;
//	}
//	return false;
//}
//
////�����ڵ�ĺ�̽ڵ�����
//void SpringLink(PNode theNode, PNode& spring, status targetStatus)
//{
//	int row;
//	int col;
//
//	getPosition(theNode, row, col);
//
//	//�յĸ����ұߵĸ��������ƶ�
//	if (col != 2)
//	{
//		PNode rlNewNode = (PNode)malloc(sizeof(NNode));
//		statusAEB(rlNewNode, theNode);
//		changeAB(rlNewNode->data[row][col], rlNewNode->data[row][col + 1]);
//		if (hasAnceSameStatus(rlNewNode, theNode->parent))
//		{
//			free(rlNewNode);//�븸����ͬ���������ڵ�
//		}
//		else
//		{
//			rlNewNode->parent = theNode;
//			rlNewNode->child = NULL;
//			rlNewNode->next = NULL;
//			computeAllValue(rlNewNode, theNode, targetStatus);
//			//�����ڵ�����̽ڵ�����
//			addNode(spring, rlNewNode);
//		}
//	}
//	//�յĸ�����ߵĸ��������ƶ�
//	if (col != 0)
//	{
//		PNode lrNewNode = (PNode)malloc(sizeof(NNode));
//		statusAEB(lrNewNode, theNode);
//		changeAB(lrNewNode->data[row][col], lrNewNode->data[row][col - 1]);
//		if (hasAnceSameStatus(lrNewNode, theNode->parent))
//		{
//			free(lrNewNode);//�븸����ͬ���������ڵ�
//		}
//		else
//		{
//			lrNewNode->parent = theNode;
//			lrNewNode->child = NULL;
//			lrNewNode->next = NULL;
//			computeAllValue(lrNewNode, theNode, targetStatus);
//			//�����ڵ�����̽ڵ�����
//			addNode(spring, lrNewNode);
//		}
//	}
//	//�յĸ����ϱߵĸ��������ƶ�
//	if (row != 0)
//	{
//		PNode udNewNode = (PNode)malloc(sizeof(NNode));
//		statusAEB(udNewNode, theNode);
//		changeAB(udNewNode->data[row][col], udNewNode->data[row - 1][col]);
//		if (hasAnceSameStatus(udNewNode, theNode->parent))
//		{
//			free(udNewNode);//�븸����ͬ���������ڵ�
//		}
//		else
//		{
//			udNewNode->parent = theNode;
//			udNewNode->child = NULL;
//			udNewNode->next = NULL;
//			computeAllValue(udNewNode, theNode, targetStatus);
//			//�����ڵ�����̽ڵ�����
//			addNode(spring, udNewNode);
//		}
//	}
//	//�յĸ����±ߵĸ��������ƶ�
//	if (row != 2)
//	{
//		PNode duNewNode = (PNode)malloc(sizeof(NNode));
//		statusAEB(duNewNode, theNode);
//		changeAB(duNewNode->data[row][col], duNewNode->data[row + 1][col]);
//		if (hasAnceSameStatus(duNewNode, theNode->parent))
//		{
//			free(duNewNode);//�븸����ͬ���������ڵ�
//		}
//		else
//		{
//			duNewNode->parent = theNode;
//			duNewNode->child = NULL;
//			duNewNode->next = NULL;
//			computeAllValue(duNewNode, theNode, targetStatus);
//			//�����ڵ�����̽ڵ�����
//			addNode(spring, duNewNode);
//		}
//	}
//}
//
////��������ڵ��״̬
//void outputStatus(PNode stat)
//{
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 3; j++)
//		{
//			cout << stat->data[i][j] << " ";
//		}
//		cout << endl;
//	}
//}
//
////�����ѵ�·��
//void outputBestRoad(PNode goal)
//{
//	int deepnum = goal->g_value;
//
//	if (goal->parent != NULL)
//	{
//		outputBestRoad(goal->parent);
//	}
//	cout << "��" << deepnum-- << "����״̬��" << endl;
//	outputStatus(goal);
//}
//
//
//void AStar(status startStatus, status targetStatus)
//{
//	PNode tmpNode;						//ָ���open�����ó����ŵ�closed���еĽڵ��ָ��
//	PNode spring;						//tmpNode�ĺ�̽ڵ���
//	PNode tmpLNode;						//tmpNode��ĳһ����̽ڵ�
//	PNode tmpChartNode;
//	PNode thePreNode;					//ָ��Ҫ��closed�����Ƶ�open���еĽڵ��ǰһ���ڵ��ָ��
//	bool getGoal = false;				//��ʶ�Ƿ�ﵽĿ��״̬
//	long numcount = 1;					//��¼��open�����ó��ڵ�����
//	
//	initial(startStatus, targetStatus);	//�Ժ������г�ʼ��
//	initLink(spring);					//�Ժ������ĳ�ʼ��
//	tmpChartNode = NULL;
//
//	cout << "��OPEN�����ó��Ľڵ��״̬����Ӧ��ֵ" << endl;
//	while (!isEmpty(open))
//	{
//		//��OPEN�����ó�fֵ��С��Ԫ��,�����ó���Ԫ�ط���CLOSED����
//		popNode(open, tmpNode);
//		addNode(closed, tmpNode);
//
//
//		cout << "��" << numcount++ << "��״̬�ǣ�" << endl;
//		outputStatus(tmpNode);
//		cout << "��fֵΪ��" << tmpNode->f_value << endl;
//		cout << "��gֵΪ��" << tmpNode->g_value << endl;
//		cout << "��hֵΪ��" << tmpNode->h_value << endl;
//
//
//		//����ó���Ԫ����Ŀ��״̬������ѭ��
//		if (computeh_value(tmpNode, targetStatus) == 0)
//		{
//			getGoal = true;
//			break;
//		}
//
//		//������ǰ���ڵ�ĺ��(�����Ȳ�ͬ)�ڵ��б������ĺ�̽ڵ��parent����ָ��ǰ���Ľڵ�
//		SpringLink(tmpNode, spring, targetStatus);
//
//		//�������ڵ�ĺ�̽ڵ�����
//		while (!isEmpty(spring))
//		{
//			popNode(spring, tmpLNode);
//			//״̬��OPEN�����Ѿ����ڣ�thePreNode���������ﲢ��������
//			if (inLink(tmpLNode, open, tmpChartNode, thePreNode))
//			{
//				addSpringNode(tmpNode, tmpChartNode);
//				if (tmpLNode->g_value < tmpChartNode->g_value)
//				{
//					tmpChartNode->parent = tmpLNode->parent;
//					tmpChartNode->g_value = tmpLNode->g_value;
//					tmpChartNode->f_value = tmpLNode->f_value;
//				}
//				free(tmpLNode);
//			}
//			//״̬��CLOSED�����Ѿ�����
//			else if (inLink(tmpLNode, closed, tmpChartNode, thePreNode))
//			{
//				addSpringNode(tmpNode, tmpChartNode);
//				if (tmpLNode->g_value < tmpChartNode->g_value)
//				{
//					PNode commu;
//					tmpChartNode->parent = tmpLNode->parent;
//					tmpChartNode->g_value = tmpLNode->g_value;
//					tmpChartNode->f_value = tmpLNode->f_value;
//					freeSpringLink(tmpChartNode->child);
//					tmpChartNode->child = NULL;
//					popNode(thePreNode, commu);
//					addAscNode(open, commu);
//				}
//				free(tmpLNode);
//			}
//			//�µ�״̬����״̬�Ȳ���OPEN����Ҳ����CLOSED����
//			else
//			{
//				addSpringNode(tmpNode, tmpLNode);
//				addAscNode(open, tmpLNode);
//			}
//		}
//	}
//
//	//Ŀ��ɴ�Ļ��������ѵ�·��
//	if (getGoal)
//	{
//		cout << endl;
//		//cout << "·������Ϊ��" << tmpNode->g_value << endl;
//		/*outputBestRoad(tmpNode);*/
//	}
//
//	//�ͷŽڵ���ռ���ڴ�
//	freeLink(open);
//	freeLink(closed);
//}
//
//int main()
//{
//	//��ʼ״̬��Ŀ��״̬
//	status startStatus = { 2, 8, 3, 1, 6, 4, 7, 0, 5 };
//	status targetStatus = { 1, 2, 3, 8, 0, 4, 7, 6, 5 };
//	if (hasSolution(startStatus, targetStatus))
//	{
//		AStar(startStatus, targetStatus);
//	}
//	else
//	{
//		cout << "�ӵ�ǰ����ĳ�ʼ״̬�޷��������޲����任����������Ŀ��״̬��" << endl;
//	}
//	return 0;
//}
//
//
//
