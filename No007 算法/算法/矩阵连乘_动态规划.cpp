//#include<iostream>
//using namespace std;
//
//int matrix_result(int p[]) {
//	int n = 4;
//	int m[5][5] = { 0 };
//	int s[5][5] = { 0 };
//	for(int r = 2; r <= n; r++) {
//		for (int i = 1; i <= n - r + 1; i++) {
//			int j = i + r - 1;
//			m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
//			s[i][j] = i;
//			for (int k = i+1; k < j; k++) {
//				int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
//				if (t < m[i][j]) {
//					m[i][j] = t;
//					s[i][j] = k;
//				}
//			}
//		}
//	}
//	return m[1][n];
//}
//int main() {
//	int p[] = { 5,7,4,3,5 };
//	cout << "最优值为:"<<matrix_result(p);
//	return 0;
//}
