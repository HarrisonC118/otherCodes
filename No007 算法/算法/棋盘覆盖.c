#include <stdio.h>
#include <stdlib.h>

#define SIZE 8

static int title = 1;    //title表示L型骨牌的编号
static int board[SIZE][SIZE];

/**
 * 棋盘覆盖
 * @param begin_y_index表示棋盘左上角行号
 * @param begin_x_index表示棋盘左上角列号
 * @param obstacle_y_index表示特殊棋盘的行号
 * @param obstacle_x_index表示特殊棋盘的列号
 * @param size = 2^k
 * 
 * 顺序：  1 2
 *         3 4
 **/

void ChessBoard(int begin_y_index, int begin_x_index, int obstacle_y_index, int obstacle_x_index, int size) {
    if (1 == size){
        return;
    }

    int t = title++;    //L型骨牌号
    int s = size / 2;    //分割棋盘

    //覆盖左上角子棋盘
    if (obstacle_y_index < begin_y_index + s && obstacle_x_index < begin_x_index + s) {
        //特殊方格在此棋盘中
        ChessBoard(begin_y_index, begin_x_index, obstacle_y_index, obstacle_x_index, s);
    } else {
        //此棋盘无特殊方格
        //用t号L型骨牌覆盖右下角
        board[begin_y_index + s - 1][begin_x_index + s - 1] = t;
        //覆盖其余方格
        ChessBoard(begin_y_index, begin_x_index, begin_y_index + s - 1, begin_x_index + s - 1, s);
      }

    //覆盖右上角
    if (obstacle_y_index < begin_y_index + s && obstacle_x_index >= begin_x_index + s)
    {
        //特殊方格在此棋盘中
        ChessBoard(begin_y_index, begin_x_index + s, obstacle_y_index, obstacle_x_index, s);
    } else {
        //此子棋盘中无特殊方格
        //用t号L型骨牌覆盖左下角
        board[begin_y_index + s - 1][begin_x_index + s] = t;
        //覆盖其余方格
        ChessBoard(begin_y_index, begin_x_index + s, begin_y_index + s - 1, begin_x_index + s, s);
      }

    //覆盖左下角子棋盘
    if (obstacle_y_index >= begin_y_index + s && obstacle_x_index < begin_x_index + s)
    {
        //特殊方格在此棋盘中
        ChessBoard(begin_y_index + s, begin_x_index, obstacle_y_index, obstacle_x_index, s);
    } else {
        //用t号L型骨牌覆盖右上角
        board[begin_y_index + s][begin_x_index + s - 1] = t;
        //覆盖其余方格
        ChessBoard(begin_y_index + s, begin_x_index, begin_y_index + s, begin_x_index + s - 1, s);
      }

    //覆盖右下角子棋盘
    if (obstacle_y_index >= begin_y_index + s && obstacle_x_index >= begin_x_index + s) {
        //特殊方格在此棋盘中
        ChessBoard(begin_y_index + s, begin_x_index + s, obstacle_y_index, obstacle_x_index, s);
    } else {
        //用t号L型骨牌覆盖左上角
        board[begin_y_index + s][begin_x_index + s] = t;
        //覆盖其余方格
        ChessBoard(begin_y_index + s, begin_x_index + s, begin_y_index + s, begin_x_index + s, s);
      }
}

//打印
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
//    //方便测试，假设特殊方格位置在第三行第三列
//    ChessBoard(0, 0, 2, 2, SIZE);
//    ChessPrint();
//    return 0;
//}