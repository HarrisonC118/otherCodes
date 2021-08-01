public class main {
    public static void main(String[] args) {
        System.out.println("--------------------------转换前数组--------------------------");
        int[][] arr = new int[11][11];
        arr[1][2] = 4;
        arr[2][3] = 8;
        arr[3][5] = 5;
        arr[0][1] = 7;
        for (int[] integers : arr) {
            for (int integer : integers) {
                System.out.print(integer + "   ");
            }
            System.out.println();
        }
        // 一、转换成稀疏数组
        /*
         * 1. 遍历二维数组找出一共有几个不为0的值
         * 2. 创建对应的稀疏数组
         * 3. 初始化第一行
         * 4. 再次遍历二维数组把对应的数据存到稀疏数组中
         *
         */
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    num++;
                }
            }
        }
        System.out.println("共有不同的数"+num+"个");
        System.out.println("--------------------------转换后数组--------------------------");
        int[][] sparseArr = new int[num +1][3]; // 创建稀疏数组
        sparseArr[0][0] = arr.length;// 初始化稀疏数组 有多少行
        sparseArr[0][1] = arr[1].length;// 初始化稀疏数组 有多少列
        sparseArr[0][2] = num;// 初始化稀疏数组 有多少个需要存储的数值
        int count = 1; // 创建一个计数器，稀疏数组的当前行存储完数据之后应该跳转到下一行存储下一条数据
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr [count][0] = i;
                    sparseArr [count][1] = j;
                    sparseArr [count][2] = arr[i][j];
                    count++;
                }
            }
        }
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }
        // 二、稀疏数组转化回去
        /*
         * 1. 创建二维数组
         * 2. 稀疏数组中的第0行的数值分别作为二维数组的行数和列数
         * 3. 把对应的值放到二维数组中
         *
         */
        System.out.println("--------------------------还原后数组--------------------------");
        int[][] originArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] integers : originArr) {
            for (int integer : integers) {
                System.out.print(integer + "   ");
            }
            System.out.println();
        }
    }
}
