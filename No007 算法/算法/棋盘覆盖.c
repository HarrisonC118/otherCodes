#include <stdio.h>
#include <stdlib.h>

#define SIZE 8

static int title = 1;    //title��ʾL�͹��Ƶı��
static int board[SIZE][SIZE];

/**
 * ���̸���
 * @param begin_y_index��ʾ�������Ͻ��к�
 * @param begin_x_index��ʾ�������Ͻ��к�
 * @param obstacle_y_index��ʾ�������̵��к�
 * @param obstacle_x_index��ʾ�������̵��к�
 * @param size = 2^k
 * 
 * ˳��  1 2
 *         3 4
 **/

void ChessBoard(int begin_y_index, int begin_x_index, int obstacle_y_index, int obstacle_x_index, int size) {
    if (1 == size){
        return;
    }

    int t = title++;    //L�͹��ƺ�
    int s = size / 2;    //�ָ�����

    //�������Ͻ�������
    if (obstacle_y_index < begin_y_index + s && obstacle_x_index < begin_x_index + s) {
        //���ⷽ���ڴ�������
        ChessBoard(begin_y_index, begin_x_index, obstacle_y_index, obstacle_x_index, s);
    } else {
        //�����������ⷽ��
        //��t��L�͹��Ƹ������½�
        board[begin_y_index + s - 1][begin_x_index + s - 1] = t;
        //�������෽��
        ChessBoard(begin_y_index, begin_x_index, begin_y_index + s - 1, begin_x_index + s - 1, s);
      }

    //�������Ͻ�
    if (obstacle_y_index < begin_y_index + s && obstacle_x_index >= begin_x_index + s)
    {
        //���ⷽ���ڴ�������
        ChessBoard(begin_y_index, begin_x_index + s, obstacle_y_index, obstacle_x_index, s);
    } else {
        //���������������ⷽ��
        //��t��L�͹��Ƹ������½�
        board[begin_y_index + s - 1][begin_x_index + s] = t;
        //�������෽��
        ChessBoard(begin_y_index, begin_x_index + s, begin_y_index + s - 1, begin_x_index + s, s);
      }

    //�������½�������
    if (obstacle_y_index >= begin_y_index + s && obstacle_x_index < begin_x_index + s)
    {
        //���ⷽ���ڴ�������
        ChessBoard(begin_y_index + s, begin_x_index, obstacle_y_index, obstacle_x_index, s);
    } else {
        //��t��L�͹��Ƹ������Ͻ�
        board[begin_y_index + s][begin_x_index + s - 1] = t;
        //�������෽��
        ChessBoard(begin_y_index + s, begin_x_index, begin_y_index + s, begin_x_index + s - 1, s);
      }

    //�������½�������
    if (obstacle_y_index >= begin_y_index + s && obstacle_x_index >= begin_x_index + s) {
        //���ⷽ���ڴ�������
        ChessBoard(begin_y_index + s, begin_x_index + s, obstacle_y_index, obstacle_x_index, s);
    } else {
        //��t��L�͹��Ƹ������Ͻ�
        board[begin_y_index + s][begin_x_index + s] = t;
        //�������෽��
        ChessBoard(begin_y_index + s, begin_x_index + s, begin_y_index + s, begin_x_index + s, s);
      }
}

//��ӡ
void ChessPrint() {
    int i;
    int j;
    for (i = 0; i < SIZE; i++) {
        for (j = 0; j < SIZE; j++) {
            printf("%2d ", board[i][j]);
        }
        printf("\n");
    }
}

//int main() {
//    //������ԣ��������ⷽ��λ���ڵ����е�����
//    ChessBoard(0, 0, 2, 2, SIZE);
//    ChessPrint();
//    return 0;
//}