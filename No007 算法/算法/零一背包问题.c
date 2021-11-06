//#include<stdio.h>
//#define max 100
//
//int weight[max];
//int value[max];
//int n, max_weight, max_value;
//
//int best_answer[max], answer[max];
//
//void print()
//{
//	printf("最大的价值是%d\n", max_value);
//	for (int i = 1; i <= n; i++) {
//		printf("%d ", best_answer[i]);
//	}
//	printf("\n");
//}
//
//void DFS(int level, int current_weight, int current_value)
//{
//	if (level >= n + 1) {
//		if (current_value > max_value) {
//			int i;
//			max_value = current_value;
//			for (i = 1; i <= n; i++) {
//				best_answer[i] = answer[i];
//			}
//		}
//	}
//	else {
//		if (current_weight >= weight[level + 1]) {
//			current_weight = current_weight - weight[level + 1];
//			current_value = current_value + value[level + 1];
//			answer[level + 1] = 1;
//			DFS(level + 1, current_weight, current_value);
//			answer[level + 1] = 0;
//			current_weight = current_weight + weight[level + 1];
//			current_value = current_value - value[level + 1];
//		}
//		DFS(level + 1, current_weight, current_value);
//	}
//}
//
//void init()
//{
//	max_value = 0;
//	for (int i = 1; i <= n; i++) {
//		answer[i] = 0;
//	}
//}
//
//int main()
//{
//	printf("请输入背包容量和最大重量：");
//	scanf_s("%d%d", &n, &max_weight);
//	printf("请输入对应的重量：");
//	for (int i = 1; i <= n; i++) {
//		scanf_s("%d", &weight[i]);
//	}
//	printf("请输入对应的价值：");
//	for (int j = 1; j <= n; j++) {
//		scanf_s("%d", &value[j]);
//	}
//	init();
//	DFS(0, max_weight, 0);
//	print();
//	return 0;
//
//}