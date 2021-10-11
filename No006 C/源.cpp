#include<stdio.h>;
#include<iostream>;
using namespace std;
#define _CRT_SECURE_NO_WARNINGS
//1．对用户输入的杂乱无序的数字序列按照由小到大的顺序排序。
//要求分别运用合并排序和快速排序完成该题目要求。
template<class Type>void MergeSort(Type a[], int n);
template<class Type>void MergePass(Type x[], Type y[], int s, int n);
template<class Type>void Merge(Type c[], Type d[], int l, int m, int r);
int main()
{
	int i;
	int t;
	int n = 0;
	printf("please put number in it:");
	int* a = new int[7];
	for (i = 0; i < 7; i++)
	{

		scanf_s("%d", &a[i]);

	}
	MergeSort(a, 7);
	for (t = 0; t < 7; t++)
	{

		printf("%d", a[t]);
	}
	return 0;
}

template<class Type>
void MergeSort(Type a[], int n) {
	Type* b = new int[n];
	int s = 1;
	while (s < n) {
		MergePass(a, b, s, n);

		s += s;
		MergePass(b, a, s, n);

		s += s;
	}
}
template<class Type>
void MergePass(Type x[], Type y[], int s, int n) {
	int i = 0;
	while (i <= n - 2 * s) {
		Merge(x, y, i, i + s - 1, i + 2 * s - 1);
		i = i + 2 * s;
	}
	if (i + s < n)
		Merge(x, y, i, i + s - 1, n - 1);
	else
		for (int j = i; j <= n - 1; j++)
			y[j] = x[j];
}



template<class Type>
void Merge(Type c[], Type d[], int l, int m, int r) {
	int i = l, j = m + 1, k = 1;
	while ((i <= m) && (j <= r)) {
		if (c[i] <= c[j])
			d[k++] = c[i++];
		else
			d[k++] = c[j++];
		if (i > m) {
			for (int q = j; q <= r; q++)
				d[k++] = c[q];
		}
		else {
			for (int q = i; q <= m; q++)
				d[k++] = c[q];

		}
	}
}