/**
* 小华读书。
* 第一天读了全书的一半加二页，
* 第二天读了剩下的一半加二页，
* 以后天天如此……，
* 第六天读完了最后的三页，
* 问全书有多少钱页？
*/

const int XHDS_END_DAY = 6;
int xhds_result(int currentDay) {
	if (currentDay == XHDS_END_DAY) {
		return 3;
	}
	return (xhds_result(currentDay + 1) + 2) * 2;
}