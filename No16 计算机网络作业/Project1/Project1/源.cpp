//// Ԥ��������
//#include "iostream"
//#include "stdlib.h"
//
//using namespace std;
//
//#define FALSE 0
//#define TRUE 1
//#define OK   1
//#define ERROR 0
//#define Null 0
//#define OVERFLOW -2
//#define INFESDIBLE -1
//typedef int Status;
////����ħ��״̬�ڵ�
//typedef struct QElemType
//{
//	string M_front[4], M_back[4], M_top[4], M_buttom[4], M_left[4], M_right[4];	//����ħ���������ɫƬ
//	QNode* father;		//���常״̬�ڵ�
//	string str = "";			//���常״̬�ڵ㵽��ǰ�ڵ������Ķ������ơ�
//}QElemType;
////������еĽڵ�
//typedef struct QNode
//{
//	QElemType data;
//	QNode* next;
//}QNode, * QueuePtr;
//
//typedef struct
//{
//	QueuePtr front;
//	QueuePtr rear;
//}LinkQueue;
//
////����1������ħ��������90�ȶ���
//QNode Left_Up_One(QNode qnode)
//{
//	QNode newNode;
//	newNode.data.str = "\n����90��";
//	newNode.data.father = &qnode;
//	//��ʱ����ǰ���0��2������ɫƬ������0��ɫƬ�����ڽ���
//	string temp[3];
//	temp[0] = qnode.data.M_front[0];
//	temp[1] = qnode.data.M_front[2];
//	temp[2] = qnode.data.M_left[0];
//	//ǰ��temp���׵�ǰ���󵽵ף��ϵ���temp��ǰ
//	newNode.data.M_front[0] = qnode.data.M_buttom[0];
//	newNode.data.M_front[2] = qnode.data.M_buttom[2];
//	newNode.data.M_buttom[0] = qnode.data.M_back[0];
//	newNode.data.M_buttom[2] = qnode.data.M_back[2];
//	newNode.data.M_back[0] = qnode.data.M_top[0];
//	newNode.data.M_back[2] = qnode.data.M_top[2];
//	newNode.data.M_top[0] = temp[0];
//	newNode.data.M_top[2] = temp[1];
//	//����4��ɫƬ������1��0��2��1��3��2��0��3
//	newNode.data.M_left[0] = qnode.data.M_left[1];
//	newNode.data.M_left[1] = qnode.data.M_left[2];
//	newNode.data.M_left[2] = qnode.data.M_left[3];
//	newNode.data.M_left[3] = temp[2];
//
//	return newNode;
//}
//
//int main()
//{
//	QNode testNode;
//	cout << "a";
//	return 0;
//}