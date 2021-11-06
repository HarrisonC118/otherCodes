//#include <stdio.h>
//int index = 0; //解的数量
//int main()
//{
//    int sudoku[9][9] = {
//	{1,0,0,5,0,0,0,8,0},
//	{2,0,3,0,0,0,1,5,0},
//	{0,0,0,0,2,0,0,0,3},
//	{0,6,4,9,0,0,0,0,0},
//	{0,0,0,0,3,0,0,0,0},
//	{0,0,0,0,0,4,2,9,0},
//	{8,0,0,0,1,0,0,0,0},
//    {0,3,9,0,0,0,6,0,8},
//	{0,1,0,0,0,7,0,0,5}
//};
//    void Sudoku(int a[9][9], int n);
//    Sudoku(sudoku, 0);
//    return 0;
//}
//void print(int a[9][9])
//{
//    for (int i = 0; i < 9; i++)
//    {
//        for (int j = 0; j < 9; j++)
//        {
//            printf("%d ", a[i][j]);
//            if ((j == 2) || (j == 5))
//                printf(" ");
//        }
//        printf("\n");
//        if ((i == 2) || (i == 5))
//            printf("\n");
//    }
//    printf("-------------------");
//    printf("\n");
//}
//
//int isValid(int sudoku[9][9], int y, int x, int num) {
//    // 左上角坐标
//    int l_t_x = (x / 3) * 3;
//    int l_t_y = (y / 3) * 3;
//    // 右下角的坐标
//    int r_t_x = l_t_x + 2;
//    int r_t_y = l_t_y + 2;
//    // printf("左上角坐标：(%d, %d), 右下角坐标：(%d, %d)\n", l_t_y, l_t_x, r_t_y, r_t_x);
//    // 判断行有没有重复
//    for (int i = 0; i < 9; i++) {
//        // 被比较的值
//        int index = sudoku[y][i];
//        if (num == index) {
//            return 0;
//        }
//    }
//    // 判断列有没有重复
//    for (int i = 0; i < 9; i++) {
//        // 被比较的值
//        int index = sudoku[i][x];
//        if (num == index) {
//            return 0;
//        }
//    }
//    // 判断方块有没有重复
//    for (int i = l_t_y; i <= r_t_y; i++) {
//        for (int j = l_t_x; j <= r_t_x; j++) {
//            int index = sudoku[i][j];
//            if (num == index) {
//                return 0;
//            }
//        }
//    }
//    return 1;
//}
////数独求解函数
//void Sudoku(int a[9][9], int n)
//{
//    // 临时数组
//    int temp[9][9];
//    int i, j;
//    for (i = 0; i < 9; i++) {
//        for (j = 0; j < 9; j++)
//            temp[i][j] = a[i][j];
//    }
//    i = n / 9; 
//    j = n % 9; 
//
//    if (a[i][j] != 0)
//    {
//        if (n == 80)
//            print(temp);
//        else
//            Sudoku(temp, n + 1);
//    } else {
//        for (int k = 1; k <= 9; k++) {
//            int flag = isValid(temp, i, j, k);
//            if (flag){
//                temp[i][j] = k;
//                if (n == 80)
//                    print(temp);
//                else
//                    Sudoku(temp, n + 1);
//                temp[i][j] = 0;
//            }
//        }
//    }
//}