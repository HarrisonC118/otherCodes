//// 预编译命令
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
////定义魔方状态节点
//typedef struct QElemType
//{
//	string M_front[4], M_back[4], M_top[4], M_buttom[4], M_left[4], M_right[4];	//定义魔方六个面的色片
//	QNode* father;		//定义父状态节点
//	string str = "";			//定义父状态节点到当前节点所作的动作名称。
//}QElemType;
////定义队列的节点
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
////动作1：定义魔方的左上90度动作
//QNode Left_Up_One(QNode qnode)
//{
//	QNode newNode;
//	newNode.data.str = "\n左上90度";
//	newNode.data.father = &qnode;
//	//临时保存前面的0、2号两个色片和左侧的0号色片，用于交换
//	string temp[3];
//	temp[0] = qnode.data.M_front[0];
//	temp[1] = qnode.data.M_front[2];
//	temp[2] = qnode.data.M_left[0];
//	//前到temp，底到前，后到底，上到后，temp到前
//	newNode.data.M_front[0] = qnode.data.M_buttom[0];
//	newNode.data.M_front[2] = qnode.data.M_buttom[2];
//	newNode.data.M_buttom[0] = qnode.data.M_back[0];
//	newNode.data.M_buttom[2] = qnode.data.M_back[2];
//	newNode.data.M_back[0] = qnode.data.M_top[0];
//	newNode.data.M_back[2] = qnode.data.M_top[2];
//	newNode.data.M_top[0] = temp[0];
//	newNode.data.M_top[2] = temp[1];
//	//侧面4个色片交换，1到0，2到1，3到2，0到3
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