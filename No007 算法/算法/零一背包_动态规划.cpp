//#include<iostream>
//using namespace std;
//int lingyi_result(int values[], int weights[], int capacity) {
//	int dp[6][11] = { 0 };
//	// i��ʾǰi��
//	// j��ʾ����
//	for (int i = 1; i <= 5; i++) {
//		for (int j = 1; j <= capacity; j++) {
//			if (weights[i] > j) {
//				dp[i][j] = dp[i - 1][j];
//			}
//			else {
//				dp[i][j] = dp[i - 1][j] > dp[i - 1][j - weights[i - 1]] + values[i- 1] ? dp[i - 1][j] : dp[i - 1][j - weights[i - 1]] + values[i - 1];
//			}
//		}
//	}
//	return dp[5][capacity];
//}
//int main() {
//	int values[] = { 6,3,5,4,6 };
//	int weights[] = { 2,2,6,5,4 };
//	int capacity = 10;
//	cout << "���ļ�ֵ�ǣ�" << lingyi_result(values, weights, capacity);
//	return 0;
//}