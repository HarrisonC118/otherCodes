//#include<stdio.h>
//#define occupied 1
//#define not_occupied 0
//
//int queen_square[20][20] = { not_occupied };
//int size;
//int answer_num = 1;
//
//
//// 能不能放
//int unguarded(int row, int col);
//// 打印期盼
//void print();
//// 求解
//void solve(int row);
//
//
//int unguarded(int row, int col)
//{
//    int ok = 1;
//    int i = 0;
//    // 列
//    for (i = 0; i < size && ok; i++)
//    {
//        if (queen_square[i][col] == occupied)
//            ok = 0;
//    }
//    // ↖
//    for (i = 1; row + i < size && col + i < size && ok; i++)
//    {
//        if (queen_square[row + i][col + i] == occupied)
//            ok = 0;
//    }
//    // ↘
//    for (i = 1; row + i < size && col - i >= 0 && ok; i++)
//    {
//        if (queen_square[row + i][col - i] == occupied)
//            ok = 0;
//    }
//    return ok;
//}
//
//void print()
//{
//    printf("第 %d 个解是:\n\n", answer_num++);
//    for (int i = 0; i < size; i++)
//    {
//        for (int j = 0; j < size; j++)
//        {
//            if (queen_square[i][j] == occupied)
//                printf(" O ");
//            else printf(" + ");
//        }
//        printf("\n\n");
//    }
//    printf("\n\n");
//}
//
//void solve(int row)
//{
//    if (row < 0) {
//        print();
//    }
//    else {
//        for (int i = 0; i < size; i++)
//            if (unguarded(row, i))
//            {
//                queen_square[row][i] = occupied;
//                solve(row - 1);
//                queen_square[row][i] = not_occupied;
//            }
//    }
//}
//
//int main() {
//    printf("请输入n是几：");
//    scanf_s("%d", &size);
//    solve(size - 1);
//    return 0;
//}
