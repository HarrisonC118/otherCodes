#include<iostream>
using namespace std;

void greedMoney(int moneyList[], int moneyLength, int money);
int main() {
	int money = 0;
	int moneyList[] = { 20,10,5,1 };
	int moneyLength;
	cout << "请输入要找的钱数:";
	cin >> money;
	moneyLength = sizeof(moneyList) / sizeof(moneyList[0]);
	greedMoney(moneyList, moneyLength, money);
}
void greedMoney(int moneyList[], int moneyLength, int money) {
	int i;
	for (i = 0; i < moneyLength; i++) {
		while (money >= moneyList[i]) {
			cout << moneyList[i] << " ";
			money = money - moneyList[i];
		}
	}
	cout << endl;
}