/**
* 
* 某种传染病第一天只有一个患者，
* 前5天为潜伏期，不发作也不会传染人，
* 第6天开始发作，从发作到治愈需要5天时间，期间每天传染3个人，
* 求第N天共有多少患者。
*
*/
int crbwt_result(int day) {
	int sum = 0;
	if (day <= 5) {
		return 1;
	}
	else {
		sum = crbwt_result(day - 5) * 3 + crbwt_result(day - 1);
	}
	return sum;
}