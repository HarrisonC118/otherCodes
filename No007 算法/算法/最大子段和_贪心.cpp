#include<iostream>
#define LENGTH 10
using namespace std;

int MaxSubseqSum2(int A[], int N, int* idxStart, int* idxEnd);
int main() {
	int startIndex = 0;
	int endIndex = 0;
	int a[LENGTH] = { 1, -5, 2, 6, -1, -3, 10, 2, -1, 3 };
	int length = sizeof(a) / sizeof(a[0]);
	int num = MaxSubseqSum2(a, length, &startIndex, &endIndex);
	cout << "最大子段和为：" << num << endl << "具体序列为：";
	for (int i = startIndex; i < endIndex; i++)
	{
		cout << a[i] << " ";
	}
	return 0;
}
int MaxSubseqSum2(int a[], int N, int* idxStart, int* idxEnd)
{
	int ThisSum, MaxSum = 0;
	int i, j;
	for (i = 0; i < N; i++) {
		ThisSum = 0;
		for (j = i; j < N; j++) { 
			ThisSum += a[j];
			if (ThisSum > MaxSum) {
				MaxSum = ThisSum;
				*idxStart = i;
				*idxEnd = j;
			}
		}
	}
	return MaxSum;
}
