//#include <iostream>
//using namespace std;
//int dp_result(int arr1[], int arr2[]) {
//	int dp[6][5] = { 0 };
//
//	for (int i = 1; i <= 5; i++) {
//		for (int j = 1; j <= 4; j++) {
//			if (arr1[i-1] == arr2[j-1]) {
//				dp[i][j] = dp[i - 1][j - 1] + 1;
//			}
//			else {
//				dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
//			}
//		}
//	}
//	return dp[5][4];
//}
//int main() {
//	int arr1[5] = { 1,4,5,9,10 };
//	int arr2[4] = { 1,4,9,10 };
//	cout << "序列{ 1,4,5,9,10 }和{ 1,4,9,10 }的最长子序列的长度是：";
//	cout << dp_result(arr1, arr2) << endl;
//	return 0;
//}